package com.fb.dao;

import java.sql.SQLException;
import java.util.List;

import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

public interface SearchD {
	
	public List<FlightMo> getSearchResult() throws SQLException, ApplicationException, DatabaseException;
	public void addTraveller(String first_name, String last_name, String aadhar,String userId,String flightid,String ticketId);
	public void CancelTicket(String ticketid) throws SQLException, ApplicationException, DatabaseException;

}
