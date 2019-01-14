package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fb.bo.LoginBo;
import com.fb.bo.RegistrationBo;
import com.fb.constants.Constants;
import com.fb.constants.ErrorConstants;
import com.fb.dao.LoginDao;
import com.fb.dao.RegistrationDao;
import com.fb.model.UserMo;
import com.fb.util.PropertyUtility;

/**
 * Servlet implementation class RegistrationControl
 */
public class RegistrationControl extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("RegistrationControl");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Logout controller initialized");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("userid");
		session.invalidate();
		
		//System.out.println(session.getAttribute("userid").toString());
		//session.removeAttribute("username");
		//out.print("you are successfully logout");
		response.sendRedirect("Login.jsp"); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String action = request.getParameter("action");
		if(action.equalsIgnoreCase("registration"))
		{
			LOG.info("Registration initialized");
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileNumber=request.getParameter("mobileNumber");
		String strDob=request.getParameter("dob");
		String aadhar = request.getParameter("aadhar");
		String gender = request.getParameter("gender");
		//PrintWriter out=response.getWriter();
		
		RequestDispatcher rd=null;
		RegistrationBo ub=new RegistrationBo();
		int userId=0;
		

			try
			{
				UserMo user = new UserMo();
				user.setFullName(fullName);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobileNumber(mobileNumber);
				user.setDob(new SimpleDateFormat("MM-dd-yyyy").parse(strDob));
				user.setAadharNumber(aadhar);
				user.setGender(gender);
				//user.setRole(Constants.DEFAULT_ROLE);
				userId=ub.registerUser(user);
				LOG.info("Registration details"+user.getFullName());
				LOG.info("Registration details"+user.getPassword());
			}
			catch(Exception sql)
			{
				sql.printStackTrace();
				//String message=PropertyUtility.getErrorMessage(ErrorConstants.USEREXISTS);
				request.setAttribute("success", "Email ID already registered!!!");
				rd=request.getRequestDispatcher("Registration.jsp");
				rd.forward(request, response);
			}
			if(userId>0)
			{
				
				rd=request.getRequestDispatcher("Login.jsp");
				//request.setAttribute("userid",userId);
			
				//request.setAttribute("fullname", fullName);
				rd.forward(request,  response);
			}
		
		
		
		
		
		}else if(action.equalsIgnoreCase("login"))
		{
			LOG.info("Login Controller");
			//PrintWriter out=response.getWriter();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			RegistrationBo ulbo=new RegistrationBo();
			List<UserMo> list=null;
			RequestDispatcher rd=null;
			String role ="";
			RegistrationDao ld=new RegistrationDao();
			
			try {
				boolean b=ulbo.loginValidate(email, password);
				if(b){
					
					
					//request.setAttribute("username",username);
					
					HttpSession session=request.getSession(true);
					//System.out.println(session.getId().toString());
					UserMo u=ulbo.getUser(email);
					
					//System.out.println(fullName);
				
				     role=ulbo.getRole(email);
				    // System.out.println(role);
				     
				     
				     if(role.equalsIgnoreCase("ADMIN"))
				     {
				    	 List<UserMo> list1=ulbo.getAdmin(email);
				    	 //System.out.println("Entered admin");
				    	 session.setAttribute("List", list1);
				    	 rd=request.getRequestDispatcher("admin.jsp");
				    	 rd.forward(request, response);
				     }
				     else
				     {
							
				    	 //System.out.println(u.getUserId());
					
					
				    session.setAttribute("username", u.getFullName());
				    session.setAttribute("userid", u.getUserId());
				    String sId = session.getId().toString();
				    String ticketid = sId.substring(0, 4)+u.getUserId();
				    System.out.println(ticketid);
				    session.setAttribute("ticketId", ticketid);
					rd=request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				     }
					//response.sendRedirect("welcome.jsp");
				}else{
					request.setAttribute("message","Incorrect Username/Password");
					//out.print("Incorrect userId and password");
					rd=request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
					
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

}
