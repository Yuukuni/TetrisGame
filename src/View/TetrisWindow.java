package View;

import javax.swing.JFrame;

import View.Texture.*;

public class TetrisWindow {
	
	private JFrame window;
	private TetrisBoard board;
	
	public int WINDOW_WIDTH, WINDOW_HEIGHT;
	public int BOARD_WIDTH, BOARD_HEIGHT;
	public int BOARD_X, BOARD_Y;
	
	public TetrisWindow(TetrisTexture currentTexture) {
		
		board = new TetrisBoard(currentTexture);
		
		BOARD_WIDTH = board.WIDTH_BLOCKS * board.BLOCK_PIXEL;
		BOARD_HEIGHT = board.HEIGHT_BLOCKS * board.BLOCK_PIXEL;
		BOARD_X = BOARD_WIDTH * 1;
		BOARD_Y = 0;
		
		board.setBounds(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
		
		window = new JFrame("Tetris Game");
		
		WINDOW_WIDTH = BOARD_WIDTH * 3;
		WINDOW_HEIGHT = BOARD_HEIGHT * 1;
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		window.setLayout(null);
		
		window.add(board);
		window.addKeyListener(board);
		
	}
	
	public void setVisible(boolean b) {
		
		window.setVisible(b);
		
	}
	
	public void repaintTetrisBoard() {
		
		board.repaint();
		
	}
	
}