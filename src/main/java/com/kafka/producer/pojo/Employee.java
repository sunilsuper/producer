package com.kafka.producer.pojo;

import java.util.List;

public class Employee {
	 
		private String name;  
		private String id;  
		private double sal;  
		private String location;  
		private List<Message> Message;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public double getSal() {
			return sal;
		}
		public void setSal(double sal) {
			this.sal = sal;
		}
		public List<Message> getMessage() {
			return Message;
		}
		public void setMessage(List<Message> message) {
			Message = message;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
}
