package View;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.TetrisBlock;
import Model.TetrisGame;
import View.Texture.*;

public class TetrisBoard extends JPanel { 
	
	private static final long serialVersionUID = 1L;
	
	public static final int BLOCK_KINDS = 9;
	public static final int BLOCK_PIXEL = 30;						 
	
	private TetrisBlock currentBlock;
	private int[][] board;
	
	private BufferedImage[] blocks;
	
	private JButton continueButton;
    private JButton restartButton;
    private JButton quitButton;
	
	public void setCurrentBlock(TetrisBlock currentBlock) {
		
		this.currentBlock = currentBlock;
	
	}
	
	public void setBoard(int[][] board) {
		
		this.board = board;
		
	}
	
	public TetrisBoard(TetrisTexture currentTexture, TetrisBlock firstBlock) {
		
		textureSetting(currentTexture);
		init(firstBlock);
		
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
	
	private void init(TetrisBlock firstBlock) {
		
		currentBlock = firstBlock;
		board = new int[TetrisGame.WIDTH_BLOCKS][TetrisGame.HEIGHT_BLOCKS];
		for(int i = 0; i < TetrisGame.WIDTH_BLOCKS; i++) {
			for(int j = 0; j < TetrisGame.HEIGHT_BLOCKS; j++) {
				if(i == 0 || i == (TetrisGame.WIDTH_BLOCKS - 1) || j == (TetrisGame.HEIGHT_BLOCKS - 1)) {
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
		
		quitButton = new JButton("Quit");
		quitButton.setBounds(135, 340, 100, 30);
		this.add(quitButton);
		
		setPauseActionsVisible(false);
		
	}
	
	public void addPauseActions(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForQuit) {
		
		continueButton.addActionListener(listenForContinue);
		restartButton.addActionListener(listenForRestart);
		quitButton.addActionListener(listenForQuit);
		
	}
	
	public void setPauseActionsVisible(boolean b) {
		
		continueButton.setVisible(b);
		restartButton.setVisible(b);
		quitButton.setVisible(b);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int i = 0; i < TetrisGame.WIDTH_BLOCKS; i++){
			for(int j = 0; j < TetrisGame.HEIGHT_BLOCKS; j++){
				int theKind = board[i][j];
			    g.drawImage(blocks[theKind], i * BLOCK_PIXEL, j * BLOCK_PIXEL, null);
			}
		}
		
		int x = currentBlock.getPosition().x;
		int y = currentBlock.getPosition().y;
		
		for(Point p : currentBlock.getShape()) {
			g.drawImage(blocks[currentBlock.getKind()], (x + p.x) * BLOCK_PIXEL, (y + p.y) * BLOCK_PIXEL, null);
		}
		
		for(int i = 0; i < TetrisGame.WIDTH_BLOCKS + 1; i++) {
			g.drawLine(i * BLOCK_PIXEL, 0, i * BLOCK_PIXEL, TetrisGame.HEIGHT_BLOCKS * BLOCK_PIXEL);
		}
		
		for(int i = 0; i < TetrisGame.HEIGHT_BLOCKS + 1; i++){
			g.drawLine(0, i * BLOCK_PIXEL, TetrisGame.WIDTH_BLOCKS * BLOCK_PIXEL, i * BLOCK_PIXEL);
		}

	}

}
