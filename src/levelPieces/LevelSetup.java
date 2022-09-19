package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	
	private int currentLevel;
	private ArrayList<GamePiece> currentPieces = new ArrayList<GamePiece>(); //Stores what pieces we have on our board

	public void createLevel(int levelNum) {
		currentLevel = levelNum;
		currentPieces.clear(); // Empty our list
		if(levelNum == 1) {
			//Load our new pieces for level 1 into arraylist
			//Level 1 is very easy with only one obsticle that can damage you
			currentPieces.add(new Task(3));
			currentPieces.add(new Task(16));
			currentPieces.add(new Crewmate(18));
			currentPieces.add(new Crewmate(7));
			currentPieces.add(new DeadBody(13));
		}
		else if(levelNum == 2) {
			currentPieces.add(new Imposter(0));
			currentPieces.add(new DeadBody(8));
			currentPieces.add(new DeadBody(6));
			currentPieces.add(new Evidence(5));
			currentPieces.add(new Task(15));
			currentPieces.add(new Task(20));
			currentPieces.add(new Crewmate(17));
			currentPieces.add(new DeadBody(19));
			
		}
	}
	
	public Drawable[] getBoard() {
		Drawable[] board = new Drawable[GameEngine.BOARD_SIZE];
		
		//Load our gamePieces onto the board
		for(GamePiece piece : currentPieces) {
			board[piece.getLocation()] = piece;
		}
		
		//Next we load anything that is only drawable
		if(currentLevel == 1) {
			board[5] = new Vent();
		}
		
		return board;
	}
	
	public ArrayList<Moveable> getMovingPieces(){
		//Create a list that we will return
		ArrayList<Moveable> pieces = new ArrayList<Moveable>();
		
		//Loop through all of our pieces
		for(GamePiece piece : currentPieces) {
			
			//If the piece is an instance of Movable, add it to the list
			if(piece instanceof Moveable) {
				pieces.add((Moveable) piece);
			}
		}
		return pieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces(){
		return currentPieces;
	}
	
	public int getPlayerStartLoc() {
		return 10;
	}
}
