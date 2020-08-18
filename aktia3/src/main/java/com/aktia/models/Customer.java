package com.aktia.models;

import java.io.Serializable;
import javax.persistence.*;


//Customer Entity - int uniqueId(autoincrement), String customerId, String customerName
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int uniqueId;

	private String customerId;

	private String customerName;

	public Customer() {
	}

	public int getUniqueId() {
		return this.uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Customer(String customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [uniqueId=" + uniqueId + ", customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}