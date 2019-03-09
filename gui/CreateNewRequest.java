package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CreateNewRequest {
	
	static Stage stage;
	
	static Label instructionLabel;
	static ComboBox<String> agentListComboBox;
	static TextField amountOfMilkField;
	static Button calculateAmount, createRequest;
	static HBox buttonBox;
	static VBox layout;
	
	public static void createNewRequest(Stage stage) {
		CreateNewRequest.stage = stage;
		
		instructionLabel = new Label("Select agent and milk amount");
		instructionLabel.setMinWidth(stage.getWidth());
		
		agentListComboBox = new ComboBox<>(getAgentList());
		agentListComboBox.getSelectionModel().selectFirst();
		agentListComboBox.setMinWidth(stage.getWidth());
		
		amountOfMilkField = new TextField();
		amountOfMilkField.setPromptText("Enter amount of milk in liters");
		amountOfMilkField.setMinWidth(stage.getWidth()-10);
		
		calculateAmount = new Button("Calculate");
		calculateAmount.setMinWidth(stage.getWidth()/2);
		calculateAmount.setOnAction(e -> onCalculate());
		
		createRequest = new Button("Request");
		createRequest.setOnAction(e -> onRequest());
		createRequest.setMinWidth(stage.getWidth()/2-10);
		
		buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(calculateAmount, createRequest);
		buttonBox.setMinWidth(stage.getWidth());
		
		layout = new VBox(10);
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(instructionLabel, agentListComboBox, amountOfMilkField, buttonBox);
		
		stage.setScene(new Scene(layout));
	}
	
	private static void onRequest() {
		// Code for creation
		
		try {
			
			MessageBox.display("Success!", "Your request has been sent to agent!");
		}catch(Exception e) {
			MessageBox.display("Failure!", "Please check if all values are entered correctly");
		}
		
		FarmerHomeScreen.showFarmerHomeScreen(stage);
	}
	
	private static void onCalculate() {
		try {
			int totalAmount = Integer.parseInt(amountOfMilkField.getText()) * 22; // Replace 22 by method of retrieving milk price by agent
			MessageBox.display("Hurray!", "You will earn "+ totalAmount + " rupees!");
		}catch(Exception e) {
			MessageBox.display("Oh!", "Please see if all values are entered correctly");
		}
	}
	
	private static ObservableList<String> getAgentList(){
		List<String> cities = new ArrayList<>();
		
		// Add Strings here, list of agents in the same city, along with per litre price
		cities.add("Amul (Rs. 22)");
		cities.add("Chitale (Rs. 25)");
		cities.add("Mahanand (Rs. 27)");
		cities.add("Mother Dairy (Rs. 23)");
		// 
		
		return (ObservableList<String>) FXCollections.observableArrayList(cities);
	}
}
