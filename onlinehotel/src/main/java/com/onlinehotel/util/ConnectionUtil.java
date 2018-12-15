package com.onlinehotel.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionUtil {
	public ConnectionUtil(){}

	public static Connection getConnection() throws SQLException{
		Connection conobj=null;

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conobj=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/onlinehotel","root","root");
			if(conobj==null)
			{
				System.out.println("no connection ");
			
			}
			else
			{
			System.out.println("Connection established");	
			}
		
		
		return conobj;
	}

}
