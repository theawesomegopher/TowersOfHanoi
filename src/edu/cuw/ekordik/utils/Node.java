package edu.cuw.ekordik.utils;


/**
 * Represents a node to be used in a linked list. Each node stores int data and the address
 * of the next node in the list.
 * 
 * @author emmakordik
 *
 */
public class Node {
	private int data;
	private Node nextNode;
	
	public Node(int data){
		this.data = data;
		this.nextNode = null;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
