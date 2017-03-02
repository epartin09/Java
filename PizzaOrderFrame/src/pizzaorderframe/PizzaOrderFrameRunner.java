/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.SwingUtilities;

/**
 *
 * @author Erica
 */
public class PizzaOrderFrameRunner {
    
    public static void createAndShowGUI() {
        PizzaOrderFrame frame = new PizzaOrderFrame("Pizza Order");
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

