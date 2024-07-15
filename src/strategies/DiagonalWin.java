package strategies;

public class DiagonalWin implements WinningStrategy{

    @Override
    public boolean isWinning(String[][] board, int X, int Y, String symbol) {
        return checkDiagonalPrimary(board, symbol) || checkDiagonalSecondary(board, symbol);
    }

    private boolean checkDiagonalSecondary(String[][] board, String symbol){
        for(int i = 0; i<board.length; i++) {
            if(board[i][board.length - 1 - i] != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonalPrimary(String[][] board, String symbol){
        for(int i = 0; i<board.length; i++) {
            if(board[i][i] != symbol) return false;
        }
        return true;
    }
}

