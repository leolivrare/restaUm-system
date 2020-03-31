package oneLeftLayer;

import boardLayer.Board;
import boardLayer.Piece;
import boardLayer.Position;


public class OneLeftMatch {
	private Board board;
	private int numPieces;

	public OneLeftMatch() {
		this.board = new Board(7, 7);
		numPieces = 32;
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
	
	public boolean validateSourcePosition(Position position) {
		if (!board.positionExists(position)) {
			System.out.println("Essa posição não existe!");
			return false;
		}
		if (!board.thereIsAPiece(position)) {
			System.out.println("Nao há nenhuma peça na posicao inicial!");
			return false;
		}
		if (!(board.piece(position).isThereAnyPossibleMove())) {
			System.out.println("Não há nenhum movimento possível para essa peça!");
			return false;
		}
		return true;
	}
	
	private boolean validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			System.out.println("A peça escolhida não pode se mover na posição de destino!");
			return false;
		}
		return true;
	}
	
	public void performMove(OneLeftPosition sourcePosition, OneLeftPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		System.out.println("Source: "+sourcePosition);
		System.out.println("Target: "+targetPosition);
		if (validateSourcePosition(source) && validateTargetPosition(source, target)) {
			makeMove(source, target);
		}
	}
	
	public boolean gameSituation() {
		if (numPieces == 1) {
			System.out.println("Voce venceu!");
			return true;
		}
		return false;
	}
	
	public void attNumPieces() {
		numPieces--;
	}
	
	private void makeMove(Position source, Position target) {
		int columnTargetPiece, rowTargetPiece;
		//Movimento Horizontal
		if (source.getRow()-target.getRow() == 0) {
			if (source.getColumn() < target.getColumn()) {
				columnTargetPiece = source.getColumn()+1;
			}
			else {
				columnTargetPiece = source.getColumn()-1;
			}
			Piece p = board.removePiece(source);
			Piece capturedPiece = board.removePiece(new Position(source.getRow(), columnTargetPiece));
			board.placePiece(p, target);
		}
		//Movimento Vertical
		else {
			if (source.getRow() < target.getRow()) {
				rowTargetPiece = source.getRow()+1;
			}
			else {
				rowTargetPiece = source.getRow()-1;
			}
			Piece p = board.removePiece(source);
			Piece capturedPiece = board.removePiece(new Position(rowTargetPiece, source.getColumn()));
			board.placePiece(p, target);
			
		}
		attNumPieces();
	}
}
