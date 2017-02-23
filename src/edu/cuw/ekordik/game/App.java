package edu.cuw.ekordik.game;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Game game;
		int numDisc = 0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to Towers Of Hanoi");
		System.out.println("The goal of this game is to move all the disc from tower 1 to the tower 3");
		System.out.println("All input must be in digits");
		
		do {
			System.out.println("You must have at least three disc.");
			System.out.print("How many disc would you like to play with? ");
			try{
				numDisc = Integer.parseInt(keyboard.nextLine());
			}catch(NumberFormatException nfe){
				System.out.println("Please enter a digit");
			}
		}while(numDisc < 3);
		
		game = new Game(numDisc);
		game.displayGame();
		
		while(!game.gameOver()) {
			try{
				System.out.print("Enter the tower to move from: ");
				int fromTower = Integer.parseInt(keyboard.nextLine());
				
				System.out.print("Enter the tower to move to: ");
				int toTower = Integer.parseInt(keyboard.nextLine());
				
				game.move(fromTower, toTower);
				game.displayGame();
			}catch(NumberFormatException nfe) {
				System.out.println("Please enter the number as a digit");
			} catch(RuntimeException e){
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Game Over! You completed it in " + game.getMoves() + " moves.");
		keyboard.close();

	}
}
