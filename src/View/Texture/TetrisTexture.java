package View.Texture;

public abstract class TetrisTexture {
	
	public static final int BLOCK_KINDS = 8;
	public static final int PREVIEW_BLOCK_KINDS = 7;
	public static final int LEVEL_TOP = 15;
	
	protected String menuBackgroundPath;
	protected String darkMenuBackgroundPath;
	
	protected String[] gameBackgroundPath;
	protected String[] darkGameBackgroundPath;
	
	protected String[] blocksPath;
	protected String[] nextBlocksPath;
	protected String[] previewBlocksPath;
	protected boolean drawLine;
	
	protected String grayAlphabetPath;
	protected String grayNumberPath;
	protected String graySelectPath;
	
	protected String blueAlphabetPath;
	protected String blueNumberPath;
	protected String blueSelectPath;
	
	protected String redAlphabetPath;
	protected String redNumberPath;
	protected String redSelectPath;
	
	protected String blueExclamationPointPath;
	
	protected String grayPlus;
	protected String grayMinus;
	protected String grayMultiplication;
	protected String grayDivision;
	protected String grayPoint;
	
	protected String redPlus;
	protected String redMinus;
	protected String redMultiplication;
	protected String redDivision;
	protected String redPoint;
	
	protected String space;
	
	public TetrisTexture() {
		
		backgroundsSetting();
		blocksSetting();
		fontSetting();
		
	}
	
	protected abstract void backgroundsSetting();
	
	protected abstract void blocksSetting();
	
	protected abstract void fontSetting();
	
	public String getMenuBackgroundPath() {
		
		return menuBackgroundPath;
		
	}
	
	public String getDarkMenuBackgroundPath() {
		
		return darkMenuBackgroundPath;
		
	}
	
	public String getGameBackgroundPath(int i) {
		
		return gameBackgroundPath[i];
		
	}
	
	public String getDarkGameBackgroundPath(int i) {
		
		return darkGameBackgroundPath[i];
		
	}
	
	public String getBlocksPath(int i) {
		
		return blocksPath[i];
		
	}
	
	public String getNextBlocksPath(int i) {
		
		return nextBlocksPath[i];
		
	}
	
	public String getPreviewBlocksPath(int i) {
		
		return previewBlocksPath[i];
		
	}
	
	public boolean getDrawLine() {
		
		return drawLine;
		
	}

	public String getGrayAlphabetPath() {
		
		return grayAlphabetPath;
		
	}
	
	public String getGrayNumberPath() {
		
		return grayNumberPath;
		
	}
	
	public String getGraySelectPath() {
		
		return graySelectPath;
		
	}
	
	public String getBlueAlphabetPath() {
		
		return blueAlphabetPath;
		
	}
	
	public String getBlueNumberPath() {
		
		return blueNumberPath;
		
	}
	
	public String getBlueSelectPath() {
		
		return blueSelectPath;
		
	}
	
	public String getRedAlphabetPath() {
		
		return redAlphabetPath;
		
	}
	
	public String getRedNumberPath() {
		
		return redNumberPath;
		
	}
	
	public String getRedSelectPath() {
		
		return redSelectPath;
		
	}
	
	public String getBlueExclamationPointPath() {
		
		return blueExclamationPointPath;
		
	}
	
	public String getGrayPlus() {
	
		return grayPlus;
		
	}
	
	public String getGrayMinus() {
		
		return grayMinus;
		
	}
	
	public String getGrayMultiplication() {
		
		return grayMultiplication;
		
	}
	
	public String getGrayDivision() {
		
		return grayDivision;
		
	}
	
	public String getGrayPoint() {
		
		return grayPoint;
		
	}
	
	public String getRedPlus() {
		
		return redPlus;
		
	}
	
	public String getRedMinus() {
		
		return redMinus;
		
	}
	
	public String getRedMultiplication() {
		
		return redMultiplication;
		
	}
	
	public String getRedDivision() {
		
		return redDivision;
		
	}
	
	public String getRedPoint() {
		
		return redPoint;
		
	}
	
	public String getSpace() {
		
		return space;
		
	}
	
}