 package com.oracle.entity;

import java.util.List;

public class Movie {
private int movieCode;
private String movieName;
private String language;
private String genre;
private List<Review> reviews;

public Movie() {
	// TODO Auto-generated constructor stub
}

public Movie(int movieCode, String movieName, String language, String genre, List<Review> reviews) {
	super();
	this.movieCode = movieCode;
	this.movieName = movieName;
	this.language = language;
	this.genre = genre;
	this.reviews = reviews;
}

public Movie(int movieCode, String movieName, String language, String genre) {
	super();
	this.movieCode = movieCode;
	this.movieName = movieName;
	this.language = language;
	this.genre = genre;
}

public List<Review> getReviews() {
	return reviews;
}

public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

public int getMovieCode() {
	return movieCode;
}
public void setMovieCode(int movieCode) {
	this.movieCode = movieCode;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}

}