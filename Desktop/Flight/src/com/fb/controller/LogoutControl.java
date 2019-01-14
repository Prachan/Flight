package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogoutControl
 */
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("LogoutController");  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Logout controller initialized");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("userid");
		session.invalidate();
		
		//System.out.println(session.getAttribute("userid").toString());
		//session.removeAttribute("username");
		//out.print("you are successfully logout");
		response.sendRedirect("Login.jsp"); 
	}

}
