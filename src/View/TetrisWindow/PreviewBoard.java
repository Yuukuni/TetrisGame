package View.TetrisWindow;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.TetrisBlock;
import View.TetrisView;
import View.Texture.TetrisTexture;

public class PreviewBoard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final int LEVEL_TOP = 15;
	private static final int BLOCK_KINDS = 7;

	private static final int BLOCK_PIXEL = 30;
	private static final int NEXT_BLOCK_PIXEL = 25;
	private static final int PREVIEW_BLOCK_PIXEL = 20;
	
	private int level;
	private ArrayList<Integer> currentBlocks;
	
	private BufferedImage[] gameBackground;
	private BufferedImage[] darkGameBackground;
	private BufferedImage[] previewBoardBackground;
	private BufferedImage[] previewAreaBackground;
	
	private BufferedImage[] nextBlocks;
	private BufferedImage[] previewBlocks;
	
	public PreviewBoard(TetrisTexture currentTexture, int startLevel, ArrayList<Integer> firstBlocks) {
		
		init(startLevel, firstBlocks);
		textureSetting(currentTexture);
		
	}
	
	private void init(int startLevel, ArrayList<Integer> firstBlocks) {
		
		level = startLevel;
		currentBlocks = firstBlocks;
		
	}
	
	private void textureSetting(TetrisTexture currentTexture) {
		
		blocksSetting(currentTexture);
		backgroundSetting(currentTexture);
		
	}
	
	private void blocksSetting(TetrisTexture currentTexture) {
		
		nextBlocks = new BufferedImage[BLOCK_KINDS];
		previewBlocks = new BufferedImage[BLOCK_KINDS];
		
		for(int i = 0; i < BLOCK_KINDS; i++) {
			try {
				nextBlocks[i] = ImageIO.read(PreviewBoard.class.getResource(currentTexture.getNextBlocksPath(i)));
				previewBlocks[i] = ImageIO.read(PreviewBoard.class.getResource(currentTexture.getPreviewBlocksPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void backgroundSetting(TetrisTexture currentTexture) {
		
		gameBackground = new BufferedImage[LEVEL_TOP];
		darkGameBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			try {
				gameBackground[i] = ImageIO.read(PreviewBoard.class.getResource(currentTexture.getGameBackgroundPath(i)));
				darkGameBackground[i] = ImageIO.read(PreviewBoard.class.getResource(currentTexture.getDarkGameBackgroundPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		previewBoardBackground = new BufferedImage[LEVEL_TOP];
		previewAreaBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			previewBoardBackground[i] = gameBackground[i].getSubimage(0, 0, TetrisView.BOARD_WIDTH, TetrisView.BOARD_HEIGHT);
			previewAreaBackground[i] = darkGameBackground[i].getSubimage((TetrisView.BOARD_WIDTH - BLOCK_PIXEL * 5), 0, BLOCK_PIXEL * 5, TetrisView.BOARD_HEIGHT);
		}
		
	}
	
	public void setLevel(int level) {
		
		this.level = level;
		
	}
	
	public void setCurrentBlocks(ArrayList<Integer> currentBlocks) {
		
		this.currentBlocks = currentBlocks;
		
	}
	
	public void paintComponent(Graphics g) {
		
		int previewAreaX = TetrisView.BOARD_WIDTH - BLOCK_PIXEL * 5;
		int previewAreaY = 0;
		
		super.paintComponent(g);
		drawBackground(g, previewAreaX, previewAreaY);
		drawNextBlock(g, previewAreaX, previewAreaY);
		drawPreviewBlocks(g, previewAreaX, previewAreaY);
		
	}
	
	private void drawBackground(Graphics g, int previewAreaX, int previewAreaY) {
		
		g.drawImage(previewBoardBackground[level - 1], 0, 0, null);
		g.drawImage(previewAreaBackground[level - 1], previewAreaX, previewAreaY, null);
		
	}
	
	private void drawNextBlock(Graphics g, int previewAreaX, int previewAreaY) {
		
		int blockX = previewAreaX + NEXT_BLOCK_PIXEL * 2 - 10;
		int blockY = previewAreaY + NEXT_BLOCK_PIXEL * 3 - 20;
		
		switch(currentBlocks.get(0)) {
		case 0:
			blockX += 10;
			break;
		case 2:
			blockY -= NEXT_BLOCK_PIXEL;
			break;
		case 3:
			blockX += 10;
			break;
		}
		
		for(Point p : TetrisBlock.getShape(currentBlocks.get(0))) {
			g.drawImage(nextBlocks[currentBlocks.get(0)], blockX + (p.x * NEXT_BLOCK_PIXEL), blockY + (p.y * NEXT_BLOCK_PIXEL), null);
		}
			
	}
	
	private void drawPreviewBlocks(Graphics g, int previewAreaX, int previewAreaY) {
		
		for(int i = 1; i < BLOCK_KINDS - 1; i++) {
			
			int blockX = previewAreaX + PREVIEW_BLOCK_PIXEL * 2 + 5;
			int blockY = previewAreaY + NEXT_BLOCK_PIXEL * 7 + PREVIEW_BLOCK_PIXEL * 7 / 2 * (i - 1) - 10;
			
			switch(currentBlocks.get(i)) {
			case 0:
				blockX += 10;
				blockY -= PREVIEW_BLOCK_PIXEL;
				previewAreaY -= PREVIEW_BLOCK_PIXEL;
				break;
			case 2:
				blockY -= PREVIEW_BLOCK_PIXEL;
				break;
			case 3:
				blockX += 10;
				break;
			}
			
			for(Point p : TetrisBlock.getShape(currentBlocks.get(i))) {
				g.drawImage(previewBlocks[currentBlocks.get(i)], blockX + (p.x * PREVIEW_BLOCK_PIXEL), blockY + (p.y * PREVIEW_BLOCK_PIXEL), null);
			}
			
		}
		
	}
	
}