package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// test
		// set title to  stage
		primaryStage.setTitle("All the world's a stage");
		// make a pane, to use in a scene later
		FlowPane pane = new FlowPane();
		pane.setHgap(30);
		pane.setVgap(5);
		// new scene
		Scene scene = new Scene(pane, 400, 400);
		// create nodes
		Button button1 = new Button("Click me!");
		Label label1 = new Label("Enter your name:");
		TextField nameField = new TextField();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		RadioButton radioB1 = new RadioButton("First option");
		radioB1.setSelected(true);
		RadioButton radioB2 = new RadioButton("Second option");
		radioB1.setToggleGroup(toggleGroup);
		radioB2.setToggleGroup(toggleGroup);
		Label helloMessage = new Label();
		
		// add nodes to the pane
		pane.getChildren().addAll(label1, nameField, button1, radioB1, radioB2, helloMessage);
		
		// associate the scene with the stage
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
		
		// set listeners 
		
		button1.setOnAction(e -> helloMessage.setText("Hello, " + nameField.getText() + "!"));
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
