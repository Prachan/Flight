package com.fb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;

public class DBUtility {

	public static Connection getConnection() throws ApplicationException,DatabaseException
	{
		ResourceBundle rb=ResourceBundle.getBundle("db");
		String driver=rb.getString("driver");
		String url=rb.getString("url");
		String username=rb.getString("username");
		String password=rb.getString("password");
		Connection con=null;
		try
		{
		Class.forName(driver);
		System.out.println("Driver loaded");
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Connected");
		}
		catch(ClassNotFoundException cnf)
		{
		cnf.printStackTrace();
		}
		catch(SQLException sql)
		{
			throw new DatabaseException(sql);
		}
		return con;
	}
}
