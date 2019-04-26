package com.ERS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ERS.bean.Manager;

public class MgrDaoImp implements MgrDao {
	private Connection conn = null;
	public List<Manager> getAllMgrs() {
		List<Manager> mgr = new ArrayList<Manager>();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT mgrId, uName, pw, fName, lName FROM manager";
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int id = rs.getInt("mgrId");
	        String uName = rs.getString("uName");
	        String pw = rs.getString("pw");
	        String fName = rs.getString("fName");
	        String lName = rs.getString("lName");
	        System.out.println(id + " " + uName + " " + fName + " " + lName);
	        Manager m = new Manager(id, uName, pw, fName, lName);
	        mgr.add(m);
	      }
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    return mgr;
	}

	public Manager getMgrById(int id) {
		Manager m = new Manager();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT mgrId, uName, pw, fName, lName FROM manager "
	    		+ "WHERE mgrId =" + id;
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int mid = rs.getInt("mgrId");
	        String uName = rs.getString("uName");
	        String pw = rs.getString("pw");
	        String fName = rs.getString("fName");
	        String lName = rs.getString("lName");
	        m.setId(mid);
	        m.setUsername(uName);
	        m.setPassword(pw);
	        m.setFirstName(fName);
	        m.setLastName(lName);
	      }
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    return m;
	}

	public void insertMgr(Manager m) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "INSERT INTO manager (mgrId, uName, pw, fName, lName)" +
				"VALUES (0, '" + m.getUsername() + "', '" + m.getPassword() + "', '" + m.getFirstName() + "', '" + m.getLastName() + "')";
		System.out.println(q);
		try {
			Statement st = conn.createStatement();
			i = st.executeUpdate(q);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("records inserted = " + i);
	}

	public void deleteMgr(Manager m) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "DELETE FROM manager WHERE mgrId= " + m.getId();
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

	public void updateMgr(Manager m) {
		int i = 0;
		conn = ConnectionManager.getConnection();
		String q = "UPDATE manager SET fName='" + m.getFirstName() + "', lName='" + m.getLastName()
	      		+ "' WHERE mgrId="+ m.getId();
	    try
	    {
	      Statement st = conn.createStatement();
	      i = st.executeUpdate(q);
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    System.out.println("records updated = " + i);
	}
}
