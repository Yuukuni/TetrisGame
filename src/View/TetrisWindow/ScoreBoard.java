package View.TetrisWindow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import View.TetrisView;
import View.Texture.TetrisTexture;

public class ScoreBoard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final int LEVEL_TOP = 15;
	private static final int BLOCK_PIXEL = 30;
	
	private static final String LEVEL = "LEVEL";
	private static final String SCORE = "SCORE";
	private static final String LINE = "LINE";
	private static final String MAX = "MAX";
	
	private static final String BLUE = "BLUE";
	private static final String RED = "RED";
	
	private int level;
	private int score;
	private int line;
	
	private BufferedImage[] gameBackground;
	private BufferedImage[] darkGameBackground;
	
	private BufferedImage[] scoreBoardBackground;
	private BufferedImage[] levelAreaBackground;
	private BufferedImage[] scoreAreaBackground;
	private BufferedImage[] lineAreaBackground;
	
	private BufferedImage blueAlphabetRead;
	private BufferedImage redAlphabetRead;
	private BufferedImage grayNumberRead;
	
	private BufferedImage[] blueAlphabets;
	private BufferedImage[] redAlphabets;
	private BufferedImage[] grayNumbers;
	
	private BufferedImage[] blueLevel;
	private BufferedImage[] blueScore;
	private BufferedImage[] blueLine;
	private BufferedImage[] redMax;
	
	public ScoreBoard(TetrisTexture currentTexture, int startLevel) {
		
		init(startLevel);
		textureSetting(currentTexture);
		
	}
	
	private void init(int startLevel) {
		
		level = startLevel;
		score = 0;
		line = 0;
		
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
				gameBackground[i] = ImageIO.read(ScoreBoard.class.getResource(currentTexture.getGameBackgroundPath(i)));
				darkGameBackground[i] = ImageIO.read(ScoreBoard.class.getResource(currentTexture.getDarkGameBackgroundPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		scoreBoardBackground = new BufferedImage[LEVEL_TOP];
		scoreAreaBackground = new BufferedImage[LEVEL_TOP];
		lineAreaBackground = new BufferedImage[LEVEL_TOP];
		levelAreaBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			scoreBoardBackground[i] = gameBackground[i].getSubimage(TetrisView.BOARD_WIDTH * 2, 0, TetrisView.BOARD_WIDTH, TetrisView.BOARD_HEIGHT);
			scoreAreaBackground[i] = darkGameBackground[i].getSubimage(TetrisView.BOARD_WIDTH * 2 + BLOCK_PIXEL * 2, BLOCK_PIXEL * 2, BLOCK_PIXEL * 8, BLOCK_PIXEL * 4);
			lineAreaBackground[i] = darkGameBackground[i].getSubimage(TetrisView.BOARD_WIDTH * 2 + BLOCK_PIXEL * 2, BLOCK_PIXEL * 15 / 2, BLOCK_PIXEL * 8, BLOCK_PIXEL * 4);
			levelAreaBackground[i] = darkGameBackground[i].getSubimage(TetrisView.BOARD_WIDTH * 2 + BLOCK_PIXEL * 2, BLOCK_PIXEL * 13, BLOCK_PIXEL * 8, BLOCK_PIXEL * 4);
		}
		
	}
	
	private void fontSetting(TetrisTexture currentTexture) {
		
		try {
			blueAlphabetRead = ImageIO.read(ScoreBoard.class.getResource(currentTexture.getBlueAlphabetPath()));
			redAlphabetRead = ImageIO.read(ScoreBoard.class.getResource(currentTexture.getRedAlphabetPath()));
			grayNumberRead = ImageIO.read(ScoreBoard.class.getResource(currentTexture.getGrayNumberPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		blueAlphabets = new BufferedImage[26];
		redAlphabets = new BufferedImage[26];
		grayNumbers = new BufferedImage[10];
		
		for(int i = 0; i < 26; i++) {
			blueAlphabets[i] = blueAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			redAlphabets[i] = redAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			if(i < 10) {
				grayNumbers[i] = grayNumberRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			}
		}
		
	}
	
	private void wordsSetting(TetrisTexture currentTexture) {
		
		blueLevel = getFontOfWord(LEVEL, BLUE);
		blueScore = getFontOfWord(SCORE, BLUE);
		blueLine = getFontOfWord(LINE, BLUE);
		redMax = getFontOfWord(MAX, RED);
		
	}
	
	private BufferedImage[] getFontOfWord(String word, String color) {
		
		int intA = 'A';
		BufferedImage[] wordImages = new BufferedImage[word.length()];
		
		switch(color) {
		case BLUE:
			for(int i = 0; i < word.length(); i++) {
				wordImages[i] = blueAlphabets[word.charAt(i) - intA];
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
	
	public int getLevel() {
		
		return level;
		
	}
	
	public void setLevel(int level) {
		
		this.level = level;
		
	}
	
	public void setScore(int score) {
		
		this.score = score;
		
	}
	
	public void setLine(int line) {
		
		this.line = line;
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		drawBackground(g);
		drawWords(g);
		drawData(g);
		
	}
	
	private void drawBackground(Graphics g) {
		
		g.drawImage(scoreBoardBackground[level - 1], 0, 0, null);
		g.drawImage(scoreAreaBackground[level - 1], BLOCK_PIXEL * 2, BLOCK_PIXEL * 2, null);
		g.drawImage(lineAreaBackground[level - 1], BLOCK_PIXEL * 2, BLOCK_PIXEL * 15 / 2, null);
		g.drawImage(levelAreaBackground[level - 1], BLOCK_PIXEL * 2, BLOCK_PIXEL * 13, null);
		
	}
	
	private void drawWords(Graphics g) {
		
		for(int i = 0; i < SCORE.length(); i++) {
			g.drawImage(blueScore[i], BLOCK_PIXEL * (i + 4) - 15, BLOCK_PIXEL * 5 / 2, null);
		}
		for(int i = 0; i < LINE.length(); i++) {
			g.drawImage(blueLine[i], BLOCK_PIXEL * (i + 4), BLOCK_PIXEL * 8, null);
		}
		for(int i = 0; i < LEVEL.length(); i++) {
			g.drawImage(blueLevel[i], BLOCK_PIXEL * (i + 4) - 15, BLOCK_PIXEL * 27 / 2, null);
		}
		
	}
	
	private void drawData(Graphics g) {
		
		drawScore(g);
		drawLine(g);
		drawLevel(g);
		
	}
	
	private void drawScore(Graphics g) {
		
		String strScore = Integer.toString(score);
		BufferedImage[] grayScoreNumber = getFontOfNumber(strScore);
		
		for(int i = 0; i < strScore.length(); i++) {
			int adjust = 9 - strScore.length();
			g.drawImage(grayScoreNumber[i], BLOCK_PIXEL * (i + adjust), BLOCK_PIXEL * 9 / 2, null);
		}
		
	}
	
	private void drawLine(Graphics g) {
		
		String strLine = Integer.toString(line);
		BufferedImage[] grayLineNumber =  getFontOfNumber(strLine);
		
		for(int i = 0; i < strLine.length(); i++) {
			int adjust = 7 - strLine.length();
			g.drawImage(grayLineNumber[i], BLOCK_PIXEL * (i + adjust) + 15, BLOCK_PIXEL * 10, null);
		}
		
	}
	
	private void drawLevel(Graphics g) {
		
		String strLevel = Integer.toString(level);
		BufferedImage[] grayLevelNumber = getFontOfNumber(strLevel);
		
		if(level == LEVEL_TOP) {
			for(int i = 0; i < MAX.length(); i++) {
				int adjust = 7 - MAX.length();
				g.drawImage(redMax[i], BLOCK_PIXEL * (i + adjust) + 10, BLOCK_PIXEL * 31 / 2, null);
			}
		} 
		else {
			for(int i = 0; i < strLevel.length(); i++) {
				int adjust = 7 - strLevel.length();
				g.drawImage(grayLevelNumber[i], BLOCK_PIXEL * (i + adjust), BLOCK_PIXEL * 31 / 2, null);
			}
		}
		
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