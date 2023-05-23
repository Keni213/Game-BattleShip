package battleship;

public class Destroyer extends Ship{
	
	//static variable
			static int LENGTH=2;

			static String TYPE= "destroyer";
			
			//constructor
			public Destroyer() {
				super(Destroyer.LENGTH);

			}
			
			
			@Override
			public String getShipType() {
				
				return Destroyer.TYPE;
			}
			
			

}
