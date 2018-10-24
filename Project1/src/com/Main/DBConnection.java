package com.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connection;
	
	public static Connection getConnection()
	{
		try {
			if(connection == null || connection.isClosed())
			{
				new DBConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	private DBConnection()//singleton method i.e. we can create only one object
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//class is a name of class in java
				
				String username="sqlserveruser1";
				String password="smonu2511";
				
				String url="jdbc:sqlserver://USER-PC\\SQLEXPRESS"+";databaseName=projectdb1";//jdbc:sqlserver://=protocol name	USER-PC=pc name \\=used to give single backslash
				connection=DriverManager.getConnection(url, username, password);//static method
				//connection is a interface
			} catch (ClassNotFoundException ex) 
			{
				System.out.println(ex);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
