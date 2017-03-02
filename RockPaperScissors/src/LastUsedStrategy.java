/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class LastUsedStrategy implements Strategy {
    
    private Hand hand = Hand.None;
    
    public LastUsedStrategy(Player player) {
        this.hand = player.prevHand();
    }
    
    @Override
    public Hand chooseHand() {
        return hand;
    }
    
    @Override
    public String toString() {
        return "Last Used Strategy";
    }
    
}
