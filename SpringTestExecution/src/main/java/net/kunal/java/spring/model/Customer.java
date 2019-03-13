package net.kunal.java.spring.model;

public class Customer {
	private int customerId;
	private String customerName;
	private double customerBalance;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerBalance="
				+ customerBalance + "]";
	}
}
