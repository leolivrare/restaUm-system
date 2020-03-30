package oneLeftLayer;

import boardLayer.Board;
import boardLayer.Piece;
import boardLayer.Position;

public class OneLeftMatch {
	private Board board;

	public OneLeftMatch() {
		this.board = new Board(7, 7);
		initialSetup();
	}
	
	private void initialSetup() {
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				if (board.positionExists(i, j)) {
					board.placePiece(new Piece(board), new Position(i, j));
				}
			}
		}
		board.removePiece(new Position(3, 3));
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Piece[][] getPieces() {
		Piece[][] mat = new Piece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = board.piece(i, j);
			}
		}
		return mat;
	}
}
