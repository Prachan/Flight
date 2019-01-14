package com.fb.model;


import java.util.Date;

public class FlightMo {
private String flightID;
private String source;
private String destination;
private String flightFranchise;
private Date departureDate;
private String departureTime;
private int journeyTime;
private int totalSeats;
private int fare;
public String getFlightID() {
return flightID;
}
public void setFlightID(String flightID) {
this.flightID = flightID;
}
public String getSource() {
return source;
}

public void setSource(String source) {
this.source = source;
}
public String getDestination() {
return destination;
}
public void setDestination(String destination) {
this.destination = destination;
}
public String getFlightFranchise() {
return flightFranchise;
}
public void setFlightFranchise(String flightFranchise) {
this.flightFranchise = flightFranchise;
}
public Date getDepartureDate() {
return departureDate;
}
public void setDepartureDate(Date departureDate) {
this.departureDate = departureDate;
}
public String getDepartureTime() {
return departureTime;
}
public void setDepartureTime(String departureTime) {
this.departureTime = departureTime;
}
public int getJourneyTime() {
return journeyTime;
}
public void setJourneyTime(int journeyTime) {
this.journeyTime = journeyTime;
}
public int getTotalSeats() {
return totalSeats;
}
public void setTotalSeats(int totalSeats) {
this.totalSeats = totalSeats;
}
public int getFare() {
return fare;
}
public void setFare(int fare) {
this.fare = fare;
}
}

