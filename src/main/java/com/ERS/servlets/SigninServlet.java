package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.ERS.bean.Employee;
import com.ERS.bean.Manager;
import com.ERS.dao.EmpService;
import com.ERS.dao.MgrService;


/**
 * Servlet implementation class LoginServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int itr=3;
	public static int itr2=2;
	//private static Logger log = Logger.getLogger(SigninServlet.class);
    /**
     * Default constructor. 
     */
    public SigninServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String empOrMgr = request.getParameter("empOrMgr");
		if(password1 == null || password1.equals("") || password2 == null || password2.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Passwords must be filled");
		}
		else if(!password1.equals(password2)) {
			response.setContentType("text/html");
			PrintWriter wr = response.getWriter();
			wr.write("Passwords do not match");
		}
		else if(username == null || username.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Username must be filled");
		}
		//RequestDispatcher dispatchy = request.getRequestDispatcher("/Users/empWelcome.html");
		//dispatchy.forward(request, response);
		else if(empOrMgr == "mgr" || empOrMgr.contentEquals("mgr")) {
			Manager newMgr = new Manager(0, username, password1, "firstname", "lastname");
			new MgrService().insertMgr(newMgr);
			itr2++;
			response.sendRedirect("./index.html");
		}
		else {
			Employee newEmp = new Employee(0, username, password1, "firstname", "lastname", 1);
			new EmpService().insertEmp(newEmp);
			itr++;
			response.sendRedirect("./index.html");
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
