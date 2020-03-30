package application;

import oneLeftLayer.OneLeftMatch;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();
		
		
		UI.printBoard(match.getPieces(), match.getBoard());
	}

}
