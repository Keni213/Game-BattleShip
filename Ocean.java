package battleship;

import java.util.Random;

public class Ocean {
	
	
	/**
	 * to determine which ship is in any given location
	 */
	private Ship[][] ships= new Ship[10][10];
	
	
	/**
	 * the total number of shots fired by user
	 */
	private int shotsFired;
	
	
	/**
	 * the number of times a shot hit a ship. If the user shoots the same part of a ship，every hit counted
	 */
	private int hitCount;
	
	
	/**
	 * the number of ship sunk
	 */
			
	 private int shipsSunk;
	
	
	//Constructor
	 
	 /**
	  * create the empty ocean
	  * initialize a game variable
	  */
	 public Ocean() {
		 
		 //create instance of EmptySea and fill the empty to the ships location. 
		 //create a new empty instance, and filled in the ships
		
		 
		 for(int i=0; i<10; i++) {
			 for(int j=0; j<10; j++) {
				 //each cell reference to a empty Ship
				 EmptySea empty1 = new EmptySea();
				 empty1.setBowColumn(j);
				 empty1.setBowRow(i);
				 this.getShipArray()[i][j]= empty1;
				 }
		 }
		 
		 
		 this.hitCount = 0;
		 
		 this.shotsFired = 0;
		 
         this.shipsSunk = 0;
		 
	 }
	 /**
	  * help the ships filled with empty ship
	  * @param empty
	  */
	 
	
	
	 //Methods
	 
	 /**
	  * place all the ships randomly in the ships
	  */
	 void placeAllShipsRandomly() {
		 
		 //place BattleShip
         //set a random from 0 to 9
		 Random rand = new Random() ;
		 
		
		 int row  ;
		 //set a column from 0 to 0
		 int column ;
		 //set a horizontal as true of false
		 boolean horizontal;
		
		 //create a battleship1
		 Battleship battleShip1 = new Battleship();
		 
		 //while the battleship is not ok to place in the ships, we have to get the new row and column
		 while(true) {
			//crate a new Random
			 
			 
			row =rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextBoolean();
			 
			 //if this location is ok to place this ship, place it and break the loop
			 if(battleShip1.okToPlaceShipAt(row, column, horizontal, this)) {
				battleShip1.placeShipAt(row, column, horizontal,this);
				break;
			}
		 }
		
		 //place two cruisers
		 
			 Cruiser cruiser1 = new Cruiser();
		 //cruise1
			 while(true) {
				 row =rand.nextInt(10);
				 column = rand.nextInt(10);
				 horizontal = rand.nextBoolean();
				 
				 //if this location is ok to place this ship, place it and break the loop
				 if(cruiser1.okToPlaceShipAt(row, column, horizontal,this)) {
					cruiser1.placeShipAt(row, column, horizontal,this);
					break;
				}
			 }
		 
		 //cruiser2
			 
			 Cruiser cruiser2 = new Cruiser();
			 
			 while(true) {
				 row =rand.nextInt(10);
				 column = rand.nextInt(10);
				 horizontal = rand.nextBoolean();
				 
				 //if this location is ok to place this ship, place it and break the loop
				 if(cruiser2.okToPlaceShipAt(row, column, horizontal, this)) {
					cruiser2.placeShipAt(row, column, horizontal,this);
					break;
				}
		 
				} 
		
			 //place three destroyers
			 
			 //destroyer1
				 
				 Destroyer destroyer1 = new Destroyer();
				 
				 while(true) {
					 row =rand.nextInt(10);
					 column = rand.nextInt(10);
					 horizontal = rand.nextBoolean();
					 
					 //if this location is ok to place this ship, place it and break the loop
					 if(destroyer1.okToPlaceShipAt(row, column, horizontal, this)) {
						 destroyer1.placeShipAt(row, column, horizontal,this);
						 break;
					}
				 }
				 
				
				//destroyer2
				 
				 Destroyer destroyer2 = new Destroyer();
					 
					 while(true) {
						 row =rand.nextInt(10);
						 column = rand.nextInt(10);
						 horizontal = rand.nextBoolean();
						 
						 //if this location is ok to place this ship, place it and break the loop
						 if(destroyer2.okToPlaceShipAt(row, column, horizontal, this)) {
							 destroyer2.placeShipAt(row, column, horizontal,this);
							 break;
						}
			 
					 }
			 
					//destroyer3
						 
					 Destroyer destroyer3 = new Destroyer();
						 
						 while(true) {
							 row =rand.nextInt(10);
							 column = rand.nextInt(10);
							 horizontal = rand.nextBoolean();
							 
							 //if this location is ok to place this ship, place it and break the loop
							 if(destroyer3.okToPlaceShipAt(row, column, horizontal, this)) {
								 destroyer3.placeShipAt(row, column, horizontal,this);
								 break;
							}
				 
						 }
		 //place 4 submarines
						 
		//submarine1
							 
	 Submarine submarine1 = new Submarine();
			
		 while(true) {
			 row =rand.nextInt(10);
			 column = rand.nextInt(10);
			 horizontal = rand.nextBoolean();
			 
			 //if this location is ok to place this ship, place it and break the loop
			 if(submarine1.okToPlaceShipAt(row, column, horizontal, this)) {
				 submarine1.placeShipAt(row, column, horizontal,this);
				 break;
			}
		 }
		
		//submarine2
							 
		 Submarine submarine2 = new Submarine();
							 
		 while(true) {
			 row =rand.nextInt(10);
			 column = rand.nextInt(10);
			 horizontal = rand.nextBoolean();
			 
			 //if this location is ok to place this ship, place it and break the loop
			 if(submarine2.okToPlaceShipAt(row, column, horizontal, this)) {
				 submarine2.placeShipAt(row, column, horizontal,this);
				 break;
			}
		 }
		
		//submarine3
							 
		 Submarine submarine3 = new Submarine();
							 

		 while(true) {
			 row =rand.nextInt(10);
			 column = rand.nextInt(10);
			 horizontal = rand.nextBoolean();
			 
			 //if this location is ok to place this ship, place it and break the loop
			 if(submarine3.okToPlaceShipAt(row, column, horizontal, this)) {
				 submarine3.placeShipAt(row, column, horizontal,this);
				 break;
			}
			}				 
		 
		 //submarine4
							 
		 Submarine submarine4 = new Submarine();

		 while(true) {
			 row =rand.nextInt(10);
			 column = rand.nextInt(10);
			 horizontal = rand.nextBoolean();
			 
			 //if this location is ok to place this ship, place it and break the loop
			 if(submarine4.okToPlaceShipAt(row, column, horizontal, this)) {
				 submarine4.placeShipAt(row, column, horizontal,this);
				 break;
			}
		    
		 }
		 
		 }	

	 
	 
