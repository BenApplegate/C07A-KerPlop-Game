package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Task extends GamePiece {
	

	public Task(int location) {
		super('T', "Task", location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//If the player is on the task, the complete the task and get a point
				if (playerLocation == getLocation()) {
					
					gameBoard[getLocation()] = null; //Remove the piece from the board, so it can't be recollected
					setLocation(-1);
					
					return InteractionResult.GET_POINT;
				}
				
		return null;
	}

	

}
