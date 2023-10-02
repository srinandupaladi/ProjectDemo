package com.oracle.exceptiions;

public class ApplicationException extends RuntimeException {
public ApplicationException() {
}
public ApplicationException(String msg) {
	super(msg);
}
}