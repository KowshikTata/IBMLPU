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
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountID=" + accountID + ", accountType=" + accountType
				+ ", balance=" + balance + "]";
	}

	
}
