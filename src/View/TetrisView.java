package View;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import View.Texture.*;

public class TetrisView {
	
	private TetrisWindow tetrisWindow;
	
	private TetrisTexture[] tetrisTextures;
	private TetrisTexture currentTexture;
	private enum TextureName { B10401020, B10401023, B10404011, B10415007, F10615001 };

	public TetrisView() {
		
		textureSetting(TextureName.B10415007);
		tetrisWindow = new TetrisWindow(currentTexture);
		tetrisWindow.setVisible(true);
		
	}
	
	private void textureSetting(TextureName texture) {

		tetrisTextures = new TetrisTexture[5];
		
		tetrisTextures[3] = new TetrisTexture_B10415007();
		//tetrisTextures[0] = new TetrisTexture_B10401020();
		//tetrisTextures[1] = new TetrisTexture_B10401023();
		//tetrisTextures[2] = new TetrisTexture_B10404011();
		//tetrisTextures[4] = new TetrisTexture_F10615001();
		
		int current = texture.ordinal();
		currentTexture = tetrisTextures[current];
		
	}
	
	public void addTetrisButtonListeners(ActionListener listenForContinue, ActionListener listenForRestart, ActionListener listenForExit) {
	
		tetrisWindow.addButtonListeners(listenForContinue, listenForRestart, listenForExit);
	
	}
	
	public void addTetrisKeyListener(KeyListener keyListener) {
		
		tetrisWindow.addKeyListener(keyListener);
		
	}
	
	public void repaintTetrisBoard(int[][] board) {	
		
		tetrisWindow.repaintTetrisBoard(board);
		
	}
	
	//Just for testing.
	public static void main(String[] args) {		
		try {
			TetrisView view = new TetrisView();
			int[][] board = new int[12][21];
			
			for(int i = 0; i < TetrisBoard.WIDTH_BLOCKS; i++){
				for(int j = 0; j < TetrisBoard.HEIGHT_BLOCKS; j++){
					if(i == 0 || i == 11 || j == 20){
						board[i][j] = 7;
					}
					else{
						board[i][j] = 8;
					}
				}
			}
			
			board[4][10] = 5;
			board[4][9] = 5;
			board[4][8] = 5;
			board[3][8] = 5;	
			view.repaintTetrisBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}