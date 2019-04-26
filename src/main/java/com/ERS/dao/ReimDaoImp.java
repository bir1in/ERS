package com.ERS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ERS.bean.Reimbursement;

public class ReimDaoImp implements ReimDao {
	private Connection conn = null;
	public List<Reimbursement> getAllReims() {
		List<Reimbursement> reim = new ArrayList<Reimbursement>();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT id, uName, amt, empId, status FROM reimbursement";
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int id = rs.getInt("id");
	        String uName = rs.getString("uName");
	    	double amt = rs.getInt("amt");
	    	int eid = rs.getInt("empId");
	    	String stat = rs.getString("status");
	        Reimbursement r = new Reimbursement(id, uName, amt, eid, stat);
	        reim.add(r);
	        //return reim;
	      }
	      return reim;
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
		return null;
	}

	public Reimbursement getReimById(int id) {
		Reimbursement r = new Reimbursement();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT id, uName, amt, empId, status FROM reimbursement "
	    		+ "WHERE empId =" + id;
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int rid = rs.getInt("id");
	        String uName = rs.getString("uName");
	        double amt = rs.getDouble("amt");
	    	int eid = rs.getInt("empId");
	    	String stat = rs.getString("status");
	        r.setId(rid);
	        r.setUsername(uName);
	        r.setAmt(amt);
	        r.seteId(eid);
	        r.setStatus(stat);
	      }
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
		return r;
	}

	public void insertReim(Reimbursement r) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "INSERT INTO reimbursement (id, uName, amt, empId, status)" +
				"VALUES (0, '" + r.getUsername() + "', " + r.getAmt() + ", " + r.geteId() + ", '" + r.getStatus() + "')";
		System.out.println(q);
		try {
			Statement st = conn.createStatement();
			i = st.executeUpdate(q);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("records inserted = " + i);
	}

	public void deleteReim(Reimbursement r) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "DELETE FROM reimbursement WHERE id= " + r.geteId();
	    try
	    {
	      Statement st = conn.createStatement();
	      i = st.executeUpdate(q);
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    System.out.println("records deleted = " + i);
	}

	public void updateReim(Reimbursement r) {
		int i = 0;
		conn = ConnectionManager.getConnection();
		String q = "UPDATE reimbursement SET status = '" + r.getStatus()
	      		+ "' WHERE id="+ r.getId();
	    try
	    {
	      Statement st = conn.createStatement();
	      i = st.executeUpdate(q);
	      System.out.println(r.getStatus());
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    System.out.println("records updated = " + i);
	}
}
