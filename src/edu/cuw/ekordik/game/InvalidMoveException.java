package edu.cuw.ekordik.game;

public class InvalidMoveException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMoveException(int movingDisc, int topDisc) {
		super("This move is invalid. " + movingDisc + " is smaller than " + topDisc);
	}
	
	public InvalidMoveException(String message) {
		super(message);
	}
}
