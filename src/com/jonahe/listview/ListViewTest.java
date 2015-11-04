package com.jonahe.listview;


import java.util.ArrayList;
import java.util.Arrays;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ListViewTest extends Application {



	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("ListView test app");
		// 
		BorderPane borderPane = new BorderPane();
		// top 
		Label titleLabel = new Label("ListView test");
		titleLabel.setFont(new javafx.scene.text.Font("Arial", 35));
		titleLabel.setAlignment(Pos.CENTER_RIGHT);
		titleLabel.setTextAlignment(TextAlignment.RIGHT);
		borderPane.setTop(titleLabel);
		// set the label to center
		BorderPane.setAlignment(titleLabel, Pos.CENTER);
		// center
		ArrayList<String> names  = new ArrayList<String>(Arrays.asList("Erik,Johan,Jocke,Emma,Sara,Niklas".split(",")));
		
		ObservableList<Student> students = FXCollections.observableArrayList();
		names.forEach( name -> students.add(new Student(name)));

		ListView<Student> namesListView = new ListView<>(students);
		namesListView.setOrientation(Orientation.HORIZONTAL);
		namesListView.setCenterShape(true);
		borderPane.setCenter(namesListView);
		// set listeners for list
		namesListView.setOnMouseClicked( mouseEvent -> {
			
			Student studentClickedOn = namesListView.getSelectionModel().getSelectedItem();
			int indexClickedOn = namesListView.getSelectionModel().getSelectedIndex();
			
			if(mouseEvent.getButton() == MouseButton.PRIMARY){
				// "copy" the student, and add it right to the one clicked
				students.add(indexClickedOn +1, new Student(studentClickedOn.getName()));				
			} else {
				students.remove(studentClickedOn);
				namesListView.getSelectionModel().clearSelection();
			}
			
		});
		
		
		
		Scene scene = new Scene(borderPane, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
