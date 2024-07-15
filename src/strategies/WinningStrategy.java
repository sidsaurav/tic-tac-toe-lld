package strategies;

public interface WinningStrategy {
    boolean isWinning(String[][] board, int X, int Y, String symbol);
}
