package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestroyerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    void testetGetShipType() {
		
	Ship destroyer = new Destroyer();
	assertEquals("destroyer", destroyer.getShipType());
	}
	@Test
 void tesGetLength() {
		
		Ship destroyer = new Destroyer();
		assertEquals(2, destroyer.getLength());
	}
	

}
