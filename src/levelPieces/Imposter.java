package levelPieces;

import gameEngine.Drawable;

import java.util.Random;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Imposter extends GamePiece implements Moveable{
	
	@Override
	public String toString() {
		return "I - Imposter (moves around and tries kill to you, don't them in arms length, just try to beat him he's pretty S U S)";
	}

	public Imposter(int location) {
		super('I', "Imposter", location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		//If the player is on or next to the imposter, kill the player
		if(playerLocation == getLocation() || playerLocation == getLocation()-1 || playerLocation == getLocation() + 1) {
			return InteractionResult.KILL;
		}
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		//The imposter moves randomly, so we will loop until we find an open slot
		while(true) {
			int newLocation = new Random().nextInt(gameBoard.length);
			if(gameBoard[newLocation] == null && newLocation != playerLocation) {
				
				//If we selected an empty location, move ourselves to that location and end loop
				gameBoard[getLocation()] = null;
				gameBoard[newLocation] = this;
				setLocation(newLocation);
				break;
			}
		}
	}

}
