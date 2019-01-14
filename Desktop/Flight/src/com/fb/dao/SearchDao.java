package com.fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;
import com.fb.model.UserMo;
import com.fb.util.DBUtility;

public class SearchDao implements SearchD{
	private static final Logger LOG = Logger.getLogger("SearchDao");
	
	public List<FlightMo> getSearchResult() throws SQLException, ApplicationException, DatabaseException
	{
		Connection con=DBUtility.getConnection();
		//String queryString="select * from flight_list";
		Statement stmt=null;
		ResultSet rs=null;
		List<FlightMo> flight_List=new ArrayList<FlightMo>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		try
		{
		stmt=con.createStatement();
		rs=stmt.executeQuery(QueryConstants.VIEW_FLIGHT_LIST);
		while(rs.next())
		{
			//System.out.println(sdf1.parse(rs.getString(8)));
			FlightMo flight = new FlightMo();
			flight.setFlightID(rs.getString(1));
			flight.setSource(rs.getString(2));
			flight.setDestination(rs.getString(3));
			flight.setFlightFranchise(rs.getString(4));
			flight.setDepartureDate(rs.getDate(5));
			flight.setDepartureTime(rs.getString(6));
			flight.setJourneyTime(rs.getInt(7));
			flight.setTotalSeats(rs.getInt(8));
			flight.setFare(rs.getInt(9));
			
			flight_List.add(flight);
		//System.out.println("Success");
		}
		}
		catch(Exception sqe)
		{
		sqe.printStackTrace();
		}
		return flight_List;
		
		
	}
	
	
	public void addTraveller(String first_name, String last_name, String aadhar,String userId,String flightid,String ticketID)
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
	            pstmt.setString(6, ticketID);
	            pstmt.executeUpdate();
	            //System.out.println(pstmt.executeUpdate());
	con.close();  
	pstmt.close();
	}catch(Exception e){ e.printStackTrace();}  
	}
	
	public String generateTicketId(String userId) throws ApplicationException, DatabaseException, SQLException
	{
		LOG.info("Generate TicketId");
		Connection conn = DBUtility.getConnection();
		//PreparedStatement pstmt= null;
		Statement stmt =conn.createStatement();
		//ResultSet result1 = null;
		String sql2= "select ticketseq.nextval from dual";
		ResultSet result1=stmt.executeQuery("select ticketseq.nextval from dual");
		result1.next();
		String ticketId = result1.getString(1);
		//String sql = "update booking set ticket_id = ? where userid = ? ";
		/*PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ticketId);
		pstmt.setString(2, userId);
		pstmt.executeUpdate();
		System.out.println("Statement executed");
		try
		{
			//Statement stmt1 =conn.createStatement();
			System.out.println("Statement Created");
			System.out.println(ticketId+"  "+userId);
			String sql = "update booking set ticket_id = ? where userid = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ticketId.trim());
			pstmt.setString(2, userId.trim());
			pstmt.executeUpdate();
			//stmt1.executeUpdate("update booking set ticket_id="+ticketId+" where userid="+ userId +"and ticket_id is null");
			System.out.println("executed");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}*/
		return (ticketId);
	}
	
	public void addTicket(String ticketId,String userid) throws ApplicationException, DatabaseException, SQLException
	{
		Connection com=DBUtility.getConnection();
		String sql = "update booking set ticket_id=? where userid=? and ticket_id is null";
		Statement stmt = null;
		stmt = com.createStatement();
		String s="insert into booking(ticket_id) VALUES('"+ticketId+"') where  userid='"+userid+"' and ticket_id is null";
		System.out.println(s);
		stmt.executeUpdate("insert into booking(ticket_id) VALUES('"+ticketId+"') where  userid='"+userid+"' and ticket_id is null");
		
		System.out.println("Byee");
		/*PreparedStatement pst= null;
		pst = com.prepareStatement(sql);
		pst.setString(1,ticketId);
		pst.setString(2,userid);
		System.out.println("Hiiii");
		pst.execute();*/
		//System.out.println("Byeeee");
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
	
	public void CancelTicket(String ticketid) throws SQLException, ApplicationException, DatabaseException
	{
		LOG.info("Cancel Ticket Dao: Cancel Ticket");
		System.out.println("Entered "+ticketid);
		Connection con=DBUtility.getConnection();
		PreparedStatement pstmt= null;
		//String queryString="select m_seq.nextval from dual";
		//String insertString="DELETE FROM TICKETS WHERE TICKETID=?";
		System.out.println("1");
		pstmt=con.prepareStatement(QueryConstants.CANCEL_TICKET);
		pstmt.setInt(1, Integer.parseInt(ticketid));
		System.out.println("2");
		
		pstmt.execute();
		System.out.println("3");
		
	}
	
	

}
