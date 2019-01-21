package com.au.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.au.test.Movie;

public class FrontEnd implements Serializable {
	
	static ArrayList<Movie> listMovies =  new ArrayList<Movie>();
	
	public String insertMovie(String name, int noOfActors, int noOfScreens) {
		Movie m = new Movie(name, noOfActors, noOfScreens);
		listMovies.add(m);
		System.out.println(listMovies);
		return "Movie successfully added !";
	}
	
	public String getMovieByName(String name) {
		Iterator<Movie> iterator = listMovies.iterator();
		while(iterator.hasNext()) {
			Movie m = iterator.next();
			if(m.getName().equals(name))
				return m.toString();
		}
		return null;
	}
	
	public String updateMovie(String name, int noOfActors, int noOfScreens) {
		Movie movie = new Movie(name, noOfActors, noOfScreens);
		Iterator<Movie> iterator = listMovies.iterator();
		int i=0; 
		boolean flag=false;
		while(iterator.hasNext()) {
			Movie m = iterator.next();
			if(m.getName().equals(name)) {
				listMovies.set(i,movie);
				flag=true;
			}
			i++;
		}
		if(flag)
			return "Successful Updation";
		else
			return "No such movies found";
	}
	
	public String deleteMovie(String name) {
		Iterator<Movie> iterator = listMovies.iterator();
		int i=0; 
		boolean flag=false;
		while(iterator.hasNext()) {
			Movie m = iterator.next();
			if(m.getName().equals(name)) {
				listMovies.remove(i);
				flag=true;
			}
			i++;
		}
		if(flag)
			return "Deletion Updation";
		else
			return "No such movies found";
	}
	
	public String getAllMovies() {
		String str = "";
		Iterator<Movie> iterator = listMovies.iterator();
		int i=0; 
		boolean flag=false;
		while(iterator.hasNext()) {
			Movie m = iterator.next();
			str+=m+", ";
		}
		return str;
	}
	
}
