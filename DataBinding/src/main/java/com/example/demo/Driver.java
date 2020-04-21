package com.example.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

public static void main(String[] args) {
	
	try {
		
		ObjectMapper mapper=new ObjectMapper();
		
		Customer myCustomer=mapper.readValue(new File("data/sample.json"),Customer.class);
		
		System.out.println("fname="+myCustomer.getFirstName());
		System.out.println("lname="+myCustomer.getLastName());
		Address myAddress=myCustomer.getAddress();
		System.out.println("street="+myAddress.getState());
		System.out.println("street="+myAddress.getCountry());
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
}

}
