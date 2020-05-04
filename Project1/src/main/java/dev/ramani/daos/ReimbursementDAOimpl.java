package dev.ramani.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.ramani.entities.Employee;
import dev.ramani.entities.Manager;
import dev.ramani.entities.Reimbursement;
import dev.ramani.utils.ConnectionUtil;

public class ReimbursementDAOimpl implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getAllEmployeeReimbursements(Employee e) {
        try(Connection conn = ConnectionUtil.createConnection()){
            //String sql = "SELECT * FROM todoDB.TASK";
        	String sql = "SELECT RID, AMOUNT, DESCRIPTION, DATE1, RSTATUS, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE EIDRequester = ?";
        	//System.out.println("SQL = "+sql);
        	//System.out.println("Inside getAllEmployees2");
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
				r1.setDESCRIPTION(rs.getString(3));
				r1.setDATE1(rs.getString(4));
				r1.setRSTATUS(rs.getString(5));
				r1.setRCOMMENT(rs.getString(6));
				reimbursements.add(r1);
            }
            /*
            for(Reimbursement r : reimbursements) {
            	System.out.println(r);
            }*/
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpApprovedReimbursements(Employee e) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE EIDRequester = ? AND RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "approved");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
				r1.setDESCRIPTION(rs.getString(3));
				r1.setDATE1(rs.getString(4));
				r1.setRCOMMENT(rs.getString(5));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpDeniedReimbursements(Employee e) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE EIDRequester = ? AND RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "denied");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
				r1.setDESCRIPTION(rs.getString(3));
				r1.setDATE1(rs.getString(4));
				r1.setRCOMMENT(rs.getString(5));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewEmpPendingReimbursements(Employee e) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE EIDRequester = ? AND RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1,  e.getEID());
        	ps.setString(2,  "pending");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setAMOUNT(rs.getInt(2));
				r1.setDESCRIPTION(rs.getString(3));
				r1.setDATE1(rs.getString(4));
				r1.setRCOMMENT(rs.getString(5));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	@Override
	public Reimbursement submitNewReimbursement(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO project1.REIMBURSEMENT1 VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, r.getEIDRequester());
			ps.setDouble(3, r.getAMOUNT());
			ps.setString(4, r.getDESCRIPTION());
			ps.setString(5, r.getDATE1());
			ps.setString(6, "pending");
			ps.setString(7, null);
			ps.execute();
			System.out.println("Entered Successfully.");
		} catch (SQLException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> getAllManagerReimbursements(Manager manager) {
        try(Connection conn = ConnectionUtil.createConnection()){
            //String sql = "SELECT * FROM todoDB.TASK";
        	String sql = "SELECT RID, EIDRequester, AMOUNT, DESCRIPTION, DATE1, RSTATUS, RCOMMENT FROM project1.REIMBURSEMENT1";
        	//String sql = "SELECT RID, EIDRequester, AMOUNT, DESCRIPTION, DATE1, RSTATUS, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE EIDRequester IN (SELECT EID FROM project1.EMPLOYEE1 WHERE managerID = ?)";
        	//System.out.println("SQL = "+sql);
        	//System.out.println("Inside getAllEmployees2");
        	PreparedStatement ps = conn.prepareStatement(sql);
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRSTATUS(rs.getString(6));
				r1.setRCOMMENT(rs.getString(7));
				reimbursements.add(r1);
            }
            /*
            for(Reimbursement r : reimbursements) {
            	System.out.println(r);
            }*/
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}
	
	@Override
	public List<Reimbursement> viewManPendingReimbursements(Manager m) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, EIDRequester, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "pending");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRCOMMENT(rs.getString(6));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewManApprovedReimbursements(Manager m) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, EIDRequester, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "approved");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRCOMMENT(rs.getString(6));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Reimbursement> viewManDeniedReimbursements(Manager m) {
        try(Connection conn = ConnectionUtil.createConnection()){
        	String sql = "SELECT RID, EIDRequester, AMOUNT, DESCRIPTION, DATE1, RCOMMENT FROM project1.REIMBURSEMENT1 WHERE RSTATUS = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1,  "denied");
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
            	Reimbursement r1 = new Reimbursement();
                r1.setRID(rs.getInt(1));
                r1.setEIDRequester(rs.getInt(2));
                r1.setAMOUNT(rs.getInt(3));
				r1.setDESCRIPTION(rs.getString(4));
				r1.setDATE1(rs.getString(5));
				r1.setRCOMMENT(rs.getString(6));
				reimbursements.add(r1);
            }
            return reimbursements;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
	}

	@Override
	public Reimbursement approveReimbursements(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT1 SET RSTATUS = ?,RCOMMENT = ? WHERE RID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, "approved");
			ps.setString(2, r.getRCOMMENT());
			ps.setInt(3, r.getRID());
			ps.executeUpdate();
			conn.commit();
			System.out.println("Reimbursement was approved successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}


	@Override
	public Reimbursement denyReimbursements(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT1 SET RSTATUS = ?,RCOMMENT = ? WHERE RID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, "denied");
			ps.setString(2, r.getRCOMMENT());
			ps.setInt(3, r.getRID());
			ps.executeUpdate();
			conn.commit();
			System.out.println("Reimbursement was denied successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}




	


}
