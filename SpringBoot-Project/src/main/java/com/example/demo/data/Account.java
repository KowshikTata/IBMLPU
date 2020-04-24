package com.example.demo.data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_no")
	private int accountNumber;
	@Column(name="customer_relationship_no")
	private String accountID;
	@Column(name="account_type")
	private String accountType;
	@Column(name="balance")
	private Double balance;
	
	
	public Account() {
		super();
		
	}
	public Account(String accountID, String accountType, Double balance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
	}
}