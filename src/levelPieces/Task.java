package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Task extends GamePiece {
	

	public Task(char symbol, String label, int location) {
		super('T', "Task", location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//If the player is on the task, the complete the task and get a point
				if (playerLocation == getLocation()) {
					return InteractionResult.GET_POINT;
				}
				
		return null;
	}

	

}