	 /**
	  * check if the given location contains a ship
	  * @param row
	  * @param column
	  * @return true if the given location contains a ship, false if it does not.
	  */
	 boolean isOccupied(int row, int column) {
		 if(this.getShipArray()[row][column].getShipType()=="empty"){
			 return false;
		 }else {
			 return true;
		 }
	 }
	 
	 /**
	  * 
	  * @param row
	  * @param column
	  * @return true if the given location contains real ship and still aflot. false if it does not
	  * update the number of shots that have been fired, and the number of hits.
	  */
	 boolean shootAt(int row, int column) {
		 //add 1 to shoutsFired
		 this.shotsFired+=1;
		 //shoot the place and change the shoot as true for this location
		 
		 
		 
		 //contain a real ship and this ship is not Sunk
		 
		 if(this.isOccupied(row, column)){
			 if(this.getShipArray()[row][column].isSunk()==false) {
		       //add hitCount
			   this.hitCount+=1;
			  //return true	
			   this.getShipArray()[row][column].shootAt(row,column);
			   
			   if(this.getShipArray()[row][column].isSunk()) {
				   shipsSunk+=1;
			   }
			   return true;
			   
				    }else {
				    	return false;
				    }
			 }else {
				 this.getShipArray()[row][column].shootAt(row,column);
				 return false;
			 }
       
	 }
				
			
		
	
			
	
     
	 
	 /**
	  * return the  number of shots fired
	  * @return
	  */
	 
