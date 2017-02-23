package edu.cuw.ekordik.game;

import edu.cuw.ekordik.utils.EmptyStackException;
import edu.cuw.ekordik.utils.Stack;

public class Game {
	private Stack[] stacks = new Stack[3];
	private int moves;
	
	/**
	 * Initializes the game with a number of discs that gets inputed
	 * 
	 * @param numDisc - number of disc to start the game with.
	 */
	public Game(int numDisc) {
		//initialize our stacks
		stacks[0] = new Stack();
		stacks[1] = new Stack();
		stacks[2] = new Stack();
		
		//put the disc on the first stack
		for(int i = numDisc; i > 0; i--) {
			stacks[0].push(i);
		}
		
	}
	
	/**
	 * Checks to see if the player has finished the game.
	 * 
	 * @return - boolean 
	 */
	public boolean gameOver() {
		if(this.stacks[0].empty() && this.stacks[1].empty()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Returns the number of moves the player has made.
	 * 
	 * @return - int
	 */
	public int getMoves() {
		return this.moves;
	}
	
	/**
	 * Displays the game to the console.
	 */
	public void displayGame() {
		System.out.println("Stack One:");
		System.out.println("|");
		displayStack(this.stacks[0]);
		System.out.println("========");
		System.out.println("Stack Two");
		System.out.println("|");
		displayStack(this.stacks[1]);
		System.out.println("========");
		System.out.println("Stack Three");
		System.out.println("|");
		displayStack(this.stacks[2]);
		System.out.println("========");
	}
	
	private void displayStack(Stack stack) {
		Stack temp = new Stack();
		while(!stack.empty()) {
			for(int i = 0; i< stack.peek(); i++) {
				System.out.print("-");
			}
			System.out.println("");
			temp.push(stack.pop());
		}
		while(!temp.empty()) {
			stack.push(temp.pop());
		}
	}
	
	/**
	 * Moves a disc from one stack to another stack
	 * 
	 * @param fromStack - the number of the stack to disc starts on
	 * @param destinationStack - the number of the stack the disc should end on
	 * @throws EmptyStackException - gets thrown if you try to move from an empty stack
	 * @throws InvalidMoveException - gets thrown if you try to do a move that is not allowed
	 */
	public void move(int fromStack, int destinationStack) throws EmptyStackException, InvalidMoveException {
		if(fromStack == destinationStack) {
			throw new InvalidMoveException("The stack to move from and to are the same!");
		}
		
		if(fromStack > this.stacks.length || fromStack <= 0) {
			throw new InvalidMoveException("You cannot move from " + fromStack 
					+ " stack. It is not a stack. Choose 1, 2, or 3");
		}
		
		if(destinationStack > this.stacks.length || destinationStack <= 0) {
			throw new InvalidMoveException("You cannot move to " + destinationStack 
					+ " stack. It is not a stack. Choose 1, 2, or 3");
		}
		
		try{
			int disc = this.stacks[fromStack-1].peek();
			if(this.stacks[destinationStack-1].peek() < disc) {
				throw new InvalidMoveException("Invalid Move. " + this.stacks[destinationStack-1].peek() + " is less than " + disc);
			}
		}catch(EmptyStackException ese) {
			//Can move to an empty stack so we ignore this.
		}
		
		this.stacks[destinationStack-1].push(this.stacks[fromStack-1].pop());
		this.moves++;
	}
}
