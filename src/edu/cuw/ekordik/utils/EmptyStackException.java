package edu.cuw.ekordik.utils;

public class EmptyStackException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String message) {
		super(message);
	}
}
