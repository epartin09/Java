/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class TicTacToe {
    
    public static final int COLS = 3;
    public static final int ROWS = 3;
    
    private Cell[][] grid = new Cell[TicTacToe.COLS][TicTacToe.ROWS];
    
    private Player1 player1 = new Player1();
    private Player2 player2 = new Player2();
    
    private State state = State.None;
    
    // Model
    public TicTacToe() {
        for (int x = 0; x < TicTacToe.COLS; x++) {
            for (int y = 0; y < TicTacToe.ROWS; y++) {
                grid[x][y] = new Cell();
            }
        }
    }
    
    public Player changePlayer() {
        switch (state) {
        case None:
        case X:
            return player1;
        case O:
            return player2;
        }
        return null;
    }
    
    public State changeState() {
        switch (state) {
        case None:
        case X:
            return State.O;
        case O:
            return State.X;
        }
        return State.None;
    }
    
    public Winner chooseWinner() {
        switch (state) {
        case X:
            return Winner.Player1;
        case O:
            return Winner.Player2;
        }
        return Winner.Cat;
    }
    
    public Cell[][] grid() {
        return grid;
    }
    
    public boolean hasLegalMove() {
        return (player1.stats().getMoves() + player2.stats().getMoves() < 9);
    }
    
    public boolean hasTie() {
        return (canTie() && (diaTie() && colTie() && rowTie()));
    }
    
    public boolean hasWin() {
        return (canWin() && (colWin() || diaWin() || rowWin()));
    }
    
    public Player player1() {
        return player1;
    }
    
    public Player player2() {
        return player2;
    }
    
    public void reset() {
        for (int x = 0; x < TicTacToe.COLS; x++) {
            for (int y = 0; y < TicTacToe.ROWS; y++) {
                grid[x][y].setState(State.None);
            }
        }
        
        player1 = new Player1();
        player2 = new Player2();
        
        state = State.None;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State state() {
        return state;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int x = 0; x < TicTacToe.COLS; x++) {
            for (int y = 0; y < TicTacToe.ROWS; y++) {
                if (grid[x][y].state() == State.None) {
                    str += "-";
                } else {
                    str += grid[x][y].state().toString();
                }
            }
            str += System.lineSeparator();
        }
        return str;
    }
    
    private boolean canTie() {
        return (player1.stats().getMoves() + player2.stats().getMoves() > 6);
    }
    
    private boolean canWin() {
        return (player1.stats().getMoves() + player2.stats().getMoves() > 4);
    }
    
    // Down-Up
    private boolean colTie() {
        boolean[] tie = { false, false, false };
        for (int y = 0; y < TicTacToe.ROWS; y++) {
            tie[y] = isTie(grid[0][y], grid[1][y], grid[2][y]);
        }
        //return (tie[0] && tie[1] && tie[2]);
        return ((tie[0] && tie[1]) || (tie[0] && tie[2]) || (tie[1] && tie[2]));
    }
    
    // Down-Up
    private boolean colWin() {
        boolean[] win = { false, false, false };
        for (int y = 0; y < TicTacToe.ROWS; y++) {
            win[y] = isWin(grid[0][y], grid[1][y], grid[2][y]);
        }
        return (win[0] || win[1] || win[2]);
    }
    
    // Diagonal
    private boolean diaTie() {
        return (ltrTie() && rtlTie());
    }
    
    // Diagonal
    private boolean diaWin() {
        return (ltrWin() || rtlWin());
    }
    
    private boolean isTie(Cell a, Cell b, Cell c) {
        if (a.state() == State.None && b.state() == State.None && c.state() == State.None) {
            return false;
        }
        boolean[] tie = { false, false, false, false, false, false };
        tie[0] = (a.state() == State.X && (b.state() == State.O || c.state() == State.O));
        tie[1] = (b.state() == State.X && (a.state() == State.O || c.state() == State.O));
        tie[2] = (c.state() == State.X && (a.state() == State.O || b.state() == State.O));
        tie[3] = (a.state() == State.O && (b.state() == State.X || c.state() == State.X));
        tie[4] = (b.state() == State.O && (a.state() == State.X || c.state() == State.X));
        tie[5] = (c.state() == State.O && (a.state() == State.X || b.state() == State.X));
        return (tie[0] || tie[1] || tie[2] || tie[3] || tie[4] || tie[5]);
    }
    
    private boolean isWin(Cell a, Cell b, Cell c) {
        if (a.state() == State.None && b.state() == State.None && c.state() == State.None) {
            return false;
        }
        return (a.state() == b.state() && a.state() == c.state());
    }
    
    // Diagonal (Left-to-Right)
    private boolean ltrTie() {
        return isTie(grid[0][0], grid[1][1], grid[2][2]);
    }
    
    // Diagonal (Left-to-Right)
    private boolean ltrWin() {
        return isWin(grid[0][0], grid[1][1], grid[2][2]);
    }
    
    // Left-Right
    private boolean rowTie() {
        boolean[] tie = { false, false, false };
        for (int x = 0; x < TicTacToe.COLS; x++) {
            tie[x] = isTie(grid[x][0], grid[x][1], grid[x][2]);
        }
        //return (tie[0] && tie[1] && tie[2]);
        return ((tie[0] && tie[1]) || (tie[0] && tie[2]) || (tie[1] && tie[2]));
    }
    
    // Left-Right
    private boolean rowWin() {
        boolean[] win = { false, false, false };
        for (int x = 0; x < TicTacToe.COLS; x++) {
            win[x] = isWin(grid[x][0], grid[x][1], grid[x][2]);
        }
        return (win[0] || win[1] || win[2]);
    }
    
    // Diagonal (Right-to-Left)
    private boolean rtlTie() {
        return isTie(grid[0][2], grid[1][1], grid[2][0]);
    }
    
    // Diagonal (Right-to-Left)
    private boolean rtlWin() {
        return isWin(grid[0][2], grid[1][1], grid[2][0]);
    }
    
}