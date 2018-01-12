package View.Texture;

public class TetrisTexture_B10404011 extends TetrisTexture {

	@Override
	protected void blocksSetting() {
		
		blocksPath = new String[BLOCK_KINDS];	
		blocksPath[0] = "/B10404011_christmas remove.png";
		blocksPath[1] = "/B10404011_snowflake blue remove.png";
		blocksPath[2] = "/B10404011_snowflake green remove.png";
		blocksPath[3] = "/B10404011_snowflake purple remove.png";
		blocksPath[4] = "/B10404011_snowflake red remove.png";
		blocksPath[5] = "/B10404011_snowflake black remove.png"; 
		blocksPath[6] = "/B10404011_snowflake white.png"; 
		blocksPath[7] = "/B10404011_wall block.png";
		
		nextBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		nextBlocksPath[0] = "/B10404011_christmas remove_next.png";
		nextBlocksPath[1] = "/B10404011_snowflake blue remove_next.png";
		nextBlocksPath[2] = "/B10404011_snowflake green remove_next.png";
		nextBlocksPath[3] = "/B10404011_snowflake purple remove_next.png";
		nextBlocksPath[4] = "/B10404011_snowflake red remove_next.png";
		nextBlocksPath[5] = "/B10404011_snowflake black remove_next.png"; 
		nextBlocksPath[6] = "/B10404011_snowflake white_next.png"; 
		
		previewBlocksPath = new String[PREVIEW_BLOCK_KINDS];	
		previewBlocksPath[0] = "/B10404011_christmas remove_preview.png";
		previewBlocksPath[1] = "/B10404011_snowflake blue remove_preview.png";
		previewBlocksPath[2] = "/B10404011_snowflake green remove_preview.png";
		previewBlocksPath[3] = "/B10404011_snowflake purple remove_preview.png";
		previewBlocksPath[4] = "/B10404011_snowflake red remove_preview.png";
		previewBlocksPath[5] = "/B10404011_snowflake black remove_preview.png"; 
		previewBlocksPath[6] = "/B10404011_snowflake white_preview.png"; 
		
		drawLine = true;
		
	}

	@Override
	protected void backgroundsSetting() {
		
		menuBackgroundPath = "/B10404011_christmas menu bright.png";
		darkMenuBackgroundPath = "/B10404011_christmas menu.png";
		
		gameBackgroundPath = new String[LEVEL_TOP];
		darkGameBackgroundPath = new String[LEVEL_TOP];
		
		for(int i = 0; i < LEVEL_TOP; i++) {
			gameBackgroundPath[i] = "/B10404011_snowbackground bright_" + Integer.toString(i + 1) + ".png";
			darkGameBackgroundPath[i] = "/B10404011_snowbackground_" + Integer.toString(i + 1) + ".png";
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