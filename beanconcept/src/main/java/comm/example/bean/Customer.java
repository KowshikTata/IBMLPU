package comm.example.bean;




public class Customer {
	
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", address=" + address + "]";
	}

	private String customerID;
	private String customerName;
	private Address address;
	
	public Customer(String customerName, Address address) {
	
		this.customerName = customerName;
		this.address = address;
	}

	public Customer() {
		super();
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	
	

}
