package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	Ocean ocean;
	Ship ship;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());
		
		//TODO
		//Test the emptySea, which the length equals to 1
		ship = new EmptySea();
		assertEquals(1, ship.getLength());
		
		//Test the Cruiser, which the length equals to 3
		ship = new Cruiser();
		assertEquals(3, ship.getLength());
		
		//Test the Destroyer, which the length equals to 2
		ship = new Destroyer();
		assertEquals(2, ship.getLength());
		
		//Test the Submarine, which the length not equals to 2
		ship = new Submarine();
		assertNotEquals(2, ship.getLength());
		
		
		
	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//Test the bowRow for emptySea 
		
		Ship emptySea = new EmptySea();
		row = 2;
		column = 2;
		horizontal = true;
		emptySea.placeShipAt(row, column, horizontal, ocean);
		assertEquals(2, emptySea.getBowRow());
		
		
		// Test the bowRow for a Destroyer
		
		Ship destroyer = new Destroyer();
		row = 8;
		column = 9;
		horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(8, destroyer.getBowRow());
		
		
		
		
	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());	
		
		//TODO
		//Test the bowColumn for emptySea 
		
		Ship emptySea = new EmptySea();
		row = 2;
		column = 2;
		horizontal = true;
	    emptySea.placeShipAt(row, column, horizontal, ocean);
		assertEquals(2, emptySea.getBowColumn());
				
				
	 // Test the bowRow for a Destroyer
				
	   Ship destroyer = new Destroyer();
	   row = 8;
	   column = 9;
	   horizontal= false;
	   destroyer.placeShipAt(row, column, horizontal, ocean);
	   destroyer.setBowColumn(column);//set the BowColumn is 9
	   assertEquals(9, destroyer.getBowColumn()); //test if  the column is equal to 9, which is what we set
	}
	
	
	
	
	
	

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		assertFalse(ship.getHit()[2]);
		
		
		//TODO
		
		//Test the emptySea
		
		ship = new EmptySea();
		hits = new boolean[1];
		assertArrayEquals(hits, ship.getHit());

		
		//Test the GetHit for Destroyer
		ship = new Destroyer();
	    hits = new boolean[2];
	    //test if they are same
		assertArrayEquals(hits, ship.getHit());		
		//test if each item in the hit Array is false
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		// test if the length of the hit Array is 2 
		assertEquals(2, ship.getHit().length);
		
		
		
		
	}
	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());
		
		//TODO
		//Test the EmptySea
		ship = new EmptySea();
		assertEquals("empty", ship.getShipType());
		
		//Test the Cruiser
		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());
		
		//Test the Destroyer
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());
		
		//Test the submarine
		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());
		
		
		
		
	}
	
	@Test
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//test the Battleship placed vertically
		Ship battleship1 = new Battleship();
		row = 9;
		column = 9;
		horizontal = false;
		//place the ship vertically
		battleship1.placeShipAt(row, column, horizontal, ocean);
		//check if the isHorizontally is false
		assertFalse(battleship1.isHorizontal());
		
		//test the Destroyer placed vertically
		Ship destroyer = new Destroyer();
		row = 2;
		column = 2;
		horizontal = false;
		//place this destroyer vertically
		destroyer.placeShipAt(row, column, horizontal, ocean);
		//the isHorizontally should be false
		assertFalse(destroyer.isHorizontal());
		
		
		
		
	}
	
	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());
		
		//TODO
		//Test EmptySea
		
		Ship empty = new EmptySea();
		row = 5;
		column = 4;
		horizontal=true;
		//set the bowRow as given row
		empty.setBowRow(row);
		//test if the bowRow for this empty is given row
		assertEquals(row, empty.getBowRow());
		
		//test a new submarine with given bowRow
		Ship submarine = new Submarine();
		row = 2;
		column = 4;
		horizontal=true;
		//set the bowRow as given row
		submarine.setBowRow(row);
		//test if the bowRow for this empty is given row
		assertEquals(row, submarine.getBowRow());
		

		
	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());
		
		//TODO
		//More tests
		
        //test the empty sea
		Ship empty = new EmptySea();
		row = 5;
		column = 4;
		horizontal=true;
		//set the bowRow as given column
		empty.setBowColumn(column);
		//test if the bowColumn for this empty is given column
		assertEquals(column, empty.getBowColumn());
		
		
		//test a new submarine with given bowRow
		Ship submarine = new Submarine();
		row = 2;
		column = 4;
		horizontal=true;
		//set the bowRow as given column
		submarine.setBowColumn(column);
		//test if the bowColumn for this empty is given column
		assertEquals(column, submarine.getBowColumn());
		
		
		
		
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		
		//test a battleship and place vertically
		
		Ship battleship1 = new Battleship();
		row = 8;
		column = 4;
		//set the horizontal is false, which mean place vertically
		horizontal = false;
		battleship1.setHorizontal(horizontal);
		//test if the horizontal for this ship is false
		assertFalse(battleship1.isHorizontal());
		
		
		//test a battleship and place vertically
		
		Ship cruiser = new Cruiser();
		row = 7;
		column = 6;
		//set the horizontal is false, which mean place vertically
		cruiser.setHorizontal(false);
		//test if the horizontal for this ship is false
		assertFalse(cruiser.isHorizontal());
		
		
		
	}

	@Test
	void testOkToPlaceShipAt() {
		
		//test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");
		
		//TODO
		//More tests
		
		//test when other ships are not in the ocean
		//test when the battle ship place horizontally in the column 2, which should be not ok.
		Ship battleship1 = new Battleship();
	    row = 0;
		column = 2;
		horizontal = true;
		ok = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		//which should be false, we can not place a battle ship horizontally in the column 2
		assertFalse(ok, "OK to place ship here.");
				
		
		
		//test when other ships are not in the ocean
		//test when the battle ship place horizontally in the column 2, which should be not ok.
		Ship battleship2 = new Battleship();
	    row = 2;
		column = 2;
		horizontal = false;//place vertically
		ok = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		//which should be false, we can not place a battle ship vertically in the row 2
		assertFalse(ok, "OK to place ship here.");
		
		
		
		
		
	}
	
	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {
		
		//test when other ships are in the ocean
		
		//place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		//test second ship, in the same place
		Battleship battleship2 = new Battleship();
		row = 0;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");
		battleship2.placeShipAt(row, column, horizontal, ocean);
		
		//test third ship, should be ok 
	    Battleship battleship3 = new Battleship();
		row = 9;
		column = 9;
		horizontal = true;
		boolean ok3 = battleship3.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok3, "OK to place ship here.");
		battleship3.placeShipAt(row, column, horizontal, ocean);
		
		
		//test cruiser next to the battleShip, which has already placed in the ocean
	    Cruiser cruiser1 = new Cruiser();
		row = 9;
		column = 8;
		horizontal = true;
		boolean ok4 = cruiser1.okToPlaceShipAt(row, column, horizontal, ocean);
		//should be false, we can't place the cruiser next to the battleship 
		assertFalse(ok4, "OK to place ship here.");
		cruiser1.placeShipAt(row, column, horizontal, ocean);
		
		//test the cruiser, if we can place a ship at the diagonal adjacent with the battleShip  placed at (0,4)
	    Cruiser cruiser2 = new Cruiser();  
		row = 1;
		column = 5;
		horizontal = true;
		boolean ok5 = cruiser2.okToPlaceShipAt(row, column, horizontal, ocean);
		//should be false to place diagonal adjacent.
		assertFalse(ok5, "OK to place ship here.");
		cruiser2.placeShipAt(row, column, horizontal, ocean);
		
	
		
		
	}

	@Test
	void testPlaceShipAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);
		

		//TODO
		//More tests
		
		//place a cruiser placed vertically
		Ship cruiser = new Cruiser();
		row = 6;
		column = 4;
		horizontal = false;//place vertically
		cruiser.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, cruiser.getBowRow());
		assertEquals(column, cruiser.getBowColumn());
		assertFalse(cruiser.isHorizontal());//should be false when place vertically
        //test the empty ship
		assertEquals("empty", ocean.getShipArray()[4][5].getShipType());
		//test if the vertical cell is also cruiser, the two cell should be equal
		assertEquals(cruiser, ocean.getShipArray()[5][4]);
		
		
		
		//place a cruiser placed vertically
		Ship destroyer = new Cruiser();
		row = 3;
		column = 4;
		horizontal = false;//place vertically
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
		assertEquals(column, destroyer.getBowColumn());
		assertFalse(destroyer.isHorizontal());//should be false when place vertically
		//test the empty ship
		assertEquals("empty", ocean.getShipArray()[3][5].getShipType());
	    //test if the vertical cell is also cruiser
		assertEquals(destroyer, ocean.getShipArray()[2][4]);
				

		
		
	}

	@Test
	void testShootAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = {false, false, false, false};
		assertArrayEquals(hitArray0, battleship.getHit());
		
		//TODO
		//More tests
		
		Ship cruiser = new Cruiser();
		row = 5;
		column = 5;
		horizontal = true;
		//place a cruiser at this location
		cruiser.placeShipAt(row, column, horizontal, ocean);
		// should be true when we shoot the location of the bow of the cruise
		assertTrue(cruiser.shootAt(5, 5));
		//the bow should be true, the hit[0]should be true
		assertEquals(true, cruiser.getHit()[0]);
		
		
		Ship destroyer = new Cruiser();
		row = 8;
		column = 8;
		horizontal = false;//place vertically
		//place a cruiser at this location
		destroyer.placeShipAt(row, column, horizontal, ocean);
		// should be true when we shoot the body the cruise
		assertTrue(destroyer.shootAt(7, 8));
		//the body should be true, the hit[1]should be true
		assertEquals(true, destroyer.getHit()[1]);
		
	
		
		
		
		
		
	}
	
	@Test
	void testIsSunk() {
		
		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());
		
		//TODO
		
		
		//test shooting the destroyer and sunk 
		Ship destroyer= new Submarine();
		row = 9;
		column = 9;
		horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(destroyer.isSunk());
		//shoot the bow and the body of the destroy
		destroyer.shootAt(9, 9);
		destroyer.shootAt(8, 9);
		//the destroyer should be sunk
		assertTrue(destroyer.isSunk());
		
		
		
		//test shooting the destroyer and sunk 
		Ship battleship= new Battleship();
		row = 5;
		column = 6;
		horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		//not sunk		
		assertFalse(battleship.isSunk());
		//only shoot the body of the battleship
		battleship.shootAt(5, 5);
		battleship.shootAt(5, 4);
		//the destroyer should not be sunk
		assertFalse(battleship.isSunk());
				
		
		
		
		
		
		
		
		
	}

	@Test
	void testToString() {
		
		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());
		
		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());
		
		//TODO
		//More tests
		
		//place a destroyer on the location
		Ship destroyer = new Destroyer();
		assertEquals("x", destroyer.toString());
		
		row = 5;
		column = 5;
		horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		//shoot the body and bow for this destroyer
		destroyer.shootAt(5, 5);
		destroyer.shootAt(4, 5);
		//should be s when this ship is sunk
		assertEquals("s", destroyer.toString());
		
		
		
		//place a destroyer on the location
		Ship cruiser = new Cruiser();
		assertEquals("x", cruiser.toString());
				
		row = 3;
		column = 3;
		horizontal = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
				
		//only shoot the body 
		cruiser.shootAt(2, 3);
		cruiser.shootAt(1, 3);
		//should be s when this ship is sunk
		assertEquals("x", cruiser.toString());
		

		
		
	}

}
