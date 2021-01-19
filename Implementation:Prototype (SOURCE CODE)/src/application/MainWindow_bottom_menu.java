package application;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;

public class MainWindow_bottom_menu {
	
	public static Node btnLayout() {
	
		FlowPane lowerBtnLayout = new FlowPane();
	    lowerBtnLayout.setLayoutX(445);
	    lowerBtnLayout.setLayoutY(677);
	    lowerBtnLayout.setMinSize(485, 130);
	    lowerBtnLayout.setMaxSize(485, 130);
	    lowerBtnLayout.setHgap(5);
	    lowerBtnLayout.setVgap(8);
	    
	    Button btnEditOrder = new Button("EDIT ORDER");
	    btnEditOrder.setMinSize(115, 60);
	    btnEditOrder.setMaxSize(115, 60);
	    btnEditOrder.setTextAlignment(TextAlignment.CENTER);
	    btnEditOrder.setWrapText(true);
	    
	    Button btnDiscount = new Button("APPLY DISCOUNT");
	    btnDiscount.setMinSize(115, 60);
	    btnDiscount.setMaxSize(115, 60);
	    btnDiscount.setTextAlignment(TextAlignment.CENTER);
	    btnDiscount.setWrapText(true);
	    
	    Button btnWaitlist = new Button("WAITLIST");
	    btnWaitlist.setMinSize(115, 60);
	    btnWaitlist.setMaxSize(115, 60);
	    btnWaitlist.setTextAlignment(TextAlignment.CENTER);
	    btnWaitlist.setWrapText(true);
	    
	    Button btnCash = new Button("CASH");
	    btnCash.setMinSize(115, 60);
	    btnCash.setMaxSize(115, 60);
	    btnCash.setTextAlignment(TextAlignment.CENTER);
	    btnCash.setWrapText(true);
	    
	    Button btnCancelOrder = new Button("CANCEL ORDER");
	    btnCancelOrder.setMinSize(115, 60);
	    btnCancelOrder.setMaxSize(115, 60);
	    btnCancelOrder.setTextAlignment(TextAlignment.CENTER);
	    btnCancelOrder.setWrapText(true);
	    
	    Button btnSplitOrder = new Button("SPLIT ORDER");
	    btnSplitOrder.setMinSize(115, 60);
	    btnSplitOrder.setMaxSize(115, 60);
	    btnSplitOrder.setTextAlignment(TextAlignment.CENTER);
	    btnSplitOrder.setWrapText(true);
	    
	    Button btnTakeOut = new Button("TAKE OUT");
	    btnTakeOut.setMinSize(115, 60);
	    btnTakeOut.setMaxSize(115, 60);
	    btnTakeOut.setTextAlignment(TextAlignment.CENTER);
	    btnTakeOut.setWrapText(true);
	    
	    Button btnShiftTimer = new Button("SHIFT TIMER");
	    btnShiftTimer.setMinSize(115, 60);
	    btnShiftTimer.setMaxSize(115, 60);
	    btnShiftTimer.setTextAlignment(TextAlignment.CENTER);
	    btnShiftTimer.setWrapText(true);
	    
	    
	    lowerBtnLayout.getChildren().addAll(btnEditOrder, 
	    		btnDiscount, btnWaitlist, btnCash, btnCancelOrder, btnSplitOrder, btnTakeOut, btnShiftTimer);
		
	    return lowerBtnLayout;
	}
}