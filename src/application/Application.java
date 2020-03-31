package application;

import oneLeftLayer.OneLeftMatch;
import oneLeftLayer.OneLeftPosition;

public class Application {

	public static void main(String[] args) {
		
		OneLeftMatch match = new OneLeftMatch();
		
		CSVReader csv = new CSVReader();
		
		csv.setDataSource("../../../Documents/RestaUm/restaUm-system/src/db/teste.csv");
		String commands[] = csv.requestCommands();
		String comando[] = commands[0].split(":");
		
		System.out.println("Tabuleiro inicial:");
		
		
		
		UI.printBoard(match.getPieces(), match.getBoard());
		System.out.println();
		
		match.performMove(new OneLeftPosition(comando[0].charAt(0), Character.getNumericValue(comando[0].charAt(1))), new OneLeftPosition(comando[1].charAt(0), Character.getNumericValue(comando[1].charAt(1))));
		UI.printBoard(match.getPieces(), match.getBoard());
		System.out.println();
		comando = commands[1].split(":");
		match.performMove(new OneLeftPosition(comando[0].charAt(0), Character.getNumericValue(comando[0].charAt(1))), new OneLeftPosition(comando[1].charAt(0), Character.getNumericValue(comando[1].charAt(1))));
		UI.printBoard(match.getPieces(), match.getBoard());
		System.out.println();
	}
}
