package View.MenuWindow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import View.TetrisView;
import View.Texture.TetrisTexture;

public class MenuBoard extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private static final int BLOCK_PIXEL = 30;
	
	private static final String START = "START";
	private static final String SETTING = "SETTING";
	private static final String EXIT = "EXIT";
	
	private static final String GRAY = "GRAY";
	private static final String RED = "RED";
	
	private static final int[] selectionY = { 
			BLOCK_PIXEL * 4 + 15, 
			BLOCK_PIXEL * 7, 
			BLOCK_PIXEL * 9 + 15 
		};
	
	private int select;
	
	private BufferedImage background;
	private BufferedImage darkBackground;
	private BufferedImage menuAreaBackground;
	
	private BufferedImage grayAlphabetRead;
	private BufferedImage redAlphabetRead;
	
	private BufferedImage[] grayAlphabets;
	private BufferedImage[] redAlphabets;
	
	private BufferedImage redSelect;
	
	private BufferedImage[] grayStart;
	private BufferedImage[] graySetting;
	private BufferedImage[] grayExit;
	
	private BufferedImage[] redStart;
	private BufferedImage[] redSetting;
	private BufferedImage[] redExit;
	
	public MenuBoard(TetrisTexture currentTexture) {
		
		init();
		textureSetting(currentTexture);

	}
	
	private void init() {
		
		select = 0;
		
	}
	
	private void textureSetting(TetrisTexture currentTexture) {
		
		backgroundSetting(currentTexture);
		fontSetting(currentTexture);
		wordsSetting(currentTexture);
		
	}

	private void backgroundSetting(TetrisTexture currentTexture) {
		
		try {
			background = ImageIO.read(MenuBoard.class.getResource(currentTexture.getMenuBackgroundPath()));
			darkBackground = ImageIO.read(MenuBoard.class.getResource(currentTexture.getDarkMenuBackgroundPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuAreaBackground = darkBackground.getSubimage(BLOCK_PIXEL * 3, BLOCK_PIXEL * 3, TetrisView.BOARD_WIDTH + BLOCK_PIXEL * 4, BLOCK_PIXEL * 9);
		
	}
	
	private void fontSetting(TetrisTexture currentTexture) {
		
		try {
			grayAlphabetRead = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayAlphabetPath()));
			redAlphabetRead = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedAlphabetPath()));
			redSelect = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedSelectPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		grayAlphabets = new BufferedImage[26];
		redAlphabets = new BufferedImage[26];
		
		for(int i = 0; i < 26; i++) {
			grayAlphabets[i] = grayAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			redAlphabets[i] = redAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
		}
		
	}
	
	private void wordsSetting(TetrisTexture currentTexture) {
		
		grayStart = getFontOfWord(START, GRAY);
		graySetting = getFontOfWord(SETTING, GRAY);
		grayExit = getFontOfWord(EXIT, GRAY);
		
		redStart = getFontOfWord(START, RED);
		redSetting = getFontOfWord(SETTING, RED);
		redExit = getFontOfWord(EXIT, RED);
		
	}
	
	private BufferedImage[] getFontOfWord(String word, String color) {
		
		int intA = 'A';
		BufferedImage[] wordImages = new BufferedImage[word.length()];
		
		switch(color) {
		case GRAY:
			for(int i = 0; i < word.length(); i++) {
				wordImages[i] = grayAlphabets[word.charAt(i) - intA];
			}
			break;
		case RED:
			for(int i = 0; i < word.length(); i++) {
				wordImages[i] = redAlphabets[word.charAt(i) - intA];
			}
			break;
		}

		return wordImages;
		
	}
	
	public int getSelect() {
		
		return select;
		
	}
	
	public void selectUp() {
		
		if(select > 0) {
			select--;
		} else {
			select = 2;
		}
		
	}
	
	public void selectDown() {
		
		if(select < 2) {
			select++;
		} else {
			select = 0;
		}
	
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		drawBackground(g);
		drawMenuArea(g);
		
	}
	
	private void drawBackground(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		g.drawImage(menuAreaBackground, BLOCK_PIXEL * 3, BLOCK_PIXEL * 3, null);
		
	}
	
	private void drawMenuArea(Graphics g) {
		
		g.drawImage(redSelect, BLOCK_PIXEL * 6, selectionY[select], null);
		
		switch(select) {
		case 0:
			for(int i = 0; i < START.length(); i++) {
				g.drawImage(redStart[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[0], null);
			}
			for(int i = 0; i < SETTING.length(); i++) {
				g.drawImage(graySetting[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[1], null);
			}
			for(int i = 0; i < EXIT.length(); i++) {
				g.drawImage(grayExit[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[2], null);
			}
			break;
		
		case 1:
			for(int i = 0; i < START.length(); i++) {
				g.drawImage(grayStart[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[0], null);
			}
			for(int i = 0; i < SETTING.length(); i++) {
				g.drawImage(redSetting[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[1], null);
			}
			for(int i = 0; i < EXIT.length(); i++) {
				g.drawImage(grayExit[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[2], null);
			}
			break;
			
		case 2:
			for(int i = 0; i < START.length(); i++) {
				g.drawImage(grayStart[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[0], null);
			}
			for(int i = 0; i < SETTING.length(); i++) {
				g.drawImage(graySetting[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[1], null);
			}
			for(int i = 0; i < EXIT.length(); i++) {
				g.drawImage(redExit[i], BLOCK_PIXEL * (i + 9) - 10, selectionY[2], null);
			}
			break;
		
		}
		
	}
	
}