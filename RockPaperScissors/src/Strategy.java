/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public interface Strategy {
    
    public Hand chooseHand();
    @Override
    public String toString();
    
}