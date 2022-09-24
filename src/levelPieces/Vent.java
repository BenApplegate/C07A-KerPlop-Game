package levelPieces;

import gameEngine.Drawable;

public class Vent implements Drawable {
	
	@Override
	public String toString() {
		return "V - Vent (it's just a vent, it does nothing)";
	}

	@Override
	public void draw() {
		System.out.print("v");
	}

}
