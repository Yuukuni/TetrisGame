package View.TetrisWindow;

import java.util.ArrayList;

import Model.TetrisBlock;

public class TetrisViewSetting {
	
	private int startLevel;
	private TetrisBlock firstBlock;
	private ArrayList<Integer> firstBlocks;
	
	public int getStartLevel() {
		
		return startLevel;
		
	}
	
	public TetrisBlock getFirstBlock() {
		
		return firstBlock;
		
	}
	
	public ArrayList<Integer> getFirstBlocks() {
		
		return firstBlocks;
		
	}

	public void setStartLevel(int startLevel) {
		
		this.startLevel = startLevel;
		
	}
	
	public void setFirstBlock(TetrisBlock firstBlock) {
		
		this.firstBlock = firstBlock;
		
	}
	
	public void setFirstBlocks(ArrayList<Integer> firstBlocks) {
		
		this.firstBlocks = firstBlocks;
		
	}
	
}