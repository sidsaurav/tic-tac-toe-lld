package strategies;

public class ColWin implements WinningStrategy{

    @Override
    public boolean isWinning(String[][] board, int X, int Y, String symbol) {
        for(int i = 0; i<board.length; i++) {
            if(board[i][Y-1] != symbol) {
                return false;
            }
        }
        return true;
    }
}

