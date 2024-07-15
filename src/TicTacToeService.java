import entities.Board;
import entities.Player;

import java.util.Scanner;

public class TicTacToeService {
    private Board gameBoard;
    private Player p1;
    private Player p2;
    private Player winner;
    private Scanner scn;
    private int turnCount;
    private int boardSize;

    public TicTacToeService(int N) {
        scn = new Scanner(System.in);
        p1 = null;
        p2 = null;
        winner = null;
        gameBoard = new Board(N);
        turnCount = 0;
        boardSize = N;
    }

    public void play() {
        p1 = getPlayerInfo();
        p2 = getPlayerInfo();

        while(true){
            int response = 0;
            while(response == 0){
                response = takeTurn(p1);
            }
            if(response == 2 || response == 3) break;

            response = 0;
            while(response == 0){
                response = takeTurn(p2);
            }
            if(response == 0) continue;
            if(response == 2 || response == 3) break;
        }

        declareWinner();
    }

    private Player getPlayerInfo() {
        System.out.println("Enter player name and symbol");
        String name = scn.next();;
        String symbol = scn.next();

        return new Player(name, symbol);
    }

    private void declareWinner() {
        if(winner == null){
            System.out.println("Game Over!");
        }

        if(winner == p1) {
            System.out.println("Player 1 won");
        }

        if(winner == p2) {
            System.out.println("Player 2 won");
        }
    }
    // 2-> winner
    //3 -> game tie
    //1 -> normal done
    //0 ->not done

    private int takeTurn(Player p) {
        System.out.println("Enter row and col");
        int X = scn.nextInt();
        int Y = scn.nextInt();
        //hame board ko set krne hai mtlb board ke member varianle to change krna h to board ke method ko call karo, we dont need to pass board as board ka hi member variable hai.
//        don't send whole player, only send the data -> for simplicity, later can refactor it
        int res = gameBoard.setBoard(X, Y, p.getSymbol());
        if(res == 0){
            System.out.println("Invalid selection. Please retry");
            return res;
        }
        gameBoard.printBoard();
        if(gameBoard.getWinner(p.getSymbol(), X, Y) == true){
            winner = p;
            return 2;
        }
        turnCount++;
        if(turnCount >= boardSize*boardSize ) {
            return 3;
        }

        return 1;
    }
}
