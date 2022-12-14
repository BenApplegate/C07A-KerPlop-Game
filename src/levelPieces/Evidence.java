package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Evidence extends GamePiece implements Moveable {

	@Override
	public String toString() {
		return "E - Evidence (will point out the imposter and you'll win)";
	}

	public Evidence(int location) {
		super('E', "Evidence against the imposter", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//The evidence attempts to move one space away from the player
		int currentLocation = getLocation();
		int newLocation;
		if(currentLocation < playerLocation && currentLocation != 0) {
			//If the evidence is to the left of the player, it will attempt to move to the left
			newLocation = currentLocation -1;
		}
		else {
			//If the evidence is to the right of the player, it will attempt to move to the right
			newLocation = currentLocation + 1;
		}
		
		if(gameBoard[newLocation] == null && newLocation >= 0 && newLocation != gameBoard.length) {
			//If our target space is empty, move to that space
			
			gameBoard[currentLocation] = null;
			gameBoard[newLocation] = this;
			setLocation(newLocation);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//If the player touches the evidence, there is an instant win
		if(playerLocation == getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}

}
