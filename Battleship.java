package battleship;

public class Battleship extends Ship{
	

//static variable
	/**
	 * default length for all battleship
	 * only accssible withing this class
	 */
	static int LENGTH=4;

	static String TYPE="battleship";


	
	
	
	//constructor
	
	   public Battleship() {
			super(Battleship.LENGTH);
		}
	
	   
	@Override
	public String getShipType() {
		
		return Battleship.TYPE;
	}
	
	
	
	
	
	

}
