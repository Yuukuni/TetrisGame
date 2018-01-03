package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class TetrisGame {
	
	public static final int WIDTH_BLOCKS = 12;
	public static final int HEIGHT_BLOCKS = 21;
	
	public static final Point[][][] TetrisBlocks = {
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
	
	private int level;
	private long score;
	
	private TetrisBlock currentBlock;
	private ArrayList<Integer> currentBlocks;
	private ArrayList<Integer> nextBlocks;
	
	public enum Blocks { Blue, Cyan, Green, Orange, Purple, Red, Yellow, Wall, None };
	private Blocks[][] board;
	
	private static Blocks blockValue(int kind) {
		
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
	
	public int getLevel() {
		
		return level;
		
	}
	
	public void setLevel(int level) {
		
		this.level = level;
		
	}
	
	public long getScore() { 
		
		return score;
		
	}
	
	public TetrisBlock getCurrentBlock() {
		
		return currentBlock;
		
	}
	
	public ArrayList<Integer> getCurrentBlocks() {
		
		return currentBlocks;
	
	}
	
	public ArrayList<Integer> getNextBlocks() {
		
		return nextBlocks;
		
	}
	
	public int[][] getBoard() {
		
		int[][] intBoard = new int[WIDTH_BLOCKS][HEIGHT_BLOCKS];
		for(int i = 0; i < WIDTH_BLOCKS; ++i) {
			for(int j = 0; j < HEIGHT_BLOCKS; ++j) {
				intBoard[i][j] = board[i][j].ordinal();
			}	
		}
		return intBoard;
		
	}
	
	public TetrisGame() {
		
		initGame();
		
	}
	
	private void initGame() {
	
		level = 0;
		score = 0;
		
		currentBlocks = blocksRandomlyGenerated();
		nextBlocks = blocksRandomlyGenerated();
		newCurrentBlock();
		
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
	
	}
	
	private ArrayList<Integer> blocksRandomlyGenerated() {
		
		ArrayList<Integer> blocks = new ArrayList<Integer>();
		Collections.addAll(blocks, 0, 1, 2, 3, 4, 5, 6);
		Collections.shuffle(blocks);
		return blocks;
		
	}
	
	private void newCurrentBlock() {
		
		currentBlock = new TetrisBlock(currentBlocks.get(0));
		
		if (nextBlocks.isEmpty()) {
			nextBlocks = blocksRandomlyGenerated();
		}
		
		for(int i = 0; i < 6; ++i) {
			currentBlocks.set(i, currentBlocks.get(i + 1));
		}
		currentBlocks.set(6, nextBlocks.get(0));
		
		for(int i = 0; i < (nextBlocks.size() - 1); ++i) {
			nextBlocks.set(i, nextBlocks.get(i + 1));
		}
		nextBlocks.remove(nextBlocks.size() - 1);
		
	}
	
	private boolean collidesAt(int x, int y, int rotation) {
		
		int kind = currentBlock.getKind();
		for (Point p : TetrisBlocks[kind][rotation]) {
			if (board[p.x + x][p.y + y] != Blocks.None) {
				return true;
			}
		}
		return false;
		
	}
	
	public void rotate() {
		
		int newRotation = (currentBlock.getRotation() + 1) % 4;
		if (!collidesAt(currentBlock.getPosition().x, currentBlock.getPosition().y, newRotation)) {
			currentBlock.setRotation(newRotation);
		}

	}
	
	public void move(int i) {
		
		if (!collidesAt(currentBlock.getPosition().x + i, currentBlock.getPosition().y, currentBlock.getRotation())) {
			currentBlock.move(i);	
		}
		
	}
	
	public void drop() {
		
		if (!collidesAt(currentBlock.getPosition().x, currentBlock.getPosition().y + 1, currentBlock.getRotation())) {
			currentBlock.drop();
		} else {
			updateBoard();
		}	

	}
	
	private void updateBoard() {
		
		Point position = currentBlock.getPosition();
		int kind = currentBlock.getKind();
		int rotation = currentBlock.getRotation();
		
		for (Point p : TetrisBlocks[kind][rotation]) {
			board[position.x + p.x][position.y + p.y] = blockValue(kind);
		}
		clearLines();
		newCurrentBlock();
		
	}
	
	private void clearLines() {
		
		boolean needClear;
		int clearLines = 0;
		for (int j = (HEIGHT_BLOCKS - 2); j > 0; --j) {
			needClear = true;
			for (int i = 1; i < (WIDTH_BLOCKS - 1); ++i) {
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