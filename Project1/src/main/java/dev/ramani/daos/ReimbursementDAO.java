package dev.ramani.daos;

import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.entities.Reimbursement;

public interface ReimbursementDAO {
	
	//services for employee
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e);
	public Reimbursement submitNewReimbursement(Reimbursement r);
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e);
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e);
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e);
	
	//services for manager
	public List<Reimbursement> getAllManagerReimbursements(Manager manager);
	public List<Reimbursement> viewManPendingReimbursements(Manager m);
	public List<Reimbursement> viewManApprovedReimbursements(Manager m);
	public List<Reimbursement> viewManDeniedReimbursements(Manager m);
	public Reimbursement approveReimbursements(Reimbursement r);
	public Reimbursement denyReimbursements(Reimbursement r);
	
}
