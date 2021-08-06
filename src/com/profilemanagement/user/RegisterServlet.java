package com.profilemanagement.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.profilemanagement.db.Register;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String password=request.getParameter("password"); 
		
		Register r = new Register();
	int status=	r.doRegister(email, fname, mname, lname, password);
	if(status>0) {
		 RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");  
         rd.forward(request,response);  
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("RegFailed.jsp");  
        rd.forward(request,response);  
	}
	r=null;
	
	
		
	}

}
