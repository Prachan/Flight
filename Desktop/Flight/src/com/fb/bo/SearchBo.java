package com.fb.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fb.dao.PaymentDao;
import com.fb.dao.SearchDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.FlightMo;

public class SearchBo {
	

	public List<FlightMo> validateSearch(FlightMo flight) throws SQLException, ApplicationException, DatabaseException
	{
		//impleDateFormat sdf = SimpleDateFormat("");
		SearchDao sdo = new SearchDao();
		List<FlightMo> li = new ArrayList<FlightMo>();
		List<FlightMo> list = sdo.getSearchResult();
		String source = flight.getSource();
		String destination = flight.getDestination();
		String franchise = flight.getFlightFranchise();
		Date departure = flight.getDepartureDate();
		//System.out.println(departure);
		for(FlightMo f: list)
		{
			//System.out.println(f.getFrom_location()+"   "+f.getTo_location());
			if(f.getSource().equalsIgnoreCase(source))
			{
				if(f.getDestination().equalsIgnoreCase(destination))
				{
					if(f.getFlightFranchise().equalsIgnoreCase(franchise))
					{
						//System.out.println(f.getDepartureDate());
						if(f.getDepartureDate().equals(departure))
						{
							li.add(f);
						}
						
					}
					
				}
				
				
			}
		}
		
		return li;
		
	}
	
	
	
	public int validatePayment(String card_no, String amount, int number_of_passengers) throws NumberFormatException, SQLException, ApplicationException, DatabaseException
	{
		//boolean valid=false;
	PaymentDao pd = new PaymentDao();
	Map<String , Integer> map = pd.getBalance();
	
	if(map.containsKey(card_no)==false)
	{
		return 1;
	}
	for(Map.Entry<String,Integer> m:map.entrySet())
	{
		if((m.getKey()).equals(card_no))
		{
			if(m.getValue()>=Long.parseLong(amount)*number_of_passengers)
				return 2;
		}
	}
	return 3;
	}



}
