package com.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyFactory {

	
	private Connection connection;
	private static MyFactory factory;
	private MyFactory() throws SQLException{
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","Tata123!");
	}
	
	private Connection getMyConnection()
	{
		
		return connection;
		
	}
	public static MyFactory getMyFactory() throws SQLException
	{
		if(factory==null)
		{
			factory=new MyFactory();
		}
		return factory;
		
	}
	
	
}
