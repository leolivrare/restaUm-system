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
			return null;
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {	
		if (!positionExists(position)) {
			return null;
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			return;
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public void removePiece(Position position) {
		if (!positionExists(position)) {
			return;
		}
		if (piece(position) == null) {
			return;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
	}
	
	public boolean positionExists(int row, int column) {
		if (row < 0 || column < 0) {
			return false;
		}
		if (row > 6 || column > 6) {
			return false;
		}
		if (row < 2 && column < 2) {
			return false;
		}
		if (row < 2 && column > 4) {
			return false;
		}
		if (row > 4 && column < 2) {
			return false;
		}
		if (row > 4 && column > 4) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			return true;
		}
		return piece(position) != null;
	}

}
