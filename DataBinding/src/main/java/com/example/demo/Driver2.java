package com.example.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver2 {

	public static void main(String[] args) {
		
		try {
			
			ObjectMapper mapper=new ObjectMapper();
			Customer c=new Customer();
			c.setFirstName("Kowshik");
			c.setLastname("Tata");
			c.setId(1);
			c.setActive(true);
			Address address=new Address();
			address.setCity("Jalandhar");
			address.setState("Punjab");
			address.setStreet("LPU");
			address.setCountry("India");
			c.setAddress(address);
			mapper.writeValue(new File("data/result.json"), c);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
}
}
