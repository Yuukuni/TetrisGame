package View;

import java.util.ArrayList;

import javax.swing.JFrame;

import Model.TetrisBlock;
import Model.TetrisGame;
import View.LevelWindow.LevelBoard;
import View.MenuWindow.MenuBoard;
import View.SettingWindow.SettingBoard;
import View.TetrisWindow.PreviewBoard;
import View.TetrisWindow.ScoreBoard;
import View.TetrisWindow.TetrisBoard;
import View.TetrisWindow.TetrisViewSetting;
import View.Texture.*;

public class TetrisView {
	
	private static final int BLOCK_PIXEL = 30;	
	public static final int BOARD_WIDTH = TetrisGame.WIDTH_BLOCKS * BLOCK_PIXEL + 1;
	public static final int BOARD_HEIGHT = (TetrisGame.HEIGHT_BLOCKS - 2) * BLOCK_PIXEL + 1;
	public static final int WINDOW_WIDTH = BOARD_WIDTH * 3;
	public static final int WINDOW_HEIGHT = BOARD_HEIGHT + BLOCK_PIXEL;
	
	private JFrame window;
	
	private MenuBoard menuBoard;
	private LevelBoard levelBoard;
	private TetrisBoard tetrisBoard;
	private PreviewBoard previewBoard; 
	private ScoreBoard scoreBoard;
	private SettingBoard settingBoard;
	
	private TetrisTexture[] tetrisTextures;
	private TetrisTexture currentTexture;
	private enum TextureName { B10401020, B10401023, B10404011, B10415007, F10615001 };

	public TetrisView() {
		
		textureSetting(TextureName.B10401020);
		windowSetting();
		
	}
	
	private void textureSetting(TextureName textureName) {

		tetrisTextures = new TetrisTexture[5];
		
		tetrisTextures[0] = new TetrisTexture_B10401020();
		tetrisTextures[1] = new TetrisTexture_B10401023();
		tetrisTextures[2] = new TetrisTexture_B10404011();
		tetrisTextures[3] = new TetrisTexture_B10415007();
		tetrisTextures[4] = new TetrisTexture_F10615001();

		currentTexture = tetrisTextures[textureName.ordinal()];
		
	}
	
	public void windowSetting() {
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		window.setLayout(null);
		
	}
	
	public MenuBoard getMenuBoard() {
		
		return menuBoard;
		
	}
	
	public LevelBoard getLevelBoard() {
		
		return levelBoard;
		
	}
	
	public TetrisBoard getTetrisBoard() {
		
		return tetrisBoard;
		
	}
	
	public SettingBoard getSettingBoard() {
		
		return settingBoard;
		
	}
	
	public void openMenuWindow() {
		
		menuBoard = new MenuBoard(currentTexture);
		menuBoard.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		menuBoard.setLayout(null);
		
		window.add(menuBoard);
		window.setTitle("Tetris Menu");
		window.setVisible(true);
		
	}
	
	public void closeMenuWindow() {
		
		menuBoard.setVisible(false);
		window.remove(menuBoard);
		
	}
	
	public void openLevelWindow() {
		
		levelBoard = new LevelBoard(currentTexture);
		levelBoard.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		levelBoard.setLayout(null);
		
		window.add(levelBoard);
		window.setTitle("Level Select");
		window.setVisible(true);
		
	}
	
	public void closeLevelWindow() {
		
		levelBoard.setVisible(false);
		window.remove(levelBoard);
		
	}
	
