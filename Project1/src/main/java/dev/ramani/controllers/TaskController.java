package dev.ramani.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.entities.Reimbursement;
import dev.ramani.exceptions.EmployeeNotFoundException;
import dev.ramani.exceptions.InvalidPasswordException;
import dev.ramani.services.EmployeeService;
import dev.ramani.services.EmployeeServiceImpl;
import dev.ramani.services.ManagerService;
import dev.ramani.services.ManagerServiceImpl;
import dev.ramani.services.ReimbursementService;
import dev.ramani.services.ReimbursementServiceImpl;


public class TaskController {
	
	EmployeeService empServ = new EmployeeServiceImpl();
	ReimbursementService ReimbServ = new ReimbursementServiceImpl();
	ManagerService managerServ = new ManagerServiceImpl();
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		List<Employee> employees = empServ.getAll();
		//System.out.println("employees List = "+employees);
		String json = gson.toJson(employees);
		//System.out.println("json = "+json);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		
	}
	
	public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		//System.out.println("body="+body);
		Gson gson = new Gson();
		String json = null;
		
		Employee employee = gson.fromJson(body, Employee.class);
		PrintWriter pw = response.getWriter();
		//System.out.println("Employee= "+employee);
		try {
			employee = empServ.employeeLogin(employee);
			//System.out.println("Employee object is not null");
			System.out.println("Selected Employee ="+employee);
			HttpSession session = request.getSession();
			
			//session.setAttribute("username", employee.getUsername());
			session.setAttribute("employee",employee);
			
			//System.out.println("session = "+session);
			//System.out.println("session = "+session.toString());
			//System.out.println("session attributes ="+session.getAttribute("employee"));
			json = gson.toJson(employee);
			pw.append(json);
			//pw.append("Login SUccessfull");
			//return;
		}catch(EmployeeNotFoundException e) {
			response.sendError(403);
			return;
		}catch(InvalidPasswordException e) {
			response.sendError(403);
			return;
		}
		
	}

	public void loginManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		String json = null;
		Manager manager = gson.fromJson(body, Manager.class);
		PrintWriter pw = response.getWriter();
		try {
			manager = managerServ.managerLogin(manager);
			System.out.println("Selected Manager ="+manager);
			HttpSession session = request.getSession();
			session.setAttribute("manager",manager);
			json = gson.toJson(manager);
			pw.append(json);
		}catch(EmployeeNotFoundException e) {
			response.sendError(403);
			return;
		}catch(InvalidPasswordException e) {
			response.sendError(403);
			return;
		}
		
	}

	public void viewAllReimbursementsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.getAllEmployeeReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void viewApprovedReimbursementsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpApprovedReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		
	}

	public void ViewDeniedRequestsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpDeniedReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void ViewPendingRequestsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewEmpPendingReimbursements(employee);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession(); 
		session.invalidate(); 
		response.getWriter().append("Logged Out");
	}

	public void submitNewReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.submitNewReimbursement(reimbursement);
		response.getWriter().append("Submitted Successfully");
	}

	public void viewAllReimbursementsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.getAllManagerReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
		
	}

	public void viewAllPendingReimbursementsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManPendingReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void viewApprovedRequestsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManApprovedReimbursements(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void viewDeniedRequestsManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ReimbServ.viewManDeniedReimbursement(manager);
		String json = gson.toJson(reimbursements);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public void updatereApproveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.approveReimbursements(reimbursement);
		response.getWriter().append("Updated. Approved Successfully");
	}

	public void updateDenyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		reimbursement = ReimbServ.denyReimbursements(reimbursement);
		response.getWriter().append("Updated. Denied Successfully");
	}





	
	
		
}
