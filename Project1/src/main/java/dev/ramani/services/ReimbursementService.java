package dev.ramani.services;

import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.entities.Reimbursement;

public interface ReimbursementService {
	
	//services for employee
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e1);
	public Reimbursement submitNewReimbursement(Reimbursement r);
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e1);
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e1);
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e1);
	
	//services for manager
	public List<Reimbursement> getAllManagerReimbursements(Manager manager);
	public List<Reimbursement> viewManPendingReimbursements(Manager m);
	public List<Reimbursement> viewManApprovedReimbursements(Manager m);
	public List<Reimbursement> viewManDeniedReimbursement(Manager m);
	public Reimbursement approveReimbursements(Reimbursement r);
	public Reimbursement denyReimbursements(Reimbursement r);
	

	

}
