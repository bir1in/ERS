package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ERS.bean.Employee;
import com.ERS.bean.Manager;
//import com.ERS.dao.EmpService;
import com.ERS.dao.MgrService;

/**
 * Servlet implementation class MgrInfoServlet
 */
public class MgrInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		String uName = request.getParameter("userName");
		String pw = request.getParameter("pw");
		String eid = request.getParameter("mgrId");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		//String empOrMgr = request.getParameter("empOrMgr");
		if(pw == null || pw.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Passwords must be filled");
		}
		else if(uName == null || uName.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Username must be filled");
		}
		else if(eid == null || eid.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Employee id must be filled");
		}
		else if(fName == null || fName.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("First Name must be filled");
		}
		else if(lName == null || lName.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Last Name must be filled");
		}
		else {
			int mgrId = Integer.parseInt(eid);
			Manager m = new MgrService().getMgrById(mgrId);
			System.out.println(m.toString());
			String managerUsername = m.getUsername();
			String managerPassword = m.getPassword();
			if(m.equals(null) || m == null) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("username, password, employee ID do not match any records");
				System.out.println(mgrId + ", " + uName + ", " + pw);
			}
			else if(m.getId() != mgrId) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("employee ID does not match any records");
				System.out.println(mgrId);
			}
			else if(!managerUsername.equals(uName)) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("username does not match any records");
				System.out.println(uName);
			}
			else if(!managerPassword.equals(pw)) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("password does not match any records");
				System.out.println(pw);
			}
			else {
				m.setUsername(uName);
				m.setPassword(pw);
				m.setFirstName(fName);
				m.setLastName(lName);
				Manager newMgr = new Manager(mgrId, uName, pw, fName, lName);
				new MgrService().updateMgr(newMgr);
				RequestDispatcher disp = request.getRequestDispatcher("./viewAllEmps.html");
				disp.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
