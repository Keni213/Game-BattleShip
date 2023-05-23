package battleship;

public class EmptySea extends Ship {
	
	static int LENGTH = 1;
	static String TYPE = "empty";
	
	
	//Constructor
	public EmptySea() {
		super(EmptySea.LENGTH);	
	}
	
	
	//Method
	
	
	/**
	 * this method overrides from ship
	 * return false to indicate that nothing was hit
	 */
	@Override
	boolean shootAt(int row, int column) {
		this.getHit()[0]=true;
		return false;
	}
	
	
	
	/**
	 * inherited from ship
	 * return false to indicate that you didn't sink anything
	 */
	@Override
	boolean isSunk() {
		return false;
	}
	
	
	/**
	 * 
	 */
	
	@Override
	public String toString() {
	   return "-";
	}
	

	
	@Override
	public String getShipType() {
		
		return EmptySea.TYPE;
	}
	
}


