package View.Texture;

public class TetrisTexture_B10415007 extends TetrisTexture {

	@Override
	protected void blocksSetting() {
		
		blocksPath = new String[BLOCK_KINDS];	
		blocksPath[0] = "/B10415007_blueBlock.png";
		blocksPath[1] = "/B10415007_cyanBlock.png";
		blocksPath[2] = "/B10415007_greenBlock.png";
		blocksPath[3] = "/B10415007_orangeBlock.png";
		blocksPath[4] = "/B10415007_purpleBlock.png";
		blocksPath[5] = "/B10415007_redBlock.png"; 
		blocksPath[6] = "/B10415007_yellowBlock.png"; 
		blocksPath[7] = "/B10415007_wallBlock.png";
		
		nextBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		nextBlocksPath[0] = "/B10415007_blueBlock_next.png";
		nextBlocksPath[1] = "/B10415007_cyanBlock_next.png";
		nextBlocksPath[2] = "/B10415007_greenBlock_next.png";
		nextBlocksPath[3] = "/B10415007_orangeBlock_next.png";
		nextBlocksPath[4] = "/B10415007_purpleBlock_next.png";
		nextBlocksPath[5] = "/B10415007_redBlock_next.png"; 
		nextBlocksPath[6] = "/B10415007_yellowBlock_next.png"; 
		
		previewBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		previewBlocksPath[0] = "/B10415007_blueBlock_preview.png";
		previewBlocksPath[1] = "/B10415007_cyanBlock_preview.png";
		previewBlocksPath[2] = "/B10415007_greenBlock_preview.png";
		previewBlocksPath[3] = "/B10415007_orangeBlock_preview.png";
		previewBlocksPath[4] = "/B10415007_purpleBlock_preview.png";
		previewBlocksPath[5] = "/B10415007_redBlock_preview.png"; 
		previewBlocksPath[6] = "/B10415007_yellowBlock_preview.png"; 
		
		drawLine = true;
		
	}

	@Override
	protected void backgroundsSetting() {
		
		menuBackgroundPath = "/B10415007_menu.png";
		darkMenuBackgroundPath = "/B10415007_menu_dark.png";
		
		gameBackgroundPath = new String[LEVEL_TOP];
		darkGameBackgroundPath = new String[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			gameBackgroundPath[i] = "/B10415007_level" + Integer.toString(i + 1) + ".png";
			darkGameBackgroundPath[i] = "/B10415007_level" + Integer.toString(i + 1) + "_dark.png";
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