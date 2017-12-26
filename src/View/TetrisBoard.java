package View;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import View.Texture.*;

public class TetrisBoard extends JPanel implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage[] blocks;

	public final int BLOCK_KINDS = 7;
	public final int BLOCK_PIXEL = 30;						 
	public final int WIDTH_BLOCKS = 12, HEIGHT_BLOCKS = 21;
	
	public TetrisBoard(TetrisTexture currentTexture) {
		
		textureSetting(currentTexture);
		
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

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		//Here to code...
		int i = 3;
		g.drawImage(blocks[i], 0, 0, null);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		//Here to code...
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}