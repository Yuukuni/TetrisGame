package Model;

import java.util.ArrayList;

public class TetrisModel {
	
	private TetrisGame game;
	
	public void GameStart() {
		
		game = new TetrisGame();
	
	}
	
	public int getLevel() {
		
		return game.getLevel();
		
	}
	
	public void setLevel(int level) {
		
		game.setLevel(level);
		
	}
	
	public long getScore() {
		
		return game.getScore();
		
	}

	public TetrisBlock getCurrentBlock() {
		
		return game.getCurrentBlock();
		
	}
	
	public ArrayList<Integer> getCurrentBlocks() {
		
		return game.getCurrentBlocks();
		
	}
	
	public ArrayList<Integer> getNextBlocks() {
		
		return game.getNextBlocks();
		
	}
	
	public int[][] getBoard() {
		
		return game.getBoard();
		
	}
	
	public void rotate() {
		
		game.rotate();
		
	}
	
	public void move(int i) {
		
		game.move(i);
		
	}
	
	public void drop() {
		
		game.drop();
		
	}
	
}