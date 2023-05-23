package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CruiserTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    void testetGetShipType() {
		
		Ship cruiser = new Cruiser();
		assertEquals("cruiser", cruiser.getShipType());
	}
	@Test
 void tesGetLength() {
		
		Ship cruiser = new Cruiser();
		assertEquals(3, cruiser.getLength());
	}
	

}
