package dev.ramani.services;

import java.util.List;

import dev.ramani.daos.EmployeeDAO;
import dev.ramani.daos.EmployeeDAOimpl;
import dev.ramani.daos.ReimbursementDAO;
import dev.ramani.daos.ReimbursementDAOimpl;
import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	private ReimbursementDAO reimbdao = new ReimbursementDAOimpl();
	@Override
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e1) {
		// TODO Auto-generated method stub
		return reimbdao.getAllEmployeeReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e1) {
		// TODO Auto-generated method stub
		return reimbdao.viewEmpApprovedReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e1) {
		// TODO Auto-generated method stub
		return reimbdao.viewEmpDeniedReimbursements(e1);
	}

	@Override
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e1) {
		// TODO Auto-generated method stub
		return reimbdao.viewEmpPendingReimbursements(e1);
	}
	
	@Override
	public Reimbursement submitNewReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return reimbdao.submitNewReimbursement(r);
	}
	
	@Override
	public List<Reimbursement> getAllManagerReimbursements(Manager manager) {
		// TODO Auto-generated method stub
		return reimbdao.getAllManagerReimbursements(manager);
	}

	@Override
	public List<Reimbursement> viewManDeniedReimbursement(Manager m) {
		// TODO Auto-generated method stub
		return reimbdao.viewManDeniedReimbursements(m);
	}
	@Override
	public List<Reimbursement> viewManPendingReimbursements(Manager m) {
		// TODO Auto-generated method stub
		return reimbdao.viewManPendingReimbursements(m);
	}

	@Override
	public List<Reimbursement> viewManApprovedReimbursements(Manager m) {
		// TODO Auto-generated method stub
		return reimbdao.viewManApprovedReimbursements(m);
	}

	@Override
	public Reimbursement approveReimbursements(Reimbursement r) {
		// TODO Auto-generated method stub
		return reimbdao.approveReimbursements(r);
	}

	@Override
	public Reimbursement denyReimbursements(Reimbursement r) {
		// TODO Auto-generated method stub
		return reimbdao.denyReimbursements(r);
	}


}
