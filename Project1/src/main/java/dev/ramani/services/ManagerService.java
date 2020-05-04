package dev.ramani.services;

import java.util.List;

import dev.ramani.entities.Manager;
import dev.ramani.exceptions.InvalidPasswordException;
import dev.ramani.exceptions.ManagerNotFoundException;

public interface ManagerService {
	
	public Manager getManagerByCredentials(String uid, String pw);
	public Manager managerLogin(Manager manager) throws ManagerNotFoundException, InvalidPasswordException;
	
	public List<Manager> getAllManagers();
	public List<Manager> getAll();
}
