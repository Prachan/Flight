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

import org.apache.log4j.Logger;

import com.fb.constants.Constants;
import com.fb.constants.QueryConstants;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.UserMo;
import com.fb.util.DBUtility;

public class RegistrationDao implements RegistrationD{
	public static final Logger LOG =Logger.getLogger("RegistrationDao");
	public int addUser(UserMo user) throws Exception
	{
		LOG.info("Registration DAO called");
		
		Connection con=DBUtility.getConnection();
		PreparedStatement pstmt= null;
		int userId=0;
		//String queryString="select m_seq.nextval from dual";
		
		Statement stmt=con.createStatement();
		
		ResultSet result=stmt.executeQuery(QueryConstants.QUERYSTRING_1);
		result.next();
		userId=result.getInt(1);
		//String insertString="insert into users values(?,?,?,?,?,?)";
		pstmt=con.prepareStatement(QueryConstants.QUERYSTRING_2);
		pstmt.setString(1, user.getFullName());
		pstmt.setInt(2, userId);
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4,user.getMobileNumber());
		pstmt.setString(5, user.getEmail());
		
		//System.out.println(user.getMobileNumber());
		pstmt.setString(6, (new SimpleDateFormat("dd-MMM-yyyy")).format(user.getDob()));
		//pstmt.setString(7, user.getRole());
		
		if(pstmt.executeUpdate()>0)
			{
				LOG.info("Registration DAO: "+userId);
				return userId;
			}
		else
			return 0;
		
		
		
	
	}
	
	
	
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
