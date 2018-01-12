package View.Texture;

public class TetrisTexture_F10615001 extends TetrisTexture {

	@Override
	protected void blocksSetting() {
		
		blocksPath = new String[BLOCK_KINDS];	
		blocksPath[0] = "/blue 30.png";
		blocksPath[1] = "/cyan 30.png";
		blocksPath[2] = "/green 30.png";
		blocksPath[3] = "/orange 30.png";
		blocksPath[4] = "/purple 30.png";
		blocksPath[5] = "/red 30.png"; 
		blocksPath[6] = "/yellow 30.png"; 
		blocksPath[7] = "/wall 30.png";
		
		nextBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		nextBlocksPath[0] = "/blue 25.png";
		nextBlocksPath[1] = "/cyan 25.png";
		nextBlocksPath[2] = "/green 25.png";
		nextBlocksPath[3] = "/orange 25.png";
		nextBlocksPath[4] = "/purple 25.png";
		nextBlocksPath[5] = "/red 25.png"; 
		nextBlocksPath[6] = "/yellow 25.png"; 
		
		previewBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		previewBlocksPath[0] = "/blue 20.png";
		previewBlocksPath[1] = "/cyan 20.png";
		previewBlocksPath[2] = "/green 20.png";
		previewBlocksPath[3] = "/orange 20.png";
		previewBlocksPath[4] = "/purple 20.png";
		previewBlocksPath[5] = "/red 20.png"; 
		previewBlocksPath[6] = "/yellow 20.png"; 
		
		drawLine = false;
		
	}

	@Override
	protected void backgroundsSetting() {
		
		menuBackgroundPath = "/B10415007_menu.png";
		darkMenuBackgroundPath = "/B10415007_menu_dark.png";
		
		gameBackgroundPath = new String[LEVEL_TOP];
		darkGameBackgroundPath = new String[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			gameBackgroundPath[i] = "/" + Integer.toString(i + 1) + ".png";
			darkGameBackgroundPath[i] = "/" + Integer.toString(i + 1) + "_.png";
		}
		
	}

	@Override
	protected void fontSetting() {
		
		grayAlphabetPath = "/B10415007_alphabet_gray.png";
		grayNumberPath = "/B10415007_number_gray.png";
		graySelectPath = "/B10415007_select_gray.png";
		
		blueAlphabetPath = "/B10415007_alphabet_blue.png";
		blueNumberPath = "/B10415007_number_blue.png";
		blueSelectPath = "/B10415007_select_blue.png";
		
		redAlphabetPath = "/B10415007_alphabet_red.png";
		redNumberPath = "/B10415007_number_red.png";
		redSelectPath = "/B10415007_select_red.png";
		
		blueExclamationPointPath = "/B10415007_exclamation_point_blue.png";
		
		grayPlus = "/grayPlus.png";
		grayMinus = "/grayMinus.png";
		grayMultiplication = "/grayMultiplication.png";
		grayDivision = "/grayDivision.png";
		grayPoint = "/grayPoint.png";
		
		redPlus = "/redPlus.png";
		redMinus = "/redMinus.png";
		redMultiplication = "/redMultiplication.png";
		redDivision = "/redDivision.png";
		redPoint = "/redPoint.png";
		
		space = "/space.png";
		
	}
	
}