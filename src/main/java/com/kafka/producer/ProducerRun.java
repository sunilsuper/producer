package com.kafka.producer;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.pojo.Employee;
import com.kafka.producer.pojo.EmployeeDetails;
import com.kafka.producer.pojo.Message;

public class ProducerRun {
	  private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class);
	    public static void main(String[] args) throws IOException {
	    	log.info("Producer Demo Started");
	    	ProducerDemo.producer(getEmployeeDetails());
	    }
	    
	    private static  String getEmployeeDetails()
	    {   ObjectMapper Obj = new ObjectMapper();  
	    	Employee empObj1=new Employee();
	    	Employee empObj2=new Employee();
	    	Message mesObj1=new Message();
	    	Message mesObj2=new Message();
	    	Message mesObj3=new Message();
	    	Message mesObj4=new Message();
	    	EmployeeDetails empDetObj =new EmployeeDetails();
	    	ArrayList<Employee> empList=new ArrayList<Employee>();
	    	ArrayList<Message> listMsgObj1=new ArrayList<Message>();
	    	ArrayList<Message> listMsgObj2=new ArrayList<Message>();
	    	String jsonStr = "";
	    	mesObj1.setKey("10");
	    	mesObj1.setValue("Message1 for Ramesh");
	    	mesObj2.setKey("20");
	    	mesObj2.setValue("Message2 for Ramesh");
	    	mesObj3.setKey("30");
	    	mesObj3.setValue("Message1 for saket");
	    	mesObj4.setKey("40");
	    	mesObj4.setValue("Message2 for saket");
	
	    	listMsgObj1.add(mesObj1);
	    	listMsgObj1.add(mesObj2);
	    	listMsgObj2.add(mesObj3);
	    	listMsgObj2.add(mesObj4);
	    	empObj1.setId("1");
	    	empObj1.setName("Ramesh");
	    	empObj1.setSal(20000);
	    	empObj1.setLocation("Pune");
	    	empObj1.setMessage(listMsgObj1);
	    	empObj2.setId("2");
	    	empObj2.setLocation("Mumbai");
	    	empObj2.setName("Saket");
	    	empObj2.setSal(40000);
	    	empObj2.setMessage(listMsgObj2);
	    	
	    	empList.add(empObj1);
	    	empList.add(empObj2);
	    	empDetObj.setEmpDet(empList);
	    	 
			try {
				jsonStr = Obj.writeValueAsString(empDetObj);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			jsonStr="{  \r\n"
					+ "  \"companyName\": \"Emma Watson\",  \r\n"
					+ "  \"companyLocation\": \"Paul Walker\",  \r\n"
					+ "  \"companyStrength\": 13000,\r\n"
					+ "  \"headOffice\": [\"Pune\", \"Banglore\"], \r\n"
					+ "  \"Test1\":\"Additional Property 1\",\r\n"
					+ "  \"Test2\":\"Additional Property 2\",\r\n"
					+ "  \"Test3\":\"Additional Property 3\",\r\n"
					+ "  \"Test4\":\"Additional Property 4\"\r\n"
					+ "}";
			return jsonStr;
	    	
	    }
	    
}
