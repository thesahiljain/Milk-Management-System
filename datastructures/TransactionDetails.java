package datastructures;

import java.util.*;

public class TransactionDetails {
	String farmerName;
	String agentName;
	String payDate;
	int milkQuantity;
	int amountPaid;
	
	public TransactionDetails() {}
	public TransactionDetails(String farmerName, String agentName, String payDate, int milkQuantity, int amountPaid) {
		this.farmerName = farmerName;
		this.agentName = agentName;
		this.payDate = payDate;
		this.milkQuantity = milkQuantity;
		this.amountPaid = amountPaid;
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
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getMilkQuantity() {
		return milkQuantity;
	}
	public void setMilkQuantity(int milkQuantity) {
		this.milkQuantity = milkQuantity;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public static List<TransactionDetails> getByFarmerName(String farmerName) {
		List<TransactionDetails> LIST = new ArrayList<>();
		
		// Write SQL method to populate the array by farmer name list
		// 1. Retrieve details. Create object. Add to LIST
		return LIST;
	}
	
	public static List<TransactionDetails> getByAgentName(String agentName) {
		List<TransactionDetails> LIST = new ArrayList<>();
		
		// Write SQL method to populate the array by farmer name list
		// 1. Retrieve details. Create object. Add to LIST
		return LIST;
	}
}
