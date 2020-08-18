package com.aktia.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomertaskTest {

	@Test
	void testCustomertaskStringStringStringString() {
		Customertask customerTask = new Customertask("abcdefg123456789", "TestiKuvaus", "true", "123456789abcdefg");
		assertEquals("abcdefg123456789", customerTask.getCustomerId());
		assertEquals("TestiKuvaus", customerTask.getTaskDescription());
		assertEquals("true", customerTask.getTaskDone());
		assertEquals("123456789abcdefg", customerTask.getTaskId());
	}

	@Test
	void testToString() {
		Customertask customerTask = new Customertask("abcdefg123456789", "TestiKuvaus", "true", "123456789abcdefg");
		assertEquals("Customertask [customerId=abcdefg123456789, taskDescription=TestiNimi, ]", customerTask.toString());
	}

}
