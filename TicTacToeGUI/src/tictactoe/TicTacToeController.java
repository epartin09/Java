/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Erica
 */
public class TicTacToeController {
    
    private TicTacToe model = null;
    private TicTacToeFrame view = null;
    
    public TicTacToeController(TicTacToe model, TicTacToeFrame view) {
        this.model = model;
        this.view = view;
        
        TicTacToeButtonListener listener = new TicTacToeButtonListener();
        
        for (int x = 0; x < TicTacToe.COLS; x++) {
            for (int y = 0; y < TicTacToe.ROWS; y++) {
                view.tiles()[x][y].addActionListener(listener);
            }
        }
    }
    
    class TicTacToeButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeTile button = (TicTacToeTile)e.getSource();
            int col = button.getCol();
            int row = button.getRow();
            
            Player player = model.changePlayer();
            
            if (!player.move(model.grid(), col, row)) {
                JOptionPane.showMessageDialog(view, "Illegal Move");
                return;
            }
            
            button.setState(player.state());
            button.setText(player.state().toString());
            //button.setText("[" + col + "][" + row + "]");
            
            //System.out.println(model.toString());
            
            if (!model.hasWin()) {
                if (!model.hasTie()) {
                    model.setState(model.changeState());
                    return;
                }
                model.setState(State.None);
            }
            
            String message = "";
            
            switch (model.chooseWinner()) {
            case Cat:
                message += (new Cat()).toString();
                break;
            case Player1:
                message += model.player1().toString();
                break;
            case Player2:
                message += model.player2().toString();
                break;
            }
            
            message += " wins! Would you like to play again?";
            
            int option = JOptionPane.showConfirmDialog(view, message, "Game Over", JOptionPane.YES_NO_OPTION);
            
            switch (option) {
            case JOptionPane.CLOSED_OPTION:
            case JOptionPane.NO_OPTION:
                view.close();
                break;
            case JOptionPane.YES_OPTION:
                model.reset();
                view.reset();
                break;
            }
        }
        
    }
    
}
