package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Model.TetrisModel;
import View.TetrisView;
import View.TetrisWindow.TetrisViewSetting;

public class TetrisController extends KeyAdapter {
	
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    
    private static final String MENU_SELECT_UP = "MENU_SELECT_UP";
    private static final String MENU_SELECT_DOWN = "MENU_SELECT_DOWN";
    private static final String MENU_SELECT_ENTER = "MENU_SELECT_ENTER";
    
    private static final String LEVEL_SELECT_UP = "LEVEL_SELECT_UP";
    private static final String LEVEL_SELECT_DOWN = "LEVEL_SELECT_DOWN";
    private static final String LEVEL_SELECT_ENTER = "LEVEL_SELECT_ENTER";
    private static final String LEVEL_EXIT = "LEVEL_EXIT";
    
    private static final String TETRIS_ROTATE = "TETRIS_ROTATE";
    private static final String TETRIS_MOVE_LEFT = "TETRIS_MOVE_LEFT";
    private static final String TETRIS_MOVE_RIGHT = "TETRIS_MOVE_RIGHT";
    private static final String TETRIS_DROP = "TETRIS_DROP";
    private static final String TETRIS_DROP_DOWN = "TETRIS_DROP_DOWN";
    private static final String TETRIS_PAUSE = "TETRIS_PAUSE";
    
    private static final String PAUSE_SELECT_UP = "TETRIS_PAUSE_SELECT_UP";
    private static final String PAUSE_SELECT_DOWN = "TETRIS_PASUE_SELECT_DOWN";
    private static final String PAUSE_SELECT_ENTER = "TETRIS_PAUSE_SELECT_ENTER";
    private static final String TETRIS_CONTINUE = "TETRIS_CONTINUE";
    
    private static final String GAMEOVER_ENTER = "GAMEOVER_ENTER";
    private static final String GAMEOVER_SELECT_CHANGE = "GAMEOVER_SELECT_CHANGE";
    private static final String GAMEOVER_SELECT_ENTER = "GAMEOVER_SELECT_ENTER";
    
    private static final String SETTING_SELECT_UP = "SETTING_SELECT_UP";
    private static final String SETTING_SELECT_DOWN = "SETTING_SELECT_DOWN";
    private static final String SETTING_SELECT_ENTER = "SETTING_SELECT_ENTER";
    private static final String SETTING_EXIT = "SETTING_EXIT";
    
    private static final int SETTING_AMOUNT = 6;
    private static final int SETTING_KEY_AMOUNT = 91;
    
