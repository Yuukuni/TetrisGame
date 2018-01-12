package View.TetrisWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.TetrisBlock;
import Model.TetrisGame;
import View.TetrisView;
import View.Texture.*;

public class TetrisBoard extends JPanel { 
	
	private static final long serialVersionUID = 1L;
	
	private static final int LEVEL_TOP = 15;
	private static final int BLOCK_KINDS = 8;
	private static final int BLOCK_PIXEL = 30;	
	
	private static final int WIDTH_BLOCKS = 12;
	private static final int HEIGHT_BLOCKS = 23;
	
	private static final String CONTINUE = "CONTINUE";
	private static final String RESTART = "RESTART";
	private static final String QUIT = "QUIT";
	private static final String GAMEOVER = "GAMEOVER";
	
	private static final String GRAY = "GRAY";
	private static final String BLUE = "BLUE";
	private static final String RED = "RED";
	
	private static final int[] selectionY = { 
			BLOCK_PIXEL * 8, 
			BLOCK_PIXEL * 10, 
			BLOCK_PIXEL * 12 
		};
	
	private int level;
	
	private TetrisBlock currentBlock;
	private int[][] board;
	
	private boolean isPausing;
	private int pauseSelect;
	
	private boolean gameover;
	private boolean gameoverEntered;
	private int gameoverSelect;
	
	private BufferedImage[] darkGameBackground;
	private BufferedImage[] tetrisBoardBackground;
	
	private BufferedImage[] blocks;
	private boolean drawLine;
	
	private BufferedImage grayAlphabetRead;
	private BufferedImage blueAlphabetRead;
	private BufferedImage redAlphabetRead;
	
	private BufferedImage[] grayAlphabets;
	private BufferedImage[] blueAlphabets;
	private BufferedImage[] redAlphabets;

	private BufferedImage redSelect;
	
	private BufferedImage[] grayContinue;
	private BufferedImage[] grayRestart;
	private BufferedImage[] grayQuit;
	
	private BufferedImage[] redContinue;
	private BufferedImage[] redRestart;
	private BufferedImage[] redQuit;
	
	private BufferedImage[] blueGameover;
	private BufferedImage blueExclamationPoint;
	
	public TetrisBoard(TetrisTexture currentTexture, int startLevel, TetrisBlock firstBlock) {
		
		init(startLevel, firstBlock);
		textureSetting(currentTexture);
		
	}
	
	private void init(int startLevel, TetrisBlock firstBlock) {
		
		level = startLevel;
		currentBlock = firstBlock;
		
		isPausing = false;
		gameover = false;
		gameoverEntered = false;
		
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
		
	}
	
	private void textureSetting(TetrisTexture currentTexture) {
		
		blocksSetting(currentTexture);
		backgroundSetting(currentTexture);
		fontSetting(currentTexture);
		wordsSetting(currentTexture);
		
	}
	
