package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fb.bo.LoginBo;
import com.fb.dao.LoginDao;
import com.fb.log.LoggerInitializer;
import com.fb.model.UserMo;

/**
 * Servlet implementation class LoginControl
 */
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("LoginControl");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Login Controller");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		LoginBo ulbo= new LoginBo();
		List<UserMo> list=null;
		RequestDispatcher rd=null;
		String role ="";
		LoginDao ld=new LoginDao();
		
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		try {
			boolean b=ulbo.loginValidate(email, password);
			if(b){
				
				
				//request.setAttribute("username",username);
				
				HttpSession session=request.getSession(true);
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

		
	


