/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class HumanStrategy implements Strategy {
    
    private Hand hand = Hand.None;
    
    public HumanStrategy(Hand hand) {
        this.hand = hand;
    }
    
    @Override
    public Hand chooseHand() {
        return hand;
    }
    
    @Override
    public String toString() {
        return "Human Strategy";
    }
    
}
