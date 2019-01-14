package com.fb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;
import com.fb.util.DBUtility;

public class FlightDao {

	public List<FlightMo> getFlightList() throws ParseException, ApplicationException, DatabaseException {
		List<FlightMo> flightList = new ArrayList<FlightMo>();
		Connection con = DBUtility.getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(QueryConstants.VIEW_FLIGHT_LIST);
			while (rs.next()) {
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
				flightList.add(flight);
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}
		return flightList;
	}

	public String addFlight(FlightMo flight) throws SQLException, ApplicationException, DatabaseException {
		// java.sql.Date sqlDate=new java.sql.Date(flight.getDeparture_time().);
		Connection con = DBUtility.getConnection();

		// String query="select to_date(departure_time,'HH24:MI') from dual";

		// String querytime="insert into flight (departure_time) values
		// (to_date(?,'HH24:MI'))";
		Statement stmt = null;
		ResultSet result = null;
		PreparedStatement pstmt = null;
		stmt = con.createStatement();
		result = stmt.executeQuery(QueryConstants.FLIGHT_ID_SEQUENCE);
		result.next();
		String flight_id = result.getString(1);
		pstmt = con.prepareStatement(QueryConstants.INSERT_FLIGHT_DETAILS);
		// pstmt.setString(1, flight.getFlight_id());
		pstmt.setString(1, flight_id);
		pstmt.setString(2, flight.getSource());
		pstmt.setString(3, flight.getDestination());
		pstmt.setString(4, flight.getFlightFranchise());
		// System.out.println(new
		// SimpleDateFormat("dd-MMM-yyyy").format(flight.getDeparture_date())+"
		// "+new SimpleDateFormat("HH:mm").format(flight.getDeparture_time()));
		pstmt.setString(5, new SimpleDateFormat("dd-MMM-yyyy").format(flight.getDepartureDate()));
		pstmt.setString(6, flight.getDepartureTime());
		pstmt.setInt(7, flight.getJourneyTime());
		pstmt.setInt(8, flight.getTotalSeats());
		pstmt.setInt(9, flight.getFare());
		if (pstmt.executeUpdate() > 0) {
			pstmt.close();
			con.close();
			return flight_id;
		} else
			return "FL000";
	}

	public void deleteFlight(String Flight_id) throws ApplicationException, DatabaseException {

		System.out.println(Flight_id);

		Connection con = DBUtility.getConnection();

		// String queryString="delete from flight_list where id='f_id'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			stmt.executeUpdate("delete from flight where flight_id='" + Flight_id + "'");

		} catch (Exception sqe) {
			sqe.printStackTrace();
		}

	}

	/*
	 * public FlightMo getFlightById(String flightID) throws
	 * ApplicationException, DatabaseException { Connection con =
	 * DBUtility.getConnection(); FlightMo flight=new FlightMo(); ResultSet rs =
	 * null; PreparedStatement pstmt = null; try {
	 * 
	 * pstmt = con.prepareStatement(QueryConstants.GET_FLIGHT);
	 * pstmt.setString(1, flightID); rs = pstmt.executeQuery();
	 * 
	 * if (rs.next()) { flight.setFlightID(rs.getString(1));
	 * flight.setSource(rs.getString(2));
	 * flight.setDestination(rs.getString(3));
	 * flight.setFlightFranchise(rs.getString(4));
	 * flight.setDepartureDate(rs.getDate(5));
	 * flight.setDepartureTime(rs.getString(6));
	 * flight.setJourneyTime(rs.getInt(7)); flight.setTotalSeats(rs.getInt(8));
	 * flight.setFare(rs.getInt(9)); } } catch(SQLException sqe) {
	 * sqe.printStackTrace(); } finally { try { if (rs != null) { rs.close(); }
	 * if (con != null) { con.close(); } pstmt.close(); } catch (SQLException
	 * sqlException) { sqlException.printStackTrace(); } } return flight; }
	 */
	public List<FlightMo> getFlight() throws SQLException, ApplicationException, DatabaseException {
		Connection con = DBUtility.getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		List<FlightMo> flight_List = new ArrayList<FlightMo>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(QueryConstants.VIEW_FLIGHT_LIST);
			while (rs.next()) {
				// System.out.println(sdf1.parse(rs.getString(8)));

				FlightMo f1 = new FlightMo();

				// FlightMo f=new FlightMo(rs.getString(1),rs.getString(2),
				// rs.getString(3), rs.getString(4), sdf.parse(rs.getString(5)),
				// sdf.parse(rs.getString(6)),
				// Integer.parseInt(rs.getString(7)),
				// sdf1.parse(rs.getString(8)),Integer.parseInt(rs.getString(9)));
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
				// System.out.println("Success");
			}
		} catch (Exception sqe) {
			sqe.printStackTrace();
		}
		return flight_List;

	}

	public FlightMo getFlightById(String flightID) throws ApplicationException, DatabaseException {
		Connection con = null;
		con = DBUtility.getConnection();
		// Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FlightMo flight = new FlightMo();
		try {

			//LOG.info("Connected to database to get details");
			//String query = "select franchise,source,destination,fare,total_seats,departure_date,departure_time,journey_time from flight where flight_id=?";
			pstmt = con.prepareStatement(QueryConstants.GetFlightId);
			pstmt.setString(1, flightID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// flight.setFlightID(rs.getString(1));
				flight.setSource(rs.getString(2));
				flight.setDestination(rs.getString(3));
				flight.setFlightFranchise(rs.getString(1));
				flight.setDepartureDate(rs.getDate(6));
				flight.setDepartureTime(rs.getString(7));
				flight.setJourneyTime(rs.getInt(8));
				flight.setTotalSeats(rs.getInt(5));
				flight.setFare(rs.getInt(4));
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}
		return flight;
	}

	public void editFlight(FlightMo flight) throws ApplicationException, DatabaseException {
		try {
			Connection con = null;
			// Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = DBUtility.getConnection();

			// LOG.info("Connected to database to update details");
			//String query = "update flight set source=?, destination=?, franchise=?, departure_date=?, departure_time=?, journey_time=?, total_seats=?, fare=? where flight_id=?";
			pstmt = con.prepareStatement(QueryConstants.EditFlight);
			
			System.out.println(flight.getFlightID());
			pstmt.setString(1, flight.getSource());
			pstmt.setString(2, flight.getDestination());
			pstmt.setString(3, flight.getFlightFranchise());
			pstmt.setString(4,new SimpleDateFormat("dd-MMM-yyyy").format(flight.getDepartureDate()));
			pstmt.setString(5, flight.getDepartureTime());
			pstmt.setInt(6, flight.getJourneyTime());
			pstmt.setInt(7, flight.getTotalSeats());
			pstmt.setInt(8, flight.getFare());
			pstmt.setString(9, flight.getFlightID());
			int i=pstmt.executeUpdate();
			System.out.println(i);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}