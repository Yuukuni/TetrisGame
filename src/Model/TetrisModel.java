package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TetrisModel {
	
	private TetrisGame game;
	
	private boolean quit;
	private boolean pause;
	
	private int[] keyCode;
	
	public TetrisModel() {
		
		keyCode = new int[] {
			KeyEvent.VK_UP, 
			KeyEvent.VK_LEFT, 
			KeyEvent.VK_RIGHT, 
			KeyEvent.VK_DOWN, 
			KeyEvent.VK_SPACE, 
			KeyEvent.VK_ESCAPE
		};
		
	}
	
	public void gameStart(int startLevel) {

		quit = false;
		pause = false;
		game = new TetrisGame(startLevel);
	
	}
	
	public boolean quit() {
		
		return quit;
		
	}
	
	public void quitGame() {
		
		quit = true;
		
	}

	public boolean pause() {
		
		return pause;
		
	}
	
	public void setPause(boolean b) {
		
		pause = b;
		
	}
	
	public boolean gameover() {
		
		return game.gameover();
		
	}
	
	public int getLevel() {
		
		return game.getLevel();
		
	}
	
	public void setLevel(int level) {
		
		game.setLevel(level);
		
	}
	
	public int getScore() {
		
		return game.getScore();
		
	}
	
	public void addScore(int i) {
		
		game.addScore(i);
		
	}
	
	public int getLine() {
		
		return game.getLine();
		
	}
	
	public int getStartLevel() {
		
		return game.getStartLevel();
		
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
	
	public void dropDown() {
		
		game.dropDown();
		
	}
	
	public int[] getKeyCode() {
		
		return keyCode;
		
	}
	
	public int getKeyCode(int i) {
		
		return keyCode[i];
		
	}
	
	public void setKeyCode(int[] keyCode) {
		
		this.keyCode = keyCode;
		
	}
	
	public void setKeyCode(int i, int keyCode) {
		
		this.keyCode[i] = keyCode;
		
	}
	
}