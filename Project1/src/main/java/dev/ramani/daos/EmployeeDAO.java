package dev.ramani.daos;
import java.util.List;
import dev.ramani.entities.Employee;


public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByCredentials(String uid, String pw);
	public List<Employee> getAllEmployees2();

}
