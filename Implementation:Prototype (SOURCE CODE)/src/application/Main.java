package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Main extends Application {
	public static String loggedUser = "";
	@Override
	public void start(Stage primaryStage) {

		try {
			Pane root = new Pane();
			root.setStyle("-fx-background-color: BLACK;");
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Create an instance of the main window class **********************************************************************
			Main_Window userMainWindow = new Main_Window();
			
			// User names and passwords for login *******************************************************************************
			String[] users = new String[] {"Chris Collins","Randy Lunetto","Joaquin Flores","Alfonso Perez", "Guest"};
			String[] passwords = new String[] {"ChrisJARC","RandyJARC","JoaquinJARC","AlfonsoJARC", "Guest"};
					
			// Display logo label properties ************************************************************************************
	        Image image = new Image("JARC.png");
	        ImageView imageView = new ImageView(image);

	        Label lblLogo = new Label(null, imageView);
	        lblLogo.setLayoutX(250);      
	        lblLogo.setLayoutY(50);       
	        lblLogo.setMinSize(283, 390);
	        lblLogo.setMaxSize(283, 390);
	        root.getChildren().add(lblLogo);
			
			// Username textfield properties ************************************************************************************
			TextField txtUsername = new TextField();
			txtUsername.setLayoutX(200);      
			txtUsername.setLayoutY(500);       
			txtUsername.setMinSize(300, 50);
			txtUsername.setMaxSize(300, 50);
			txtUsername.setFont(Font.font("Arial",FontPosture.REGULAR,25));
			txtUsername.setPromptText("Username");
			root.getChildren().add(txtUsername);
			
			// Password textfield properties ************************************************************************************
			PasswordField txtPassword = new PasswordField();
			txtPassword.setLayoutX(200);      
			txtPassword.setLayoutY(560);       
			txtPassword.setMinSize(300, 50);
			txtPassword.setMaxSize(300, 50);
			txtPassword.setFont(Font.font("Arial",FontPosture.REGULAR,25));
			txtPassword.setPromptText("Password");
			root.getChildren().add(txtPassword);
						
			// Login button properties ******************************************************************************************
			Button btnLogin = new Button("Login");
			btnLogin.setLayoutX(510);
			btnLogin.setLayoutY(500);
			btnLogin.setAlignment(Pos.CENTER);
			btnLogin.setStyle("-fx-background-color: #a8a6a2; -fx-text-fill: black; -fx-font:25 Arial");
			btnLogin.setShape(new Circle(50));
			btnLogin.setPrefWidth(110);
			btnLogin.setPrefHeight(110);
			root.getChildren().add(btnLogin);
			
			// Display error message label properties ***************************************************************************
			Label lblMessage = new Label();
			lblMessage.setAlignment(Pos.CENTER);
			lblMessage.setLayoutX(150);      
			lblMessage.setLayoutY(630);
			lblMessage.setMinSize(500, 25);
			lblMessage.setFont(Font.font("Arial",FontPosture.REGULAR,15));
			lblMessage.setStyle("-fx-text-fill: Red");
			root.getChildren().add(lblMessage);
			
			// Display copyrights label properties ***************************************************************************
			Label lblcopyrights = new Label("Copyright © 2020, JARC Technologies. All rights reserved.");
			lblcopyrights.setAlignment(Pos.CENTER);
			lblcopyrights.setLayoutX(150);      
			lblcopyrights.setLayoutY(780);
			lblcopyrights.setMinSize(500, 25);
			lblcopyrights.setFont(Font.font("Arial",FontPosture.REGULAR,15));
			lblcopyrights.setStyle("-fx-text-fill: White");
			root.getChildren().add(lblcopyrights);
			
			// Change button color on mouse enter and exit **********************************************************************
			btnLogin.setOnMouseEntered(event -> btnLogin.setStyle(("-fx-background-color: #86afcf; -fx-text-fill: black; -fx-font:25 Arial")));
			btnLogin.setOnMouseExited(event -> btnLogin.setStyle(("-fx-background-color: #a8a6a2; -fx-text-fill: black; -fx-font:25 Arial")));
			
			// Login button handler properties **********************************************************************************
			btnLogin.setOnAction(new EventHandler<ActionEvent>() {
				 
			    public void handle(ActionEvent e) {
			    	
			    		
			    		if (txtUsername.getText().equals(users[0]) && txtPassword.getText().equals(passwords[0])) 
						{
			    			loggedUser = txtUsername.getText();
			    			primaryStage.close();
							userMainWindow.start(primaryStage);
						}
						else if (txtUsername.getText().equals(users[1]) && txtPassword.getText().equals(passwords[1])) 
						{
							loggedUser = txtUsername.getText();
							primaryStage.close();
							userMainWindow.start(primaryStage);
						}
						else if (txtUsername.getText().equals(users[2]) && txtPassword.getText().equals(passwords[2])) 
						{
							loggedUser = txtUsername.getText();
							primaryStage.close();
							userMainWindow.start(primaryStage);
						}
						else if (txtUsername.getText().equals(users[3]) && txtPassword.getText().equals(passwords[3])) 
						{
							loggedUser = txtUsername.getText();
							primaryStage.close();
							userMainWindow.start(primaryStage);
						}
						else if (txtUsername.getText().equals(users[4]) && txtPassword.getText().equals(passwords[4])) 
						{
							loggedUser = txtUsername.getText();
							primaryStage.close();
							userMainWindow.start(primaryStage);
						}
						else {lblMessage.setText("Invalid username or password. Please check your credentials and try again!");}
			    }
			});
			
			primaryStage.getIcons().add(new Image("logo.png"));
			primaryStage.setTitle("JARC POS System"); 
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
