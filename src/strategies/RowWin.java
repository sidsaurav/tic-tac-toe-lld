package strategies;

public class RowWin implements WinningStrategy{

    @Override
    public boolean isWinning(String[][] board, int X, int Y, String symbol) {
        for(int i = 0; i<board.length; i++) {
            if(board[X-1][i] != symbol) {
                return false;
            }
        }
        return true;
    }
}

