package View;

import javax.swing.JFrame;

import View.Texture.*;

public class TetrisWindow {
	
	public static final int WINDOW_WIDTH = 720, WINDOW_HEIGHT = 420;
	public static final int BOARD_WIDTH = 240, BOARD_HEIGHT = 420;
	public static final int BOARD_X = 240, BOARD_Y = 0;
	
	private JFrame window;
	private TetrisBoard board;
	
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
	
}