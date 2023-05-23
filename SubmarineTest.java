package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubmarineTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    void testetGetShipType() {
		
	Ship submarine = new Submarine();
	assertEquals("submarine", submarine.getShipType());
	}
	@Test
 void tesGetLength() {
		
		Ship submarine = new Submarine();
		assertEquals(1, submarine.getLength());
	}
	
}
