package gui;

import datastructures.CurrentLoginDetails;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class FarmerHomeScreen {
	
	static Stage stage;
	static Button newRequestButton, checkStatusButton, transactionHistoryButton, logoutButton;
	static VBox layout;
	
	public static void showFarmerHomeScreen(Stage stage) {
		FarmerHomeScreen.stage = stage;
		
		newRequestButton = new Button("Create New Request");
		newRequestButton.setMinWidth(stage.getWidth());
		newRequestButton.setOnAction(e -> CreateNewRequest.createNewRequest(stage));
		
		checkStatusButton = new Button("Check Pending Request");
		checkStatusButton.setMinWidth(stage.getWidth());
		checkStatusButton.setOnAction(e -> CheckPendingRequestsScreen.showCheckRequestsScreen(stage));
		
		transactionHistoryButton = new Button("Transaction History");
		transactionHistoryButton.setMinWidth(stage.getWidth());
		transactionHistoryButton.setOnAction(e -> TransactionHistoryScreen.showTransactionHistoryScreen(stage, CurrentLoginDetails.name, "Farmer"));
		
		logoutButton = new Button("Logout");
		logoutButton.setMinWidth(stage.getWidth());
		
		logoutButton.setOnAction(e -> LoginScreen.loadScreen());
		
		layout = new VBox(10);
		layout.setPadding(new Insets(15));
		layout.getChildren().addAll(newRequestButton, checkStatusButton, transactionHistoryButton, logoutButton);
		stage.setScene(new Scene(layout));
	}
}
