package View;

import javax.swing.JFrame;

import View.Texture.*;

public class TetrisWindow {
	
	private JFrame window;
	private TetrisBoard board;
	
	public TetrisWindow(TetrisTexture currentTexture) {
		
		int boardWidth = TetrisBoard.WIDTH_BLOCKS * TetrisBoard.BLOCK_PIXEL;
		int boardHeight = TetrisBoard.HEIGHT_BLOCKS * TetrisBoard.BLOCK_PIXEL;
		
		int windowWidth = boardWidth * 3;
		int windowHeight = boardHeight * 1;
		
		int boardX = boardWidth * 1;
		int boardY = 0;
			
		window = new JFrame("Tetris Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(windowWidth, windowHeight);
		window.setResizable(false);
		window.setLayout(null);
		
		board = new TetrisBoard(currentTexture);
		board.setBounds(boardX, boardY, boardWidth, boardHeight);
		window.add(board);
		
	}
	
	public void setVisible(boolean b) {
		
		window.setVisible(b);
		
	}
	
	public void repaintTetrisBoard() {
		
		board.repaint();
		
	}
	
}