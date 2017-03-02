/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class Cell {
    
    private State state = State.None;
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State state() {
        return state;
    }
    
}