    private static final String[] SETTING_KEYS = {
    		
    		"SETTING_KEY_ESCAPE",				// 0
    		
    		"SETTING_KEY_F1",					// 1
    		"SETTING_KEY_F2",					// 2
    		"SETTING_KEY_F3",					// 3
    		"SETTING_KEY_F4",					// 4
    		"SETTING_KEY_F5",					// 5
    		"SETTING_KEY_F6",					// 6
    		"SETTING_KEY_F7",					// 7
    		"SETTING_KEY_F8",					// 8
    		"SETTING_KEY_F9",					// 9
    		"SETTING_KEY_F10",					// 10
    		"SETTING_KEY_F11",					// 11
    		"SETTING_KEY_F12",					// 12
    		
    		"SETTING_KEY_0",					// 13
    		"SETTING_KEY_1",					// 14
    		"SETTING_KEY_2",					// 15
    		"SETTING_KEY_3",					// 16
    		"SETTING_KEY_4",					// 17
    		"SETTING_KEY_5",					// 18
    		"SETTING_KEY_6",					// 19
    		"SETTING_KEY_7",					// 20
    		"SETTING_KEY_8",					// 21
    		"SETTING_KEY_9",					// 22
    		
    		"SETTING_KEY_NUMPAD0",				// 23
    		"SETTING_KEY_NUMPAD1",				// 24
    		"SETTING_KEY_NUMPAD2",				// 25
    		"SETTING_KEY_NUMPAD3",				// 26
    		"SETTING_KEY_NUMPAD4",				// 27
    		"SETTING_KEY_NUMPAD5",				// 28
    		"SETTING_KEY_NUMPAD6",				// 29
    		"SETTING_KEY_NUMPAD7",				// 30
    		"SETTING_KEY_NUMPAD8",				// 31
    		"SETTING_KEY_NUMPAD9",				// 32
    		
    		"SETTING_KEY_A",					// 33
    		"SETTING_KEY_B",					// 34
    		"SETTING_KEY_C",					// 35
    		"SETTING_KEY_D",					// 36
    		"SETTING_KEY_E",					// 37
    		"SETTING_KEY_F",					// 38
    		"SETTING_KEY_G",					// 39
    		"SETTING_KEY_H",					// 40
    		"SETTING_KEY_I",					// 41
    		"SETTING_KEY_J",					// 42
    		"SETTING_KEY_K",					// 43
    		"SETTING_KEY_L",					// 44
    		"SETTING_KEY_M",					// 45
    		"SETTING_KEY_N",					// 46
    		"SETTING_KEY_O",					// 47
    		"SETTING_KEY_P",					// 48
    		"SETTING_KEY_Q",					// 49
    		"SETTING_KEY_R",					// 50
    		"SETTING_KEY_S",					// 51
    		"SETTING_KEY_T",					// 52
    		"SETTING_KEY_U",					// 53
    		"SETTING_KEY_V",					// 54
    		"SETTING_KEY_W",					// 55
    		"SETTING_KEY_X",					// 56
    		"SETTING_KEY_Y",					// 57
    		"SETTING_KEY_Z",					// 58
    		
    		"SETTING_KEY_INSERT",				// 59
    		"SETTING_KEY_DELETE",				// 60
    		"SETTING_KEY_BACK_SPACE",			// 61
    		
    		"SETTING_KEY_PAGE_UP",				// 62
    		"SETTING_KEY_PAGE_DOWN",			// 63
    		"SETTING_KEY_HOME",					// 64
    		"SETTING_KEY_END",					// 65
    		
    		"SETTING_KEY_SHIFT",				// 66
    		"SETTING_KEY_CONTROL",				// 67
    		"SETTING_KEY_ALT",					// 68
    		"SETTING_KEY_SPACE",				// 69
    		"SETTING_KEY_ENTER",				// 70
    		
    		"SETTING_KEY_UP",					// 71
    		"SETTING_KEY_LEFT",					// 72
    		"SETTING_KEY_RIGHT",				// 73
    		"SETTING_KEY_DOWN",					// 74
    		
    		"SETTING_KEY_OPEN_BRACKET",			// 75
    		"SETTING_KEY_CLOSE_BRACKET",		// 76
    		"SETTING_KEY_SEMICOLON",			// 77
    		"SETTING_KEY_QUOTE",				// 78
    		"SETTING_KEY_BACK_QUOTE",			// 79
    		"SETTING_KEY_COMMA",				// 80
    		"SETTING_KEY_PERIOD",				// 81
    		"SETTING_KEY_SLASH",				// 82
    		"SETTING_KEY_BACK_SLASH",			// 83
    	    
    		"SETTING_KEY_ADD",					// 84
    		"SETTING_KEY_SUBTRACT",				// 85
    		"SETTING_KEY_MULTIPLY",				// 86
    		"SETTING_KEY_DIVIDE",				// 87
    		
    		"SETTING_KEY_EQUALS",				// 88
    		"SETTING_KEY_MINUS",				// 89
    		"SETTING_KEY_DECIMAL"				// 90  
    		
    };
    
