package com.bridgelabz.demo.repository;

import com.bridgelabz.demo.model.EmployeePayrollData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {
	 @Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and department= :departments", nativeQuery = true)
	    List<EmployeePayrollData> findEmployeesByDepartment(String department);
	 
	 @Query(value = "select * from employeepayroll_db where gender= :gender", nativeQuery = true)
	    List<EmployeePayrollData> findEmployeesByGender(String gender);

}
