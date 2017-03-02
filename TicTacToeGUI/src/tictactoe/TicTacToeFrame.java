/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Erica
 */
public class TicTacToeFrame extends JFrame {
    
    // <editor-fold desc="Components">
    private JButton button1 = null;
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private TicTacToeTile[][] tiles = null;
    // </editor-fold>
    
    // View
    public TicTacToeFrame(String title) {
        super(title);
        initComponents();
    }
    
    public void close() {
        this.dispose();
    }
    
    public void reset() {
        for (java.awt.Component component : panel1.getComponents()) {
            if (component instanceof JButton) {
                TicTacToeTile tile = (TicTacToeTile)component;
                tile.setState(State.None);
                tile.setText("");
            }
        }
    }
    
    public TicTacToeTile[][] tiles() {
        return tiles;
    }
    
    private void button1_OnActionPerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        switch (option) {
        case JOptionPane.YES_OPTION:
            close();
            break;
        }
    }
    
    private void initComponents() {
        // "Game" Panel
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(TicTacToe.COLS, TicTacToe.ROWS));
        
        tiles = new TicTacToeTile[TicTacToe.COLS][TicTacToe.ROWS];
        
        for (int x = 0; x < TicTacToe.COLS; x++) {
            for (int y = 0; y < TicTacToe.ROWS; y++) {
                tiles[x][y] = new TicTacToeTile(x, y);
                tiles[x][y].setPreferredSize(new Dimension(100, 100));
                panel1.add(tiles[x][y]);
            }
        }
        
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        
        // "Quit" Panel
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        button1 = new JButton("Quit");
        button1.addActionListener((ActionEvent e) -> {
            button1_OnActionPerformed(e);
        });
        button1.setPreferredSize(new Dimension(300, 50));
        panel2.add(button1);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
    }
    
}