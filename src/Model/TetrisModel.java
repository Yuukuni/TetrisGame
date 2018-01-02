package Model;

import java.awt.Point;
import java.util.ArrayList;

public class TetrisModel {
	
	private TetrisGame game;
	
	public void GameStart() {
		
		game = new TetrisGame();
	
	}
	
	public long getScore() {
		
		return game.score();
		
	}
	
	public int[][] getBoard() {
		
		return game.intBoard();
		
	}
	
	public ArrayList<Integer> getCurrentBlocks() {
		
		return game.currentBlocks();
		
	}
	
	public ArrayList<Integer> getNextBlocks() {
		
		return game.nextBlocks();
		
	}
	
	public Point getCurrentBlockPosition() {
		
		return game.currentBlockPosition();
		
	}
	
	public int getCurrentBlockKind() {
		
		return game.currentBlockKind();
	}
	
	public int getCurrentBlockRotation() {
		
		return game.currentBlockRotation();
		
	}
	
	public Point[][][] getTetrisBlocks() {
		
		return game.TetrisBlocks();
		
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