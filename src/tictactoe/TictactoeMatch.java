package tictactoe;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class TictactoeMatch {
	private Board board;
	private String currentPlayer;
	private boolean match;
	private boolean draw;
	public TictactoeMatch() {
		board = new Board();
		currentPlayer = "X";
		match = true;
		draw = false;
	}

	public boolean getMatch() {
		return match;
	}

	public Board getBoard() {
		return board;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	private void positionExists(Position position) {
		if (position.getRow() >= 0 && position.getRow() < 3 && position.getColumn() >= 0 && position.getColumn() < 3) {

		} else {
			throw new TictactoeException("Invalide position. Valid values are from a1 to c3.");
		}

	}

	public boolean getDraw() {
		return draw;
	}
	
	public void moviment(Position position) {
		positionExists(position);
		validatePosition(position);
		if (currentPlayer == "X") {
			board.addPiece(position.getRow(), position.getColumn(), new PieceX());
			currentPlayer = "O";
		} else {
			board.addPiece(position.getRow(), position.getColumn(), new PieceO());
			currentPlayer = "X";
		}
		if(thereIsAWinner()) {
			match = false;
		}
		else if(endGame()) {
			match = false;
			draw = true;
		}
		
	}
	
	private boolean endGame() {
		Piece[][] pieces = getPieces();
		boolean isNull = false;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(pieces[i][j] == null) {
					isNull = true;
				}
			}
		}
		return !isNull;
	}
	
	private void validatePosition(Position position) {
		Piece[][] pieces = getPieces();
		if (pieces[position.getRow()][position.getColumn()] == null) {

		} else {
			throw new TictactoeException("Invalide position. There is piece in this position.");
		}

	}

	private boolean thereIsAWinner() {
		boolean winner = false;
		Piece[][] pieces = getPieces();
		String line;
		String column;
		String diagonal1;
		String diagonal2;
		diagonal1 = "";
		diagonal2 = "";
		for (int i = 0; i < 3; i++) {
			line = "";
			column = "";

			for (int j = 0; j < 3; j++) {
				line += pieces[i][j];
				column += pieces[j][i];
				if (i == j) {
					diagonal1 += pieces[j][i];
				}
				if (i + j == 2) {
					diagonal2 += pieces[j][i];
				}
			}

			if (line.equals("XXX") || line.equals("OOO") || column.equals("XXX") || column.equals("OOO")) {
				winner = true;
				currentPlayer = currentPlayer == "X" ? "O" : "X";
			}

		}

		if (diagonal1.equals("XXX") || diagonal1.equals("OOO") || diagonal2.equals("XXX") || diagonal2.equals("OOO")) {
			winner = true;
			currentPlayer = currentPlayer == "X" ? "O" : "X";
		}
		return winner;
	}

	public Piece[][] getPieces() {
		Piece[][] pieces = new Piece[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pieces[i][j] = board.piece(i, j);
			}
		}
		return pieces;
	}
}
