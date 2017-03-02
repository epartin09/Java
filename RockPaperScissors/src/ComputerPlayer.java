/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Erica
 */
public class ComputerPlayer extends Player {
    
    @Override
    public Strategy chooseStrategy() {
        ArrayList<Strategy> strategies = new ArrayList<>();
        
        // !!! Random Strategy must be first !!!
        strategies.add(new RandomStrategy());
        // !!! Random Strategy must be first !!!
        strategies.add(new LastUsedStrategy(this.opponent()));
        strategies.add(new LeastUsedStrategy(this.opponent()));
        strategies.add(new MostUsedStrategy(this.opponent()));
        // !!! Cheat Strategy must be last !!!
        strategies.add(new CheatStrategy(this.opponent()));
        // !!! Cheat Strategy must be last !!!
        
        int origin = 0;
        int bound = strategies.size();
        
        // Choose Cheat Strategy
        if (ThreadLocalRandom.current().nextInt(10) == 0) {
            origin = bound - 1;
        }
        // Choose Random Strategy
        else if (this.prevHand() == Hand.None) {
            bound = origin + 1;
        }
        
        strategy = strategies.get(ThreadLocalRandom.current().nextInt(origin, bound));
        
        return strategy;
    }
    
}