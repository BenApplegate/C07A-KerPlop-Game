package levelPieces;

import gameEngine.Drawable;
import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Crewmate extends GamePiece implements Moveable {

	Crewmate(int location){
		super('c', "Crewmate", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Randomly selects for the piece to attempt to move left or right
		int direction = new Random().nextBoolean() ? -1 : 1;
		int newLocation = getLocation() + direction;
		
		if(newLocation < 0 || newLocation == gameBoard.length) {
			//If the piece would move off the board, don't move
			return;
		}

		if(gameBoard[newLocation] == null) {
			gameBoard[getLocation()] = null;
			gameBoard[newLocation] = this;
		}
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//The crewmate does not interact with the player
		return InteractionResult.NONE;
	}

}