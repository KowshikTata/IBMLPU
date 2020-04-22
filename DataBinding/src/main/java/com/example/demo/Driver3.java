package com.example.demo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

//another way (pojo to json)
public class Driver3 {

	public static void main(String[] args) {
		
		 Jsonb jsonb = JsonbBuilder.create();
		 Address ad=new Address();
		 ad.setCity("Jalandhar");
		 ad.setCountry("India");
		 ad.setState("Punjab");
		 ad.setStreet("LPU");
		 ad.setZip("144411");
		 String[] lang= {"Java","C++","SQL"};
		 String result=jsonb.toJson(new
		 Customer(1,"John","Doe",true,ad,lang));
		 System.out.println(result);
		 
		
	}
	
	
	
	
	
	
	
	
	
	
}
