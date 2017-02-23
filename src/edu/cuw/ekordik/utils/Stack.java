package edu.cuw.ekordik.utils;

/**
 * Stack class that allows the user to pop, push, and peek at the top of the stack.
 * 
 * @author emmakordik
 *
 */
public class Stack {
	
	private Node top;
	private int count;
	
	public Stack() {
		this.top = null;
		this.count = 0;
	}
	
	/**
	 * Pushs an item onto the top of the stack
	 * 
	 * @param payload - int
	 */
	public void push(int payload) {
		if(this.top == null) {
			this.top = new Node(payload);
		}else {
			Node newNode = new Node(payload);
			newNode.setNextNode(top);
			top = newNode;
		}
		
		this.count++;
	}
	
	/**
	 * Removes the item from the top of the stack and returns it.
	 * 
	 * @return - int 
	 * @throws EmptyStackException - if you attempt to pop from an empty stack
	 */
	public int pop() throws EmptyStackException {
		if(this.top == null) {
			throw new EmptyStackException("Can't pop from an empty stack");
		}else {
			int valToReturn = this.top.getData();
			this.top = this.top.getNextNode();
			this.count--;
			return valToReturn;
		}
		
	}
	
	/**
	 * Displays the item on the top of the stack without removing it.
	 * 
	 * @return - int
	 * @throws EmptyStackException - if you attempt to peek at an empty stack
	 */
	public int peek() throws EmptyStackException {
		if(this.top == null) {
			throw new EmptyStackException("You have an empyt stack; nothing to peek.");
		}
		
		return this.top.getData();
	}
	
	/**
	 * Returns a boolean based on whether or not the stack is empty.
	 * 
	 * @return - boolean
	 */
	public boolean empty() {
		return this.count == 0 ? true : false;
	}
}
