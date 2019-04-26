package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.ERS.bean.Reimbursement;
import com.ERS.dao.ReimService;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int itr2=3;
	//private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementServlet() {
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
		String eid = request.getParameter("empId");
		String rAmt = request.getParameter("rAmt");
		double amt = 0.0;
		int empId = 0;
		empId = Integer.parseInt(eid);
		amt = Double.parseDouble(rAmt);
		if(uName == null || uName.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Username must be filled");
		}
		else if(eid == "" || eid.contentEquals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Employee ID must be filled");
		}
		//RequestDispatcher dispatchy = request.getRequestDispatcher("/Users/empWelcome.html");
		//dispatchy.forward(request, response);
		else if(rAmt == "" || rAmt.contentEquals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Amount must be filled");
		}
		else {
			Reimbursement newReim = new Reimbursement(0, uName, amt, empId, "pending");
			new ReimService().insertReim(newReim);
			itr2++;
			//response.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.process(request, response)));
			//response.sendRedirect("./Users/empWelcome.html");
			RequestDispatcher disp = request.getRequestDispatcher("./Users/empWelcome.html");
			disp.forward(request, response);
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
