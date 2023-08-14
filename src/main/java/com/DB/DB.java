package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection getConnection() {
		
		
		try {
			
			//register driver [load the driver]
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//getConnection(url, username, password)
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
}
