package tictactoe;

import boardgame.Position;

public class TictactoePosition {
	private int row;
	private char column;
	
	public TictactoePosition(char column, int row) {
		this.row = row;
		this.column = column;
	}
	
	public Position toPosition() {
		return new Position(3-row,column - 'a');
	}
}
