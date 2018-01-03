package View;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.TetrisBlock;
import View.Texture.*;

public class TetrisWindow {
	
	private JFrame window;
	private TetrisBoard tetrisBoard;
	
	public TetrisWindow(TetrisTexture currentTexture, TetrisBlock firstBlock) {
		
		int boardWidth = TetrisBoard.WIDTH_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
		int boardHeight = TetrisBoard.HEIGHT_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
		int boardX = boardWidth * 1;
		int boardY = 0;
		
		int windowWidth = boardWidth * 3;
		int windowHeightCorrected = TetrisBoard.BLOCK_PIXEL;
		int windowHeight = boardHeight * 1 + windowHeightCorrected;
			
		window = new JFrame("Tetris Game");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth, windowHeight);
		window.setResizable(false);
		window.setLayout(null);
		
		tetrisBoard = new TetrisBoard(currentTexture, firstBlock);
		tetrisBoard.setLayout(null);
		tetrisBoard.setBounds(boardX, boardY, boardWidth, boardHeight);
		window.add(tetrisBoard);
		
	}
	
	public TetrisBoard getTetrisBoard() {
		
		return tetrisBoard;
		
	}
	
	public void addPauseActions(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForQuit) {
		
		tetrisBoard.addPauseActions(listenForContinue, listenForRestart, listenForQuit);
	
	}
	
	public void setVisible(boolean b) {
		
		window.setVisible(b);
		
	}
	
	public void repaintTetrisBoard(TetrisBlock currentBlock, int[][] board) {
		
		tetrisBoard.setCurrentBlock(currentBlock);
		tetrisBoard.setBoard(board);
		tetrisBoard.repaint();
		
	}
	
	public void setPauseActionsVisible(boolean b) {
		
		tetrisBoard.setPauseActionsVisible(b);
		
	}

}