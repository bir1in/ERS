package com.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ERS.bean.Reimbursement;
import com.ERS.dao.ReimService;

/**
 * Servlet implementation class ReimbursementStatusServlet
 */
public class ReimbursementStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementStatusServlet() {
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
		//String reimId = request.getParameter("reimId");
		String eid = request.getParameter("empId");
		//String reimStat = request.getParameter("reimStatus");
		String apOrDen = request.getParameter("apOrDen");
		String reimStat = "pending";
		int empId = 0;
		//int rId =0;
		//rId = Integer.parseInt(reimId);
		empId = Integer.parseInt(eid);
		HttpSession mySession = request.getSession(false);
		/*if(reimId == null || reimId.equals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Reimbursement ID must be filled");
		}
		else */
		if(apOrDen == "approve" || apOrDen.contentEquals("approve")) {
			reimStat = "approved " + mySession.getAttribute("managerId");
		}
		if(apOrDen == "deny" || apOrDen.contentEquals("deny")) {
			reimStat = "denied " + mySession.getAttribute("managerId");
		}
		if(eid == "" || eid.contentEquals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Reimbursement ID must be filled");
		}
		//RequestDispatcher dispatchy = request.getRequestDispatcher("/Users/empWelcome.html");
		//dispatchy.forward(request, response);
		else if(reimStat == "" || reimStat.contentEquals("")) {
			response.setContentType("text/plain");
			PrintWriter writing = response.getWriter();
			writing.write("Status must be filled");
		}
		else {
			Reimbursement newReim = new ReimService().getReimById(empId);
			Reimbursement newerReim = new Reimbursement(newReim.getId(), newReim.getUsername(), newReim.getAmt(), newReim.geteId(), reimStat);
			new ReimService().updateReim(newerReim);
			//response.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.process(request, response)));
			//response.sendRedirect("./Users/empWelcome.html");
			RequestDispatcher disp = request.getRequestDispatcher("./Users/mgrWelcome.html");
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
