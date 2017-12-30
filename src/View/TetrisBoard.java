package View;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JPanel;

import View.Texture.*;

public class TetrisBoard extends JPanel /*implements KeyListener*/{ 
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage[] blocks;
	private int[][] board;
	//private JButton continueButton;
    //private JButton restartButton;
    //private JButton exitButton;
    
	public static final int BLOCK_KINDS = 9;
	public static final int BLOCK_PIXEL = 30;						 
	public static final int WIDTH_BLOCKS = 12, HEIGHT_BLOCKS = 21;
	
	
	public void setBoard(int[][] board) {
		
		this.board = board;
		
	}
	
	public TetrisBoard(TetrisTexture currentTexture) {
		
		textureSetting(currentTexture);
		
		/*
		continueButton = new JButton("Continue");
		continueButton.setBounds(0, 0, 0, 0);
		this.add(continueButton);
		
		restartButton = new JButton("Restart");
		continueButton.setBounds(0, 0, 0, 0);
		this.add(restartButton);
		
		exitButton = new JButton("Exit");
		continueButton.setBounds(0, 0, 0, 0);
		this.add(exitButton);
		*/
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
	
	public void addButtonListeners(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForExit){
		
		
		
	}
	
	public void addKeyListener(KeyListener keyListener){}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		
		for(int i = 0; i < WIDTH_BLOCKS + 1; i++) {
			g.drawLine(i * BLOCK_PIXEL, 0, i * BLOCK_PIXEL, HEIGHT_BLOCKS * BLOCK_PIXEL);
		}
		
		for(int i = 0; i < HEIGHT_BLOCKS + 1; i++){
			g.drawLine(0, i * BLOCK_PIXEL, WIDTH_BLOCKS * BLOCK_PIXEL, i * BLOCK_PIXEL);
		}
		
		for(int i = 0; i < WIDTH_BLOCKS; i++){
			for(int j = 0; j < HEIGHT_BLOCKS; j++){
				int currentBlock = board[i][j];
				g.drawImage(blocks[currentBlock], i * BLOCK_PIXEL, j * BLOCK_PIXEL, null);
			}
		}
		
	}

}
