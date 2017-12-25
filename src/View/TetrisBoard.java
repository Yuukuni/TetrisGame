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
	public static final int BLOCK_KINDS = 7;
	public static final int BLOCK_PIXEL = 20;						 
	public static final int WIDIH_BLOCKS = 12, HEIGHT_BLOCKS = 21;
	
	private BufferedImage[] blocks;
	
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
		g.drawImage(blocks[3], 0, 0, null);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
}