package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ERS.bean.Employee;
import com.ERS.dao.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetAllEmps
 */
public class GetAllEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllEmps() {
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
		List<Employee> emp = new EmpService().getAllEmps();
		response.setContentType("application/json");
		//This response header tells the browser that this domain will allow scripts from
		//other domains to make requests to its endpoints.
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		out.write(mapper.writeValueAsString(emp));
		//response.getOutputStream().write(mapper.writeValueAsBytes(reims));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
