package com.fb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.PaymentInfo;
import com.fb.util.DBUtility;

public class PaymentDao {
	private static final Logger LOG=Logger.getLogger("PaymentDao");
	public Map<String, Integer> getBalance() throws NumberFormatException, SQLException, ApplicationException, DatabaseException
	{
		Map<String,Integer> map = new HashMap<String, Integer>();
		Connection con=DBUtility.getConnection();
		//String queryString="select cno,balance from paymentdb";
		LOG.info("Payment DAO Called-getBalanceList");
		Statement stmt=null;
		ResultSet rs=null;
		int blnc=0;
		String cno=null;
		
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(QueryConstants.PAYMENT);
			while(rs.next())
			{
				cno = rs.getString(1);
				blnc = Integer.parseInt(rs.getString(2));
				map.put(cno,blnc);
				LOG.info("Payment DAO-Data of user : "+cno);
				
			}
		}catch(SQLException sqe)
		{
			LOG.info("Payment DAO- SQL Exception throwed");
		sqe.printStackTrace();
		}
		finally
		{
			try{
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return map;
		}

}