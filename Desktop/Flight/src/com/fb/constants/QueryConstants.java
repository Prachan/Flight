package com.fb.constants;

public class QueryConstants {
	
	public static final String QUERYSTRING_1= "select m_seq.nextval from dual";
	public static final String QUERYSTRING_2= "insert into users(fullname,userid,password,mobilenumber,email,dob) values(?,?,?,?,?,?)";
	public static final String QUERYSTRING_3 = "select * from flight";
	//public static final String QUERYSTRING_4 = "select flight_id,departure_date from flight";
	public static final String CANCEL_TICKET = "DELETE FROM TICKETS WHERE TICKETID=?";
	public static final String VIEW_FLIGHT_LIST="select * from flight";
	public static final String FLIGHT_ID_SEQUENCE="select flight_seq.nextval from dual";
	public static final String INSERT_FLIGHT_DETAILS="insert into flight values(?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_FLIGHT = "INSERT INTO booking(passenger_id,name,aadhar,userid,flightid,TICKET_ID) VALUES(?,?,?,?,?,?)";
	public static final String GET_FLIGHT="select franchise,source,destination,fare,total_seats,departure_date,departure_time,journey_time from flight where flight_id=?";
	public static final String SQL1 = "select m_passenger.nextval from dual";
	public static final String SQL2 = "select ticketseq.nextval from dual";
	public static final String UPDATE_TICKET = "update booking set ticket_id=? where userid=? and ticket_id is null";
	public static final String GetFlightId="select franchise,source,destination,fare,total_seats,departure_date,departure_time,journey_time from flight where flight_id=?";
	public static final String EditFlight="update flight set source=?, destination=?, franchise=?, departure_date=?, departure_time=?, journey_time=?, total_seats=?, fare=? where flight_id=?";
	//public static final String QUERYSTRING_5 = "delete from flight_list1  where flight_id='"+Flight_id+"'";
	public static final String GETUSERNAME="select fullname,email,userid from users";
	public static final String GETROLE="select fullname,email,mobilenumber,role from users";
	public static final String PAYMENT="select cno,balance from paymentdb";

}
