package com.profilemanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class LoginDAO {

	public static boolean validate(String mail, String pass) {
		boolean flag=false;
		 
		 try {
			 
			 
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");
				
			 PreparedStatement ps = con.prepareStatement("select * from userTable where user_mail=? and user_pass=?");
			 
			 ps.setString(1, mail);
			 ps.setString(2, pass);
			 
			 ResultSet rs = ps.executeQuery();
			 flag=rs.next();
			
			
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		
		return flag;
		
		
	}

}
