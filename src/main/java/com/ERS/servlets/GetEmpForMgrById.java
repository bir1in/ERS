package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.ERS.bean.Employee;
import com.ERS.dao.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetEmpForMgrById
 */
public class GetEmpForMgrById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpForMgrById() {
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
		//HttpSession session = request.getSession(false);
		//String eid = (String) session.getAttribute("userId");
		String eid = request.getParameter("empId");
		int empId = Integer.parseInt(eid);
		Employee emp = new EmpService().getEmpById(empId);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		out.write(mapper.writeValueAsString(emp));
		//response.setContentType("text/html");
		//RequestDispatcher disp = request.getRequestDispatcher("./viewAllEmps.html");
		//disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
