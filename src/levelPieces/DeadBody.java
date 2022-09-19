package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class DeadBody extends GamePiece {
	

	
	public DeadBody(char symbol, String label, int location) {
		super('D', "Dead body", location);
	}
	
	
	

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//If the player is on the Dead body, they seem SUS and take a hit
		if (playerLocation == getLocation()) {
			return InteractionResult.HIT;
		}
		
		
		
		return null;
	}

}
