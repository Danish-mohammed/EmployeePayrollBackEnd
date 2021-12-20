package com.bridgelabz.demo.Service;

// import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bridgelabz.demo.dto.EmployeePayrollDTO;
import com.bridgelabz.demo.model.EmployeePayrollData;
import com.bridgelabz.demo.Exceptions.EmployeePayrollException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.demo.repository.EmployeePayrollRepository;
import com.bridgelabz.demo.util.TokenUtil;

@Service
// @Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
    private EmployeePayrollRepository employeePayrollRepository;
	
	 @Autowired
	   TokenUtil tokenUtil;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(long id) {
		
		return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee With employeeId: " + id + " does not exists"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(long id,EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
		empData.updateEmployeePayollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(long id) {
		 EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
	        employeePayrollRepository.delete(empData);
	}

	@Override
    public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
	
	 @Override
	    public List<EmployeePayrollData> getEmployeesPayrollDataByGender(String gender) {
	        return employeePayrollRepository.findEmployeesByGender(gender);
	    }

	    @Override
	    public String deleteallEmployeePayrollData() {
	        employeePayrollRepository.deleteAll();
	        return "All Data Delete";
	    }

	    @Override
	    public List<EmployeePayrollData> getAllEmployeePayrollData(String token) {
	        
	        Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(tokenUtil.decodeToken(token));
	        if (empData.isPresent()) {
	            List<EmployeePayrollData> employeePayrollDataList = employeePayrollRepository.findAll();
	            return employeePayrollDataList;
	        }
	        return null;
	    }

	    @Override
	    public Optional<EmployeePayrollData> getupdateEmployeePayrollData(String token) {
	       
	        Optional<EmployeePayrollData> empData = employeePayrollRepository.findById(tokenUtil.decodeToken(token));
	        if (empData.isPresent()) {
	            Optional<EmployeePayrollData> employeePayrollUpdateData = employeePayrollRepository.findById(tokenUtil.decodeToken(token));
	            return employeePayrollUpdateData;
	        }
	        return null;
	    }

	    @Override
	    public String deleteAllEmployeePayrollData() {
	        employeePayrollRepository.deleteAll();
	        return "All Data Delete";
	    }

}
