package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ERS.bean.Employee;
import com.ERS.bean.Manager;
import com.ERS.dao.EmpService;
import com.ERS.dao.MgrService;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private static Logger log = Logger.getLogger(LoginServlet.class);
    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		String eid = request.getParameter("empId");
		String empOrMgr = request.getParameter("empOrMgr");
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
		else if(empOrMgr == "mgr" || empOrMgr.contentEquals("mgr")) {
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
				//response.sendRedirect("./Users/empWelcome.html");
	            HttpSession oldSession = request.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            HttpSession newSession = request.getSession(true);
	            //newSession.setMaxInactiveInterval(5*60);
	            Cookie message = new Cookie("message", "Welcome");
	            response.addCookie(message);
	            newSession.setAttribute("managerId", eid);
	            //response.sendRedirect("./Users/mgrWelcome.html");
	            RequestDispatcher disp = request.getRequestDispatcher("./Users/mgrWelcome.html");
				disp.forward(request, response);
			}
		}
		else {
			int empId = Integer.parseInt(eid);
			//List<Employee> employee = new EmpService().getAllEmps();
			Employee e = new EmpService().getEmpById(empId);
			System.out.println(e.toString());
			String employeeUsername = e.getUsername();
			String employeePassword = e.getPassword();
			if(e.equals(null) || e == null) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("username, password, employee ID do not match any records");
				System.out.println(empId + ", " + uName + ", " + pw);
			}
			else if(e.getId() != empId) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("employee ID does not match any records");
				System.out.println(empId);
			}
			else if(!employeeUsername.equals(uName)) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("username does not match any records");
				System.out.println(uName);
			}
			else if(!employeePassword.equals(pw)) {
				response.setContentType("text/plain");
				PrintWriter writing = response.getWriter();
				writing.write("password does not match any records");
				System.out.println(pw);
			}
			else {
				//response.sendRedirect("./Users/empWelcome.html");
	            HttpSession oldSession = request.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            HttpSession newSession = request.getSession(true);
	            //newSession.setMaxInactiveInterval(5*60);
	            Cookie message = new Cookie("message", "Welcome");
	            response.addCookie(message);
	            newSession.setAttribute("userId", eid);
	            //newSession.setAttribute("employeeId", empId);
	            //response.sendRedirect("./Users/empWelcome.html");
				RequestDispatcher disp = request.getRequestDispatcher("./Users/empWelcome.html");
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
