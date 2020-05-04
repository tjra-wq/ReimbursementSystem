package dev.ramani.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.utils.ConnectionUtil;

public class EmployeeDAOimpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		Employee e1 = null;
		try(Connection conn = ConnectionUtil.createConnection()) {
			String sql = "SELECT EID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, managerID FROM EMPLOYEE1 WHERE isManager = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  0);
			ResultSet rs = ps.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				e1 = new Employee();
				e1.setEID(rs.getInt(1));
				e1.setUsername(rs.getString(2));
				e1.setPassword(rs.getString(3));
				e1.setFirstname(rs.getString(4));
				e1.setLastname(rs.getString(5));
				e1.setManagerID(rs.getInt(6));
				employees.add(e1);
			}
		return employees;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCredentials(String uid, String pw) {
		Employee employee = null;
		try(Connection conn = ConnectionUtil.createConnection()) {
			String sql = "SELECT EID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, managerID FROM EMPLOYEE1 WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  uid);
			ps.setString(2,  pw);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEID(rs.getInt(1));
				employee.setUsername(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setFirstname(rs.getString(4));
				employee.setLastname(rs.getString(5));
				employee.setManagerID(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees2() {
        try(Connection conn = ConnectionUtil.createConnection()){
            //String sql = "SELECT * FROM todoDB.TASK";
        	String sql = "SELECT EID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, managerID FROM project1.EMPLOYEE1 WHERE isManager=0";
        	//System.out.println("SQL = "+sql);
        	//System.out.println("Inside getAllEmployees2");
            List<Employee> employees = new ArrayList<Employee>();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()) {
                Employee e1 = new Employee();
                e1.setEID(rs.getInt(1));
                e1.setUsername(rs.getString(2));
				e1.setPassword(rs.getString(3));
				e1.setFirstname(rs.getString(4));
				e1.setLastname(rs.getString(5));
				e1.setManagerID(rs.getInt(6));
				employees.add(e1);
            }
            /*
            for(Employee e : employees) {
            	System.out.println(e);
            }*/
            return employees;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	

}
