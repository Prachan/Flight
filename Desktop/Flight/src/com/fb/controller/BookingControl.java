package com.fb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fb.dao.BookingDao;

/**
 * Servlet implementation class BookingControl
 */
public class BookingControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str=request.getParameter("h2");
		//String flightId = request.getParameter("flightId");
		String userId = (request.getParameter("userId"));
		String flightId = request.getParameter("flightId");
		//System.out.println(userId);
		System.out.println(flightId);

		//System.out.println(str);

		String words[] = str.split(";");

		RequestDispatcher rd = null;

		for(String s:words)

		{

		String[] word = s.split("\\s");

		String first_name = word[0];

		String last_name= word[1];
		
		String aadhar = word[2];

		BookingDao bd = new BookingDao();

		bd.addTraveller(first_name, last_name,aadhar,userId,flightId);


		//request.setAttribute("First", first_name);

		

		//System.out.println(first_name+" "+last_name);

		}
		
		rd = request.getRequestDispatcher("Payment.jsp");

		rd.forward(request, response);
	}

}