	private void blocksSetting(TetrisTexture currentTexture) {
		
		blocks = new BufferedImage[BLOCK_KINDS];
		
		for(int i = 0; i < (BLOCK_KINDS); i++) {
			try {
				blocks[i] = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getBlocksPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		drawLine = currentTexture.getDrawLine();
		
	}
	
	private void backgroundSetting(TetrisTexture currentTexture) {
		
		darkGameBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			try {
				darkGameBackground[i] = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getDarkGameBackgroundPath(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		tetrisBoardBackground = new BufferedImage[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			tetrisBoardBackground[i] = darkGameBackground[i].getSubimage(TetrisView.BOARD_WIDTH, 0, TetrisView.BOARD_WIDTH, TetrisView.BOARD_HEIGHT);
		}
		
	}
	
	private void fontSetting(TetrisTexture currentTexture) {
		
		try {
			grayAlphabetRead = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getGrayAlphabetPath()));
			blueAlphabetRead = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getBlueAlphabetPath()));
			redAlphabetRead = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getRedAlphabetPath()));
			redSelect = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getRedSelectPath()));
			blueExclamationPoint = ImageIO.read(TetrisBoard.class.getResource(currentTexture.getBlueExclamationPointPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		grayAlphabets = new BufferedImage[26];
		blueAlphabets = new BufferedImage[26];
		redAlphabets = new BufferedImage[26];
		
		for(int i = 0; i < 26; i++) {
			grayAlphabets[i] = grayAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			blueAlphabets[i] = blueAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			redAlphabets[i] = redAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
		}
		
	}
    
	private void wordsSetting(TetrisTexture currentTexture) {
		
		grayContinue = getFontOfWord(CONTINUE, GRAY);
		grayRestart = getFontOfWord(RESTART, GRAY);
		grayQuit = getFontOfWord(QUIT, GRAY);
		
		redContinue = getFontOfWord(CONTINUE, RED);
		redRestart = getFontOfWord(RESTART, RED);
		redQuit = getFontOfWord(QUIT, RED);
		
		blueGameover = getFontOfWord(GAMEOVER, BLUE);
		
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
	
    public void setLevel(int level) {
    	
    	this.level = level;
    	
    }
    
    public TetrisBlock getCurrentBlock() {
    	
    	return currentBlock;
    	
    }
    
	public void setCurrentBlock(TetrisBlock currentBlock) {
		
		this.currentBlock = currentBlock;
	
	}
	
	public void setBoard(int[][] board) {
		
		this.board = board;
		
	}
	
	public void setPause(boolean b) {
		
		isPausing = b;
		pauseSelect = 0;
		
	}
	
	public int getPauseSelect() {
		
		return pauseSelect;
		
	}
	
	public void pauseSelectUp() {
		
		if(pauseSelect > 0) {
			pauseSelect--;
		} else {
			pauseSelect = 2;
		}
		
	}
	
	public void pauseSelectDown() {
		
		if(pauseSelect < 2) {
			pauseSelect++;
		} else {
			pauseSelect = 0;
		}
	
	}
	
	public void gameover() {
		
		gameover = true;
		
	}
	
	public void gameoverEntered() {
		
		gameoverEntered = true;
		gameoverSelect = 0;
		
	}
	
	public int getGameoverSelect() {
		
		return gameoverSelect;
		
	}
	
	public void gameoverSelectChange() {
		
		if(gameoverSelect == 0) {
			gameoverSelect = 1;
		}
		else {
			gameoverSelect = 0;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		drawBackground(g);
		
		if(!gameover) {
			drawBoard(g);
			drawCurrentBlock(g);
		}
		else {
			drawBoardForGameover(g);
			drawCurrentBlockForGameover(g);
			drawGameoverArea(g);
		}
		
		if(drawLine) {
			drawLines(g);
		}
		
		if(isPausing) {
			drawPauseArea(g);
		}

	}
	
	private void drawBackground(Graphics g) {
		
		g.drawImage(tetrisBoardBackground[level - 1], 0, 0, null);
		
	}
	
	private void drawBoard(Graphics g) {
		
		for(int i = 0; i < WIDTH_BLOCKS; i++){
			for(int j = 2; j < HEIGHT_BLOCKS; j++){
				int theKind = board[i][j];
				if(theKind < BLOCK_KINDS) {
					g.drawImage(blocks[theKind], i * BLOCK_PIXEL, (j - 2) * BLOCK_PIXEL, null);
				}
			}
		}

	}
	
	private void drawCurrentBlock(Graphics g) {
		
		int x = currentBlock.getPosition().x;
		int y = currentBlock.getPosition().y;

		for(Point p : currentBlock.getShape()) {
			g.drawImage(blocks[currentBlock.getKind()], (x + p.x) * BLOCK_PIXEL, (y + p.y - 2) * BLOCK_PIXEL, null);
		}
		
	}
	
	private void drawBoardForGameover(Graphics g) {
		
		for(int i = 0; i < WIDTH_BLOCKS; i++){
			for(int j = 2; j < HEIGHT_BLOCKS; j++){
				int theKind = board[i][j];
				if(theKind < BLOCK_KINDS) {
					g.drawImage(blocks[BLOCK_KINDS - 1], i * BLOCK_PIXEL, (j - 2) * BLOCK_PIXEL, null);
				}
			}
		}
		
	}
	
	private void drawCurrentBlockForGameover(Graphics g) {
		
		int x = currentBlock.getPosition().x;
		int y = currentBlock.getPosition().y;
		
		for(Point p : currentBlock.getShape()) {
			g.drawImage(blocks[BLOCK_KINDS - 1], (x + p.x) * BLOCK_PIXEL, (y + p.y - 2) * BLOCK_PIXEL, null);
		}
		
	}
	
	private void drawGameoverArea(Graphics g) {
		
		if(!gameoverEntered) {
			for(int i = 0; i < GAMEOVER.length(); i++) {
				g.drawImage(blueGameover[i], BLOCK_PIXEL * (i + 1), BLOCK_PIXEL * 10, null);
				if(i == GAMEOVER.length() - 1) {
					g.drawImage(blueExclamationPoint, BLOCK_PIXEL * (i + 3), BLOCK_PIXEL * 10, null);
				}
			}
		}
		else {
			switch(gameoverSelect) {
			case 0:
				g.drawImage(redSelect, BLOCK_PIXEL * 1, BLOCK_PIXEL * 9, null);
				for(int i = 0; i < RESTART.length(); i++) {
					g.drawImage(redRestart[i], BLOCK_PIXEL * (i + 4), BLOCK_PIXEL * 9, null);
				}
				for(int i = 0; i < QUIT.length(); i++) {
					g.drawImage(grayQuit[i], BLOCK_PIXEL * (i + 4), BLOCK_PIXEL * 11, null);
				}
				break;
			case 1:
				g.drawImage(redSelect, BLOCK_PIXEL * 1, BLOCK_PIXEL * 11, null);
				for(int i = 0; i < RESTART.length(); i++) {
					g.drawImage(grayRestart[i], BLOCK_PIXEL * (i + 4), BLOCK_PIXEL * 9, null);
				}
				for(int i = 0; i < QUIT.length(); i++) {
					g.drawImage(redQuit[i], BLOCK_PIXEL * (i + 4), BLOCK_PIXEL * 11, null);
				}
				break;
			}
		}
		
	}
	
	private void drawLines(Graphics g) {
		
		g.setColor(Color.GRAY);
		
		for(int i = 0; i < TetrisGame.WIDTH_BLOCKS + 1; i++) {
			g.drawLine(i * BLOCK_PIXEL, 0, i * BLOCK_PIXEL, HEIGHT_BLOCKS * BLOCK_PIXEL);
		}
		
		for(int i = 0; i < TetrisGame.HEIGHT_BLOCKS - 1; i++){
			g.drawLine(0, i * BLOCK_PIXEL, WIDTH_BLOCKS * BLOCK_PIXEL, i * BLOCK_PIXEL);
		}
		
	}
	
	private void drawPauseArea(Graphics g) {
		
		g.drawImage(redSelect, BLOCK_PIXEL * 1, selectionY[pauseSelect], null);
		
		switch(pauseSelect) {
		case 0:
			for(int i = 0; i < CONTINUE.length(); i++) {
				g.drawImage(redContinue[i], BLOCK_PIXEL * (i + 3), selectionY[0], null);
			}
			for(int i = 0; i < RESTART.length(); i++) {
				g.drawImage(grayRestart[i], BLOCK_PIXEL * (i + 3), selectionY[1], null);
			}
			for(int i = 0; i < QUIT.length(); i++) {
				g.drawImage(grayQuit[i], BLOCK_PIXEL * (i + 3), selectionY[2], null);
			}
			break;
			
		case 1:
			for(int i = 0; i < CONTINUE.length(); i++) {
				g.drawImage(grayContinue[i], BLOCK_PIXEL * (i + 3), selectionY[0], null);
			}
			for(int i = 0; i < RESTART.length(); i++) {
				g.drawImage(redRestart[i], BLOCK_PIXEL * (i + 3), selectionY[1], null);
			}
			for(int i = 0; i < QUIT.length(); i++) {
				g.drawImage(grayQuit[i], BLOCK_PIXEL * (i + 3), selectionY[2], null);
			}
			break;
			
		case 2:
			for(int i = 0; i < CONTINUE.length(); i++) {
				g.drawImage(grayContinue[i], BLOCK_PIXEL * (i + 3), selectionY[0], null);
			}
			for(int i = 0; i < RESTART.length(); i++) {
				g.drawImage(grayRestart[i], BLOCK_PIXEL * (i + 3), selectionY[1], null);
			}
			for(int i = 0; i < QUIT.length(); i++) {
				g.drawImage(redQuit[i], BLOCK_PIXEL * (i + 3), selectionY[2], null);
			}
			break;
		}
		
	}

}
