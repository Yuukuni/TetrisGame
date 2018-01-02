public class MVCTetris{
    public static void main (String[] args){
        TetrisView theView = new TetrisView();
        TetrisModel theModel = new TetrisModel();
        TetrisController theController = new TetrisController(theView,theModel);
        theModel.GameStart();
    }
}