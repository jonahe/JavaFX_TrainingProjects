package com.jonahe.listview;

public class Student {

	private String name;
	
	public Student(String name){
		this.name = name;
	}
	
	public String getName(){ return name;}
	public void setName(String name){ this.name = name;}
	
	@Override
	public String toString(){
		// return "Student with name '" + name + "'";
		
		// For a horizontal listview this gives a "nice" effect..
		String verticalName = "";
		char[] lettersInName = name.toUpperCase().toCharArray();
		for(char c : lettersInName){
			verticalName += c + "\n";
		}
		return verticalName;
	}
}
