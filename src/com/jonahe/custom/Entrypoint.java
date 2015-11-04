package com.jonahe.custom;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Entrypoint extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox();
		Scene scene  = new Scene(root);
		
		Form personForm = new Form("Person form", "Save", 3);
		personForm.addFormRow("First name", new TextField());
		personForm.addFormRow("Last name", new TextField());
		personForm.addFormRow("Date of birth", new DatePicker(LocalDate.now().minusYears(30)));
		
		
		root.getChildren().addAll(personForm);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//TODO: Delete this todo.. (Just trying something with GitHub)
//		
//		
//		
//		TextField tfFirstName = (TextField) personForm.getNodeByLabelText("First name");
//		tfFirstName.setText("Hello WOrld!");
//		System.out.println(tfFirstName.getText());
	}

}
