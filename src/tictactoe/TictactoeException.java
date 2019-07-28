package tictactoe;

import boardgame.BoardException;

public class TictactoeException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	public TictactoeException(String msg) {
		super(msg);
	}
}
