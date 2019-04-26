package com.ERS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ERS.bean.Employee;

public class EmpDaoImp implements EmpDao {
	private Connection conn = null;
	public List<Employee> getAllEmps() {
		List<Employee> emp = new ArrayList<Employee>();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT id, uName, pw, fName, lName, managerId FROM employee";
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int id = rs.getInt("id");
	        String uName = rs.getString("uName");
	        String pw = rs.getString("pw");
	        String fName = rs.getString("fName");
	        String lName = rs.getString("lName");
	    	int mid = rs.getInt("managerId");
	        Employee e = new Employee(id, uName, pw, fName, lName, mid);
	        emp.add(e);
	      }
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
		return emp;
	}

	public Employee getEmpById(int id) {
		Employee e = new Employee();
		conn = ConnectionManager.getConnection();
	    String query = "SELECT id, uName, pw, fName, lName, managerId FROM employee "
	    		+ "WHERE id =" + id;
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      while (rs.next())
	      {
	    	int eid = rs.getInt("id");
	        String uName = rs.getString("uName");
	        String pw = rs.getString("pw");
	        String fName = rs.getString("fName");
	        String lName = rs.getString("lName");
	    	int mid = rs.getInt("managerId");
	        e.setId(eid);
	        e.setUsername(uName);
	        e.setPassword(pw);
	        e.setFirstName(fName);
	        e.setLastName(lName);
	        e.setmId(mid);
	      }
	    }
	    catch (SQLException ex)
	    {
	      ex.printStackTrace();
	    }
		return e;
	}

	public void insertEmp(Employee e) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "INSERT INTO employee (id, uName, pw, fName, lName, managerId)" +
				"VALUES (0, '" + e.getUsername() + "', '" + e.getPassword() + "', '" + e.getFirstName() + "', '" + e.getLastName() + "', " + e.getmId() + ")";
		System.out.println(q);
		try {
			Statement st = conn.createStatement();
			i = st.executeUpdate(q);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("records inserted = " + i);
	}

	public void deleteEmp(Employee e) {
		int i=0;
		conn = ConnectionManager.getConnection();
		String q = "DELETE FROM employee WHERE id= " + e.getId();
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

	public void updateEmp(Employee e) {
		int i = 0;
		conn = ConnectionManager.getConnection();
		String q = "UPDATE employee SET fName='" + e.getFirstName() + "', lName='" + e.getLastName()
	      		+ "' WHERE id="+ e.getId();
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
