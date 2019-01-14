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

import org.apache.log4j.Logger;

import com.fb.bo.SearchBo;
import com.fb.dao.FlightDao;

import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

/**
 * Servlet implementation class SearchControl
 */
public class ShowFlightControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("ShowFlightControl");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFlightControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LOG.info("show Flight Control initialized");
		System.out.println("in controller");
		
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		List<FlightMo> l1 = new ArrayList<FlightMo>();
		FlightDao sfd=new FlightDao();
	        
			List<FlightMo> list=null;
			try {
				list = sfd.getFlight();
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
			
			
		
		
			
		

			
			if(list.size()==0)
			{
			
				request.setAttribute("error", "Ooopsss!!!Flight Not Found");
				rd = request.getRequestDispatcher("Showflight.jsp");
				rd.include(request, response);
				LOG.info("Flight not found error!!!");
			}
			else
			{
				rd= request.getRequestDispatcher("ShowFlight.jsp");
				
				request.setAttribute("list", list);
				rd.include(request, response);
			}
			
			
		
		
		
		
		
	}


}
