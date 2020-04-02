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
	}
}
