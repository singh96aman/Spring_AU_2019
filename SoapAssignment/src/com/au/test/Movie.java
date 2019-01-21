package com.au.test;

public class Movie {

	String name;
	int noOfActors, noOfScreens;
	
	Movie(String name, int noOfActors, int noOfScreens){
		this.name=name;
		this.noOfScreens=noOfScreens;
		this.noOfActors=noOfActors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfActors() {
		return noOfActors;
	}

	public void setNoOfActors(int noOfActors) {
		this.noOfActors = noOfActors;
	}

	public int getNoOfScreens() {
		return noOfScreens;
	}

	public void setNoOfScreens(int noOfScreens) {
		this.noOfScreens = noOfScreens;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.noOfActors+" "+this.noOfScreens;
	}
}
