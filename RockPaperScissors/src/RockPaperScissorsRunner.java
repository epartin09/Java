/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Erica
 */
public class RockPaperScissorsRunner {
    
    public static void createAndShowGUI() {
        RockPaperScissorsFrame frame = new RockPaperScissorsFrame("Rock Paper Scissors Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    
}