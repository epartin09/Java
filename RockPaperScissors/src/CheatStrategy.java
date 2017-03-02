/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class CheatStrategy implements Strategy {
    
    private Hand hand = Hand.None;
    
    public CheatStrategy(Player player) {
        this.hand = player.hand();
    }
    
    @Override
    public Hand chooseHand() {
        switch (hand) {
            case Rock:
                return Hand.Paper;
            case Paper:
                return Hand.Scissors;
            case Scissors:
                return Hand.Rock;
        }
        return Hand.None;
    }
    
    @Override
    public String toString() {
        return "Cheat Strategy";
    }
    
}
