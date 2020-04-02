package application;

import java.util.stream.Stream;

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

		Stream.of(commands).forEach(it -> {
			String command[] = it.split(":");

			Character sourceColumn = command[0].charAt(0);
			Character targetColumn = command[1].charAt(0);

			int sourceRow = Character.getNumericValue(command[0].charAt(1));
			int targetRow = Character.getNumericValue(command[1].charAt(1));
			
			match.performMove(new OneLeftPosition(sourceColumn, sourceRow), new OneLeftPosition(targetColumn, targetRow));
			
			UI.printBoard(match.getPieces(), match.getBoard());
			System.out.println();
		});
	}
}
