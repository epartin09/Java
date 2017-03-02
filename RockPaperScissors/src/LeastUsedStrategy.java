/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class LeastUsedStrategy implements Strategy {
    
    private int p = 0;
    private int r = 0;
    private int s = 0;
    
    public LeastUsedStrategy(Player player) {
        p = player.stats().getPaper();
        r = player.stats().getRock();
        s = player.stats().getScissors();
    }
    
    @Override
    public Hand chooseHand() {
        // Rock
        if (r < p && r < s) {
            return Hand.Rock;
        }
        // Paper
        else if (p < r && p < s) {
            return Hand.Paper;
        }
        // Scissors
        else if (s < r && s < p) {
            return Hand.Scissors;
        }
        return Hand.None;
    }
    
    @Override
    public String toString() {
        return "Least Used Strategy";
    }
    
}