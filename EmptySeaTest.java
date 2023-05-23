package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptySeaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    void testetGetShipType() {
		
	Ship empty = new EmptySea();
	assertEquals("empty", empty.getShipType());
	}
	
	@Test
     void tesGetLength() {
		
    Ship empty = new EmptySea();
	assertEquals(1, empty.getLength());
	}
	
	
	@Test
	void testShootAt() {
	Ship empty = new EmptySea();
	Ocean ocean= new Ocean();
	empty .placeShipAt(1, 3, true, ocean);
	assertFalse(empty.shootAt(1,3));
	
	}
	
	
	/**
	 * inherited from ship
	 * return false to indicate that you didn't sink anything
	 */
	@Test
	
	void testIsSunk(){
	Ship empty = new EmptySea();
	assertFalse(empty.isSunk());
	}
	
	
	/**
	 * 
	 */
	
	@Test
	void testToString() {
	Ship empty = new EmptySea();
	assertEquals("-",empty.toString());
	}
	
	
	
	
	

}
