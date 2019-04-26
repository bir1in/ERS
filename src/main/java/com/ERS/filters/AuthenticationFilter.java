package com.ERS.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {
	private static Logger log = Logger.getLogger(AuthenticationFilter.class);

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("My authentication filter is working.");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if(session == null || session.equals(null)) {
			log.info("my session is null");
			resp.sendRedirect("./index.html");
		}
		else {
			log.info("my session wasnt null");
			if(!session.getAttribute("userId").equals(null)) {
				//resp.sendRedirect("./Users/empWelcome.html");
				log.info("inside session");
				RequestDispatcher dispat = request.getRequestDispatcher("./Users/empWelcome.html");
				dispat.forward(request, response);
				//resp.sendError(404)
			}
			if(!session.getAttribute("managerId").equals(null)) {
				//resp.sendRedirect("./Users/reimbursement.html");
				RequestDispatcher dispat = request.getRequestDispatcher("./Users/mgrWelcome.html");
				dispat.forward(request, response);
				//resp.sendError(404)
			}
			//chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
