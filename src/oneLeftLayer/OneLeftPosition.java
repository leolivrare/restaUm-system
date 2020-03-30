package oneLeftLayer;

import boardLayer.Position;


public class OneLeftPosition{
	private char column;
	private int row;
	
	
	public OneLeftPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			System.out.println("Erro de instanciacao de posicao. Valores de coluna ou linha invalidos");
			System.exit(0);
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position((7 - row), column - 'a');
	}
	
	protected static OneLeftPosition fromPosition(Position position) {
		return new OneLeftPosition((char)('a' - position.getColumn()), 7 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
