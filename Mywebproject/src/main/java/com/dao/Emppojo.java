package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Empmodel;

public class Emppojo {
	
	public boolean mydao(Empmodel e) throws ClassNotFoundException {
		
		boolean status = false;
//		Connection con=null;
		
		String firstname = e.getFirstname();
		String lastname = e.getLastname();
		String username = e.getUsername();
		String pwd = e.getPwd();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection	con  = DriverManager.getConnection("jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");
		
		Statement s =con.createStatement();
	    int r = s.executeUpdate("insert into emp(firstname,lastname,username,pwd)values('"+firstname+"','"+lastname+"','"+username+"','"+pwd+"')");
		System.out.println(r);
		
		if(r>0) {
			status=true;
			System.out.println(status);
		}
		
		
		} 
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		return status;
		
	}
	
}
