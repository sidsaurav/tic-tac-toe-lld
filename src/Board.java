public class Board {
    String[][] board;

    public Board(int size){
        board = new String[size][size];

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                board[i][j] = "-";
            }
        }
    }

    //use return codes for mentioning if the operation is success or failed or other thing.
    public int setBoard(int X, int Y, String symbol) {
        if(X > board.length || Y > board.length) return 0;
        if(board[X-1][Y-1] != "-") return 0;
        board[X-1][Y-1] = symbol;
        return 1;
    }

    public boolean getWinner(String symbol, int X, int Y) {
        boolean allRow = true;
        boolean allCol = true;

        for(int i = 0; i<board.length; i++) {
            if(board[X-1][i] != symbol) allRow = false;
            if(board[i][Y-1] != symbol) allCol = false;
        }

        return allRow || allCol || checkDiagonalPrimary(symbol) || checkDiagonalSecondary(symbol);
    }

    private boolean checkDiagonalSecondary(String symbol){
        for(int i = 0; i<board.length; i++) {
            if(board[i][board.length - 1 - i] != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonalPrimary(String symbol){
        for(int i = 0; i<board.length; i++) {
            if(board[i][i] != symbol) return false;
        }
        return true;
    }

    public void printBoard(){
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
