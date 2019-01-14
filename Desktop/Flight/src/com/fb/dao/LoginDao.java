package com.fb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.UserMo;
import com.fb.util.DBUtility;

public class LoginDao implements LoginD {
	private static final Logger LOG = Logger.getLogger("LoginDao");
public List<UserMo> getUser() throws ParseException, ApplicationException, DatabaseException{
	
		List<UserMo> ul=new ArrayList<UserMo>();
		Connection con=DBUtility.getConnection();
		String query="select email,password from users";
		String query1 = "insert into users(role) values(?)";
		ResultSet rs=null;
		LOG.info("Login DAO Called-getCustomerList");
		try {
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			//System.out.println(rs.getString(1));
			while(rs.next()){
				
				UserMo u=new UserMo(rs.getString(1),rs.getString(2));
				//System.out.println(u.getEmail());
				ul.add(u);
				//System.out.println(ul);
				
				LOG.info("Login DAO-Data inserted of user : "+u.getFullName());
			}
			
		} catch (SQLException sqe) {
			LOG.info("Login DAO-SQL Exception Thread");
			// TODO Auto-generated catch block
			sqe.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return ul;
	
}
public List<UserMo> getUserName1() throws ApplicationException, DatabaseException
{

	List<UserMo> ul=new ArrayList<UserMo>();
	Connection con=DBUtility.getConnection();
	//String query="select fullname,email,userid from users";
	ResultSet rs=null;
	LOG.info("Login DAO Called-getCustomerList");
	try {
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(QueryConstants.GETUSERNAME);
		//System.out.println(rs.getString(1));
		while(rs.next()){
			
			UserMo u=new UserMo(rs.getString(1),rs.getString(2),rs.getInt(3));
			//System.out.println(u.getEmail());
			ul.add(u);
			//System.out.println(ul);
			
			LOG.info("Login DAO-Data inserted of user : "+u.getFullName());
		}
		
	} catch (SQLException sqe) {
		LOG.info("Login DAO-SQL Exception Thread");
		// TODO Auto-generated catch block
		sqe.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	return ul;
	
}

public List<UserMo> getRole() throws ApplicationException, DatabaseException
{

	List<UserMo> ul=new ArrayList<UserMo>();
	Connection con=DBUtility.getConnection();
	//String query="select fullname,email,mobilenumber,role from users";
	ResultSet rs=null;
	LOG.info("Login DAO Called-getCustomerList");
	try {
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(QueryConstants.GETROLE);
		//System.out.println(rs.getString(1));
		while(rs.next()){
			
			UserMo u=new UserMo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			//System.out.println(u.getEmail());
			ul.add(u);
			//System.out.println(ul);
			
			LOG.info("Login DAO-Data inserted of user : "+u.getRole());
		}
		
	} catch (SQLException sqe) {
		LOG.info("Login DAO-SQL Exception Thread");
		// TODO Auto-generated catch block
		sqe.printStackTrace();
	}
	finally
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	return ul;
	
}



           


}
