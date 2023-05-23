package battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {

	Ocean ocean;
	
	static int NUM_BATTLESHIPS = 1;
	static int NUM_CRUISERS = 2;
	static int NUM_DESTROYERS = 3;
	static int NUM_SUBMARINES = 4;
	static int OCEAN_SIZE = 10;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}
	
	@Test
	void testEmptyOcean() {
		
		//tests that all locations in the ocean are "empty"
		
		Ship[][] ships = ocean.getShipArray();
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				
				assertEquals("empty", ship.getShipType());
			}
		}
		
		assertEquals(0, ships[0][0].getBowRow());
		assertEquals(0, ships[0][0].getBowColumn());
		
		assertEquals(5, ships[5][5].getBowRow());
		assertEquals(5, ships[5][5].getBowColumn());
		
		assertEquals(9, ships[9][0].getBowRow());
		assertEquals(0, ships[9][0].getBowColumn());
	}
	
	@Test
	void testPlaceAllShipsRandomly() {
		
		//tests that the correct number of each ship type is placed in the ocean
		
		ocean.placeAllShipsRandomly();

		Ship[][] ships = ocean.getShipArray();
		ArrayList<Ship> shipsFound = new ArrayList<Ship>();
		
		int numBattlehips = 0;
		int numCruisers = 0;
		int numDestroyers = 0;
		int numSubmarines = 0;
		int numEmptySeas = 0;
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				if (!shipsFound.contains(ship)) {
					shipsFound.add(ship);
				}
			}
		}
		
		for (Ship ship : shipsFound) {
			if ("battleship".equals(ship.getShipType())) {		
				numBattlehips++;
			} else if ("cruiser".equals(ship.getShipType())) {
				numCruisers++;
			} else if ("destroyer".equals(ship.getShipType())) {
				numDestroyers++;
			} else if ("submarine".equals(ship.getShipType())) {
				numSubmarines++;
			} else if ("empty".equals(ship.getShipType())) {
				numEmptySeas++;
			}
		}
		
		assertEquals(NUM_BATTLESHIPS, numBattlehips);
		assertEquals(NUM_CRUISERS, numCruisers);
		assertEquals(NUM_DESTROYERS, numDestroyers);
		assertEquals(NUM_SUBMARINES, numSubmarines);
		
		//calculate total number of available spaces and occupied spaces
		int totalSpaces = OCEAN_SIZE * OCEAN_SIZE; 
		int occupiedSpaces = (NUM_BATTLESHIPS * 4)
				+ (NUM_CRUISERS * 3)
				+ (NUM_DESTROYERS * 2)
				+ (NUM_SUBMARINES * 1);
		
		//test number of empty seas, each with length of 1
		assertEquals(totalSpaces - occupiedSpaces, numEmptySeas);
	}

	@Test
	void testIsOccupied() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.isOccupied(1, 5));
		
		//TODO
		
		Ship submarine2 = new Submarine();
		row = 9;
		column = 9;
		horizontal = false;
		submarine2.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.isOccupied(9, 9));
		
		Ship battleship = new Battleship();
		row = 9;
		column = 4;
		horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(ocean.isOccupied(9, 5));
	}

	@Test
	void testShootAt() {
	
		assertFalse(ocean.shootAt(0, 1));
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		//assertTrue(ocean.shootAt(0, 5));
		
		//TODO
		//testing an afloat battleship 
		Ship battleship = new Battleship();
		row = 9;
		column = 9;
		horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(battleship.isSunk());
		assertTrue(ocean.shootAt(9, 8));
		assertFalse(battleship.isSunk());
		assertTrue(ocean.shootAt(9, 7));
		assertFalse(battleship.isSunk());
		
		//testing a sunk submarine
		
		Ship submarine = new Submarine();
		row = 5;
		column = 5;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(5, 5));
		assertTrue(submarine.isSunk());
		assertFalse(ocean.shootAt(5, 5));
		
		
	}

	@Test
	void testGetShotsFired() {
		
		//should be all false - no ships added yet
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 0));
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(9, 9));
		assertEquals(4, ocean.getShotsFired());
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(6, ocean.getShotsFired());
		
		//TODO
		//testing shooting at one ship until sunk 
		assertTrue(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		assertFalse(ocean.shootAt(0, 0));
		assertEquals(8, ocean.getShotsFired());
		
		//testing another destroyer
		
		Cruiser cruiser = new Cruiser();
		row = 9;
		column = 9;
		horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(cruiser.isSunk());
		assertTrue(ocean.shootAt(9, 8));
		assertFalse(cruiser.isSunk());
		assertTrue(ocean.shootAt(9, 7));
		assertTrue(cruiser.isSunk());
		assertEquals(11, ocean.getShotsFired());
		
		
		
	}

	@Test
	void testGetHitCount() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		
		//TODO
		
		//testing on an afloat cruiser, hitting repeatedly on same spot
		Cruiser cruiser = new Cruiser();
		row = 9;
		column = 9;
		horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(cruiser.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(cruiser.isSunk());
		assertEquals(3, ocean.getHitCount());
		
		//testing on a sunk submarine, repeately hitting after ship sunk
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		assertEquals(4, ocean.getHitCount());
		
		assertFalse(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		assertEquals(4, ocean.getHitCount());
		
	}
	
	@Test
	void testGetShipsSunk() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
		
		//TODO
		
		//scenario2: testing on a submarine
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
		
		//scenario 3: testing on another destroyer
		Destroyer destroyer1 = new Destroyer();
		row = 9;
		column = 9;
		horizontal = true;
		destroyer1.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(destroyer1.isSunk());
		assertEquals(3, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
		assertTrue(ocean.shootAt(9, 8));
		assertTrue(destroyer1.isSunk());
		assertEquals(4, ocean.getHitCount());
		assertEquals(2, ocean.getShipsSunk());
		
		//scenario 4: testing on previous destroyer
		
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(5, ocean.getHitCount());
		assertEquals(3, ocean.getShipsSunk());
		
	
	}

	@Test
	void testGetShipArray() {
		
		Ship[][] shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);
		
		assertEquals("empty", shipArray[0][0].getShipType());
		
		//TODO
		
		//place a destroyer 
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);
		
		assertEquals("destroyer", shipArray[0][5].getShipType());
		
		
		//place a submarine 
		assertEquals("empty", shipArray[9][9].getShipType());
		
		Ship submarine = new Submarine();
		row = 9;
		column = 9;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertEquals("submarine", shipArray[9][9].getShipType());
	}

}