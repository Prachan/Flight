package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fb.bo.PaymentBo;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;

/**
 * Servlet implementation class LoginServlet
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger("PaymentController");
    /**
     * Default constructor. 
     */
    public PaymentController() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Payment Controller");
		String name = request.getParameter("Name");
		String card_no = request.getParameter("card_no");
		String amount = (request.getParameter("amount"));
		int price=0;
		int no_of_passengers=Integer.parseInt(request.getParameter("no_of_passengers"));
		RequestDispatcher rd=null;
		PrintWriter out = response.getWriter();
		PaymentBo pb = new PaymentBo();
		try{
			if(pb.validatePayment(card_no, amount, no_of_passengers)==1)
			{
				request.setAttribute("errorMessage1","Invalid Card Number");
				rd=request.getRequestDispatcher("Payment.jsp");
				rd.include(request, response);
			}
			if(pb.validatePayment(card_no, amount, no_of_passengers)==3)
			{
				request.setAttribute("errorMessage","Not Enough Balance");
				rd=request.getRequestDispatcher("Payment.jsp");
				rd.include(request, response);
			}
			else if(pb.validatePayment(card_no, amount, no_of_passengers)==2)
			{
				price = Integer.parseInt(amount) *  no_of_passengers;
				request.setAttribute("name", name);
				request.setAttribute("price", price);
				rd = request.getRequestDispatcher("Invoice.jsp");
				rd.forward(request, response);
			}
		   } 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}


