package application;

import oneLeftLayer.OneLeftMatch;
import oneLeftLayer.OneLeftPosition;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();	
		
		match.performMove(new OneLeftPosition('c', 4), new OneLeftPosition('e', 4));
		UI.printBoard(match.getPieces(), match.getBoard());

		match.performMove(new OneLeftPosition('c', 2), new OneLeftPosition('c', 4));
		UI.printBoard(match.getPieces(), match.getBoard());		

		match.performMove(new OneLeftPosition('d', 6), new OneLeftPosition('d', 4));
		UI.printBoard(match.getPieces(), match.getBoard());	

		match.performMove(new OneLeftPosition('f', 5), new OneLeftPosition('d', 5));
		UI.printBoard(match.getPieces(), match.getBoard());		

		match.performMove(new OneLeftPosition('c', 5), new OneLeftPosition('e', 5));
		UI.printBoard(match.getPieces(), match.getBoard());		

		match.performMove(new OneLeftPosition('d', 3), new OneLeftPosition('d', 5));
		UI.printBoard(match.getPieces(), match.getBoard());

		match.performMove(new OneLeftPosition('d', 5), new OneLeftPosition('f', 5));
		UI.printBoard(match.getPieces(), match.getBoard());		
		
	}
}
