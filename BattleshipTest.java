package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleshipTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
       void testetGetShipType() {
		
		Ship battleship = new Battleship();
		assertEquals("battleship", battleship.getShipType());
	}
	@Test
    void tesGetLength() {
		
		Ship battleship = new Battleship();
		assertEquals(4, battleship.getLength());
	}
	
	
	

}