	 int getShotsFired() {
		 return this.shotsFired;
		 
	 }
	 
	 
	 /**
	  * return the number of hits recorded(in the game)
	  * @return
	  */
	 int getHitCount() {
		 return this.hitCount;
		 
	 }
	 
	 
	 /**
	  * return the number of ships sunk(in the game)
	  */
	 int getShipsSunk() {
		 return this.shipsSunk;
	 }
	 
	 /**
	  * to check if the game is done
	  * @return true if all ships has been sunk, otherwise false
	  */
	 boolean isGameOver() {
		 
		 //we assume the game over, initiate the over is ture; 
		 boolean over=true;
		 
		 //we can loop every the location in the 10*10 ocean
		 for(int i=0;i<10;i++) {
			 for(int j=0; j<10 ; j++){ 
				 //if one location occupied by a ship and is not sunk, this game is not over
				 //(if not occupied, and this sunk is false. we can not get true. 
				 if(this.isOccupied(i, j) && (this.getShipArray()[i][j].isSunk()==false)) {
					 over=false;
					 break;
				 }
			 }
		 }  
		
		 return over; 
	 }
	 
	 
	 
	 /**
	  * return the array of Ship
	  * @return
	  */
	 
	 Ship[][] getShipArray(){
		 return this.ships;
	 }
	 
	 
	 /**
	  * void Print
	  */
	 
	 void print() {
		
		 for(int i=-1;i<10;i++) {
			 
			 for(int j=-1; j<10 ; j++){ 
				 
                //the first row should be the column index
				 if(i==-1 && j==-1) {
					 System.out.print("  "); 
				 }else if(i==-1) {
					 System.out.print(j+" ");
				 } else if(j==-1){
					 System.out.print(i+" ");
				 }else if
				 (this.wasHit(i,j)){
						 System.out.print(this.getShipArray()[i][j].toString()+" ");				   
					
					 }

			 else {
				 
					 System.out.print("."+" "); 
				 
			 }
	 }
		 System.out.println("");
	 } 	 
} 
	/**
	 * try to find if the input column and row hit the ship.
	 * @param i
	 * @param j
	 * @return
	 */
	
	boolean wasHit(int i, int j) {
		
		boolean hit = false;
	
	if(this.isOccupied(i, j)==false) {//if this is an emptySea
		if (this.getShipArray()[i][j].getHit()[0]==true){//if the getHit[0] is true, this empty has been shooted
			hit = true;
	}
	
	
	} else {	
	if(this.getShipArray()[i][j].isHorizontal()) {
			
		int index=this.getShipArray()[i][j].getBowColumn()-j;	
		if(this.getShipArray()[i][j].getHit()[index]) {//if this location is been shoot, return true
			hit = true;
		}
	} 
	else{	
	if(this.getShipArray()[i][j].isHorizontal()==false){
		int index=this.getShipArray()[i][j].getBowRow()-i;
		if(this.getShipArray()[i][j].getHit()[index]) {
				hit = true;
		}
			
	}
	}
	}

	return hit;
	}

 
	 /**
	  * return 
	  */

	 
	 void printWithShips() {
			
		 for(int i=-1;i<10;i++) {
			 
			 for(int j=-1; j<10 ; j++){ 
				 
                //the first row should be the column index
				 if(i==-1 && j==-1) {
					 System.out.print("  "); 
				 }else if(i==-1) {
					 System.out.print(j+" ");
				 } else if(j==-1){
					 System.out.print(i+" ");
				 }else if(ships[i][j].getShipType().equals("battleship")) {
						 
						 System.out.print("b ");
						 
					 }else if(ships[i][j].getShipType().equals("cruiser")){
						 
						 System.out.print("c "); 
						 
					 }else if(ships[i][j].getShipType().equals("destroyer")) {
						 
						 System.out.print("d "); 
					
					 }else if(ships[i][j].getShipType().equals("submarine")) {
						 
						 System.out.print("s "); 
					 }
					 
					 else {
						 System.out.print("."+" ");  
					 }
			
			 }System.out.println("");
	 }
		 
	 } 	 

		 
	 }
	 
	 

	 
	 
	 
	 
	 
	 
	



