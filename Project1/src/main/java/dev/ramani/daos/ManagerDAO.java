package dev.ramani.daos;

import java.sql.Connection;
import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;

public interface ManagerDAO {

	public List<Manager> getAllManagers();
	public Manager getManagerById(int id);
	public Manager getManagerByCredentials(String uid, String pw);
}
