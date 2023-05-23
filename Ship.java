package battleship;

public abstract class Ship {

	//instance variable
	
	private int bowRow;
	
	private int bowColumn;
	
	private int length;
	
	private boolean horizontal;
	
	private boolean[]hit;
	
	
	//constructor
	
	/**
	 * call by subclasses of Ship to create instances of different type of ship
	 * @param length of the ship
	 */
	public Ship(int length) {
		this.length = length;	
		this.hit = new boolean[this.getLength()];
	}
	
	
	//Methods
	
	//Getter
	/**
	 * get the row for ship bow
	 * @return
	 */
	public int getBowRow() {
		return this.bowRow;
	}


	/**
	 * get the column for ship bow
	 * @return
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}
    
	/**
	 * get the length of the ship
	 * @return
	 */
	
	public int getLength() {
		return this.length;
	}
	
	/**
	 * get the horizon of this ship
	 * @return
	 */
	
	public boolean isHorizontal() {
		return this.horizontal;
	}
	
	/**
	 * get the hit array for this ship
	 * @return
	 */

	public boolean[] getHit() {
		return this.hit;
	}


	
	
	//Setter
	/**
	 * set the row for the ship bow
	 * @param bowRow
	 */
	
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow; 
	}

    /**
     * set the column for this ship bow
     * @param bowColumn
     */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	
/**
 * set the horizon or vertical
 * @param horizontal
 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}


	
	//Abstract Method
	
	/**
	 * abstract method, setting whithout function
	 * @return
	 */
	public abstract String getShipType();
	
	
	//Other non-abstract method
	

    /**
     * check the adjacent cell for each cell
     * @param row
     * @param column
     * @param ocean
     * @return true if the row and column in the ocean and not occupied. or out or bondary. 
     */
	
	 boolean checkAdj(int row,int column,Ocean ocean) {
		
		boolean check =false;
		
		if(column>=0 && row>=0 && row<10 && column<10) {//if any column or row out of range, it is ok for adjacent, 
			// we have to check the the occupation 
			if(ocean.isOccupied(row,column)==false) {
				
				check = true; //it is ok to be a adjacent. 
			}
			}else {
			check= true;
		}
			
          return check;
           
        }
		
		
	/**
	 * check if the cell is ok for place a ship
	 * @param row
	 * @param column
	 * @param ocean
	 * @return true if the all the adjacent cell is true
	 * 
	 */
	
	
	 boolean checkCell(int row, int column, Ocean ocean) {//we have to check the location and all the adjacent to be ok. 
		
		boolean check = false;
		//if all the 9 cell is true for this location ,return true
		
		if(column>=0 && row>=0 && row<10 && column<10) {
			if(ocean.isOccupied(row, column)==false) {
				if (this.checkAdj(row,column+1,ocean)
						&& this.checkAdj(row,column-1,ocean)
						&& this.checkAdj(row+1,column-1,ocean)
						&& this.checkAdj(row+1,column,ocean) 
		    			&& this.checkAdj(row+1,column+1,ocean) 
		    			&& this.checkAdj(row-1,column-1,ocean) 
		    			&& this.checkAdj(row-1,column,ocean)
		    			&& this.checkAdj(row-1,column+1,ocean)) {
					check = true;
				}
			}
		}
		return check;
	 }
				
	
	
	
	/**
	 * check if okay to put a ship in this location
	 * @param row in the ocean
	 * @param column in the ocean
	 * @param horizontal 
	 * @param ocean
	 * @return true if it is ok to place this this location, return false if not
	 */
	
	boolean okToPlaceShipAt(int row, int column, boolean horizontal,Ocean ocean) {

		boolean ok = true;
		//boolean ok = true;
        if(horizontal) {//when the ship is horizontally placed, 
        for(int i=0;i<this.getLength();i++) { //check all the cell on this ship
 
        	//if any cell is not ok, we can break and return false.
        	 if(checkCell(row,column-i,ocean)==false) {
        		 ok = false;
        		break;
        	}
        }
        
        }else {//if vertically
        	   for(int j=0;j<this.getLength();j++) {//if any cell is not ok, we can break and return false.	   
        		

              	 if(checkCell(row-j,column,ocean)==false){
              		ok = false;
              		 break;
              	 }
              	}
             
	  }
        
	return ok;
	 }
	
	
	
	/**
	 * place this ship into the Ocean based on the parameters
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */

	void placeShipAt(int row, int column,boolean horizontal,Ocean ocean) {
		//set the bowRow and bowColumn for this Ship
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		//if the length of this ship is 4
 
				
			if(horizontal) {//place horizontally
			for(int i=0;i<this.getLength();i++) {
				//place this ship into the location in the ocean
				ocean.getShipArray()[row][column-i]=this;
			}
			}else {//place vertically
				for(int j=0;j<this.getLength();j++) {
					//place this ship into the location in the ocean
					ocean.getShipArray()[row-j][column]=this;
				}
			}
	}
		
		
		
	
	/**
	 * to check if shoot a part of the ship in the ocean
	 * @param row the location to be shoot
	 * @param column the location to be shoot
	 * @return true if it shoot a part of ship
	 */
	boolean shootAt(int row, int column) {
		//set the initial shootAt as false
		boolean shoot=false;
		

		//based on the bowRow and bowColumn, we can have the index for shoot location
		int rowIndex= this.getBowRow()-row;//index of row, is the different between ship bow - given row
		int colIndex= this.getBowColumn()-column; //index of column, is the difference between this ship column-given column

		//if the bow and column same with the bow location, shoot the bow of the ship
		if(row==this.getBowRow() && column== this.getBowColumn()) {
			this.getHit()[0]=true;
			shoot = true;
		}
			
		//if  shoot the body of the ship
		if(this.isHorizontal()&&row==this.getBowRow()&& colIndex<this.getLength() && colIndex>=0 ) {
			//same row, different column, the index of the column between length and 0. this ship place horizontally
			this.getHit()[colIndex]=true;
			shoot = true;
				}
		
		if((this.horizontal==false) && column ==this.getBowColumn() && rowIndex<this.getLength() && rowIndex>=0){
			//same column, the row index is between of and the length of the ship, we can change the hit to be true and return true
			this.getHit()[rowIndex]=true;
			shoot=true;
		}
		return shoot;
		
	}
	
	
	/**
	 * check if every part in the ship has been hit. 
	 * @return true if the ship is sunk,
	 *  return false when any part of the ship is not been shoot
	 */
	boolean isSunk() {
		boolean isSunk =false;
		int count=0;
		for(int i=0;i<this.getLength();i++) {
			if(this.getHit()[i]==true) {
				count+=1;
			}
		}
		if(count==this.length) {
			isSunk = true;
		}
		return isSunk;
	}
	
	
	/**
	 * print out location in the ocean that have been shoot at
	 * @return "s"if the ship has been sunk, return"x"if it has not been sunk
	 */
	
	@Override
	public String toString() {
		if(this.isSunk()){
			return "s";
		}else {
			return "x";
	
	}
	}
	
	
	
	
	
}
