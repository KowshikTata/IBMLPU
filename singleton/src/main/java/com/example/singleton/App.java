package com.example.singleton;


import java.util.Scanner;
import java.util.UUID;

import com.example.service.ImageService;
import com.example.service.ImageServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Scanner scanner = new Scanner(System.in);

		/*
		 * MyConnectionFactory factory,factory1=null;
		 * factory=MyConnectionFactory.getConnectionObject();
		 * factory1=MyConnectionFactory.getConnectionObject();
		 * System.out.println(factory==factory1); try { Connection
		 * connection=factory.getMyConnection(); System.out.println(connection);
		 * Connection connection1=factory.getMyConnection();
		 * System.out.println(connection1); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
    	int choice = 0;
    	do {
    	
    	ImageService imgService=new ImageServiceImpl();
    	System.out.println("1. Create Image.");
		System.out.println("2. Display Iamge");
		System.out.println("3. Update Image");
		System.out.println("4. Delete Image");
		System.out.println("5. Exit");
		System.out.print("chose your choice: ");
		choice=scanner.nextInt();
    	
		switch (choice) {
		case 1:
			String imageId=UUID.randomUUID().toString();
			System.out.print("Enter ImageUrl: ");
			String imageUrl=scanner.next();
			System.out.print("Enter ImageAvailability: ");
			Boolean isAvailable=scanner.nextBoolean();
			imgService.create(imageId, imageUrl, isAvailable);
			break;
		case 2:
			imgService.getImage();
			break;
		case 3:
			System.out.print("Enter ImageUrl: ");
			String oldUrl=scanner.next();
			System.out.print("Enter New ImageUrl: ");
			String newUrl=scanner.next();
			imgService.update(oldUrl, newUrl);
			break;
		case 4:
			System.out.print("Enter ImageUrl: ");
			String url=scanner.next();
			imgService.delete(url);
			break;
		case 5:
			System.out.println("bye.!!!!!");
			System.exit(0);
			break;
		default:
			break;
		}

	} while (choice != 0);
    	
    } 
}

