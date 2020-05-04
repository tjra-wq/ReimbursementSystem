package dev.ramani.services;

import java.util.ArrayList;
import java.util.List;


import dev.ramani.daos.ManagerDAO;
import dev.ramani.daos.ManagerDAOimpl;
import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.exceptions.EmployeeNotFoundException;
import dev.ramani.exceptions.InvalidPasswordException;
import dev.ramani.exceptions.ManagerNotFoundException;

public class ManagerServiceImpl implements ManagerService {
	
	private ManagerDAO managerdao = new ManagerDAOimpl();

	@Override
	public Manager managerLogin(Manager manager) throws ManagerNotFoundException, InvalidPasswordException {
		// TODO Auto-generated method stub
		boolean managerFound = false;
		boolean pwCheck = false;
		
		List<Manager> managers = new ArrayList<Manager>(managerdao.getAllManagers());
		Manager currentManager = new Manager();
		
		for(Manager m : managers) {
			if(m.getUsername().equals(manager.getUsername())) {
				managerFound = true;
				if(m.getPassword().equals(manager.getPassword())) {
					pwCheck = true;
					currentManager.setEID(m.getEID());
					currentManager.setUsername(m.getUsername());
					currentManager.setPassword(m.getPassword());
					currentManager.setFirstname(m.getFirstname());
					currentManager.setLastname(m.getLastname());
					return currentManager;
				}
			}
		}
		if(!managerFound) {
			throw new ManagerNotFoundException("There are no managers with this username: " + manager.getUsername());
		}
			
		if(managerFound && !pwCheck) {
			throw new InvalidPasswordException("This is incorrect Password. Plase try again.");
		}
		return null;
	}
	
	@Override
	public Manager getManagerByCredentials(String uid, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
