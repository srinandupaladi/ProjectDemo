package com.oracle.dto;
//dto ->Data Transfer Object
public class ApiError {
private String error;
private int statusCode;
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

}