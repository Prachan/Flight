package com.fb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fb.bo.FlightBo;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

/**
 * Servlet implementation class CancelFlightControl
 */
public class CancelFlightControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("CancelFlightControl");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelFlightControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Flight_id=request.getParameter("Flight_id");
		String dep_date=request.getParameter("departure_date");
		System.out.println(Flight_id);
		System.out.println(dep_date);
		//List<FlightMo> list=new ArrayList<FlightMo>();
		FlightBo cb=new FlightBo();
		RequestDispatcher rd = null;
		try {
			if(cb.validateFlight(Flight_id,new SimpleDateFormat("yyyy-MM-dd").parse(dep_date)))
			{
				LOG.info("Cancel Flight True: "+Flight_id);
				System.out.println("Flight deleted");
				request.setAttribute("success", "Flight Deleted");
				rd=request.getRequestDispatcher("CancelFlight.jsp");
				rd.forward(request, response);
			}
			else
			{
				LOG.info("Cancel Flight False: "+Flight_id);
				System.out.println("flight not found");
				request.setAttribute("success", "Flight Not Found");
				rd=request.getRequestDispatcher("CancelFlight.jsp");
				rd.forward(request, response);
			}
		} catch (ParseException e) {
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
