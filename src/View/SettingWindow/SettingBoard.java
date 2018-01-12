package View.SettingWindow;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import View.TetrisView;
import View.MenuWindow.MenuBoard;
import View.Texture.TetrisTexture;

public class SettingBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int KEY_AMOUNT = 6;
	private static final int ITEM_AMOUNT = 8;
	private static final int BLOCK_PIXEL = 30;
	
	private static final String ROTATE = "ROTATE";
	private static final String MOVE_LEFT = "MOVE LEFT";
	private static final String MOVE_RIGHT = "MOVE RIGHT";
	private static final String DROP = "DROP";
	private static final String DROP_DOWN = "DROP DOWN";
	private static final String PAUSE = "PAUSE";
	private static final String SAVE_AND_EXIT = "SAVE AND EXIT";
	private static final String CANCEL = "CANCEL";
	
	private static final String GRAY = "GRAY";
	private static final String RED = "RED";
	
	private static final int[] selectY = {
			BLOCK_PIXEL * 5 / 2,
			BLOCK_PIXEL * 9 / 2,
			BLOCK_PIXEL * 13 / 2,
			BLOCK_PIXEL * 17 / 2,
			BLOCK_PIXEL * 21 / 2,
			BLOCK_PIXEL * 25 / 2,
			BLOCK_PIXEL * 29 / 2,
			BLOCK_PIXEL * 33 / 2
	};
	
	private static final int selectX = selectY[0] + 10;
	
	private int select;
	
	private boolean selectEntered;
	
	private int[] keyCode;
	private String[] key;
	
	private BufferedImage background;
	private BufferedImage darkBackground;
	private BufferedImage[] settingAreaBackgrounds;
	
	private BufferedImage grayAlphabetRead;
	private BufferedImage redAlphabetRead;
	private BufferedImage grayNumberRead;
	private BufferedImage redNumberRead;
	
	private BufferedImage[] grayAlphabets;
	private BufferedImage[] redAlphabets;
	private BufferedImage[] grayNumbers;
	private BufferedImage[] redNumbers;
	
	private BufferedImage redSelect;
	
	private BufferedImage grayPlus;
	private BufferedImage grayMinus;
	private BufferedImage grayMultiplication;
	private BufferedImage grayDivision;
	private BufferedImage grayPoint;
	
	private BufferedImage redPlus;
	private BufferedImage redMinus;
	private BufferedImage redMultiplication;
	private BufferedImage redDivision;
	private BufferedImage redPoint;
	
	private BufferedImage space;
	
	private BufferedImage[][] grayKey;
	private BufferedImage[] graySaveAndExit;
	private BufferedImage[] grayCancel;
	
	private BufferedImage[][] redKey;
	private BufferedImage[] redSaveAndExit;
	private BufferedImage[] redCancel;
	
	public SettingBoard(TetrisTexture currentTexture, int[] keyCode) {
		
		init(keyCode);
		textureSetting(currentTexture);
		
	}
	
	private void init(int[] keyCode) {
		
		select = 0;
		selectEntered = false;
		this.keyCode = keyCode;
		
		key = new String[KEY_AMOUNT];
		
		for(int i = 0; i < KEY_AMOUNT; i++) {
			this.key[i] = KeyEvent.getKeyText(keyCode[i]);
		}
		
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
		
		settingAreaBackgrounds = new BufferedImage[ITEM_AMOUNT];
		
		for(int i = 0; i < ITEM_AMOUNT; i++) {
			settingAreaBackgrounds[i] = darkBackground.getSubimage(selectX, selectY[i], TetrisView.BOARD_WIDTH * 5 / 2, BLOCK_PIXEL * 3 / 2);
		}
		
	}

	private void fontSetting(TetrisTexture currentTexture) {
		
		try {
			grayAlphabetRead = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayAlphabetPath()));
			redAlphabetRead = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedAlphabetPath()));
			grayNumberRead = ImageIO.read(SettingBoard.class.getResource(currentTexture.getGrayNumberPath()));
			redNumberRead = ImageIO.read(SettingBoard.class.getResource(currentTexture.getRedNumberPath()));
			
			redSelect = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedSelectPath()));
			
			grayPlus = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayPlus()));
			grayMinus = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayMinus()));
			grayMultiplication = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayMultiplication()));
			grayDivision = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayDivision()));
			grayPoint = ImageIO.read(MenuBoard.class.getResource(currentTexture.getGrayPoint()));
			
			redPlus = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedPlus()));
			redMinus = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedMinus()));
			redMultiplication = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedMultiplication()));
			redDivision = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedDivision()));
			redPoint = ImageIO.read(MenuBoard.class.getResource(currentTexture.getRedPoint()));
			
			space = ImageIO.read(MenuBoard.class.getResource(currentTexture.getSpace()));		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		grayAlphabets = new BufferedImage[26];
		redAlphabets = new BufferedImage[26];
		grayNumbers = new BufferedImage[10];
		redNumbers = new BufferedImage[10];
		
		for(int i = 0; i < 26; i++) {
			grayAlphabets[i] = grayAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			redAlphabets[i] = redAlphabetRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			if(i < 10) {
				grayNumbers[i] = grayNumberRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
				redNumbers[i] = redNumberRead.getSubimage(i * BLOCK_PIXEL, 0, BLOCK_PIXEL, BLOCK_PIXEL);
			}
		}
		
	}
	
	private void wordsSetting(TetrisTexture currentTexture) {
		
		grayKey = new BufferedImage[KEY_AMOUNT][];
		grayKey[0] = getFontOfString(ROTATE, GRAY);
		grayKey[1] = getFontOfString(MOVE_LEFT, GRAY);
		grayKey[2] = getFontOfString(MOVE_RIGHT, GRAY);
		grayKey[3] = getFontOfString(DROP, GRAY);
		grayKey[4] = getFontOfString(DROP_DOWN, GRAY);
		grayKey[5] = getFontOfString(PAUSE, GRAY);
		
		graySaveAndExit = getFontOfString(SAVE_AND_EXIT, GRAY);
		grayCancel = getFontOfString(CANCEL, GRAY);
		
		redKey = new BufferedImage[KEY_AMOUNT][];
		redKey[0] = getFontOfString(ROTATE, RED);
		redKey[1] = getFontOfString(MOVE_LEFT, RED);
		redKey[2] = getFontOfString(MOVE_RIGHT, RED);
		redKey[3] = getFontOfString(DROP, RED);
		redKey[4] = getFontOfString(DROP_DOWN, RED);
		redKey[5] = getFontOfString(PAUSE, RED);
		
		redSaveAndExit = getFontOfString(SAVE_AND_EXIT, RED);
		redCancel = getFontOfString(CANCEL, RED);
		
	}
	
	private BufferedImage[] getFontOfString(String input, String color) {
		
		input = input.toUpperCase();
		BufferedImage[] output = new BufferedImage[input.length()];
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				if(color == GRAY) {
					output[i] = grayAlphabets[c - 'A'];
				}
				else if(color == RED) {
					output[i] = redAlphabets[c - 'A'];
				}
			}
			else if(c >= '0' && c <= '9') {
				if(color == GRAY) {
					output[i] = grayNumbers[c - '0'];
				}
				else if(color == RED) {
					output[i] = redNumbers[c - '0'];
				}
			}
			else {
				switch(c) {
				case '+':
					if(color == GRAY) {
						output[i] = grayPlus;
					}
					else if(color == RED) {
						output[i] = redPlus;
					}
					break;
					
				case '-':
					if(color == GRAY) {
						output[i] = grayMinus;
					}
					else if(color == RED){
						output[i] = redMinus;
					}
					break;
					
				case '*':
					if(color == GRAY) {
						output[i] = grayMultiplication;
					}
					else if(color == RED) {
						output[i] = redMultiplication;
					}
					break;
					
				case '/':
					if(color == GRAY) {
						output[i] = grayDivision;
					}
					else if(color == RED) {
						output[i] = redDivision;
					}
					break;
					
				case '.':
					if(color == GRAY) {
						output[i] = grayPoint;
					}
					else if(color == RED) {
						output[i] = redPoint;
					}
					break;
					
				case ' ':
					output[i] = space;
					break;
				}
			}
		}
		return output;
		
	}
	
	public int getSelect() {
		
		return select;
		
	}
	
	public void selectUp() {
		
		if(select > 0) {
			select--;
		}
		else {
			select = ITEM_AMOUNT - 1;
		}
		
	}
	
	public void selectDown() {
		
		if(select < ITEM_AMOUNT - 1) {
			select++;
		}
		else {
			select = 0;
		}
		
	}
	
	public boolean getSelectEntered() {
		
		return selectEntered;
		
	}
	
	public void selectEntered() {
		
		selectEntered = true;
		
	}
	
	public void keyEntered() {
		
		selectEntered = false;
		
	}
	
	public int[] getKeyCode() {
		
		return keyCode;
		
	}
	
	public void setKey(int[] keyCode) {
		
		this.keyCode = keyCode;
		for(int i = 0; i < KEY_AMOUNT; i++) {
			key[i] = KeyEvent.getKeyText(keyCode[i]);
		}
		
	}
	
	public void setKey(int i, int keyCode) {
		
		boolean cannotSet = false;
		
		if(select == 5) {
			if(keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
				cannotSet = true;
			}
		}
		
		for(int j = 0; j < KEY_AMOUNT; j++) {
			if(this.keyCode[j] == keyCode) {
				cannotSet = true;
				break;
			}
		}
		
		if(!cannotSet) {
			this.keyCode[i] = keyCode;
			this.key[i] = KeyEvent.getKeyText(keyCode);	
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		drawBackground(g);
		
		if(selectEntered) {
			drawSelectBackground(g);
		}
		else {
			drawSettingAreaBackgrounds(g);
		}
		
		drawWords(g);
			
	}
	
	private void drawBackground(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		
	}
	
	private void drawSelectBackground(Graphics g) {
		
		g.drawImage(settingAreaBackgrounds[select], selectX, selectY[select], null);
		
	}
	
	private void drawSettingAreaBackgrounds(Graphics g) {
		
		for(int i = 0; i < ITEM_AMOUNT; i++) {
			g.drawImage(settingAreaBackgrounds[i], selectX, selectY[i], null);
		}
		
	}
	
	private void drawWords(Graphics g) {
		
		g.drawImage(redSelect, selectX + BLOCK_PIXEL, selectY[select] + 7, null);
		
		BufferedImage[] currentItem = null;
		BufferedImage[] currentKey = null;
		
		for(int i = 0; i < ITEM_AMOUNT; i++) {
			switch(i) {
			case 0: case 1: case 2: case 3: case 4: case 5:
				if(i == select) {
					currentItem = redKey[i];
					currentKey = getFontOfString(key[i], RED);
				}
				else {
					currentItem = grayKey[i];
					currentKey = getFontOfString(key[i], GRAY);
				}
				for(int j = currentKey.length - 1; j >= 0; j--) {
					int theX = selectX + TetrisView.BOARD_WIDTH * 5 / 2 - BLOCK_PIXEL * (j + 2);
					g.drawImage(currentKey[currentKey.length - 1 - j], theX, selectY[i] + 8, null);
				}
				break;
			case 6:
				if(i == select) {
					currentItem = redSaveAndExit;
				}
				else {
					currentItem = graySaveAndExit;
				}
				break;
			case 7:
				if(i == select) {
					currentItem = redCancel;
				}
				else {
					currentItem = grayCancel;
				}
				break;
			}
			for(int j = 0; j < currentItem.length; j++) {
				g.drawImage(currentItem[j], selectX + BLOCK_PIXEL * (3 + j), selectY[i] + 8, null);
			}
		}
		
	}
	
}