package View.LevelWindow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import View.TetrisView;
import View.Texture.TetrisTexture;

public class LevelBoard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final int BLOCK_PIXEL = 30;
	private static final int LEVEL_TOP = 15;
	
	private static final String LEVEL_SELECT = "LEVELSELECT";
	
	private int select;
	
	private BufferedImage[] gameBackground;
	private BufferedImage[] darkGameBackground;
	private BufferedImage[] levelAreaBackground;
	
	private BufferedImage blueAlphabetRead;
	private BufferedImage grayNumberRead;
	
	private BufferedImage graySelect;
	
	private BufferedImage[] blueAlphabets;
	private BufferedImage[] grayNumbers;

	
	private BufferedImage[] blueLevelSelect = new BufferedImage[LEVEL_SELECT.length()];
	
	public LevelBoard(TetrisTexture currentTexture) {
		
		init();
		textureSetting(currentTexture);
		
	}
	
	private void init() {
		
		select = 1;
		
	}
	
	private void textureSetting(TetrisTexture currentTexture) {
		
		backgroundSetting(currentTexture);
		fontSetting(currentTexture);
		wordsSetting(currentTexture);
		
	}
	
	private void backgroundSetting(TetrisTexture currentTexture) {
		
		gameBackground = new BufferedImage[LEVEL_TOP];
		darkGameBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			try {
				gameBackground[i] = ImageIO.read(LevelBoard.class.getResource(currentTexture.getGameBackgroundPath(i)));
				darkGameBackground[i] = ImageIO.read(LevelBoard.class.getResource(currentTexture.getDarkGameBackgroundPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		levelAreaBackground = new BufferedImage[LEVEL_TOP];

		for(int i = 0; i < LEVEL_TOP; i++) {
			levelAreaBackground[i] = darkGameBackground[i].getSubimage(BLOCK_PIXEL * 10, BLOCK_PIXEL * 7, TetrisView.BOARD_WIDTH + BLOCK_PIXEL * 4, BLOCK_PIXEL * 7);
		}
		
	}
	
	private void fontSetting(TetrisTexture currentTexture) {
		
		try {
			blueAlphabetRead = ImageIO.read(LevelBoard.class.getResource(currentTexture.getBlueAlphabetPath()));
			grayNumberRead = ImageIO.read(LevelBoard.class.getResource(currentTexture.getGrayNumberPath()));
			graySelect = ImageIO.read(LevelBoard.class.getResource(currentTexture.getGraySelectPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		blueAlphabets = new BufferedImage[26];
		grayNumbers = new BufferedImage[10];
		
		for(int i = 0; i < 26; i++) {
			blueAlphabets[i] = blueAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			if(i < 10) {
				grayNumbers[i] = grayNumberRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			}
		}
		
	}
	
	private void wordsSetting(TetrisTexture currentTexture) {
		
		blueLevelSelect = getFontOfWord(LEVEL_SELECT);
		
	}
	
	private BufferedImage[] getFontOfWord(String word) {
		
		int intA = 'A';
		BufferedImage[] wordImages = new BufferedImage[word.length()];
		
		for(int i = 0; i < word.length(); i++) {
			wordImages[i] = blueAlphabets[word.charAt(i) - intA];
		}
		
		return wordImages;
		
	}
	
	public int getSelect() {
		
		return select;
		
	}
	
	public void setSelect(int select) {
		
		this.select = select;
		
	}
	
	public void selectUp() {
		
		if(select < 15) {
			select++;
		} else {
			select = 1;
		}
	
	}
	
	public void selectDown() {
		
		if(select > 1) {
			select--;
		} else {
			select = 15;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		int boardX = BLOCK_PIXEL * 10;
		int boardY = BLOCK_PIXEL * 7;
		
		super.paintComponent(g);
		drawBackground(g, boardX, boardY);
		drawLevelArea(g, boardX, boardY);
		
	}
	
	private void drawBackground(Graphics g, int boardX, int boardY) {
		
		g.drawImage(gameBackground[select - 1], 0, 0, null);
		g.drawImage(levelAreaBackground[select - 1], boardX, boardY, null);
		
	}
	
	private void drawLevelArea(Graphics g, int boardX, int boardY) {
	
		int adjust = 0;
		int needSpacing = 5;
				
		for(int i = 0; i < LEVEL_SELECT.length(); i++) {
			if(i == needSpacing) {
				adjust++;
			}
			g.drawImage(blueLevelSelect[i], boardX + BLOCK_PIXEL * (i + 2 + adjust), boardY + BLOCK_PIXEL + 15, null);
		}
		
		String strLevel = Integer.toString(select);
		BufferedImage[] grayLevelNumber = getFontOfNumber(strLevel);
		
		for(int i = 0; i < strLevel.length(); i++) {
			g.drawImage(grayLevelNumber[i], boardX + (i + 9) * BLOCK_PIXEL - 15, boardY + BLOCK_PIXEL * 4, null);
		}
		
		g.drawImage(graySelect, boardX + BLOCK_PIXEL * 6 - 15, boardY + BLOCK_PIXEL * 4, null);
		
	}
	
	private BufferedImage[] getFontOfNumber(String number) {
		
		int Zero = '0';
		BufferedImage[] numberImages = new BufferedImage[number.length()];
		
		for(int i = 0; i < number.length(); i++) {
			numberImages[i] = grayNumbers[number.charAt(i) - Zero];
		}
		
		return numberImages;
		
	}
	
}