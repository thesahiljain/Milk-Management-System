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

public class CheckRequestsScreen {
	
	static Stage stage;
	static TableView<RequestDetails> table;
	
	static TableColumn<RequestDetails, String> farmerNameColumn;
	static TableColumn<RequestDetails, Integer> amountOfMilkColumn;
	static TableColumn<RequestDetails, Integer> perLiterPriceColumn;
	static TableColumn<RequestDetails, String> requestDateColumn;
	
	static Button backButton, acceptButton, rejectButton;
	
	static VBox layout;
	static HBox buttonBox;
	
	public static void showCheckRequestsScreen(Stage stage) {
		CheckRequestsScreen.stage = stage;
		
		farmerNameColumn = new TableColumn<>("Farmer");
		farmerNameColumn.setCellValueFactory(new PropertyValueFactory<>("farmerName"));
		
		amountOfMilkColumn = new TableColumn<>("Amount of Milk");
		amountOfMilkColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfMilk"));
		
		perLiterPriceColumn = new TableColumn<>("Price/Liter");
		perLiterPriceColumn.setCellValueFactory(new PropertyValueFactory<>("perLiterPrice"));
		
		requestDateColumn = new TableColumn<>("Request Date");
		requestDateColumn.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
		
		table = new TableView<>(FXCollections.observableArrayList(RequestDetails.getListByAgent("Amul")));
		table.getColumns().addAll(farmerNameColumn, amountOfMilkColumn, perLiterPriceColumn, requestDateColumn);
		
		backButton = new Button("Back");
		backButton.setMinWidth(120);
		acceptButton = new Button("Accept");
		acceptButton.setMinWidth(120);
		rejectButton = new Button("Reject");
		rejectButton.setMinWidth(120);
		
		backButton.setOnAction(e -> AgentHomeScreen.showAgentHomeScreen(stage));
		acceptButton.setOnAction(e -> onAccept());
		rejectButton.setOnAction(e -> onReject());
		
		buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(backButton, acceptButton, rejectButton);
		
		layout = new VBox(10);
		layout.setPadding(new Insets(15));
		layout.getChildren().addAll(table, buttonBox);
		
		stage.setScene(new Scene(layout));
	}
	
	private static void onAccept() {
		RequestDetails request;
		try {
			request = table.getSelectionModel().getSelectedItem();
			if(request == null)
				throw new Exception();
		}catch(Exception e) {
			MessageBox.display("Invalid Event", "Please select a record first");
			return;
		}
		String message = "Amount to be paid Rs " + request.getPerLiterPrice()*request.getAmountOfMilk() + "\nAre you sure you want to accept this request?";
		boolean choice = YesNoBox.display(message);
		if(choice) {
			// Write method to accept the milk request
			showCheckRequestsScreen(stage); // Refresh the layout
		}
	}
	
	private static void onReject() {
		RequestDetails request;
		try {
			request = table.getSelectionModel().getSelectedItem();
			if(request == null)
				throw new Exception();
		}catch(Exception e) {
			MessageBox.display("Invalid Event", "Please select a record first");
			return;
		}
		String message = "Amount to be paid Rs " + request.getPerLiterPrice()*request.getAmountOfMilk() + "\nAre you sure you want to reject this request?";
		boolean choice = YesNoBox.display(message);
		if(choice) {
			// Write method to reject the milk request
			showCheckRequestsScreen(stage); // Refresh the layout
		}	
	}
}