    private static final int[] SETTING_KEYCODES = {
    	
		KeyEvent.VK_ESCAPE,					// 0
		
		KeyEvent.VK_F1,						// 1
		KeyEvent.VK_F2,						// 2
		KeyEvent.VK_F3,						// 3
		KeyEvent.VK_F4,						// 4
		KeyEvent.VK_F5,						// 5
		KeyEvent.VK_F6,						// 6
		KeyEvent.VK_F7,						// 7
		KeyEvent.VK_F8,						// 8
		KeyEvent.VK_F9,						// 9
		KeyEvent.VK_F10,					// 10
		KeyEvent.VK_F11,					// 11
		KeyEvent.VK_F12,					// 12
		
		KeyEvent.VK_0,						// 13
		KeyEvent.VK_1,						// 14
		KeyEvent.VK_2,						// 15
		KeyEvent.VK_3,						// 16
		KeyEvent.VK_4,						// 17
		KeyEvent.VK_5,						// 18
		KeyEvent.VK_6,						// 19
		KeyEvent.VK_7,						// 20
		KeyEvent.VK_8,						// 21
		KeyEvent.VK_9,						// 22
		
		KeyEvent.VK_NUMPAD0,				// 23
		KeyEvent.VK_NUMPAD1,				// 24
		KeyEvent.VK_NUMPAD2,				// 25
		KeyEvent.VK_NUMPAD3,				// 26
		KeyEvent.VK_NUMPAD4,				// 27
		KeyEvent.VK_NUMPAD5,				// 28
		KeyEvent.VK_NUMPAD6,				// 29
		KeyEvent.VK_NUMPAD7,				// 30
		KeyEvent.VK_NUMPAD8,				// 31
		KeyEvent.VK_NUMPAD9,				// 32
		
		KeyEvent.VK_A,						// 33
		KeyEvent.VK_B,						// 34
		KeyEvent.VK_C,						// 35
		KeyEvent.VK_D,						// 36
		KeyEvent.VK_E,						// 37
		KeyEvent.VK_F,						// 38
		KeyEvent.VK_G,						// 39
		KeyEvent.VK_H,						// 40
		KeyEvent.VK_I,						// 41
		KeyEvent.VK_J,						// 42
		KeyEvent.VK_K,						// 43
		KeyEvent.VK_L,						// 44
		KeyEvent.VK_M,						// 45
		KeyEvent.VK_N,						// 46
		KeyEvent.VK_O,						// 47
		KeyEvent.VK_P,						// 48
		KeyEvent.VK_Q,						// 49
		KeyEvent.VK_R,						// 50
		KeyEvent.VK_S,						// 51
		KeyEvent.VK_T,						// 52
		KeyEvent.VK_U,						// 53
		KeyEvent.VK_V,						// 54
		KeyEvent.VK_W,						// 55
		KeyEvent.VK_X,						// 56
		KeyEvent.VK_Y,						// 57
		KeyEvent.VK_Z,						// 58
		
		KeyEvent.VK_INSERT,					// 59
		KeyEvent.VK_DELETE,					// 60
		KeyEvent.VK_BACK_SPACE,				// 61
		
		KeyEvent.VK_PAGE_UP,				// 62
		KeyEvent.VK_PAGE_DOWN,				// 63
		KeyEvent.VK_HOME,					// 64
		KeyEvent.VK_END,					// 65
		
		KeyEvent.VK_SHIFT,					// 66
		KeyEvent.VK_CONTROL,				// 67
		KeyEvent.VK_ALT,					// 68
		KeyEvent.VK_SPACE,					// 69
		KeyEvent.VK_ENTER,					// 70
		
		KeyEvent.VK_UP,						// 71
		KeyEvent.VK_LEFT,					// 72
		KeyEvent.VK_RIGHT,					// 73
		KeyEvent.VK_DOWN,					// 74
		
		KeyEvent.VK_OPEN_BRACKET,			// 75
		KeyEvent.VK_CLOSE_BRACKET,			// 76
		KeyEvent.VK_SEMICOLON,				// 77
		KeyEvent.VK_QUOTE,					// 78
		KeyEvent.VK_BACK_QUOTE,				// 79
		KeyEvent.VK_COMMA,					// 80
		KeyEvent.VK_PERIOD,					// 81
		KeyEvent.VK_SLASH,					// 82
		KeyEvent.VK_BACK_SLASH,				// 83
	    
		KeyEvent.VK_ADD,					// 84
		KeyEvent.VK_SUBTRACT,				// 85
		KeyEvent.VK_MULTIPLY,				// 86
		KeyEvent.VK_DIVIDE,					// 87
		
		KeyEvent.VK_EQUALS,					// 88
		KeyEvent.VK_MINUS,					// 89
		KeyEvent.VK_DECIMAL					// 90  
    	
    };
    
    private static final int[] SPEED_LEVEL = { 	
    		1200,	1000,	800,	600,	500,
    		400,	300,	250,	200,	180,
    		160,	140,	120,	100,	80
    	};
	
    private TetrisView theView;
    private TetrisModel theModel;

    public TetrisController() {
    	
    	theModel = new TetrisModel();
    	theView = new TetrisView();
    	
    }
    