	public void openTetrisWindow(TetrisViewSetting initSetting) {
		
		tetrisBoard = new TetrisBoard(currentTexture, initSetting.getStartLevel(), initSetting.getFirstBlock());
		tetrisBoard.setBounds(BOARD_WIDTH * 1, 0, BOARD_WIDTH, BOARD_HEIGHT);
		tetrisBoard.setLayout(null);
		
		previewBoard = new PreviewBoard(currentTexture, initSetting.getStartLevel(), initSetting.getFirstBlocks());
		previewBoard.setBounds(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		previewBoard.setLayout(null);
		
		scoreBoard = new ScoreBoard(currentTexture, initSetting.getStartLevel());
		scoreBoard.setBounds(BOARD_WIDTH * 2, 0, BOARD_WIDTH, BOARD_HEIGHT);
		scoreBoard.setLayout(null);
		
		window.add(tetrisBoard);
		window.add(previewBoard);
		window.add(scoreBoard);
		window.setTitle("Tetris Gaming");
		window.setVisible(true);
		
	}
	
	public void closeTetrisWindow() {
		
		tetrisBoard.setVisible(false);
		previewBoard.setVisible(false);
		scoreBoard.setVisible(false);
		
		window.remove(tetrisBoard);
		window.remove(previewBoard);
		window.remove(scoreBoard);
		
	}
	
	public void openSettingWindow(int[] keyCode) {
		
		settingBoard = new SettingBoard(currentTexture, keyCode);
		settingBoard.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		settingBoard.setLayout(null);
		
		window.add(settingBoard);
		window.setTitle("Setting");
		window.setVisible(true);
		
	}
	
	public void closeSettingWindow() {
		
		settingBoard.setVisible(false);
		window.remove(settingBoard);
		
	}
	
	public int getMenuSelect() {
		
		return menuBoard.getSelect();
		
	}
	
	public void menuSelectUp() {
		
		menuBoard.selectUp();
		menuBoard.repaint();
		
	}
	
	public void menuSelectDown() {
		
		menuBoard.selectDown();
		menuBoard.repaint();
		
	}
	
	public int getLevelSelect() {
		
		return levelBoard.getSelect();
		
	}
	
	public void setLevelSelect(int select) {
		
		levelBoard.setSelect(select);
		
	}
	
	public void levelSelectUp() {
		
		levelBoard.selectUp();
		levelBoard.repaint();
	
	}
	
	public void levelSelectDown() {
		
		levelBoard.selectDown();
		levelBoard.repaint();
		
	}
	
	public int getLevel() {
		
		return scoreBoard.getLevel();
		
	}
	
	public TetrisBlock getCurrentBlock() {
		
		return tetrisBoard.getCurrentBlock();
		
	}
	
	public void setPause(boolean b) {
		
		tetrisBoard.setPause(b);
		tetrisBoard.repaint();
		
	}
	
	public int getPauseSelect() {
		
		return tetrisBoard.getPauseSelect();
		
	}

	public void pauseSelectUp() {
		
		tetrisBoard.pauseSelectUp();
		tetrisBoard.repaint();
		
	}
	
	public void pauseSelectDown() {
		
		tetrisBoard.pauseSelectDown();
		tetrisBoard.repaint();
		
	}
	
	public void gameover() {
		
		tetrisBoard.gameover();
		tetrisBoard.repaint();
		
	}
	
	public void gameoverEntered() {
		
		tetrisBoard.gameoverEntered();
		tetrisBoard.repaint();
		
	}
	
	public int getGameoverSelect() {
		
		return tetrisBoard.getGameoverSelect();
		
	}
	
	public void gameoverSelectChange() {
		
		tetrisBoard.gameoverSelectChange();
		tetrisBoard.repaint();
		
	}
	
	public int getSettingSelect() {
		
		return settingBoard.getSelect();
		
	}
	
	public void settingSelectUp() {
		
		settingBoard.selectUp();
		settingBoard.repaint();
		
	}
	
	public void settingSelectDown() {
		
		settingBoard.selectDown();
		settingBoard.repaint();
		
	}
	
	public boolean getSelectEntered() {
		
		return settingBoard.getSelectEntered();
		
	}
	
	public void settingSelectEntered() {
		
		settingBoard.selectEntered();
		settingBoard.repaint();
		
	}
	
	public void settingKeyEntered() {
		
		settingBoard.keyEntered();
		settingBoard.repaint();
		
	}
	
	public int[] getkeyCode() {
		
		return settingBoard.getKeyCode();
		
	}
	
	public void setKey(int[] keyCode) {
		
		settingBoard.setKey(keyCode);
		
	}
	
	public void setKey(int i, int keyCode) {
		
		settingBoard.setKey(i, keyCode);
		
	}
	
	public void repaintTetrisBoard(TetrisBlock currentBlock, int[][] board) {	
		
		tetrisBoard.setCurrentBlock(currentBlock);
		tetrisBoard.setBoard(board);
		tetrisBoard.repaint();
		
	}
	
	public void repaintPreviewBoard(ArrayList<Integer> currentBlocks) {
		
		previewBoard.setCurrentBlocks(currentBlocks);
		previewBoard.repaint();
		
	}

	public void repaintScoreBoard(int score, int line) {
		
		scoreBoard.setScore(score);
		scoreBoard.setLine(line);
		scoreBoard.repaint();
		
	}
	
	public void setLevel(int level) {
		
		tetrisBoard.setLevel(level);
		previewBoard.setLevel(level);
		scoreBoard.setLevel(level);
		
	}
	
}