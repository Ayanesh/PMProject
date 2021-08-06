package com.profilemanagement.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.profilemanagement.db.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession s = request.getSession();
	    
		 String mail=request.getParameter("email");  
	     String pass=request.getParameter("password"); 
        
       
	       
        if(LoginDAO.validate(mail,pass)){
        	
        	synchronized(s){
        	
        		s.setAttribute(mail,"mail");
        		s.setAttribute(pass, "pass");
            RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");  
            rd.forward(request,response);  
        }  }
        else{  
             
            RequestDispatcher rd=request.getRequestDispatcher("LoginFalied.jsp");  
            rd.include(request,response);  
        }  
              
       
        }  
      
		
	}

