package battleship;

public class Cruiser extends Ship {

	
	//static variable
		static int LENGTH=3;

		static String TYPE="cruiser";
		
		//constructor
		public Cruiser() {
			super(Cruiser.LENGTH);
			
		}
		
		
		@Override
		public String getShipType() {
			
			return Cruiser.TYPE;
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}
