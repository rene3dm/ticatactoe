package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import tictactoe.TictactoeException;
import tictactoe.TictactoeMatch;
import tictactoe.TictactoePosition;

public class Program {

	public static void main(String[] args) {
		//System.out.println("Hello tic tac toe game!!!");
		TictactoeMatch tictactoeMatch = new TictactoeMatch();
		Scanner sc = new Scanner(System.in);
		
		while(tictactoeMatch.getMatch()) {
			try {
			
			UI.clearScreen();
			UI.printMatch(tictactoeMatch);
			TictactoePosition tposition = UI.readMove(sc);
			tictactoeMatch.moviment(tposition.toPosition());
			}
			catch (TictactoeException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(tictactoeMatch);
		System.out.println();
		if (tictactoeMatch.getDraw()) {
			System.out.println("Draw game!!!!!");
		}else {
		System.out.println("Congratulations   " + tictactoeMatch.getCurrentPlayer() + "  winn!!");
		}
		sc.close();
	}

}
