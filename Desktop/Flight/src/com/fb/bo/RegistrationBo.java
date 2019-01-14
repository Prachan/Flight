package com.fb.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fb.dao.LoginDao;
import com.fb.dao.RegistrationDao;
import com.fb.exceptions.ApplicationException;
import com.fb.exceptions.DatabaseException;
import com.fb.model.UserMo;

public class RegistrationBo {
	
	public int registerUser(UserMo user12) throws Exception
		{
			String fullName = user12.getFullName();
			String email = user12.getEmail();
			String password = user12.getPassword();
			String mobileNumber = user12.getMobileNumber();
			Date dob = user12.getDob();
			String aadharNumber = user12.getAadharNumber();
			String gender = user12.getGender();
			UserMo user=new UserMo(fullName, email, password, mobileNumber, dob, aadharNumber, gender);
			RegistrationDao ud=new RegistrationDao();
			return ud.addUser(user);
		}
	
	
	
	
	public boolean loginValidate(String email,String password) throws ParseException,ApplicationException,DatabaseException{
		boolean valid = false;
		LoginDao ld=new LoginDao();
		List<UserMo> ul=ld.getUser();
		
	
		for(UserMo u:ul){
			
			if(u.getEmail().equals(email) && u.getPassword().equals(password)){
				
				valid=true;
				break;
			}
		}
		return valid;
	}
	
	public UserMo getUser(String email) throws ApplicationException, DatabaseException
	{
		//System.out.println(email);
		LoginDao ld=new LoginDao();
		
		List<UserMo> list=ld.getUserName1();
		
		String fullname=null;
		UserMo u=new UserMo();
		for(UserMo m:list)
		{
			//System.out.println(m.getEmail());
			if(m.getEmail().equalsIgnoreCase(email))
			{
				
				 u.setFullName(m.getFullName());
				 u.setUserId(m.getUserId());
				 break;
			
				
			}
		}
		return u;
	}
	
	
public String getRole(String email) throws ParseException, ApplicationException, DatabaseException
	{
		String role="";
		LoginDao ld=new LoginDao();
		List<UserMo> u1=ld.getRole();
		for(UserMo u:u1)
		{
			//System.out.println(u.getEmail()+" "+u.getRole()+" "+u.getFullName());
		}
		for(UserMo u:u1)
		{
			if(email.equals(u.getEmail()))
			{
				role=u.getRole();
			}
		}
		
          		
		
		return role;
		
	}
public List<UserMo> getAdmin(String email)
{

	LoginDao ld=new LoginDao();
	List<UserMo> list=new ArrayList<UserMo>();
	List<UserMo> list1=new ArrayList<UserMo>();
	try {
		list = ld.getRole();

		
		
		for(UserMo l:list)
		{
			if(l.getEmail().equals(email))
			{
				list1.add(l);
			}
		}
		
		
		
		
		
		
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list1;
}
	
	
	
	

}
