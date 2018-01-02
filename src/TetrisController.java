import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TetrisController {
    private TetrisView theView;
    private TetrisModel theModel;

    public TetrisController(TetrisView theView, TetrisModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
/*        this.theView.addTetrisButtonListener(new ContinueButtonListener());
        this.theView.addTetrisButtonListener(new RestartButtonListener());
        this.theView.addTetrisButtonListener(new ExitButtonListener());*/
        this.theView.addTetrisKeyListener(new TetrisKeyListener());
        
    }
   
 
    class ContinueButtonListener implements ButtonListener{

        public void actionPerformed(ActionEvent e) {
            
        }
        
    }

    class RestartButtonListener implements ButtonListener{

        public void actionPerformed(ActionEvent e) {
                        
        }
        
    }

    class ExitButtonListener implements ButtonListener{

        public void actionPerformed(ActionEvent e) {
                        
        }
        
    }

    
    class TetrisKeyListener implements KeyListener{
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP:
                    theModel.rotate();
                    theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition, theModel.getCurrentBlockKind, theModel.getCurrentBlockRotation);
                    break;
                case KeyEvent.VK_LEFT:
                    theModel.move(-1);
                    theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition, theModel.getCurrentBlockKind, theModel.getCurrentBlockRotation);
                    break;
                case KeyEvent.VK_RIGHT:
                    theModel.move(1);
                    theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition, theModel.getCurrentBlockKind, theModel.getCurrentBlockRotation);
                    break;
                case KeyEvent.VK_DOWN:
                    theModel.drop();
                    theView.repaintTetrisBoard(theModel.getBoard(), theModel.getCurrentBlockPosition, theModel.getCurrentBlockKind, theModel.getCurrentBlockRotation);
                    break;

            }
            
        }

        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub
            
        }

        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub
            
        }
        
    }
}