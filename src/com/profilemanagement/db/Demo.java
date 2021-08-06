package com.profilemanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
public static void main(String[] args) throws SQLException {
	String query="select * from userTable where user_mail=? and user_pass=?";
	String mail="ayanesh.2000@gmail.com";
	String password="admin";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sinhaPersonal","Connect@Here1122");

PreparedStatement smt= con.prepareStatement(query);
smt.setString(1, mail);
smt.setString(2,password);

ResultSet rs = smt.executeQuery();
while(rs.next()) {
	System.out.println("Admin Email is: "+rs.getString(1));
	System.out.println("Admin Name is: "+rs.getString(2).toUpperCase()+" "+rs.getString(3).toUpperCase()+" "+rs.getString(4).toUpperCase());
	
	System.out.println("Admin Password is: "+rs.getString(5));
}
	

}
}
