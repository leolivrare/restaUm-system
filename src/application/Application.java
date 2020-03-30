package application;

import oneLeftLayer.OneLeftMatch;
import oneLeftLayer.OneLeftPosition;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();
		
		CSVReader csv = new CSVReader();
		
		csv.setDataSource("teste.csv");
		String commands[] = csv.requestCommands();
		System.out.println(commands);
		
		
		UI.printBoard(match.getPieces(), match.getBoard());
		
		match.performMove(new OneLeftPosition('f', 4), new OneLeftPosition('d', 4));
		UI.printBoard(match.getPieces(), match.getBoard());
		match.performMove(new OneLeftPosition('c', 4), new OneLeftPosition('e', 4));
		UI.printBoard(match.getPieces(), match.getBoard());
	}

}
