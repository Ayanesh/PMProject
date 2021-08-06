package com.profilemanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {
	
	
	public int doRegister(String email, String fname, String mname, String lname, String password) {
		int count =0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");
			 
			 PreparedStatement ps = con.prepareStatement("insert into userTable(user_mail,user_fname,user_mname,user_lname,user_pass) values(?,?,?,?,?)");
			 ps.setString(1, email);
			 ps.setString(2, fname);
			 ps.setString(3, mname);
			 ps.setString(4, lname);
			 ps.setString(5, password);
			 
			 count=ps.executeUpdate();
			
			
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		
		return count;
	}

}
