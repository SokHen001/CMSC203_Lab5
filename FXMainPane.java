


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button bb1;
	Button bb2;
	Button bb3;
	Button bb4;
	Button bb5;
	
	Label label;
	
	TextField textfield;
	
	//  declare two HBoxes
	HBox hb1;
	HBox hb2;
	
	//student Task #4:
	
	//  declare an instance of DataManager
	DataManager dm;
	Insets inset = new Insets(5);
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		bb1 = new Button("Hello");
		bb2 = new Button("Howdy");
		bb3 = new Button("Chinese");
		bb4 = new Button("Clear");
		bb5 = new Button("Exit");
		
		Label label = new Label("Feedback");
		
		textfield = new TextField();
		
		//  instantiate the HBoxes
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		
		//  set margins and set alignment of the components
		
		HBox.setMargin(bb1, inset); 
		HBox.setMargin(bb2, inset); 
		HBox.setMargin(bb3, inset); 
		HBox.setMargin(bb4, inset); 
		HBox.setMargin(bb5, inset); 
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);

		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hb1.getChildren().addAll(label, textfield);
		
		//  add the buttons to the other HBox
		hb2.getChildren().addAll(bb1, bb2, bb3, bb4, bb5);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hb1, hb2);
		bb1.setOnAction(new ButtonHandler());
	    bb2.setOnAction(new ButtonHandler());
	    bb3.setOnAction(new ButtonHandler());
	    bb4.setOnAction(new ButtonHandler());
	    bb5.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event) {
			if (event.getTarget().equals(bb1)) {
				textfield.setText(dm.getHello());
			}
			
			else if (event.getTarget().equals(bb2)) {
				textfield.setText(dm.getHowdy());
			}
			
			else if (event.getTarget().equals(bb3)) {
				textfield.setText(dm.getChinese());
			}
			
			else if (event.getTarget().equals(bb4)) {
				textfield.setText("");
			}
			
			else if (event.getTarget().equals(bb5)) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
	
}
	