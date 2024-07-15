package entities;

import strategies.ColWin;
import strategies.DiagonalWin;
import strategies.RowWin;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    String[][] board;
    List<WinningStrategy> strategies;

    public Board(int size){
        board = new String[size][size];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                board[i][j] = "-";
            }
        }

        strategies = new ArrayList<>();

        strategies.add(new ColWin());
        strategies.add(new RowWin());
        strategies.add(new DiagonalWin());
    }

    //use return codes for mentioning if the operation is success or failed or other thing.
    public int setBoard(int X, int Y, String symbol) {
        if(X > board.length || Y > board.length) return 0;
        if(board[X-1][Y-1] != "-") return 0;
        board[X-1][Y-1] = symbol;
        return 1;
    }

    public boolean getWinner(String symbol, int X, int Y) {
        for(WinningStrategy strategy : strategies ){
            if(strategy.isWinning(board, X, Y, symbol)){
                return true;
            }
        }
        return false;
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
