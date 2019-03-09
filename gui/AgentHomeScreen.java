package gui;

import datastructures.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class AgentHomeScreen {
	
	static Stage stage;
	static Button checkRequestsButton, updateBalanceButton, transactionHistoryButton, logoutButton;
	static VBox layout;
	
	public static void showAgentHomeScreen(Stage stage) {
		FarmerHomeScreen.stage = stage;
		
		checkRequestsButton = new Button("Check Requests");
		checkRequestsButton.setMinWidth(stage.getWidth());
		
		updateBalanceButton = new Button("Update Balance");
		updateBalanceButton.setMinWidth(stage.getWidth());
		updateBalanceButton.setOnAction(e -> UpdateBalanceScreen.showUpdateBalanceScreen(stage));
		
		transactionHistoryButton = new Button("Transaction History");
		transactionHistoryButton.setMinWidth(stage.getWidth());
		transactionHistoryButton.setOnAction(e -> TransactionHistoryScreen.showTransactionHistoryScreen(stage, CurrentLoginDetails.name, "Agent"));
		
		logoutButton = new Button("Logout");
		logoutButton.setMinWidth(stage.getWidth());
		
		checkRequestsButton.setOnAction(e -> CheckRequestsScreen.showCheckRequestsScreen(stage));
		logoutButton.setOnAction(e -> LoginScreen.loadScreen());
		
		layout = new VBox(10);
		layout.setPadding(new Insets(15));
		layout.getChildren().addAll(checkRequestsButton, updateBalanceButton, transactionHistoryButton, logoutButton);
		stage.setScene(new Scene(layout));
	}
}
