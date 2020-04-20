package comm.example.model;

import java.util.LinkedHashMap;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private LinkedHashMap<String,String> countryOptions;
	private String favouriteLanguage;
	private String[] operatingSystems;
	
	
	


	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}


	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}


	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


	public Student() {
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("IN","India");
		countryOptions.put("UK","United Kingdom");
		countryOptions.put("US","United States");
		
	}


	public Student( String firstName, String lastName, String email) {
	
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
}
