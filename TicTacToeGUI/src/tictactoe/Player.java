/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public abstract class Player {
    
    private State state = State.None;
    private Stats stats = new Stats();
    
    public Player(State state) {
        this.state = state;
    }
    
    public boolean move(Cell[][] grid, int col, int row) {
        if (grid[col][row].state() != State.None) {
            return false;
        }
        grid[col][row].setState(state);
        stats.setMoves(stats.getMoves() + 1);
        return true;
    }
    
    public State state() {
        return state;
    }
    
    public Stats stats() {
        return stats;
    }
    
    @Override
    public abstract String toString();
    
}
