package com.bridgelabz.demo.dto;

import java.util.List;
import java.util.Optional;
import com.bridgelabz.demo.model.EmployeePayrollData;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public @Data class ResponseDTO {
	
	private String message;
	private Object data;
	private Object token;

	public ResponseDTO(String string, EmployeePayrollData payrollData) {
		this.message=string;
		this.data=payrollData;
		
	}
	public ResponseDTO(String message, String string) {}

	public ResponseDTO(String string, Optional<EmployeePayrollData> employeeList) {
		
	}

    // public ResponseDTO(String string, List<EmployeePayrollData> employeeList) {
    // }
    public ResponseDTO(String string, List<String> errMesg) {
    }
	
	

}
