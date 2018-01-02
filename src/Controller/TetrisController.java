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
	
    private TetrisView theView;
    private TetrisModel theModel;
    
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String ROTATE = "ROTATE";
    private static final String MOVE_LEFT = "MOVE_LEFT";
    private static final String MOVE_RIGHT = "MOVE_RIGHT";
    private static final String DROP = "DROP";
    
    public void GameStart() {
    	
    	theModel = new TetrisModel();
    	theModel.GameStart();
    	
    	theView = new TetrisView(theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());

/*      this.theView.addTetrisButtonListener(new ContinueButtonListener());
        this.theView.addTetrisButtonListener(new RestartButtonListener());
        this.theView.addTetrisButtonListener(new ExitButtonListener());*/
        addTetrisKeyListener();
    	
		new Thread() {
			@Override 
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						theModel.drop();
						theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());
					} catch ( InterruptedException e ) {}
				}
			}
		}.start();
    	
    }
   
    public class ContinueButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            
        }
        
    }

    public class RestartButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
                        
        }
        
    }

    public class ExitButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
                        
        }
        
    }
    
    private Action rotate = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.rotate();
			theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());
			
		}
    	
    };
    
    private Action moveLeft = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(-1);
			theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());
			
		}
    	
    };
    
    private Action moveRight = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.move(1);
			theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());
			
		}
    	
    };
    
    private Action drop = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			theModel.drop();
			theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition(), theModel.getCurrentBlockKind(), theModel.getCurrentBlockRotation());
			
		}
    	
    };
    
    private void addTetrisKeyListener() {
    	
    	 theView.getTetrisWindow().getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), ROTATE);
    	 theView.getTetrisWindow().getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
    	 theView.getTetrisWindow().getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
    	 theView.getTetrisWindow().getTetrisBoard().getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), DROP);

    	 theView.getTetrisWindow().getTetrisBoard().getActionMap().put(ROTATE, rotate);
    	 theView.getTetrisWindow().getTetrisBoard().getActionMap().put(MOVE_LEFT, moveLeft);
    	 theView.getTetrisWindow().getTetrisBoard().getActionMap().put(MOVE_RIGHT, moveRight);
    	 theView.getTetrisWindow().getTetrisBoard().getActionMap().put(DROP, drop);

    }
 
}