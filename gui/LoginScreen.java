package gui;

import datastructures.CurrentLoginDetails;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class LoginScreen extends Application{

	// Scene and stage variables
	static Stage stage;
	static Scene scene;
	
	// Layouts
	static VBox loginScreenLayout;
	static HBox buttonLayout;
	
	// Different widgets in the login screen
	static Label loginLabel;
	static TextField userIDField;
	static PasswordField passwordField;
	static Button loginButton, newUserButton;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		 this.stage = stage;
		 loadScreen();
	}
	
	public static void loadScreen() {
		stage.setTitle("Milk Management System");
		
		loginLabel = new Label("Login for Agent/Farmer");
		
		userIDField = new TextField();
		userIDField.setMinWidth(100);
		userIDField.setPromptText("User ID");
		
		passwordField = new PasswordField();
		passwordField.setMinWidth(100);
		passwordField.setPromptText("Password");
		
		loginButton = new Button("Login");
		loginButton.setMinWidth(100);
		newUserButton = new Button("New User");
		newUserButton.setMinWidth(100);
		
		buttonLayout = new HBox(10);
		buttonLayout.getChildren().addAll(loginButton, newUserButton);
		
		loginScreenLayout = new VBox(10);
		loginScreenLayout.setPadding(new Insets(10));
		loginScreenLayout.getChildren().addAll(loginLabel, userIDField, passwordField, buttonLayout);
		
		scene = new Scene(loginScreenLayout);
		stage.setScene(scene);
		
		newUserButton.setOnAction(e -> NewUserScreen.showNewUserScreen(stage));
		loginButton.setOnAction(e -> onLogin());
		 
		stage.show();
	}
	
	private static void onLogin() {
		try {
			// SQL method for login
			CurrentLoginDetails.name = "Yash";
			CurrentLoginDetails.type = "Agent";
			CurrentLoginDetails.userID = Integer.parseInt(userIDField.getText());
			CurrentLoginDetails.password = passwordField.getText();
			//
			
			boolean isAgent;
			if(CurrentLoginDetails.type.equals("Farmer"))
				isAgent = false; // Set this variable to true is login belongs to farmer
			else
				isAgent = true;
			
			if(isAgent)
				AgentHomeScreen.showAgentHomeScreen(stage);
			else
				FarmerHomeScreen.showFarmerHomeScreen(stage);
		}catch(Exception e) {
			MessageBox.display("Login error", e.getLocalizedMessage());
		}
	}
}
