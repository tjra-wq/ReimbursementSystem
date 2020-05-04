package dev.ramani.daos;

public interface LoginDAO {

	public boolean authenticateUser(String email, String password, String loginType);
}
