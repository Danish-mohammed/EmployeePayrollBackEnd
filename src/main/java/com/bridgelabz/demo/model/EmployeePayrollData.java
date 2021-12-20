package com.bridgelabz.demo.model;

import com.bridgelabz.demo.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "employeepayroll_db")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "name")
	private String name;

	private String salary;

	private String gender;

	private String startDate;

	private String note;

	private String profilePic;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	
	@Column(name = "departments")
	private List<String> departments;

	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.updateEmployeePayollData(employeePayrollDTO);
	}

	public void updateEmployeePayollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;

    }
}

