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
    
    protected Strategy strategy;
    
    private Hand hand = Hand.None;
    private Hand prevHand = Hand.None;
    private Player opponent = null;
    private Stats stats = null;
    
    public Hand hand() {
        return hand;
    }
    
    public Player opponent() {
        return opponent;
    }
    
    public Hand prevHand() {
        return prevHand;
    }
    
    public void setHand(Hand hand) {
        prevHand = this.hand;
        this.hand = hand;
    }
    
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
    
    public Stats stats() {
        if (stats == null) {
            stats = new Stats();
        }
        return stats;
    }
    
    public Strategy strategy() {
        return strategy;
    }
    
    public abstract Strategy chooseStrategy();
    
}
