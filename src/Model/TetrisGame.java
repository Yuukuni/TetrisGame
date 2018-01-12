package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class TetrisGame {
	
	public static final int WIDTH_BLOCKS = 12;
	public static final int HEIGHT_BLOCKS = 23;
	
	public static final int LEVEL_TOP = 15;
	
	private boolean gameover;
	
	private int level;
	private int score;
	private int line;
	private int startLevel;
	
	private TetrisBlock currentBlock;
	private ArrayList<Integer> currentBlocks;
	private ArrayList<Integer> nextBlocks;
	
	public enum Blocks { Blue, Cyan, Green, Orange, Purple, Red, Yellow, Wall, None };
	private Blocks[][] board;
	
	public TetrisGame(int startLevel) {
		
		initGame(startLevel);
		
	}
	
	private void initGame(int startLevel) {
		
		gameover = false;
		
		level = startLevel;
		score = 0;
		line = 0;
		this.startLevel = startLevel;
		
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
		
		currentBlocks = blocksRandomlyGenerated();
		nextBlocks = blocksRandomlyGenerated();
		
		newCurrentBlock();
	
	}
	
	private ArrayList<Integer> blocksRandomlyGenerated() {
		
		ArrayList<Integer> blocks = new ArrayList<Integer>();
		Collections.addAll(blocks, 0, 1, 2, 3, 4, 5, 6);
		Collections.shuffle(blocks);
		return blocks;
		
	}
	
	private void newCurrentBlock() {
		
		if(!canNewCurrentBlock()) {
			gameover = true;
		}
		else {
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
	
	}
	
	private boolean canNewCurrentBlock() {
		
		for (Point p : TetrisBlock.getShape(currentBlocks.get(0))) {
			if (board[p.x + TetrisBlock.START_POSITION_X][p.y + TetrisBlock.START_POSITION_Y] != Blocks.None) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean collidesAt(int x, int y, int rotation) {
		
		for (Point p : currentBlock.getShapeWithRotation(rotation)) {
			if(p.x + x < 0) {
				return true;
			}
			if (board[p.x + x][p.y + y] != Blocks.None) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean gameover() {
		
		return gameover;
		
	}
	
	public int getLevel() {
		
		return level;
		
	}
	
	public void setLevel(int level) {
		
		this.level = level;
		
	}
	
	public int getScore() { 
		
		return score;
		
	}
	
	public void addScore(int i) {
		
		score += i;
		
	}
	
	public int getLine() {
		
		return line;
		
	}
	
	public int getStartLevel() {
		
		return startLevel;
		
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
	
	public void rotate() {
		
		int currentRotation = currentBlock.getRotation();
		int newRotation = (currentRotation + 1) % 4;
		
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
	
	public void dropDown() {
		
		while (!collidesAt(currentBlock.getPosition().x, currentBlock.getPosition().y + 1, currentBlock.getRotation())) {
			currentBlock.drop();
			score += 2;
		}
		updateBoard();
	}
	
	private void updateBoard() {
		
		int x = currentBlock.getPosition().x;
		int y = currentBlock.getPosition().y;
		for (Point p : currentBlock.getShape()) {
			board[x + p.x][y + p.y] = Blocks.values()[currentBlock.getKind()];
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
		
		line += clearLines;
		if(line + (startLevel - 1) * 10 >= level * 10 && level < LEVEL_TOP) {
			level++;
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