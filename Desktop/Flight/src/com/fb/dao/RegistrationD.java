package com.fb.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.UserMo;

public interface RegistrationD {
	public int addUser(UserMo user) throws Exception;
public List<UserMo> getUser() throws ParseException, SQLException, ApplicationException, DatabaseException;
	
	public List<UserMo> getUserName1() throws ApplicationException, DatabaseException;


}
