package View;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import View.Texture.*;

public class TetrisBoard extends JPanel { 
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage[] blocks;
	
	private int[][] board;
	private Point currentBlockPosition;
	private int currentBlockKind;
	private int currentBlockRotation;
	
	private JButton continueButton;
    private JButton restartButton;
    private JButton exitButton;
    
	public static final int BLOCK_KINDS = 9;
	public static final int BLOCK_PIXEL = 30;						 
	public static final int WIDTH_BLOCKS = 12, HEIGHT_BLOCKS = 21;
	
	private static final Point[][][] TetrisBlocks = {
			// I-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O-Piece
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S-Piece
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-Piece
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-Piece
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};
	
	public void setBoard(int[][] board) {
		
		this.board = board;
		
	}
	
	public void setCurrentBlockPosition(Point position) {
		
		this.currentBlockPosition = position;
		
	}
	
	public void setCurrentBlockKind(int kind) {
		
		this.currentBlockKind = kind;
		
	}
	
	public void setCurrentBlockRotation(int rotation) {
		
		this.currentBlockRotation = rotation;
		
	}
	
	public TetrisBoard(TetrisTexture currentTexture, Point currentBlockPosition, int currentBlockKind, int currentBlockRotation) {
		
		textureSetting(currentTexture);
		init(currentBlockPosition, currentBlockKind, currentBlockRotation);
		
	}
	
	private void textureSetting(TetrisTexture currentTexture) {
		
		blocksSetting(currentTexture);
		
	}
	
	private void blocksSetting(TetrisTexture currentTexture) {
		
		blocks = new BufferedImage[BLOCK_KINDS];
		
		for(int i = 0; i < BLOCK_KINDS; ++i) {
			try {
				blocks[i] = ImageIO.read(TetrisBoard.class.getResource(currentTexture.blocksPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void init(Point currentBlockPosition, int currentBlockKind, int currentBlockRotation) {
		
		this.currentBlockPosition = new Point(currentBlockPosition.x, currentBlockPosition.y);
		this.currentBlockKind = currentBlockKind;
		this.currentBlockRotation = currentBlockRotation;
		
		board = new int[WIDTH_BLOCKS][HEIGHT_BLOCKS];
		for(int i = 0; i < WIDTH_BLOCKS; i++) {
			for(int j = 0; j < HEIGHT_BLOCKS; j++) {
				if(i == 0 || i == (WIDTH_BLOCKS - 1) || j == (HEIGHT_BLOCKS - 1)) {
					board[i][j] = 7;
				}
				else {
					board[i][j] = 8;
				}
			}
		}
		
		initButtons();
		
	}
	
	private void initButtons(){
		
		continueButton = new JButton("Continue");
		continueButton.setBounds(135, 240, 100, 30);
		this.add(continueButton);
		
		restartButton = new JButton("Restart");
		restartButton.setBounds(135, 290, 100, 30);
		this.add(restartButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(135, 340, 100, 30);
		this.add(exitButton);
		
		setButtonsVisible(false);
		
	}
	
	public void setButtonsVisible(boolean b) {
		
		continueButton.setVisible(b);
		restartButton.setVisible(b);
		exitButton.setVisible(b);
		
	}
	
	public void addButtonListeners(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForExit) {
		
		continueButton.addActionListener(listenForContinue);
		restartButton.addActionListener(listenForRestart);
		exitButton.addActionListener(listenForExit);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int i = 0; i < WIDTH_BLOCKS; i++){
			for(int j = 0; j < HEIGHT_BLOCKS; j++){
				int currentBlock = board[i][j];
			    g.drawImage(blocks[currentBlock], i * BLOCK_PIXEL, j * BLOCK_PIXEL, null);
			}
		}
		
		for(Point p : TetrisBlocks[currentBlockKind][currentBlockRotation]) {
			
			g.drawImage(blocks[currentBlockKind], (currentBlockPosition.x + p.x) * BLOCK_PIXEL, (currentBlockPosition.y + p.y) * BLOCK_PIXEL, null);
			
		}
		
		for(int i = 0; i < WIDTH_BLOCKS + 1; i++) {
			g.drawLine(i * BLOCK_PIXEL, 0, i * BLOCK_PIXEL, HEIGHT_BLOCKS * BLOCK_PIXEL);
		}
		
		for(int i = 0; i < HEIGHT_BLOCKS + 1; i++){
			g.drawLine(0, i * BLOCK_PIXEL, WIDTH_BLOCKS * BLOCK_PIXEL, i * BLOCK_PIXEL);
		}

	}

}
