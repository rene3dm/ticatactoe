package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Piece;
import tictactoe.TictactoeMatch;
import tictactoe.TictactoePosition;

public class UI {
		
		// https://stackoverflow.com/questions/2979383/java-clear-the-console
		public static void clearScreen() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}	
		
		public static void printMatch(TictactoeMatch tictactoeMatch) { 
			printBoard(tictactoeMatch.getPieces());
			System.out.println("Player turn: " + tictactoeMatch.getCurrentPlayer());
			System.out.print("Enter moviment: ");
		}
		
		public static TictactoePosition readMove(Scanner sc) {
			try {
			String move = sc.nextLine();
			char column = move.charAt(0);
			int row = Integer.parseInt(move.substring(1));
			return new TictactoePosition(column,row);
			}
			catch (RuntimeException e) {
				throw new InputMismatchException("Invalid moviment. Valid moves are from a1 to c3.");
			}
		}
		
		private static void printBoard(Piece[][] pieces) {
			for(int i=0;i<3;i++) {
				System.out.print(3-i + " ");
				for(int j=0;j<3;j++) {
					printPiece(i, j,pieces);
				}
				System.out.println();
			}
			System.out.println("  a b c");
		}
		
		private static void printPiece(int row, int column,Piece[][] pieces) {
			if (pieces[row][column] == null) {
				System.out.print("-");
			}
			else {
				System.out.print(pieces[row][column]);
			}
				
			System.out.print(" ");
		}
}
