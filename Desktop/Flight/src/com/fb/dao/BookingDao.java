package com.fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.UserMo;
import com.fb.util.DBUtility;

public class BookingDao {
	private static final Logger LOG = Logger.getLogger("BookingDao");
	
	public void addTraveller(String first_name, String last_name, String aadhar,String userId,String flightid)
	{
	try{  
		LOG.info("Booking dao: add traveller");
		UserMo u = new UserMo();
		
		
		
		
		Connection con=DBUtility.getConnection();
		String name= first_name+" "+last_name;
	
		PreparedStatement pstmt= null;
		int passengerId=0;
		
		Statement stmt=con.createStatement();
		//String sql1 = "select m_passenger.nextval from dual";
		//String sql2= "select ticketseq.nextval from dual";
		ResultSet result=stmt.executeQuery(QueryConstants.SQL1);
		
		result.next();
		passengerId=result.getInt(1);
		
		//String sql = "INSERT INTO booking(passenger_id,name,aadhar,userid,flightid) VALUES(?,?,?,?,?)"; 
		pstmt = con.prepareStatement(QueryConstants.INSERT_FLIGHT); 
	
		result.next();
	        pstmt.setInt(1, passengerId);
	            pstmt.setString(2, name);
	            pstmt.setString(3, aadhar);
	            pstmt.setString(4, userId);
	            pstmt.setString(5, flightid);
	            pstmt.executeUpdate();
	            //System.out.println(pstmt.executeUpdate());
	con.close();  
	pstmt.close();
	}catch(Exception e){ e.printStackTrace();}  
	}
	/*public int generateTicketId(String userid) throws ApplicationException, DatabaseException, SQLException
	{	LOG.info("Booking dao: generate Ticket id");
		//Statement stmt = null;
		System.out.println("Entered");
		System.out.println(userid);	
		Connection con=DBUtility.getConnection();
		Statement stmt=con.createStatement();
		PreparedStatement pstmt= null;
		//String sql2= "select ticketseq.nextval from dual";
		ResultSet result1=stmt.executeQuery(QueryConstants.SQL2);
		result1.next();
		String ticketId = result1.getString(1);
		System.out.println(ticketId);
		//String sql = "update booking set ticket_id=? where userid=? and ticket_id is null";
		System.out.println("1");
		pstmt = con.prepareStatement(QueryConstants.UPDATE_TICKET);
		System.out.println("2");
		pstmt.setString(1,ticketId);
		System.out.println("3");
		pstmt.setString(2, userid);
		System.out.println("4");
		ResultSet rs2=pstmt.executeQuery();
		rs2.next();
		//con.close();
		System.out.println("5");
		
		
			return Integer.parseInt(ticketId);
		//return 1;
		
	}*/
	
	
}
