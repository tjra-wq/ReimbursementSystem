package dev.ramani.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramani.controllers.TaskController;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TaskController tcontroller = new TaskController();

    public DispatcherServlet() {
        super();
    }


    // HTTP requests get to this method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/Project1/api/getAll":
			tcontroller.getAll(request, response);
			break;
		
		case "/Project1/api/employeelogin":
			tcontroller.loginEmployee(request, response);
			break;
		
		case "/Project1/api/managerlogin":
			tcontroller.loginManager(request, response);
			break;
			
		case "/Project1/api/employeehome/viewAllReimbursementsEmployee":
			tcontroller.viewAllReimbursementsEmployee(request, response);
			break;
			
		case "/Project1/api/employeehome/viewApprovedReimbursementsEmployee":
			tcontroller.viewApprovedReimbursementsEmployee(request, response);
			break;
			
		case "/Project1/api/employeehome/ViewDeniedRequestsEmployee":
			tcontroller.ViewDeniedRequestsEmployee(request, response);
			break;
		
		case "/Project1/api/employeehome/ViewPendingRequestsEmployee":
			tcontroller.ViewPendingRequestsEmployee(request, response);
			break;
			
			
		case "/Project1/api/employeehome/logout":
			tcontroller.logout(request, response);
			break;
		
		case "/Project1/api/employeehome/submitNewReimbursement":
			tcontroller.submitNewReimbursement(request, response);
			break;
			
		case "/Project1/api/managerhome/viewAllReimbursementsManager":
			tcontroller.viewAllReimbursementsManager(request, response);
			break;
			
		case "/Project1/api/managerhome/viewAllPendingRequestsManager":
			tcontroller.viewAllPendingReimbursementsManager(request, response);
			break;
			
		case "/Project1/api/managerhome/viewApprovedRequestsManager":
			tcontroller.viewApprovedRequestsManager(request, response);
			break;
			
		case "/Project1/api/managerhome/viewDeniedRequestsManager":
			tcontroller.viewDeniedRequestsManager(request, response);
			break;
			
		case "/Project1/api/managerhome/logout":
			tcontroller.logout(request, response);
			break;
			
		case "/Project1/api/managerhome/updatereApproveReimbursement":
			tcontroller.updatereApproveReimbursement(request, response);
			break;
			
		case "/Project1/api/managerhome/updateDenyReimbursement":
			tcontroller.updateDenyReimbursement(request, response);
			break;

		default:
			response.getWriter().append("Served at: ").append(request.getContextPath());
			break;
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
