/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class HumanPlayer extends Player {
    
    @Override
    public Strategy chooseStrategy() {
        strategy = new HumanStrategy(this.hand());
        return strategy;
    }
    
}
