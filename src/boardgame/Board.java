package boardgame;

public class Board {
	private Piece[][] pieces;
	
	public Board() {
		pieces = new Piece[3][3];
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public void addPiece(int row, int column, Piece piece) {
		pieces[row][column] = piece;
		
		
	}
}
