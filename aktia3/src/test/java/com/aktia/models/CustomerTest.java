package com.aktia.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testCustomerStringString() {
		Customer customer = new Customer("abcdefg123456789", "TestiNimi");
		assertEquals("TestiNimi", customer.getCustomerName());
		assertEquals("abcdefg123456789", customer.getCustomerId());
	}

	@Test
	void testToString() {
		Customer customer = new Customer("abcdefg123456789", "TestiNimi");
		assertEquals("Customer [customerId=abcdefg123456789, taskDescription=TestiKuvaus, taskDone=true, taskId=123456789abcdefg]", customer.toString());
	}

}
