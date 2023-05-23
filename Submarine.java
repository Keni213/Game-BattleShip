package battleship;

public class Submarine extends Ship{

	//static variable
	static int length=1;

	static String type = "submarine";
	
	//constructor
	public Submarine() {
		super(Submarine.length);	
	}
	
	
	@Override
	public String getShipType() {
		
		return Submarine.type;
	}
	
}
