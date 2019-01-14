package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fb.bo.PaymentBo;
import com.fb.bo.SearchBo;
import com.fb.dao.BookingDao;
import com.fb.dao.CancelTicketDao;
import com.fb.dao.SearchDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

/**
 * Servlet implementation class SearchControl
 */
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("SearchControl");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String action = request.getParameter("action");
		if(action.equalsIgnoreCase("search"))
		{
			HttpSession session=request.getSession();
		LOG.info("Search Control initialized");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String d_date = request.getParameter("departure_date");
		String departure_time = request.getParameter("departure_time");
		String airline = request.getParameter("airline");
		
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		List<FlightMo> l1 = new ArrayList<FlightMo>();
	
		
		//out.print(source);
		//out.print(destination);
		SearchBo sbo = new SearchBo();
			List<FlightMo> list=null;
			//System.out.println(d_date);
			try {
				FlightMo flight = new FlightMo();
				flight.setSource(source);
				flight.setDestination(destination);
				flight.setFlightFranchise(airline);
				flight.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse(d_date));
				list = sbo.validateSearch(flight);
				session.setAttribute("source", flight.getSource());
				session.setAttribute("destination", flight.getDestination());
				session.setAttribute("departuredate", flight.getDepartureDate());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.info("SQL Exception occured: "+e);
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//String booking_fid="";
 catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(list.size()==0)
			{
				//out.print("<b>Ooopsss!!!Flight Not Found</b>");
				request.setAttribute("error", "Ooopsss!!!Flight Not Found");
				rd = request.getRequestDispatcher("search.jsp");
				rd.include(request, response);
				LOG.info("Flight not found error!!!");
			}
			else
			{
				;
				rd= request.getRequestDispatcher("display.jsp");
				for(FlightMo f: list)
				{
					/*request.setAttribute("flightid", f.getFlight_id());
					request.setAttribute("flightfranchise", f.getFlight_franchise());
					request.setAttribute("fromLocation", f.getFrom_location());
					request.setAttribute("toLocation",f.getTo_location());
					request.setAttribute("startTime",f.getStart_time());
					request.setAttribute("endTime",f.getEnd_time());
					request.setAttribute("fare",f.getFare());*/
					l1.add(f);
					
				}
				request.setAttribute("list", l1);
				rd.include(request, response);
			}
			
			
		}
		else if(action.equalsIgnoreCase("booking"))
		{
			LOG.info("Booking initialized");
			RequestDispatcher rd = null;
			
			HttpSession session=request.getSession();
			//session.setAttribute("ticket_id", ticketId);
			String str=request.getParameter("h2");
			//String flightId = request.getParameter("flightId");
			String userId = (request.getParameter("userId"));
			String flightId = request.getParameter("flightId");
			//System.out.println(userId);
			//System.out.println(flightId);

			//System.out.println(str);

			String words[] = str.split(";");
			String ticketId = session.getAttribute("ticketId").toString();
			//RequestDispatcher rd = null;
			for(String s:words)

			{

			String[] word = s.split("\\s");

			String first_name = word[0];

			String last_name= word[1];
			
			String aadhar = word[2];
			//SearchBo bd = new SearchBo();
			SearchDao bd = new SearchDao();
			

			bd.addTraveller(first_name, last_name,aadhar,userId,flightId,ticketId);
			}
			rd = request.getRequestDispatcher("Payment.jsp");
			rd.forward(request, response);
			SearchDao bd1 = new SearchDao();
			try {
				String ticket = bd1.generateTicketId((userId));
				bd1.addTicket(ticket, userId);
				rd = request.getRequestDispatcher("Payment.jsp");
				rd.forward(request, response);
				System.out.println(ticket);
				HttpSession ses = request.getSession();
				ses.setAttribute("ticketId", ticket);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			}
			
			
		
		
		else if(action.equalsIgnoreCase("payment"))
		{
			LOG.info("Payment Controller");
			String name = request.getParameter("Name");
			String card_no = request.getParameter("card_no");
			String amount = (request.getParameter("amount"));
			int price=0;
			int no_of_passengers=Integer.parseInt(request.getParameter("no_of_passengers"));
			RequestDispatcher rd=null;
			PrintWriter out = response.getWriter();
			//PaymentBo pb = new PaymentBo();
			SearchBo pb = new SearchBo();
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
		else if(action.equalsIgnoreCase("cancel"))
		{
			LOG.info("Cancel Ticket");
			RequestDispatcher rd = null;
			String ticketID = request.getParameter("cancel");
			System.out.println(ticketID);
			CancelTicketDao cd = new CancelTicketDao();
			try {
				cd.CancelTicket(ticketID);
				request.setAttribute("success", "Successfully cancelled");
				rd = request.getRequestDispatcher("cancelTicket.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
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


}
