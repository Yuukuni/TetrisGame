package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class TetrisGame {
	
	private long score;
	
	public enum Blocks { Blue, Cyan, Green, Orange, Purple, Red, Yellow, Wall, None };
	private Blocks[][] board;
	
	private ArrayList<Integer> currentBlocks = new ArrayList<Integer>();
	private ArrayList<Integer> nextBlocks = new ArrayList<Integer>();
	
	private Point currentBlockPosition;
	private int currentBlockKind;
	private int currentBlockRotation;
	
	public static final int WIDTH_BLOCKS = 12;
	public static final int HEIGHT_BLOCKS = 21;
	
	private static final int START_POSITION_X = 5;
	private static final int START_POSITION_Y = 0;
	private static final int START_ROTATION = 0;
	
	private static final Point[][][] TetrisBlocks = {
			// I-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O-Piece
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S-Piece
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-Piece
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-Piece
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};
	
	private static Blocks Blocks(int kind) {
		
		switch(kind) {
			case 0: return Blocks.Blue;
			case 1: return Blocks.Cyan;
			case 2: return Blocks.Green;
			case 3: return Blocks.Orange;
			case 4: return Blocks.Purple;
			case 5: return Blocks.Red;
			case 6: return Blocks.Yellow;
			case 7: return Blocks.Wall;
			case 8: return Blocks.None;
			default: return null;
		}
		
	}
	
	public long score() { 
		
		return score;
		
	}
	
	public int[][] intBoard() {
		
		int[][] intBoard = new int[WIDTH_BLOCKS][HEIGHT_BLOCKS];
		for(int i = 0; i < WIDTH_BLOCKS; ++i) {
			for(int j = 0; j < HEIGHT_BLOCKS; ++j) {
				intBoard[i][j] = board[i][j].ordinal();
			}	
		}
		return intBoard;
		
	}
	
	public ArrayList<Integer> currentBlocks() {
		
		return currentBlocks;
	
	}
	
	public ArrayList<Integer> nextBlocks() {
		
		return nextBlocks;
		
	}
	
	public Point currentBlockPosition() {
		
		return currentBlockPosition;
		
	}
	
	public int currentBlockKind() {
		
		return currentBlockKind;
		
	}
	
	public int currentBlockRotation() {
		
		return currentBlockRotation;
		
	}
	
	public Point[][][] TetrisBlocks() {
		
		return TetrisBlocks;
		
	}
	
	public TetrisGame() {
		
		initGame();
		
	}
	
	private void initGame() {
	
		score = 0;
		board = new Blocks[WIDTH_BLOCKS][HEIGHT_BLOCKS];
		for (int i = 0; i < WIDTH_BLOCKS; ++i) {
			for (int j = 0; j < HEIGHT_BLOCKS; ++j) {
				if (i == 0 || i == (WIDTH_BLOCKS - 1) || j == (HEIGHT_BLOCKS - 1)) {
					board[i][j] = Blocks.Wall;
				} else {
					board[i][j] = Blocks.None;
				}
			}
		}
		Collections.addAll(currentBlocks, 0, 1, 2, 3, 4, 5, 6);
		Collections.shuffle(currentBlocks);
		Collections.addAll(nextBlocks, 0, 1, 2, 3, 4, 5, 6);
		Collections.shuffle(nextBlocks);
		newBlock();
	
	}
	
	private void newBlock() {
		
		currentBlockPosition = new Point(START_POSITION_X, START_POSITION_Y);
		currentBlockKind = currentBlocks.get(0);
		currentBlockRotation = START_ROTATION;
		
		if (nextBlocks.isEmpty()) {
			Collections.addAll(nextBlocks, 0, 1, 2, 3, 4, 5, 6);
			Collections.shuffle(nextBlocks);
		}
		
		int nextFirstBlock = nextBlocks.get(0);
		
		for(int i = 0; i < 6; ++i) {
			currentBlocks.set(i, currentBlocks.get(i+1));
			if(i < (nextBlocks.size() - 1)) {
				nextBlocks.set(i, nextBlocks.get(i+1));
			}
		}
		currentBlocks.set(6, nextFirstBlock);
		nextBlocks.remove(nextBlocks.size() - 1);
		
	}
	
	private boolean collidesAt(int x, int y, int rotation) {
		
		for (Point p : TetrisBlocks[currentBlockKind][rotation]) {
			if (board[p.x + x][p.y + y] != Blocks.None) {
				return true;
			}
		}
		return false;
		
	}
	
	public void rotate() {
		
		int newRotation = (currentBlockRotation + 1) % 4;
		if (!collidesAt(currentBlockPosition.x, currentBlockPosition.y, newRotation)) {
			currentBlockRotation = newRotation;
		}

	}
	
	public void move(int i) {
		
		if (!collidesAt(currentBlockPosition.x + i, currentBlockPosition.y, currentBlockRotation)) {
			currentBlockPosition.x += i;	
		}
		
	}
	
	public void drop() {
		
		if (!collidesAt(currentBlockPosition.x, currentBlockPosition.y + 1, currentBlockRotation)) {
			currentBlockPosition.y++;
		} else {
			updateBoard();
		}	

	}
	
	private void updateBoard() {
		
		for (Point p : TetrisBlocks[currentBlockKind][currentBlockRotation]) {
			board[currentBlockPosition.x + p.x][currentBlockPosition.y + p.y] = Blocks(currentBlockKind);
		}
		clearLines();
		newBlock();
		
	}
	
	private void clearLines() {
		
		boolean needClear;
		int clearLines = 0;
		for (int j = HEIGHT_BLOCKS - 2; j > 0; j--) {
			needClear = true;
			for (int i = 1; i < (WIDTH_BLOCKS - 1); i++) {
				if (board[i][j] == Blocks.None) {
					needClear = false;
					break;
				}
			}
			if (needClear) {
				deleteRow(j++);
				clearLines++;
			}
		}
		
		switch (clearLines) {
		case 1:
			score += 100;
			break;
		case 2:
			score += 300;
			break;
		case 3:
			score += 500;
			break;
		case 4:
			score += 800;
			break;
		}
		
	}
		
	private void deleteRow(int row) {
	
		for (int j = row; j > 0; j--) {
			for (int i = 1; i < (WIDTH_BLOCKS - 1); ++i) {
				board[i][j] = board[i][j - 1];
			}
		}
		for(int i = 1; i < (WIDTH_BLOCKS - 1); ++i)
			board[i][0] = Blocks.None;
		
	}
	
}