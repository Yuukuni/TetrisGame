package View;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import View.Texture.*;

public class TetrisView {
	
	private TetrisWindow tetrisWindow;
	
	private TetrisTexture[] tetrisTextures;
	private TetrisTexture currentTexture;
	private enum TextureName { B10401020, B10401023, B10404011, B10415007, F10615001 };
	
	public TetrisWindow getTetrisWindow() {
		
		return tetrisWindow;
		
	}

	public TetrisView(Point currentBlockPosition, int currentBlockKind, int currentBlockRotation) {
		
		textureSetting(TextureName.B10415007);
		tetrisWindow = new TetrisWindow(currentTexture, currentBlockPosition, currentBlockKind, currentBlockRotation);
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
	
	public void repaintTetrisBoard(int[][] board, Point currentBlockPosition, int currentBlockKind, int currentBlockRotation) {	
		
		tetrisWindow.repaintTetrisBoard(board, currentBlockPosition, currentBlockKind, currentBlockRotation);
		
	}
	
	public void setStopButtonsVisible(boolean b) {
		
		tetrisWindow.setStopButtonsVisible(b);
		
	}

}