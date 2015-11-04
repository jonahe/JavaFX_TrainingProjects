package com.jonahe.custom;

import java.util.HashMap;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


public class Form extends GridPane {
	private String name;
	private int rowCounter = 0;
	private HashMap<String, Node> rowNodes;
	private Button submitButton;

	public Form(String formNameForIdentification, String submitBtnText, int numberOfFields) { //TODO: work out how to move the btn down one step for each added row
		rowNodes = new HashMap<String, Node>();
		name = formNameForIdentification;
		setStyle("-fx-border-style: solid");
		setStyle("-fx-border-color: lightgrey");
		this.setPadding(new Insets(5));
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(33);
		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(67);
		this.getColumnConstraints().addAll(c1, c2);
		this.setVgap(4);
		
		setSubmitButton(submitBtnText, numberOfFields);
		// moveButtonToBottomRow();
	}
	
	public String getname() { 
		return name; 
	}
	
	public Node getNodeByLabelText(String labelText) { 
		return rowNodes.get(labelText); 
	}
	
	public void addFormRow(String labelText, Node control) {
		Label label = new Label(labelText);
		addRow(rowCounter, label, control);
		rowCounter++;
		
		// save for easy access
		rowNodes.put(labelText, control);
		
		// moveButtonToBottomRow();
		
	}
	
	//TODO: fix so that this method works. Currently, it seems to break the layout somehow.
	private void moveButtonToBottomRow() {
		//setConstraints(submitButton, 0, rowCounter);
		setRowIndex(submitButton, rowCounter);
	}
	
	private void setSubmitButton(String submitBtnText, int numberOfFields) {
		this.submitButton = new Button(submitBtnText);
		setColumnSpan(submitButton, 2);
		setHalignment(submitButton, HPos.CENTER);
		addRow(numberOfFields, submitButton);
	}
	
	
	
	
}
