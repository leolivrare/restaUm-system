package application;

import oneLeftLayer.OneLeftMatch;
import oneLeftLayer.OneLeftPosition;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();	
		
		CSVReader csvReader = new CSVReader();
		csvReader.setDataSource("src/db/teste.csv");

		String[] commands = csvReader.requestCommands();

		System.out.println("Tabuleiro inicial:");
		UI.printBoard(match.getPieces(), match.getBoard());
		System.out.println();
		
		for (int i = 0; i < commands.length; i++) {
			String command[] = commands[i].split(":");

			Character sourceColumn = command[0].charAt(0);
			Character targetColumn = command[1].charAt(0);

			int sourceRow = Character.getNumericValue(command[0].charAt(1));
			int targetRow = Character.getNumericValue(command[1].charAt(1));
			
			match.performMove(new OneLeftPosition(sourceColumn, sourceRow), new OneLeftPosition(targetColumn, targetRow));
			
			UI.printBoard(match.getPieces(), match.getBoard());
			System.out.println();
		}
		
		// match.performMove(new OneLeftPosition('f', 4), new OneLeftPosition('d', 4));
		// UI.printBoard(match.getPieces(), match.getBoard());
		
		// match.performMove(new OneLeftPosition('c', 4), new OneLeftPosition('e', 4));
		// UI.printBoard(match.getPieces(), match.getBoard());

		// match.performMove(new OneLeftPosition('c', 2), new OneLeftPosition('c', 4));
		// UI.printBoard(match.getPieces(), match.getBoard());		

		// match.performMove(new OneLeftPosition('d', 6), new OneLeftPosition('d', 4));
		// UI.printBoard(match.getPieces(), match.getBoard());	

		// match.performMove(new OneLeftPosition('f', 5), new OneLeftPosition('d', 5));
		// UI.printBoard(match.getPieces(), match.getBoard());		

		// match.performMove(new OneLeftPosition('c', 5), new OneLeftPosition('e', 5));
		// UI.printBoard(match.getPieces(), match.getBoard());		

		// match.performMove(new OneLeftPosition('d', 3), new OneLeftPosition('d', 5));
		// UI.printBoard(match.getPieces(), match.getBoard());

		// match.performMove(new OneLeftPosition('d', 5), new OneLeftPosition('f', 5));
		// UI.printBoard(match.getPieces(), match.getBoard());	

		// match.performMove(new OneLeftPosition('e', 3), new OneLeftPosition('e', 5));
		// UI.printBoard(match.getPieces(), match.getBoard());	

		// match.performMove(new OneLeftPosition('b', 4), new OneLeftPosition('d', 4));
		// UI.printBoard(match.getPieces(), match.getBoard());		
	}
}
