package View;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.TetrisBlock;
import Model.TetrisGame;
import View.Texture.*;

public class TetrisWindow {
	
	private static final int BOARD_WIDTH = TetrisGame.WIDTH_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
	private static final int BOARD_HEIGHT = TetrisGame.HEIGHT_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
	private static final int BOARD_X = BOARD_WIDTH;
	private static final int BOARD_Y = 0;
	
	private static final int WINDOW_WIDTH = BOARD_WIDTH * 3;
	private static final int WINDOW_HEIGHT = BOARD_HEIGHT + TetrisBoard.BLOCK_PIXEL;
	
	private TetrisBoard tetrisBoard;
	private JFrame window;
	
	public TetrisWindow(TetrisTexture currentTexture, TetrisBlock firstBlock) {
		
		tetrisBoard = new TetrisBoard(currentTexture, firstBlock);
		tetrisBoard.setBounds(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
		tetrisBoard.setLayout(null);
		tetrisBoard.setPauseActionsVisible(true);
		
		window = new JFrame("Tetris Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		window.setLayout(null);
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