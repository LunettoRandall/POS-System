package application;
	
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

public class Main_Window extends Application {
	private int total = 0;
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			root.setStyle("-fx-background-color: BLACK;");
			Scene scene = new Scene(root,1000,800);
			
			// Create an instance on the login window class *********************************************************************
			Main userLogin = new Main();
			
			// Call to MainWindow_bottom_menu and Menu_buttons classes for buttons***********************************************
			root.getChildren().add(MainWindow_bottom_menu.btnLayout());
			
			// Prices variables *************************************************************************************************
			int red = 25;
			int yellow = 20;
			int lawngreen = 15;
			int orange = 10;
			int lightblue = 5;
			int sandybrown = 1;
			String receipt = "****** PRINTING RECEIPT ******";
			
			
			// Display logo label properties ************************************************************************************
	        Image JARC = new Image("Main screen logo.png");
	        ImageView jarcLogo = new ImageView(JARC);
			
	        Label lblLogo = new Label(null, jarcLogo);
	        lblLogo.setLayoutX(927);      
	        lblLogo.setLayoutY(1);       
	        lblLogo.setMinSize(83, 130);
	        lblLogo.setMaxSize(83, 130);
	        root.getChildren().add(lblLogo);
	        
	        // Display logged in user name **************************************************************************************
	        Label lblUser = new Label("Logged in as:  " + Main.loggedUser.toUpperCase());
	        lblUser.setLayoutX(200);      
	        lblUser.setLayoutY(0);       
	        lblUser.setMinSize(350, 30);
	        lblUser.setMaxSize(350, 30);
	        lblUser.setFont(Font.font("Arial",FontPosture.REGULAR,20));
	        lblUser.setStyle("-fx-text-fill: #56fc03");
	        root.getChildren().add(lblUser);
	        
