/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Erica
 */
public class RandomStrategy implements Strategy {
    
    @Override
    public Hand chooseHand() {
        return Hand.fromOrdinal(ThreadLocalRandom.current().nextInt((Hand.None.ordinal() + 1), Hand.values().length));
    }
    
    @Override
    public String toString() {
        return "Random Strategy";
    }
    
}
