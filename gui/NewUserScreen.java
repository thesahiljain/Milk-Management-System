package gui;

import java.util.*;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class NewUserScreen {
	
	static Stage stage;
	static GridPane layout;
	
	static Label nameLabel, typeLabel, cityLabel, accountNumberLabel, userIDLabel, passwordLabel;
	static TextField nameField, accountNumberField, userIDField;
	static PasswordField passwordField;
	static Button submitButton;
	
	static ComboBox<String> cityBox;
	
	static RadioButton agentButton, farmerButton;
	static ToggleGroup typeGroup;
	static HBox typeField;
	
	public static void showNewUserScreen(Stage stage) {
		
		NewUserScreen.stage = stage;
		
		nameLabel = new Label("Name");
		GridPane.setConstraints(nameLabel, 0, 0);
		typeLabel = new Label("Type");
		GridPane.setConstraints(typeLabel, 0, 1);
		cityLabel = new Label("City");
		GridPane.setConstraints(cityLabel, 0, 2);
		accountNumberLabel = new Label("Account Number");
		GridPane.setConstraints(accountNumberLabel, 0, 3);
		userIDLabel = new Label("User ID");
		GridPane.setConstraints(userIDLabel, 0, 4);
		passwordLabel = new Label("Password");
		GridPane.setConstraints(passwordLabel, 0, 5);
		
		nameField = new TextField();
		nameField.setMinWidth(100);
		GridPane.setConstraints(nameField, 1, 0);
		
		agentButton = new RadioButton("Agent");
		agentButton.setSelected(true);
		farmerButton = new RadioButton("Farmer");
		
		typeGroup = new ToggleGroup();
		agentButton.setToggleGroup(typeGroup);
		farmerButton.setToggleGroup(typeGroup);
	
		typeField = new HBox(10);
		typeField.getChildren().addAll(agentButton, farmerButton);
		GridPane.setConstraints(typeField, 1, 1);
		
		cityBox = new ComboBox<String>(getCityNames());
		cityBox.getSelectionModel().selectFirst();
		cityBox.setMinWidth(100);
		GridPane.setConstraints(cityBox, 1, 2);
		
		accountNumberField = new TextField();
		accountNumberField.setMinWidth(100);
		GridPane.setConstraints(accountNumberField, 1, 3);
		
		userIDField = new TextField();
		userIDField.setMinWidth(100);
		GridPane.setConstraints(userIDField, 1, 4);
		
		passwordField = new PasswordField();
		passwordField.setMinWidth(100);
		GridPane.setConstraints(passwordField, 1, 5);
		
		submitButton = new Button("Register");
		GridPane.setConstraints(submitButton, 1, 6);
		submitButton.setOnAction(e -> onSubmit());
		
		layout = new GridPane();
		layout.setPadding(new Insets(10));
		layout.setHgap(10);
		layout.setVgap(10);
		layout.getChildren().addAll(nameLabel, typeLabel, cityLabel, accountNumberLabel, userIDLabel, passwordLabel, submitButton,
				nameField, typeField, cityBox, accountNumberField, userIDField, passwordField);
				
		stage.setScene(new Scene(layout));
	}
	
	private static void onSubmit() {
		try {
			
			String name = nameField.getText();
			// type is "Agent" or "Farmer"
			String type = ((RadioButton)typeGroup.getSelectedToggle()).getText();
			String city = cityBox.getSelectionModel().getSelectedItem();
			String accountNumber = accountNumberField.getText();
			int userID = Integer.parseInt(userIDField.getText());
			String password = passwordField.getText();
			
			if(type.equals("Agent"))
				MessageBox.display("Message", "Default Milk Price set to Rs 25");
			
			// Write SQL code to all to database
			
			// Finally after insertion
			MessageBox.display("Success!", "User inserted successfully");
		}catch(Exception e){
			MessageBox.display("Error", "Unable to insert to databse\n" + e.getLocalizedMessage());
		}
		LoginScreen.loadScreen();
	}
	
	private static ObservableList<String> getCityNames(){
		List<String> cities = new ArrayList<>();
		
		// Add Strings here
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Lonavla");
		cities.add("Pimpri");
		//
		
		return (ObservableList<String>) FXCollections.observableArrayList(cities);
	}
}
