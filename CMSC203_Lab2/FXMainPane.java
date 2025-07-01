package CMSC203_Lab2;


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
	//  declare two HBoxes
	private Button buttonOne;
	private Button buttonTwo;
	private Button buttonThree;
	private Button buttonFour;
	private Button buttonFive;
	private Button buttonSix;

	private Label labelFeedback;

	private TextField textField;

	private HBox hBoxOne;
	private HBox hBoxTwo;

	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		buttonOne = new Button("Hello");
		buttonTwo = new Button("Howdy");
		buttonThree = new Button("Chinese");
		buttonFour = new Button("Turkish");
		buttonFive = new Button("Clear");
		buttonSix = new Button("Exit");

		ButtonHandler buttonHandler = new ButtonHandler();

		buttonOne.setOnAction(buttonHandler);
		buttonTwo.setOnAction(buttonHandler);
		buttonThree.setOnAction(buttonHandler);
		buttonFour.setOnAction(buttonHandler);
		buttonFive.setOnAction(buttonHandler);
		buttonSix.setOnAction(buttonHandler);

		labelFeedback = new Label("Feedback:");

		textField = new TextField();

		//  instantiate the HBoxes
		hBoxOne = new HBox();
		hBoxTwo = new HBox();


		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(buttonOne, Insets.EMPTY);
		HBox.setMargin(buttonTwo, Insets.EMPTY);
		HBox.setMargin(buttonThree, Insets.EMPTY);
		HBox.setMargin(buttonFour, Insets.EMPTY);
		HBox.setMargin(buttonFive, Insets.EMPTY);
		HBox.setMargin(buttonSix, Insets.EMPTY);

		hBoxOne.setAlignment(Pos.CENTER);
		hBoxTwo.setAlignment(Pos.CENTER);

		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBoxOne.getChildren().addAll(labelFeedback, textField);
		//  add the buttons to the other HBox
		hBoxTwo.getChildren().addAll(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBoxOne, hBoxTwo);
		
	}

	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if(event.getTarget().equals(buttonOne)){
				textField.setText(dataManager.getHello());
			}else if(event.getTarget().equals(buttonTwo)){
				textField.setText(dataManager.getHowdy());
			}else if(event.getTarget().equals(buttonThree)){
				textField.setText(dataManager.getChinese());
			}else if(event.getTarget().equals(buttonFour)){
				textField.setText(dataManager.getTurkish());
			}else if(event.getTarget().equals(buttonFive)){
				textField.setText("");
			}else if(event.getTarget().equals(buttonSix)){
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
