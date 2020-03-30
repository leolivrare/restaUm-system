package application;

import oneLeftLayer.OneLeftMatch;
import oneLeftLayer.OneLeftPosition;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();
		
		
		UI.printBoard(match.getPieces(), match.getBoard());
		
		match.performMove(new OneLeftPosition('d', 2), new OneLeftPosition('d', 4));
		UI.printBoard(match.getPieces(), match.getBoard());
	}

}
