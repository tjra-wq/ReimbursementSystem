package dev.ramani.services;

import java.util.List;
import java.util.ArrayList;

import dev.ramani.daos.EmployeeDAO;
import dev.ramani.daos.EmployeeDAOimpl;
import dev.ramani.entities.Employee;
import dev.ramani.exceptions.EmployeeNotFoundException;
import dev.ramani.exceptions.InvalidPasswordException;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeedao = new EmployeeDAOimpl();
	
	@Override
	public Employee employeeLogin(Employee employee) throws EmployeeNotFoundException, InvalidPasswordException {
		// TODO Auto-generated method stub
		boolean employeeFound = false;
		boolean pwCheck = false;
		
		List<Employee> employees = new ArrayList<Employee>(employeedao.getAllEmployees());
		Employee currentEmployee = new Employee();
		
		for(Employee e : employees) {
			if(e.getUsername().equals(employee.getUsername())) {
				employeeFound = true;
				if(e.getPassword().equals(employee.getPassword())) {
					pwCheck = true;
					currentEmployee.setEID(e.getEID());
					currentEmployee.setUsername(e.getUsername());
					currentEmployee.setPassword(e.getPassword());
					currentEmployee.setFirstname(e.getFirstname());
					currentEmployee.setLastname(e.getLastname());
					currentEmployee.setManagerID(e.getManagerID());
					return currentEmployee;
				}
			}
		}
		if(!employeeFound) {
			//System.out.println("Employee not found");
			//return null;
			throw new EmployeeNotFoundException("There are no employees with this username: " + employee.getUsername());
		}
			
		if(employeeFound && !pwCheck) {
			//System.out.println("Invalid password");
			//return null;
			throw new InvalidPasswordException("This is incorrect Password. Plase try again.");
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCredentials(String uid, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeedao.getAllEmployees2();
	}

}
