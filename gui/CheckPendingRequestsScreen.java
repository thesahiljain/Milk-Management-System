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

public class CheckPendingRequestsScreen {
	
	static Stage stage;
	static TableView<RequestDetails> table;
	
	static TableColumn<RequestDetails, String> agentNameColumn;
	static TableColumn<RequestDetails, Integer> amountOfMilkColumn;
	static TableColumn<RequestDetails, Integer> perLiterPriceColumn;
	static TableColumn<RequestDetails, String> requestDateColumn;
	
	static Button backButton, deleteButton;
	
	static VBox layout;
	static HBox buttonBox;
	
	public static void showCheckRequestsScreen(Stage stage) {
		CheckPendingRequestsScreen.stage = stage;
		
		agentNameColumn = new TableColumn<>("Agent");
		agentNameColumn.setCellValueFactory(new PropertyValueFactory<>("agentName"));
		
		amountOfMilkColumn = new TableColumn<>("Amount of Milk");
		amountOfMilkColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfMilk"));
		
		perLiterPriceColumn = new TableColumn<>("Price/Liter");
		perLiterPriceColumn.setCellValueFactory(new PropertyValueFactory<>("perLiterPrice"));
		
		requestDateColumn = new TableColumn<>("Request Date");
		requestDateColumn.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
		
		table = new TableView<>(FXCollections.observableArrayList(RequestDetails.getListByFarmer("Yash")));
		table.getColumns().addAll(agentNameColumn, amountOfMilkColumn, perLiterPriceColumn, requestDateColumn);
		
		backButton = new Button("Back");
		backButton.setMinWidth(120);
		deleteButton = new Button("Delete");
		deleteButton.setMinWidth(120);
		
		backButton.setOnAction(e -> FarmerHomeScreen.showFarmerHomeScreen(stage));
		deleteButton.setOnAction(e -> onDelete());
		
		buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(backButton, deleteButton);
		
		layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(15));
		layout.getChildren().addAll(table, buttonBox);
		
		stage.setScene(new Scene(layout, 430, 300));
	}
	
	private static void onDelete() {
		RequestDetails request;
		try {
			request = table.getSelectionModel().getSelectedItem();
			if(request == null)
				throw new Exception();
		}catch(Exception e) {
			MessageBox.display("Invalid Event", "Please select a record first");
			return;
		}
		String message = "Amount to recieve Rs " + request.getPerLiterPrice()*request.getAmountOfMilk() + "\nAre you sure you want to delete this request?";
		boolean choice = YesNoBox.display(message);
		if(choice) {
			// Write method to delete the milk request
			showCheckRequestsScreen(stage);
		}	
	}
}
