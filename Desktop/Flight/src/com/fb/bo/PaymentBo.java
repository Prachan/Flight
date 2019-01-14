package com.fb.bo;

	import java.sql.SQLException;
	import java.util.Map;
	import java.util.Map.Entry;
	import java.util.Set;

	import com.fb.dao.PaymentDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;

	public class PaymentBo {
		
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