    public void start() {
    	
    	menu();
    	
    }
    
    private void menu() {
    	
    	theView.openMenuWindow();
    	putMenuKeyBindings();
    	
    }
    
    private void putMenuKeyBindings() {
    	
    	putKeyBindings(theView.getMenuBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), MENU_SELECT_UP, menuSelectUp);
    	putKeyBindings(theView.getMenuBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), MENU_SELECT_DOWN, menuSelectDown);
    	putKeyBindings(theView.getMenuBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), MENU_SELECT_ENTER, menuSelectEnter);
    	
    }
    
    private void putKeyBindings(JPanel board, KeyStroke key, String actionMapKey, Action action) {
    	
    	putKeyBindingsOfInputMap(board, key, actionMapKey);
    	putKeyBindingsOfActionMap(board, actionMapKey, action);
    	
    }
    
    private void putKeyBindingsOfInputMap(JPanel board, KeyStroke key, String actionMapKey) {
    	
    	board.getInputMap(IFW).put(key, actionMapKey);
    	
    }
    
    private void putKeyBindingsOfActionMap(JPanel board, String actionMapKey, Action action) {
    	
    	board.getActionMap().put(actionMapKey, action);
    	
    }
    
    private Action menuSelectUp = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.menuSelectUp();
			
		}
    	
    };
    
    private Action menuSelectDown = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.menuSelectDown();
			
		}
    	
    };
    
    private Action menuSelectEnter = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			switch(theView.getMenuSelect()) {
			case 0:
				theView.closeMenuWindow();
				levelSelect(1);
				break;
			case 1:
				theView.closeMenuWindow();
				setting();
				break;
			case 2:
				System.exit(0);
			}
			
		}
    	
    };
    
    private void levelSelect(int startLevel) {
    	
    	theView.openLevelWindow();
    	theView.setLevelSelect(startLevel);
    	putLevelSelectKeyBindings();
    	
    }
    
    private void putLevelSelectKeyBindings() {
    	
    	putKeyBindings(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), LEVEL_SELECT_UP, levelSelectUp);
    	putKeyBindings(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), LEVEL_SELECT_DOWN, levelSelectDown);
    	putKeyBindings(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), LEVEL_SELECT_ENTER, levelSelectEnter);
    	putKeyBindings(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), LEVEL_EXIT, levelExit);
    	
    	putKeyBindingsOfInputMap(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), LEVEL_SELECT_UP);
    	putKeyBindingsOfInputMap(theView.getLevelBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), LEVEL_SELECT_DOWN);
    	
    }
    
    private Action levelSelectUp = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.levelSelectUp();
			
		}
    	
    };
    
    private Action levelSelectDown = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.levelSelectDown();
			
		}
    	
    };
    
    private Action levelSelectEnter = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.closeLevelWindow();
			gameStart(theView.getLevelSelect());
			
		}
    	
    };
    
    private Action levelExit = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.closeLevelWindow();
			menu();
			
		}

    };
    
    private void gameStart(int startLevel) {
    	
    	theModel.gameStart(startLevel);
    	viewSettingForGameStart();
    	blockDroping();

    }
    
    private void viewSettingForGameStart() {
    	
    	TetrisViewSetting tetrisViewSetting = new TetrisViewSetting();
    	
    	tetrisViewSetting.setStartLevel(theModel.getLevel());
    	tetrisViewSetting.setFirstBlock(theModel.getCurrentBlock());
    	tetrisViewSetting.setFirstBlocks(theModel.getCurrentBlocks());
    	
    	theView.openTetrisWindow(tetrisViewSetting);
        putTetrisKeyBindings();
    	
    }
    
    private void putTetrisKeyBindings() {
    	
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(0), 0), TETRIS_ROTATE, tetrisRotate);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(1), 0), TETRIS_MOVE_LEFT, tetrisMoveLeft);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(2), 0), TETRIS_MOVE_RIGHT, tetrisMoveRight);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(3), 0), TETRIS_DROP, tetrisDrop);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(4), 0), TETRIS_DROP_DOWN, tetrisDropdown);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(5), 0), TETRIS_PAUSE, tetrisPause);
   	 
    }
    
	private Action tetrisRotate = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.rotate();
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
    
    private Action tetrisMoveLeft = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(-1);
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
    
    private Action tetrisMoveRight = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(1);
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
        
    private Action tetrisDrop = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.drop();
			theModel.addScore(1);
			dropRepaint();
			
		}
    	
    };
    
    private Action tetrisDropdown = new AbstractAction() {
    	
    	private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.dropDown();
			dropRepaint();
			
		}
    	
    };
    
    private Action tetrisPause = new AbstractAction() {
    	
    	private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {

				theModel.setPause(true);
				theView.setPause(true);
				removeTetrisKeyBindings();
				putPauseKeyBindings();
			
		}
    	
    };
    
    private void removeTetrisKeyBindings() {
    	
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(0), 0), TETRIS_ROTATE);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(1), 0), TETRIS_MOVE_LEFT);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(2), 0), TETRIS_MOVE_RIGHT);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(3), 0), TETRIS_DROP);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(4), 0), TETRIS_DROP_DOWN);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(5), 0), TETRIS_PAUSE);
    	
    }
    
    private void removeKeyBindings(JPanel board, KeyStroke key, String actionMapKey) {
    	
    	board.getInputMap(IFW).remove(key);
    	board.getActionMap().remove(actionMapKey);
    	
    }
    
    private void putPauseKeyBindings() {
    	
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), PAUSE_SELECT_UP, pauseSelectUp);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), PAUSE_SELECT_DOWN, pauseSelectDown);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), PAUSE_SELECT_ENTER, pauseSelectEnter);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(theModel.getKeyCode(5), 0), TETRIS_CONTINUE, tetrisContinue);
    	
    }
    
    private Action pauseSelectUp = new AbstractAction() {
    	
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.pauseSelectUp();
			
		}
    	
    };
    
    private Action pauseSelectDown = new AbstractAction() {
    	
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.pauseSelectDown();
			
		}
    	
    };
    
    private Action pauseSelectEnter = new AbstractAction() {
    	
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			switch(theView.getPauseSelect()) {
			case 0: 
				tetrisContinue.actionPerformed(null);
				break;
			case 1:
				theView.closeTetrisWindow();
				theModel.quitGame();
				levelSelect(theModel.getStartLevel());
				break;
			case 2:
				theView.closeTetrisWindow();
				theModel.quitGame();
				menu();
				break;
			}
			
		}
    	
    };
    
    private Action tetrisContinue = new AbstractAction() {
    	
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.setPause(false);
			theView.setPause(false);
			removePauseKeyBindings();
			putTetrisKeyBindings();
			
		}
    	
    };
    
    private void removePauseKeyBindings() {
    	
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), PAUSE_SELECT_UP);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), PAUSE_SELECT_DOWN);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), PAUSE_SELECT_ENTER);
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), TETRIS_CONTINUE);
    	
    }
   
    private void dropRepaint() {
    	
		if(theModel.getLevel() != theView.getLevel()) {
			theView.setLevel(theModel.getLevel());
		}
		if(theModel.getCurrentBlock().getPosition().y == 0) {
			theView.repaintPreviewBoard(theModel.getCurrentBlocks());
		}
		theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
		theView.repaintScoreBoard(theModel.getScore(), theModel.getLine());
    	
    }
	
    private void blockDroping() {
    
		new Thread() {
			@Override 
			public void run() {
				while (!theModel.quit() && !theModel.gameover()) {
					try {
						Thread.sleep(SPEED_LEVEL[theModel.getLevel() - 1]);
						if(!theModel.pause()) {
							theModel.drop();
							dropRepaint();
						}
					} catch ( InterruptedException e ) {}
				}
				if(theModel.gameover()) {
					theView.gameover();
					removeTetrisKeyBindings();
					putGameoverKeyBindings();
				}
			}
		}.start();
    
    }
    
    private void putGameoverKeyBindings() {
    	
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), GAMEOVER_ENTER, gameoverEnter);
    	
    }
    
    private Action gameoverEnter = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			theView.gameoverEntered();
			removeGameoverKeyBindings();
			putGameoverSelectKeyBindings();
			
		}

    };
    
    private void removeGameoverKeyBindings() {
    	
    	removeKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), GAMEOVER_ENTER);
    	
    }
    
    private void putGameoverSelectKeyBindings() {
    	
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), GAMEOVER_SELECT_CHANGE, gameoverSelectChange);
    	putKeyBindingsOfInputMap(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), GAMEOVER_SELECT_CHANGE);
    	putKeyBindings(theView.getTetrisBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), GAMEOVER_SELECT_ENTER, gameoverSelectEnter);
    	
    }
    
    private Action gameoverSelectChange = new AbstractAction() {

 		private static final long serialVersionUID = 1L;
 		@Override
 		public void actionPerformed(ActionEvent arg0) {
 			
 			theView.gameoverSelectChange();
 			
 		}
     	
     };
     
     private Action gameoverSelectEnter = new AbstractAction() {

 		private static final long serialVersionUID = 1L;
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			
 			theView.closeTetrisWindow();
 			theModel.quitGame();
 			
 			switch(theView.getGameoverSelect()) {
			case 0:
				levelSelect(theModel.getStartLevel());
				break;
			case 1:
				menu();
				break;
 			}
 			
 		}
     	
     };
     
     private void setting() {
    	 
    	 int[] keyCode = new int[SETTING_AMOUNT];
    	 
    	 for(int i = 0; i < SETTING_AMOUNT; i++) {
    		 keyCode[i] = theModel.getKeyCode(i);
    	 }
    	 
    	 theView.openSettingWindow(keyCode);
         putSettingKeyBindings();
    	 
     }
     
     private void putSettingKeyBindings() {

    	 putKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), SETTING_SELECT_UP, settingSelectUp);
    	 putKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), SETTING_SELECT_DOWN, settingSelectDown);
    	 putKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), SETTING_SELECT_ENTER, settingSelectEnter);
    	 putKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), SETTING_EXIT, settingExit);
    	 
     }
     
     private Action settingSelectUp = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.settingSelectUp();
			
		}
    	 
     };
 
     private Action settingSelectDown = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.settingSelectDown();
			
		}
    	 
     };
     
     private Action settingSelectEnter = new AbstractAction() {
    	 
    	private static final long serialVersionUID = 1L;
    	
 		@Override
 		public void actionPerformed(ActionEvent arg0) {
 		
 			switch(theView.getSettingSelect()) {
 			case 0: case 1: case 2: case 3: case 4: case 5:
 				theView.settingSelectEntered();
 				removeSettingKeyBindings();
 				putSettingKeyKeyBindings();
 				break;
 				
 			case 6:
 				theModel.setKeyCode(theView.getkeyCode());
 				settingExit.actionPerformed(null);
 				break;
 				
 			case 7:
 				theView.setKey(theModel.getKeyCode());
 				settingExit.actionPerformed(null);
 				break;
 			}
 			
 		}
    	 
     };
 
     private Action settingExit = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theView.closeSettingWindow();
			menu();
			
		}
    	 
     };
     
     private void removeSettingKeyBindings() {

    	 removeKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), SETTING_SELECT_UP);
    	 removeKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), SETTING_SELECT_DOWN);
    	 removeKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), SETTING_SELECT_ENTER);
    	 removeKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), SETTING_EXIT);
    	 
     }
     
     private Action[] settingKeys = new AbstractAction[SETTING_KEY_AMOUNT];
     
     private void putSettingKeyKeyBindings() {
    	 
    	 for(int i = 0; i < SETTING_KEY_AMOUNT; i++) {
    		 final int idx = i;
    		 settingKeys[idx] = new AbstractAction() {
				private static final long serialVersionUID = 1L;
				@Override
				public void actionPerformed(ActionEvent e) {
					
					theView.setKey(theView.getSettingSelect(), SETTING_KEYCODES[idx]);
					theView.settingKeyEntered();
					removeSettingKeyKeyBindings();
					putSettingKeyBindings();
					
				}
    		 };
    		 putKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(SETTING_KEYCODES[i], 0), SETTING_KEYS[i], settingKeys[i]);
    	 }
    	 
     }
     
     private void removeSettingKeyKeyBindings() {
    	 
    	 for(int i = 0; i < SETTING_KEY_AMOUNT; i++) {
    		 removeKeyBindings(theView.getSettingBoard(), KeyStroke.getKeyStroke(SETTING_KEYCODES[i], 0), SETTING_KEYS[i]);
    	 }
    	 
     }

}