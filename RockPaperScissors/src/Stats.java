/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class Stats {
    
    private int losses = 0;
    private int paper = 0;
    private int rock = 0;
    private int scissors = 0;
    private int ties = 0;
    private int wins = 0;
    
    public int getLosses() {
        return losses;
    }
    
    public int getPaper() {
        return paper;
    }
    
    public int getRock() {
        return rock;
    }
    
    public int getScissors() {
        return scissors;
    }
    
    public int getTies() {
        return ties;
    }
    
    public int getWins() {
        return wins;
    }
    
    public void setLosses(int losses) {
        this.losses = losses;
    }
    
    public void setPaper(int paper) {
        this.paper = paper;
    }
    
    public void setRock(int rock) {
        this.rock = rock;
    }
    
    public void setScissors(int scissors) {
        this.scissors = scissors;
    }
    
    public void setTies(int ties) {
        this.ties = ties;
    }
    
    public void setWins(int wins) {
        this.wins = wins;
    }
    
}
