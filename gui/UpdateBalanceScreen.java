package gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;

public class UpdateBalanceScreen {
	
	static Stage stage;
	static Label currentBalance, milkPrice;
	static TextField enterAmount, newMilkPrice;
	static Button okayButton;
	static VBox layout;
	
	public static void showUpdateBalanceScreen(Stage stage) {
		UpdateBalanceScreen.stage = stage;
		
		currentBalance = new Label("Current Balance : Rs. " + getBalance());
		currentBalance.setMinWidth(100);
		
		enterAmount = new TextField();
		enterAmount.setMinWidth(100);
		enterAmount.setPromptText("Enter amount in rupees");
		
		milkPrice = new Label("Update milk price");
		milkPrice.setMinWidth(100);
		
		newMilkPrice = new TextField(Integer.toString(22)); // Modify this to set current milk price
		newMilkPrice.setMinWidth(100);
		
		okayButton = new Button("Add Money");
		okayButton.setMinWidth(100);
		okayButton.setOnAction(e -> onAddButton());
		
		layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(currentBalance, enterAmount, milkPrice, newMilkPrice, okayButton);
		
		stage.setScene(new Scene(layout));
	}
	
	private static int getBalance() {
		// Write method to get current account balance of agent;
		return 10000;
	}
	
	private static void onAddButton() {
		// Write method to update balance
		AgentHomeScreen.showAgentHomeScreen(stage);
	}
}
