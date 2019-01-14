package com.fb.dao;

import java.util.List;

import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

public interface CancelFlightD {
	public List<FlightMo>  getFlight() throws ApplicationException, DatabaseException;
	public void deleteFlight(String Flight_id) throws ApplicationException, DatabaseException;

}
