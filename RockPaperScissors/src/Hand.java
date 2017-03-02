/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public enum Hand {
    
    None, Rock, Paper, Scissors;
    
    private static Hand[] values;
    
    public static Hand fromOrdinal(int ordinal) {
        if (values == null) {
            values = values();
        }
        return values[ordinal];
    }
    
}