package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Model.TetrisModel;
import View.TetrisView;

public class TetrisController {
	
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    
    private static final String ROTATE = "ROTATE";
    private static final String MOVE_LEFT = "MOVE_LEFT";
    private static final String MOVE_RIGHT = "MOVE_RIGHT";
    private static final String DROP = "DROP";
	
    private TetrisView theView;
    private TetrisModel theModel;
    
    public void GameStart() {
    	
    	theModel = new TetrisModel();
    	theModel.GameStart();
    	
    	theView = new TetrisView(theModel.getCurrentBlock());
    	theView.addPauseActions(listenForContinue, listenForRestart, listenForQuit);
    	
        addTetrisKeyListener();
    	
		new Thread() {
			@Override 
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						theModel.drop();
						theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
					} catch ( InterruptedException e ) {}
				}
			}
		}.start();
    	
    }

	private ActionListener listenForContinue = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	
	};
	
	private ActionListener listenForRestart = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	
	};
	
	private ActionListener listenForQuit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	
	};
    
	private Action rotate = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.rotate();
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
    
    private Action moveLeft = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(-1);
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
    
    private Action moveRight = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(1);
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
        
    private Action drop = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.drop();
			theView.repaintTetrisBoard(theModel.getCurrentBlock(), theModel.getBoard());
			
		}
    	
    };
    
    private void addTetrisKeyListener() {
    	
    	 theView.getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), ROTATE);
    	 theView.getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
    	 theView.getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
    	 theView.getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), DROP);

    	 theView.getTetrisBoard().getActionMap().put(ROTATE, rotate);
    	 theView.getTetrisBoard().getActionMap().put(MOVE_LEFT, moveLeft);
    	 theView.getTetrisBoard().getActionMap().put(MOVE_RIGHT, moveRight);
    	 theView.getTetrisBoard().getActionMap().put(DROP, drop);

    }
 
}