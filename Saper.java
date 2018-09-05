package pl.sda.java.basics;
import java.util.Random;

public class Saper {

	public static void main(String[] args) {
		boolean[][] newBoard = boardGenerator(5, 10);
		saperBoard(newBoard);
		printValues(printNumbers(newBoard));

	}
	
	
	static boolean[][] boardGenerator(int width, int height) {
		boolean [][] board = new boolean[width][height];
		int bombDensity = 4;
		int bombNumber = width * height / bombDensity;
		Random random = new Random();
		
		for (int i = 0; i < bombNumber; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			if(board[x][y]) {
				i--;
			} else {
				board[x][y] = true;
			}
			
		}
		return board;
	}
	
	static void saperBoard(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]?" X":" _");
			}
			System.out.println();
		}
		
	}
	static void printValues(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != -1) {
					System.out.print(board[i][j] + " ");
				} else {
					System.out.print("@ ");
				}
			}
			System.out.println();
		}
		
	}
	
	static int[][] printNumbers(boolean[][] board) {
		int[][] returnedBoard = new int[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {       			
			for (int j = 0; j < board[0].length; j++) {			
				if(board[i][j]) {
					returnedBoard[i][j] = -1;
				} else {
					returnedBoard[i][j] = calculateArea(board, i , j);
				}
			}
		}
		return returnedBoard;
	}

	private static int calculateArea(boolean[][] board, int i, int j) {
		int sum = 0;
		for(int x = i - 1; x <= i + 1; x++) {
			for(int y = j - 1; y <= j + 1; y++) {
				if(x > -1 && y > -1 && x < board.length && y < board[0].length) {
					if(board[x][y]) {
						sum++;
					}
				}
			}
		}
		return sum;
	}

}
