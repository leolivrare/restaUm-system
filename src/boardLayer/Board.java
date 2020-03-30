package boardLayer;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			System.out.println("Posicao invalida!");
			System.exit(0);
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {	
		if (!positionExists(position)) {
			System.out.println("Posicao invalida!");
			System.exit(0);
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			System.out.println("Já existe uma peça na posição" + position);
			System.exit(0);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public void removePiece(Position position) {
		if (!positionExists(position)) {
			System.out.println("Posicao invalida!");
			System.exit(0);
		}
		if (piece(position) == null) {
			return;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
	}
	
	public boolean positionExists(int row, int column) {
		return row >= 2 && row < (rows-2) && column >= 2 && column < (columns-2);
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			System.out.println("Posição inválida!");
			System.exit(0);
		}
		return piece(position) != null;
	}

}
