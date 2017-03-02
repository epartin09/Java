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
public class TicTacToeRunner {
    
    public static void createAndShowGUI() {
        TicTacToe model = new TicTacToe();
        TicTacToeFrame view = new TicTacToeFrame("Tic-Tac-Toe Game");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setLocationRelativeTo(null);
        TicTacToeController controller = new TicTacToeController(model, view);
        view.setVisible(true);
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