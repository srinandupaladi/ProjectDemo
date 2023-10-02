package com.oracle.entity;

public class Review {
private int revId;
private String reviewerName;
private String content;
private float ratings;
public Review() {
	// TODO Auto-generated constructor stub
}

public Review(int revId, String reviewerName, String content, float ratings) {
	super();
	this.revId = revId;
	this.reviewerName = reviewerName;
	this.content = content;
	this.ratings = ratings;
}

public int getRevId() {
	return revId;
}
public void setRevId(int revId) {
	this.revId = revId;
}
public String getReviewerName() {
	return reviewerName;
}
public void setReviewerName(String reviewerName) {
	this.reviewerName = reviewerName;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public float getRatings() {
	return ratings;
}
public void setRatings(float ratings) {
	this.ratings = ratings;
}


}