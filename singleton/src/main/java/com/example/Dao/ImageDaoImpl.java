package com.example.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.example.factory.MyConnectionFactory;
import com.example.model.Image;

public class ImageDaoImpl implements ImageDao {
	
	
			Scanner scanner=new Scanner(System.in);
			Image image=new Image();
	
		
		
	public void create(String imageId,String imageUrl,boolean isAvailable) {
		// TODO Auto-generated method stub
		MyConnectionFactory factory=new MyConnectionFactory();
		Connection connection;
		try {
			connection = factory.getMyConnection();

			PreparedStatement psSelect=connection.prepareStatement("insert into image values(?,?,?)");
			psSelect.setString(1, imageId);
			psSelect.setString(2, imageUrl);
			psSelect.setBoolean(3, isAvailable);
			psSelect.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	public void getImage() {
		MyConnectionFactory factory=new MyConnectionFactory();
		Connection connection;
		try {
			connection = factory.getMyConnection();

			PreparedStatement psSelect=connection.prepareStatement("select * from image");
			ResultSet rs=psSelect.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getBoolean(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	public void update(String oldurl, String newurl) {
		MyConnectionFactory factory=new MyConnectionFactory();
		Connection connection;
		try {
			connection = factory.getMyConnection();

			PreparedStatement psSelect=connection.prepareStatement("update image set imageUrl=? where imageUrl=?");
			psSelect.setString(1, newurl);
			psSelect.setString(2, oldurl);
			psSelect.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	public void delete(String url) {
		MyConnectionFactory factory=new MyConnectionFactory();
		Connection connection;
		try {
			connection = factory.getMyConnection();

			PreparedStatement psSelect=connection.prepareStatement("delete from image where imageUrl=?");
			psSelect.setString(1, url);
			
			psSelect.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

}

