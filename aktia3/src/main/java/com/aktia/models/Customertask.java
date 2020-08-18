package com.aktia.models;

import java.io.Serializable;
import javax.persistence.*;


//Customertask Entity - int customerTasksId(autoincrement), String customerId, String taskDescription, String taskDone, String taskId
@Entity
@NamedQuery(name="Customertask.findAll", query="SELECT c FROM Customertask c")
public class Customertask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int customerTasksId;

	private String customerId;

	private String taskDescription;

	private String taskDone;

	private String taskId;
	
	

	public Customertask(String customerId, String taskDescription, String taskDone,
			String taskId) {
		super();
		this.customerId = customerId;
		this.taskDescription = taskDescription;
		this.taskDone = taskDone;
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "Customertask [customerTasksId=" + customerTasksId + ", customerId=" + customerId + ", taskDescription="
				+ taskDescription + ", taskDone=" + taskDone + ", taskId=" + taskId + "]";
	}

	public Customertask() {
	}

	public int getCustomerTasksId() {
		return this.customerTasksId;
	}

	public void setCustomerTasksId(int customerTasksId) {
		this.customerTasksId = customerTasksId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTaskDescription() {
		return this.taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskDone() {
		return this.taskDone;
	}

	public void setTaskDone(String taskDone) {
		this.taskDone = taskDone;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}