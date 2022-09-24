package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

public class TestMovingPieces {

	/*
	 * The imposter moves randomly, so our tests need to make sure
	 * that the imposter does not move to an occupied position,
	 * and that the imposter doesn't move if there are no available spaces to move to
	 * 
	 * Test 1: If there is only one open space, the imposter either shouldnt move or will move to the open spot
	 * I will use a board smaller than the actual board in the game, but it does not matter as the imposter does
	 * not rely on GameEngine.boardLength 
	 *
	 * Test 2: The imposter has no room to move, the imposter should stay still
	 */
	@Test
	public void testImposterMovement() {
		//First test
		Imposter test1Imposter = new Imposter(3);
		//We leave two open spaces, but one of them will be the player space (Space 2)
		//The imposter should not move to the player space
		Drawable[] test1Board = {new Vent(), new Vent(), null, new Vent(), test1Imposter, new Vent(), null};
		test1Imposter.move(test1Board, 2);
		for(int i = 0; i < test1Board.length; i++) {
			//Fail if the imposter moved to a location that was previously filled
			if(test1Board[i] == test1Imposter && (i != 4 && i != 6)) {
				fail();
			}
			//Pass if the imposter moved to a correct location
			else if(test1Board[i] == test1Imposter && (i == 4 || i == 6)) {
				assert(true);
			}
		}
		
		//Second Test
		Imposter test2Imposter = new Imposter(2);
		//Our board has all spaces filled either by a vent or by the player
		Drawable[] test2Board = {new Vent(), null, test2Imposter};
		test2Imposter.move(test2Board, 1);
		
		if(test2Board[2] != test2Imposter) {
			fail();
			//Fail if the imposter isn't where it started
		}
		else {
			assert(true);
		}
		
		if(test2Board[0] == test2Imposter || test2Board[1] == test2Imposter) {
			fail();
			//Fail if the imposter is in a new location
		}
		
		
	}
	
	
	/*
	 * The crewmate randomly moves to an open space next to it.
	 * If there are no open spaces, it does not move
	 * If only one space next to it is open, it may or may not move
	 * 
	 * Test 1: The piece has both spaces next to it open, it should move
	 * Test 2: The piece has no available movement spaces, it should not move
	 * Test 3: The piece has one available movement space, it may move or may stay still
	 */
	@Test
	public void testCrewmateMovement() {

		//First Test
		Crewmate test1Crewmate = new Crewmate(1);
		Drawable[] test1Board = {null, test1Crewmate, null, null};
		test1Crewmate.move(test1Board, 3);
		if(test1Board[1] == test1Crewmate) {
			fail();
			//Fail if the crewmate did not move
		}
		if(test1Board[0] != test1Crewmate && test1Board[2] != test1Crewmate) {
			fail();
			//Fail if the crewmate is not found in either of the open slots;
		}
		
		//Second Test
		Crewmate test2Crewmate = new Crewmate(1);
		Drawable[] test2Board = {new Vent(), test2Crewmate, null};
		test2Crewmate.move(test2Board, 2);
		if(test2Board[1] != test2Crewmate) {
			fail();
			//Pass if the crewmate did not move
		}
		if(test2Board[0] == test2Crewmate || test2Board[2] == test2Crewmate) {
			fail();
			//Fail if the crewmate is found in either of the blocked slots;
		}
		
		//Third Test
		Crewmate test3Crewmate = new Crewmate(1);
		Drawable[] test3Board = {new Vent(), test3Crewmate, null, null};
		test3Crewmate.move(test3Board, 3);
		if(test3Board[0] == test3Crewmate) {
			fail();
			//Fail if the crewmate moved to the blocked space
		}
		if(test3Board[1] == test3Crewmate || test3Board[2] == test3Crewmate) {
			assert(true);
			//pass if the crewmate moved to the open spot or did not move
		}
		
	}
	
	/*
	 * The evidence will attempt to move one space in the direction away from the player
	 * It will not move if there is no open space
	 * 
	 * Test 1: The piece has both spaces next to it open, it should move
	 * Test 2: The piece has no available movement spaces, it should not move
	 * Test 3: The piece has one available movement space with the player towards the open space, it should not move
	 * Test 4: The piece has one available space with the player away from the open space, the piece should move
	 */
	@Test
	public void testEvidenceMovement() {
		//First Test
		Evidence test1Evidence = new Evidence(1);
		Drawable[] test1Board = {null, test1Evidence, null, null};
		test1Evidence.move(test1Board, 3);
		if(test1Board[1] == test1Evidence) {
			fail();
			//Fail if the evidence did not move
		}
		if(test1Board[0] != test1Evidence) {
			fail();
			//Fail if the evidence is not found in the correct spot
		}
		
		//Second Test
		Evidence test2Evidence = new Evidence(1);
		Drawable[] test2Board = {new Vent(), test2Evidence, null};
		test2Evidence.move(test2Board, 2);
		if(test2Board[1] != test2Evidence) {
			fail();
			//Pass if the evidence did not move
		}
		if(test2Board[0] == test2Evidence || test2Board[2] == test2Evidence) {
			fail();
			//Fail if the evidence is found in either of the blocked slots;
		}
		
		//Third Test
		Evidence test3Evidence = new Evidence(1);
		Drawable[] test3Board = {new Vent(), test3Evidence, null, null};
		test3Evidence.move(test3Board, 3);
		if(test3Board[0] == test3Evidence || test3Board[2] == test3Evidence) {
			fail();
			//Fail if the evidence moved to either space around it
		}
		if(test3Board[1] == test3Evidence) {
			assert(true);
			//pass if the evidence did not move
		}
		
		//Fourth Test
		Evidence test4Evidence = new Evidence(2);
		Drawable[] test4Board = {null, new Vent(), test4Evidence, null};
		test4Evidence.move(test4Board, 0);
		if(test4Board[1] == test4Evidence || test4Board[2] == test4Evidence) {
			fail();
			//Fail if the evidence moved left or did not move
		}
		if(test4Board[3] == test4Evidence) {
			assert(true);
			//pass if the evidence moved to the right
		}
			
	}
}

