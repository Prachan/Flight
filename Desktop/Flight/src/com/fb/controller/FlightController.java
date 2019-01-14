package com.fb.controller;

import java.io.IOException;
import java.sql.SQLException;
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

import com.fb.bo.FlightBo;
import com.fb.dao.FlightDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

/**
 * Servlet implementation class FlightController
 */
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String insertedit = "/addflight.jsp";
	private static final Logger LOG = Logger.getLogger("FlightController");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String forward = "";
			FlightBo fbo = new FlightBo();
			final String action = request.getParameter("action");
			if (action.equalsIgnoreCase("edit")) {
				LOG.info("EDIT flight initialized");
				FlightMo flight = new FlightMo();
				forward = insertedit;
				String flightID = request.getParameter("flightID");
				flight = fbo.getFlightById(flightID);
				request.setAttribute("flight", flight);
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
				dispatcher.forward(request, response);
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("in f controller");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		final String action = request.getParameter("action");
		FlightMo flight=new FlightMo();
		RequestDispatcher rd = null;
		// TODO Auto-generated method stub
		if (action.equalsIgnoreCase("addFlight")) {
			LOG.info("ADD Flight initialized");
			try {
				
				flight.setSource(request.getParameter("source"));
				flight.setDestination(request.getParameter("destination"));
				flight.setFlightFranchise(request.getParameter("franchise"));
				flight.setDepartureDate(sdf2.parse(request.getParameter("departure_date")));
				flight.setDepartureTime(request.getParameter("departure_time"));
				flight.setJourneyTime(Integer.parseInt(request.getParameter("journey_time")));
				flight.setTotalSeats(Integer.parseInt(request.getParameter("noOfSeats")));
				flight.setFare(Integer.parseInt(request.getParameter("flightfare")));
				FlightBo fbo = new FlightBo();
				fbo.addFlight(flight);
				request.setAttribute("success", "Successfully Added!!!");
				rd = request.getRequestDispatcher("addFlight.jsp");
				rd.forward(request, response);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		else if (action.equalsIgnoreCase("update")) {
			LOG.info("Update initialized");
			try {
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				HttpSession session = request.getSession();
			String flightID =  request.getParameter("flight_id");
			//System.out.println(flightID);
			flight.setFlightID((String)session.getAttribute("flight_id"));
			//System.out.println(request.getParameter("departure_date"));
			flight.setDepartureDate(sdf1.parse(request.getParameter("departure_date")));
			flight.setDepartureTime(request.getParameter("departure_time"));
			flight.setDestination(request.getParameter("destination"));
			flight.setFare(Integer.parseInt(request.getParameter("flightfare")));
			flight.setFlightFranchise(request.getParameter("franchise"));
			flight.setJourneyTime(Integer.parseInt(request.getParameter("journey_time")));
			flight.setSource(request.getParameter("source"));
			flight.setTotalSeats(Integer.parseInt(request.getParameter("noOfSeats")));
			request.setAttribute("success", "Successfully Updated!!!");
			rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			FlightBo fbo=new FlightBo();
			try {
				fbo.editFlight(flight);
				System.out.println("edited");
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if (action.equalsIgnoreCase("delete")) {
		List<FlightMo> list = new ArrayList<FlightMo>();

		System.out.println(action);
		FlightDao fdao = new FlightDao();
		
			try {
				String Flight_id = request.getParameter("flight_id");
				fdao.deleteFlight(Flight_id);
				System.out.println("Flight Deleted");
				//request.setAttribute("success", "Successfully Deleted");
				request.setAttribute("success1", "Successfully deleted!!!");
				rd = request.getRequestDispatcher("ShowFlight.jsp");
				rd.forward(request, response);
				
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
