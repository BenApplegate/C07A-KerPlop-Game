package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.*;

public class TestInteractions {
	
	
	/*
     * Test that Crewmate location is the same as the player location and should return NONE
    */
	@Test
	public void testCrewmate() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Crewmate crewmate = new Crewmate(18);
		gameBoard[18] = crewmate;
		// does nothing if player is on the same space
		assertEquals(InteractionResult.NONE, crewmate.interact(gameBoard, 18));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<18; i++) {
			assertEquals(InteractionResult.NONE, crewmate.interact(gameBoard, i));}
		for (int i=19; i<GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, crewmate.interact(gameBoard, i)); }
		
	}
	
	
	/*
     * Test that DeadBody location is the same as the player location and should return HIT
    */
	@Test
	public void testDeadBody() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		DeadBody deadBody = new DeadBody(8);
		gameBoard[8] = deadBody;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, deadBody.interact(gameBoard, 8));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<8; i++) {
			assertEquals(InteractionResult.NONE, deadBody.interact(gameBoard, i));}
		for (int i=9; i<GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, deadBody.interact(gameBoard, i));}
		
	}
	
	
	/*
     * Test that Evidence location is the same as the player location and should return ADVANCE
    */
	@Test
	public void testEvidence() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Evidence evidence = new Evidence(5);
		gameBoard[5] = evidence;
		// Advance to next level if player is on same space
		assertEquals(InteractionResult.ADVANCE, evidence.interact(gameBoard, 5));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<5; i++) {
			assertEquals(InteractionResult.NONE, evidence.interact(gameBoard, i));}
		for (int i=6; i<GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, evidence.interact(gameBoard, i));}
		
	}

	/*
     * Test that Imposter location is the same as the player location or player location is +1 or -1 away and should return KILL
    */
	@Test
	public void testImposter() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Imposter imposter = new Imposter(7);
		gameBoard[1] = imposter;
		// kills the player if they on the same space or one space over
		assertEquals(InteractionResult.KILL, imposter.interact(gameBoard, 7));
		assertEquals(InteractionResult.KILL, imposter.interact(gameBoard, 7+1));
		assertEquals(InteractionResult.KILL, imposter.interact(gameBoard, 7-1));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<6; i++) {
			assertEquals(InteractionResult.NONE, imposter.interact(gameBoard, i));}
		for (int i=9; i<GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, imposter.interact(gameBoard, i));}
		
	}
	
	
	/*
     * Test that Evidence location is the same as the player location and should return GET_POINT
    */
	@Test
	public void testTask() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Task task = new Task(16);
		gameBoard[16] = task;
		// will get a point if player is on same space
		assertEquals(InteractionResult.GET_POINT, task.interact(gameBoard, 16));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<16; i++) {
			assertEquals(InteractionResult.NONE, task.interact(gameBoard, i));}
		for (int i=17; i<GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, task.interact(gameBoard, i));}
		
	}
}
