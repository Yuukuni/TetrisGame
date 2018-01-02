package View;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import View.Texture.*;

public class TetrisWindow {
	
	private JFrame tetrisWindow;
	private TetrisBoard tetrisBoard;
	
	public TetrisWindow(TetrisTexture currentTexture) {
		
		int boardWidth = TetrisBoard.WIDTH_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
		int boardHeight = TetrisBoard.HEIGHT_BLOCKS * TetrisBoard.BLOCK_PIXEL + 1;
		int boardX = boardWidth * 1;
		int boardY = 0;
		
		int windowWidth = boardWidth * 3;
		int windowHeightCorrected = TetrisBoard.BLOCK_PIXEL;
		int windowHeight = boardHeight * 1 + windowHeightCorrected;
			
		tetrisWindow = new JFrame("Tetris Game");
		tetrisWindow.setLayout(null);
		tetrisWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tetrisWindow.setSize(windowWidth, windowHeight);
		tetrisWindow.setResizable(false);
		tetrisWindow.setLayout(null);
		
		tetrisBoard = new TetrisBoard(currentTexture);
		tetrisBoard.setLayout(null);
		tetrisBoard.setBounds(boardX, boardY, boardWidth, boardHeight);
		tetrisWindow.add(tetrisBoard);
		
	}
	
	public void setVisible(boolean b) {
		
		tetrisWindow.setVisible(b);
		
	}
	
	public void addButtonListeners(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForExit){
		
		tetrisBoard.addButtonListeners(listenForContinue, listenForRestart, listenForExit);
	
	}
	
	public void addKeyListener(KeyListener keyListener){
		
		tetrisBoard.addKeyListener(keyListener);
		
	}
	
	public void repaintTetrisBoard(int[][] board, Point currentBlockPosition, int currentBlockKind, int currentBlockRotation) {
		
		tetrisBoard.setBoard(board);
		tetrisBoard.setCurrentBlockPosition(currentBlockPosition);
		tetrisBoard.setCurrentBlockKind(currentBlockKind);
		tetrisBoard.setCurrentBlockRotation(currentBlockRotation);
		tetrisBoard.repaint();
		
	}
	
	public void setStopButtonsVisible(boolean b) {
		
		tetrisBoard.setButtonsVisible(b);
		
	}

}