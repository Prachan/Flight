package com.fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.util.DBUtility;

public class CancelTicketDao {
	private static final Logger LOG = Logger.getLogger("CancelTicketDao");
	
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
