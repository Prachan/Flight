package com.fb.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fb.constants.ErrorConstants;
import com.fb.dao.FlightDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

public class FlightBo {
	static FlightDao fdao = new FlightDao();
	public String addFlight(FlightMo flight)
			throws ParseException, SQLException, ApplicationException, DatabaseException {
		//FlightDao fdao = new FlightDao();
		String flightId = "FL000";
		if (FlightBo.validateFlight(flight.getDepartureDate())) {
			flightId = fdao.addFlight(flight);
		}
		return flightId;
	}

	public static boolean validateFlight(Date departureDate)
			throws ParseException, ApplicationException, DatabaseException {
		boolean valid = true;
		//FlightDao fdao = new FlightDao();
		List<FlightMo> flightList = fdao.getFlightList();
		for (FlightMo flight : flightList) {
			if (flight.getDepartureDate().equals(departureDate))
				valid = false;
			Calendar today = Calendar.getInstance();
			if (departureDate.before(today.getTime())) {
				valid = false;
			}
		}
		return valid;
	}

	public boolean validateFlight(String Flight_id, Date departure_date)
			throws ApplicationException, DatabaseException, ParseException {
		System.out.println(departure_date);
		List<FlightMo> list = new ArrayList<FlightMo>();
		
		boolean flag = false;
		list = fdao.getFlightList();
		for (FlightMo f : list) {
			if (f.getFlightID().equals(Flight_id)) {
				System.out.println("flight_id found");
				if (f.getDepartureDate().equals(departure_date)) {
					flag = true;
					fdao.deleteFlight(Flight_id);

				}
			}
		}

		return flag;

	}
	public FlightMo getFlightById(String FlightID) throws ApplicationException, DatabaseException
	{
		return fdao.getFlightById(FlightID);
	}
	public void editFlight(FlightMo flight) throws ApplicationException, DatabaseException
	{
	FlightDao fdao=new FlightDao();
	fdao.editFlight(flight);
	}
}
