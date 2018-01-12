package View.Texture;

public class TetrisTexture_B10401023 extends TetrisTexture {

	@Override
	protected void blocksSetting() {
		
		blocksPath = new String[BLOCK_KINDS];	
		blocksPath[0] = "/blue30.png";
		blocksPath[1] = "/cyan30.png";
		blocksPath[2] = "/green30.png";
		blocksPath[3] = "/orange30.png";
		blocksPath[4] = "/purple30.png";
		blocksPath[5] = "/red30.png"; 
		blocksPath[6] = "/yellow30.png"; 
		blocksPath[7] = "/white30.png";
		
		nextBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		nextBlocksPath[0] = "/blue25.png";
		nextBlocksPath[1] = "/cyan25.png";
		nextBlocksPath[2] = "/green25.png";
		nextBlocksPath[3] = "/orange25.png";
		nextBlocksPath[4] = "/purple25.png";
		nextBlocksPath[5] = "/red25.png"; 
		nextBlocksPath[6] = "/yellow25.png"; 
		
		previewBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		previewBlocksPath[0] = "/blue20.png";
		previewBlocksPath[1] = "/cyan20.png";
		previewBlocksPath[2] = "/green20.png";
		previewBlocksPath[3] = "/orange20.png";
		previewBlocksPath[4] = "/purple20.png";
		previewBlocksPath[5] = "/red20.png"; 
		previewBlocksPath[6] = "/yellow20.png"; 
		
		drawLine = true;
		
	}

	@Override
	protected void backgroundsSetting() {
		
		menuBackgroundPath = "/B10415007_menu.png";
		darkMenuBackgroundPath = "/B10415007_menu_dark.png";
		
		gameBackgroundPath = new String[LEVEL_TOP];
		darkGameBackgroundPath = new String[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			gameBackgroundPath[i] = "/" + Integer.toString(i + 1) + "-1.jpg";
			darkGameBackgroundPath[i] = "/" + Integer.toString(i + 1) + "-2.jpg";
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