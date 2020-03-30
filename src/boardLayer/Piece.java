package boardLayer;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.position = null;
		this.board = board;
	}
	
	protected Board getBoard() {
		return board;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean[][] possibleMoves() {
		boolean[][] possibleMoves = new boolean[board.getRows()][board.getColumns()];
		Position posAux = new Position(0, 0);
		Position posAux2 = new Position(0, 0);
		
		posAux.setValues(position.getRow()+2, position.getColumn());
		posAux2.setValues(position.getRow()+1, position.getColumn());
		if (board.positionExists(posAux) && !board.thereIsAPiece(posAux) && board.thereIsAPiece(posAux2)) {
			possibleMoves[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow()-2, position.getColumn());
		posAux2.setValues(position.getRow()-1, position.getColumn());
		if (board.positionExists(posAux) && !board.thereIsAPiece(posAux) && board.thereIsAPiece(posAux2)) {
			possibleMoves[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow(), position.getColumn()+2);
		posAux2.setValues(position.getRow(), position.getColumn()+1);
		if (board.positionExists(posAux) && !board.thereIsAPiece(posAux) && board.thereIsAPiece(posAux2)) {
			possibleMoves[posAux.getRow()][posAux.getColumn()] = true;
		}
		
		posAux.setValues(position.getRow(), position.getColumn()-2);
		posAux2.setValues(position.getRow(), position.getColumn()-1);
		if (board.positionExists(posAux) && !board.thereIsAPiece(posAux) && board.thereIsAPiece(posAux2)) {
			possibleMoves[posAux.getRow()][posAux.getColumn()] = true;
		}
		return possibleMoves;
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] possibleMoves = possibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			for (int j = 0; j < possibleMoves.length; j++) {
				if (possibleMoves[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