	        // Display date and time ********************************************************************************************
	        Label lblDateTime = new Label();
	        lblDateTime.setLayoutX(550);      
	        lblDateTime.setLayoutY(0);       
	        lblDateTime.setMinSize(370, 30);
	        lblDateTime.setMaxSize(370, 30);
	        lblDateTime.setFont(Font.font("Arial",FontPosture.REGULAR,20));
	        lblDateTime.setStyle("-fx-text-fill: White");
	        root.getChildren().add(lblDateTime);
	        
	        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
	        	@Override public void handle(ActionEvent actionEvent) {
	        		LocalDateTime dt = LocalDateTime.now();
	    	        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy    h:mm:ss a");
	        		lblDateTime.setText((dt.format(customFormatter)));
	        	}
	        }),
	        	new KeyFrame(Duration.seconds(1))
	        );
	        tl.setCycleCount(Animation.INDEFINITE);
	        tl.play();
	        
	        // Home button properties *******************************************************************************************
	        Image btnHome = new Image("btnHome.png");
	        ImageView homeButtonIcon = new ImageView(btnHome);
	        
	        Button homeScreen = new Button("Home", homeButtonIcon);
	        homeScreen.setMinHeight(130);
	        homeScreen.setMinWidth(83);
	        homeScreen.setContentDisplay(ContentDisplay.TOP);
	        
	        // Calculator button properties *************************************************************************************
	        Image btnCalc = new Image("btnCalc.png");
	        ImageView calcButtonIcon = new ImageView(btnCalc);
	       
	        Button calc = new Button("Calculator", calcButtonIcon);
	        calc.setMinHeight(130);
	        calc.setMinWidth(83);
	        calc.setContentDisplay(ContentDisplay.TOP);
	        
	        // Orders log button properties *************************************************************************************
	        Image btnOrderLog = new Image("btnOrderLog.png");
	        ImageView orderLogButtonIcon = new ImageView(btnOrderLog);
	       
	        Button orderLog = new Button("Orders Log", orderLogButtonIcon);
	        orderLog.setMinHeight(130);
	        orderLog.setMinWidth(83);
	        orderLog.setContentDisplay(ContentDisplay.TOP);
	        
	        // Settings button properties ***************************************************************************************
	        Image btnSettings = new Image("btnSettings.png");
	        ImageView settingsButtonIcon = new ImageView(btnSettings);
	       
	        Button settings = new Button("Settings", settingsButtonIcon);
	        settings.setMinHeight(130);
	        settings.setMinWidth(83);
	        settings.setContentDisplay(ContentDisplay.TOP);
	        
	        // Logout button properties *****************************************************************************************
	        Image btnLogout = new Image("btnLogout.png");
	        ImageView logoutButtonIcon = new ImageView(btnLogout);
	       
	        Button Logout = new Button("Logout", logoutButtonIcon);
	        Logout.setMinHeight(130);
	        Logout.setMinWidth(83);
	        Logout.setContentDisplay(ContentDisplay.TOP);
	        Logout.setOnAction(new EventHandler<ActionEvent>() {
	        	
	        	public void handle(ActionEvent e) {
	        		primaryStage.close();
	        		userLogin.start(primaryStage);
	        		Main.loggedUser = "";
	        	}
	        });
	        	        
	        // Vertical box container for side menu buttons *********************************************************************
	        VBox rightSideOptions = new VBox(homeScreen, calc, orderLog, settings, Logout);
	        rightSideOptions.setLayoutX(927);
	        rightSideOptions.setLayoutY(155);
	        root.getChildren().add(rightSideOptions);	        
	        	 	
			MenuBar menuBar = new MenuBar();
			menuBar.setMinWidth(150);
			 
	        // --- Menu File
	        Menu menuFile = new Menu("File");
	        MenuItem miNew = new MenuItem("New");
	        MenuItem miOpen = new MenuItem("Open");
	        MenuItem miLogout = new MenuItem("Logout");
	        MenuItem miExit = new MenuItem("Exit");
	        menuFile.getItems().addAll(miNew, miOpen, miLogout, miExit);
	        
	        // --- Menu Edit
	        Menu menuEdit = new Menu("Edit");
	        MenuItem miCopy = new MenuItem("Copy");
	        MenuItem miPaste = new MenuItem("Paste");
	        MenuItem miFind = new MenuItem("Find");
	        MenuItem miReplace = new MenuItem("Replace");
	        menuEdit.getItems().addAll(miCopy, miPaste, miFind, miReplace);
	        
	        // --- Menu About
	        Menu menuAbout = new Menu("About");
	        MenuItem miAboutJARC = new Menu("JARC");
	        menuAbout.getItems().add(miAboutJARC);
	        
	        // --- Menu Help
	        Menu menuHelp = new Menu("Help");
	        MenuItem miContactUs = new Menu("Contact us");
	        menuHelp.getItems().add(miContactUs);
	 
	        menuBar.getMenus().addAll(menuFile, menuEdit, menuAbout, menuHelp);
	        root.getChildren().addAll(menuBar);
	        
	        // Display customer order details ***********************************************************************************
	        Label lblcustomerOrder = new Label();
	        lblcustomerOrder.setLayoutX(5);      
	        lblcustomerOrder.setLayoutY(155);       
	        lblcustomerOrder.setMinSize(300, 600);
	        lblcustomerOrder.setMaxSize(300, 600);
	        lblcustomerOrder.setFont(Font.font("Arial",FontPosture.REGULAR,20));
	        lblcustomerOrder.setStyle("-fx-text-fill: White; -fx-border-width: 1; -fx-border-color: blue;");
	        lblcustomerOrder.setContentDisplay(ContentDisplay.TOP);
	        lblcustomerOrder.layout();
	        root.getChildren().add(lblcustomerOrder);
	        
	        // Display customer order total *************************************************************************************
	        Label lblOrderTotal = new Label();
	        lblOrderTotal.setLayoutX(105);      
	        lblOrderTotal.setLayoutY(757);       
	        lblOrderTotal.setMinSize(200, 50);
	        lblOrderTotal.setMaxSize(200, 50);
	        lblOrderTotal.setFont(Font.font("Arial",FontPosture.REGULAR,25));
	        lblOrderTotal.setStyle("-fx-text-fill: White; -fx-border-width: 1; -fx-border-color: blue;");
	        root.getChildren().add(lblOrderTotal);
	        
	        // Display customer order total text ********************************************************************************
	        Label lblOrderTotalText = new Label("TOTAL");
	        lblOrderTotalText.setLayoutX(15);      
	        lblOrderTotalText.setLayoutY(755);       
	        lblOrderTotalText.setMinSize(100, 50);
	        lblOrderTotalText.setMaxSize(100, 50);
	        lblOrderTotalText.setFont(Font.font("Arial",FontPosture.REGULAR,25));
	        lblOrderTotalText.setStyle("-fx-text-fill: White;");
	        root.getChildren().add(lblOrderTotalText);
	        
	        Button btnPrint = new Button("PRINT RECEIPT");
	        btnPrint.setLayoutX(312);
	        btnPrint.setLayoutY(677);
	        btnPrint.setMinSize(125, 128);
	        btnPrint.setMaxSize(125, 128);
	        btnPrint.setFont(Font.font("Arial",FontPosture.REGULAR,18));
	        btnPrint.setWrapText(true);
	        btnPrint.setTextAlignment(TextAlignment.CENTER);
	        btnPrint.setOnAction(e->{
	        	lblcustomerOrder.setText(receipt);
	        	total = 0;
	        });
	        root.getChildren().add(btnPrint);
	        
			
			FlowPane foodItemsLayout = new FlowPane();
			foodItemsLayout.setLayoutX(355);
			foodItemsLayout.setLayoutY(155);
			foodItemsLayout.setMinSize(520, 130);
			foodItemsLayout.setMaxSize(520, 130);
			foodItemsLayout.setHgap(20);
			foodItemsLayout.setVgap(20);
			
		    Button btnSteak = new Button("STEAK");
		    btnSteak.setMinSize(115, 60);
		    btnSteak.setMaxSize(115, 60);
		    btnSteak.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnSteak.setTextAlignment(TextAlignment.CENTER);
		    btnSteak.setStyle("-fx-background-color: RED; -fx-font-weight: bold;");
		    btnSteak.setWrapText(true);
		    btnSteak.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnSteak.getText()+"...................................$"+red+"\n");
		    	total += red;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBurger = new Button("BURGERS");
		    btnBurger.setMinSize(115, 60);
		    btnBurger.setMaxSize(115, 60);
		    btnBurger.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBurger.setTextAlignment(TextAlignment.CENTER);
		    btnBurger.setStyle("-fx-background-color: RED; -fx-font-weight: bold;");
		    btnBurger.setWrapText(true);
		    btnBurger.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBurger.getText()+".............................$"+red+"\n");
		    	total += red;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBeefBrisket = new Button("BEEF BRISKET");
		    btnBeefBrisket.setMinSize(115, 60);
		    btnBeefBrisket.setMaxSize(115, 60);
		    btnBeefBrisket.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBeefBrisket.setTextAlignment(TextAlignment.CENTER);
		    btnBeefBrisket.setStyle("-fx-background-color: RED; -fx-font-weight: bold;");
		    btnBeefBrisket.setWrapText(true);
		    btnBeefBrisket.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBeefBrisket.getText()+".....................$"+red+"\n");
		    	total += red;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBeefRibs = new Button("BEEF RIBS");
		    btnBeefRibs.setMinSize(115, 60);
		    btnBeefRibs.setMaxSize(115, 60);
		    btnBeefRibs.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBeefRibs.setTextAlignment(TextAlignment.CENTER);
		    btnBeefRibs.setStyle("-fx-background-color: RED; -fx-font-weight: bold;");
		    btnBeefRibs.setWrapText(true);
		    btnBeefRibs.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBeefRibs.getText()+"............................$"+red+"\n");
		    	total += red;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnChickenTenders = new Button("CHICKEN TENDERS");
		    btnChickenTenders.setMinSize(115, 60);
		    btnChickenTenders.setMaxSize(115, 60);
		    btnChickenTenders.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnChickenTenders.setTextAlignment(TextAlignment.CENTER);
		    btnChickenTenders.setStyle("-fx-background-color: YELLOW; -fx-font-weight: bold;");
		    btnChickenTenders.setWrapText(true);
		    btnChickenTenders.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnChickenTenders.getText()+".............$"+yellow+"\n");
		    	total += yellow;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBakedChicken = new Button("BAKED CHICKEN");
		    btnBakedChicken.setMinSize(115, 60);
		    btnBakedChicken.setMaxSize(115, 60);
		    btnBakedChicken.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBakedChicken.setTextAlignment(TextAlignment.CENTER);
		    btnBakedChicken.setStyle("-fx-background-color: YELLOW; -fx-font-weight: bold;");
		    btnBakedChicken.setWrapText(true);
		    btnBakedChicken.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBakedChicken.getText()+"..................$"+yellow+"\n");
		    	total += yellow;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnOrangeChicken = new Button("ORANGE CHICKEN");
		    btnOrangeChicken.setMinSize(115, 60);
		    btnOrangeChicken.setMaxSize(115, 60);
		    btnOrangeChicken.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnOrangeChicken.setTextAlignment(TextAlignment.CENTER);
		    btnOrangeChicken.setStyle("-fx-background-color: YELLOW; -fx-font-weight: bold;");
		    btnOrangeChicken.setWrapText(true);
		    btnOrangeChicken.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnOrangeChicken.getText()+"..............$"+yellow+"\n");
		    	total += yellow;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBBQChicken = new Button("BBQ CHICKEN");
		    btnBBQChicken.setMinSize(115, 60);
		    btnBBQChicken.setMaxSize(115, 60);
		    btnBBQChicken.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBBQChicken.setTextAlignment(TextAlignment.CENTER);
		    btnBBQChicken.setStyle("-fx-background-color: YELLOW; -fx-font-weight: bold;");
		    btnBBQChicken.setWrapText(true);
		    btnBBQChicken.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBBQChicken.getText()+"......................$"+yellow+"\n");
		    	total += yellow;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnSteakSalad = new Button("STEAK SALAD");
		    btnSteakSalad.setMinSize(115, 60);
		    btnSteakSalad.setMaxSize(115, 60);
		    btnSteakSalad.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnSteakSalad.setTextAlignment(TextAlignment.CENTER);
		    btnSteakSalad.setStyle("-fx-background-color: LAWNGREEN; -fx-font-weight: bold;");
		    btnSteakSalad.setWrapText(true);
		    btnSteakSalad.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnSteakSalad.getText()+"......................$"+lawngreen+"\n");
		    	total += lawngreen;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnChickenSalad = new Button("CHICKEN SALAD");
		    btnChickenSalad.setMinSize(115, 60);
		    btnChickenSalad.setMaxSize(115, 60);
		    btnChickenSalad.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnChickenSalad.setTextAlignment(TextAlignment.CENTER);
		    btnChickenSalad.setStyle("-fx-background-color: LAWNGREEN; -fx-font-weight: bold;");
		    btnChickenSalad.setWrapText(true);
		    btnChickenSalad.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnChickenSalad.getText()+"..................$"+lawngreen+"\n");
		    	total += lawngreen;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnCaesarSalad = new Button("CAESAR SALAD");
		    btnCaesarSalad.setMinSize(115, 60);
		    btnCaesarSalad.setMaxSize(115, 60);
		    btnCaesarSalad.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnCaesarSalad.setTextAlignment(TextAlignment.CENTER);
		    btnCaesarSalad.setStyle("-fx-background-color: LAWNGREEN; -fx-font-weight: bold;");
		    btnCaesarSalad.setWrapText(true);
		    btnCaesarSalad.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnCaesarSalad.getText()+"...................$"+lawngreen+"\n");
		    	total += lawngreen;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnChoppedSalad = new Button("CHOPPED SALAD");
		    btnChoppedSalad.setMinSize(115, 60);
		    btnChoppedSalad.setMaxSize(115, 60);
		    btnChoppedSalad.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnChoppedSalad.setTextAlignment(TextAlignment.CENTER);
		    btnChoppedSalad.setStyle("-fx-background-color: LAWNGREEN; -fx-font-weight: bold;");
		    btnChoppedSalad.setWrapText(true);
		    btnChoppedSalad.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnChoppedSalad.getText()+"................$"+lawngreen+"\n");
		    	total += lawngreen;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnTiramisu = new Button("TIRAMISU");
		    btnTiramisu.setMinSize(115, 60);
		    btnTiramisu.setMaxSize(115, 60);
		    btnTiramisu.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnTiramisu.setTextAlignment(TextAlignment.CENTER);
		    btnTiramisu.setStyle("-fx-background-color: ORANGE; -fx-font-weight: bold;");
		    btnTiramisu.setWrapText(true);
		    btnTiramisu.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnTiramisu.getText()+"..............................$"+orange+"\n");
		    	total += orange;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnPecanPie = new Button("PECAN PIE");
		    btnPecanPie.setMinSize(115, 60);
		    btnPecanPie.setMaxSize(115, 60);
		    btnPecanPie.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnPecanPie.setTextAlignment(TextAlignment.CENTER);
		    btnPecanPie.setStyle("-fx-background-color: ORANGE; -fx-font-weight: bold;");
		    btnPecanPie.setWrapText(true);
		    btnPecanPie.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnPecanPie.getText()+"............................$"+orange+"\n");
		    	total += orange;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnTripleMousse = new Button("TRIPLE MOUSSE");
		    btnTripleMousse.setMinSize(115, 60);
		    btnTripleMousse.setMaxSize(115, 60);
		    btnTripleMousse.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnTripleMousse.setTextAlignment(TextAlignment.CENTER);
		    btnTripleMousse.setStyle("-fx-background-color: ORANGE; -fx-font-weight: bold;");
		    btnTripleMousse.setWrapText(true);
		    btnTripleMousse.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnTripleMousse.getText()+"..................$"+orange+"\n");
		    	total += orange;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnCremeBrulee = new Button("CREME BRULEE");
		    btnCremeBrulee.setMinSize(115, 60);
		    btnCremeBrulee.setMaxSize(115, 60);
		    btnCremeBrulee.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnCremeBrulee.setTextAlignment(TextAlignment.CENTER);
		    btnCremeBrulee.setStyle("-fx-background-color: ORANGE; -fx-font-weight: bold;");
		    btnCremeBrulee.setWrapText(true);
		    btnCremeBrulee.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnCremeBrulee.getText()+"..................$"+orange+"\n");
		    	total += orange;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnBeer = new Button("BEER");
		    btnBeer.setMinSize(115, 60);
		    btnBeer.setMaxSize(115, 60);
		    btnBeer.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnBeer.setTextAlignment(TextAlignment.CENTER);
		    btnBeer.setStyle("-fx-background-color: LIGHTBLUE; -fx-font-weight: bold;");
		    btnBeer.setWrapText(true);
		    btnBeer.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnBeer.getText()+".......................................$"+lightblue+"\n");
		    	total += lightblue;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnWine = new Button("WINE");
		    btnWine.setMinSize(115, 60);
		    btnWine.setMaxSize(115, 60);
		    btnWine.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnWine.setTextAlignment(TextAlignment.CENTER);
		    btnWine.setStyle("-fx-background-color: LIGHTBLUE; -fx-font-weight: bold;");
		    btnWine.setWrapText(true);
		    btnWine.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnWine.getText()+"........................................$"+lightblue+"\n");
		    	total += lightblue;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnLiquor= new Button("LIQUOR");
		    btnLiquor.setMinSize(115, 60);
		    btnLiquor.setMaxSize(115, 60);
		    btnLiquor.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnLiquor.setTextAlignment(TextAlignment.CENTER);
		    btnLiquor.setStyle("-fx-background-color: LIGHTBLUE; -fx-font-weight: bold;");
		    btnLiquor.setWrapText(true);
		    btnLiquor.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnLiquor.getText()+"...................................$"+lightblue+"\n");
		    	total += lightblue;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnCocktail = new Button("MIXED DRINKS");
		    btnCocktail.setMinSize(115, 60);
		    btnCocktail.setMaxSize(115, 60);
		    btnCocktail.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnCocktail.setTextAlignment(TextAlignment.CENTER);
		    btnCocktail.setStyle("-fx-background-color: LIGHTBLUE; -fx-font-weight: bold;");
		    btnCocktail.setWrapText(true);
		    btnCocktail.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnCocktail.getText()+".......................$"+lightblue+"\n");
		    	total += lightblue;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnHotBeverage = new Button("HOT DRINKS");
		    btnHotBeverage.setMinSize(115, 60);
		    btnHotBeverage.setMaxSize(115, 60);
		    btnHotBeverage.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnHotBeverage.setTextAlignment(TextAlignment.CENTER);
		    btnHotBeverage.setStyle("-fx-background-color: SANDYBROWN; -fx-font-weight: bold;");
		    btnHotBeverage.setWrapText(true);
		    btnHotBeverage.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnHotBeverage.getText()+"...........................$"+sandybrown+"\n");
		    	total += sandybrown;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnColdBeverage = new Button("COLD DRINKS");
		    btnColdBeverage.setMinSize(115, 60);
		    btnColdBeverage.setMaxSize(115, 60);
		    btnColdBeverage.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnColdBeverage.setTextAlignment(TextAlignment.CENTER);
		    btnColdBeverage.setStyle("-fx-background-color: SANDYBROWN; -fx-font-weight: bold;");
		    btnColdBeverage.setWrapText(true);
		    btnColdBeverage.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnColdBeverage.getText()+".........................$"+sandybrown+"\n");
		    	total += sandybrown;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnSoda = new Button("SODA");
		    btnSoda.setMinSize(115, 60);
		    btnSoda.setMaxSize(115, 60);
		    btnSoda.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnSoda.setTextAlignment(TextAlignment.CENTER);
		    btnSoda.setStyle("-fx-background-color: SANDYBROWN; -fx-font-weight: bold;");
		    btnSoda.setWrapText(true);
		    btnSoda.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnSoda.getText()+".......................................$"+sandybrown+"\n");
		    	total += sandybrown;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    Button btnJuice = new Button("JUICE");
		    btnJuice.setMinSize(115, 60);
		    btnJuice.setMaxSize(115, 60);
		    btnJuice.setFont(Font.font("Arial",FontPosture.REGULAR,18));
		    btnJuice.setTextAlignment(TextAlignment.CENTER);
		    btnJuice.setStyle("-fx-background-color: SANDYBROWN; -fx-font-weight: bold;");
		    btnJuice.setWrapText(true);
		    btnJuice.setOnAction(e-> {
		    	if (lblcustomerOrder.getText().equals(receipt)) {lblcustomerOrder.setText("");}
		    	lblcustomerOrder.setText(lblcustomerOrder.getText()
		    			+btnJuice.getText()+".......................................$"+sandybrown+"\n");
		    	total += sandybrown;
		    	lblOrderTotal.setText(" $ "+total);
		    });
		    
		    foodItemsLayout.getChildren().addAll(btnSteak, 
		    		btnBurger, btnBeefBrisket, btnBeefRibs, btnChickenTenders, btnBakedChicken, 
		    		btnOrangeChicken, btnBBQChicken, btnSteakSalad, btnChickenSalad, btnCaesarSalad,
		    		btnChoppedSalad, btnTiramisu, btnPecanPie, btnTripleMousse, btnCremeBrulee,
		    		btnBeer, btnWine, btnLiquor, btnCocktail, btnHotBeverage, btnColdBeverage,
		    		btnSoda, btnJuice);

		    root.getChildren().add(foodItemsLayout);
	        
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
