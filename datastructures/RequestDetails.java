package datastructures;

import java.util.*;

public class RequestDetails{
	private String farmerName;
	private String agentName;
	private int amountOfMilk;
	private int perLiterPrice;
	private String requestDate;
	
	public RequestDetails() {}
	
	public RequestDetails(String farmerName, String agentName, int amountOfMilk, int perLiterPrice, String requestDate) {
		this.farmerName = farmerName;
		this.agentName = agentName;
		this.amountOfMilk = amountOfMilk;
		this.perLiterPrice = perLiterPrice;
		this.requestDate = requestDate;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public int getAmountOfMilk() {
		return amountOfMilk;
	}
	public void setAmountOfMilk(int amountOfMilk) {
		this.amountOfMilk = amountOfMilk;
	}
	public double getPerLiterPrice() {
		return perLiterPrice;
	}
	public void setPerLiterPrice(int perLiterPrice) {
		this.perLiterPrice = perLiterPrice;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	public static List<RequestDetails> getListByFarmer(String farmerName){
		List<RequestDetails> LIST = new ArrayList<>();
		
		// Write code to populate list with objects of request details according to farmer name
		
		// Following examples are added for testing. Remove from final version
		
		LIST.add(new RequestDetails("Yash", "Amul", 50, 22, "2018-10-9"));
		LIST.add(new RequestDetails("Ajay", "Mahanand", 50, 22, "2018-10-9"));
		LIST.add(new RequestDetails("Rahul", "Go", 50, 22, "2018-10-9"));
		
		return LIST;
	}
	
	public static List<RequestDetails> getListByAgent(String agentName){
		List<RequestDetails> LIST = new ArrayList<>();
		
		// Write code to populate list with objects of request details according to farmer name
		
		// Following examples are added for testing. Remove from final version
		
		LIST.add(new RequestDetails("Yash", "Amul", 50, 22, "2018-10-9"));
		LIST.add(new RequestDetails("Ajay", "Mahanand", 50, 22, "2018-10-9"));
		LIST.add(new RequestDetails("Rahul", "Go", 50, 22, "2018-10-9"));
		
		return LIST;
	}
}
