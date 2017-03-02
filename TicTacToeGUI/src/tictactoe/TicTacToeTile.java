/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;

/**
 *
 * @author Erica
 */
public class TicTacToeTile extends JButton {
    
    private int col = 0;
    private int row = 0;
    
    private State state = State.None;
    
    public TicTacToeTile(int col, int row) {
        this.col = col;
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State state() {
        return state;
    }
    
}

