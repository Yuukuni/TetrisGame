package View;

import View.Texture.*;

public class TetrisView {
	
	private TetrisTexture[] tetrisTextures;
	TetrisTexture currentTexture;
	enum TextureName { B10401020, B10401023, B10404011, B10415007, F10615001 };
	
	private TetrisWindow tetrisWindow;
	
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
		
		currentTexture = tetrisTextures[texture.ordinal()];
		
	}
	
	//Just for testing.
	public static void main(String[] args) {
		
		new TetrisView();

	}
	
}