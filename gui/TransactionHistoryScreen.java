package gui;

import datastructures.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;

public class TransactionHistoryScreen {
	
	static Stage stage;
	
	static TableView<TransactionDetails> table;
	static TableColumn<TransactionDetails, String> farmerName;
	static TableColumn<TransactionDetails, String> agentName;
	static TableColumn<TransactionDetails, String> payDate;
	static TableColumn<TransactionDetails, Integer> milkQuantity;
	static TableColumn<TransactionDetails, Integer> amountPaid;
	static List<TransactionDetails> LIST;
	
	static Button backButton;
	static VBox layout;
	
	public static void showTransactionHistoryScreen(Stage stage, String name, String type) {
		TransactionHistoryScreen.stage = stage;
		
		farmerName = new TableColumn<>("Farmer");
		farmerName.setCellValueFactory(new PropertyValueFactory<>("farmerName"));
		
		agentName = new TableColumn<>("Agent");
		agentName.setCellValueFactory(new PropertyValueFactory<>("agentName"));
		
		payDate = new TableColumn<>("Pay Date");
		payDate.setCellValueFactory(new PropertyValueFactory<>("payDate"));
		
		milkQuantity = new TableColumn<>("Milk Quantity");
		milkQuantity.setCellValueFactory(new PropertyValueFactory<>("milkQuantity"));
		
		amountPaid = new TableColumn<>("Amount Paid");
		amountPaid.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));
		
		if(type.equals("Farmer"))
			LIST = TransactionDetails.getByFarmerName(name);
		else if(type.equals("Agent"))
			LIST = TransactionDetails.getByAgentName(name);
		
		table = new TableView<>(FXCollections.observableArrayList(LIST));
		table.getColumns().addAll(farmerName, agentName, payDate, milkQuantity, amountPaid);
		
		backButton = new Button("Back");
		backButton.setMinWidth(100);
		backButton.setOnAction(e -> onBack(type));
		
		layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(15));
		layout.getChildren().addAll(table, backButton);
		
		stage.setScene(new Scene(layout));
	}
	
	private static void onBack(String type) {
		if(type.equals("Farmer"))
			FarmerHomeScreen.showFarmerHomeScreen(stage);
		else
			AgentHomeScreen.showAgentHomeScreen(stage);
	}
}
