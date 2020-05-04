package dev.ramani.services;

import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.exceptions.EmployeeNotFoundException;
import dev.ramani.exceptions.InvalidPasswordException;

public interface EmployeeService {

	public Employee getEmployeeByCredentials(String uid, String pw);
	public Employee employeeLogin(Employee employee) throws EmployeeNotFoundException, InvalidPasswordException;
	
	public List<Employee> getAllEmployees();
	public List<Employee> getAll();

}
