package View;

import javax.swing.JFrame;

import View.Texture.*;

public class TetrisWindow {
	
	private JFrame window;
	private TetrisBoard board;
	
	public final int BOARD_WIDTH = board.WIDTH_BLOCKS() * board.BLOCK_PIXEL();
	public final int BOARD_HEIGHT = board.HEIGHT_BLOCKS() * board.BLOCK_PIXEL();
	
	public final int BOARD_X = BOARD_WIDTH * 1;
	public final int BOARD_Y = 0;
	
	public final int WINDOW_WIDTH = BOARD_WIDTH * 3;
	public final int WINDOW_HEIGHT = BOARD_HEIGHT * 1;
	
	public TetrisWindow(TetrisTexture currentTexture) {
		
		window = new JFrame("Tetris Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		window.setLayout(null);
		
		board = new TetrisBoard(currentTexture);
		board.setBounds(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
		
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