package battleship;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the BattleShip Game.");
		//initialize the game 
		Ocean ocean = new Ocean();
		
		System.out.println("Now the game is ready to play!");
		
		//place all the ship in the sea
		ocean.placeAllShipsRandomly();
		
	
		//ocean.printWithShips();
		System.out.println(" ");
		
		//print a sea without any shoot
		ocean.printWithShips();
		ocean.print();
		
		
	
		while(ocean.isGameOver()==false) {
			
			
		Scanner input= new Scanner(System.in);
		
		System.out.print(" please shoot a location, input row and column:");
		
		int row = input.nextInt();
		int column = input.nextInt();
		
		//shoot this location
		ocean.shootAt(row,column);
			
		//print the map with shooting 
		ocean.print();
		System.out.println("Total number of shooting:" + ocean.getShotsFired());
		System.out.println("Total number of hitting the ship:" + ocean.getHitCount());
		System.out.println("Total number of ship sunk:" + ocean.getShipsSunk());
		
		if(ocean.isGameOver()==true) {
			
			System.out.println("Game Over");
			
			break;
		
		}
		
		}
		

	}

}
