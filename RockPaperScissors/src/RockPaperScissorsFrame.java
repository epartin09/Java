/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Erica
 */
public class RockPaperScissorsFrame extends JFrame {
    
    private HumanPlayer me = null;
    private ComputerPlayer ai = null;
    
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    // </editor-fold>
    
    public RockPaperScissorsFrame(String title) {
        super(title);
        initComponents();
        me = new HumanPlayer();
        ai = new ComputerPlayer();
    }
    
    private void button1_OnActionPerformed(ActionEvent e) {
        me.setHand(Hand.Rock);
        onActionPerformed(e);
    }
    
    private void button2_OnActionPerformed(ActionEvent e) {
        me.setHand(Hand.Paper);
        onActionPerformed(e);
    }
    
    private void button3_OnActionPerformed(ActionEvent e) {
        me.setHand(Hand.Scissors);
        onActionPerformed(e);
    }
    
    private void button4_OnActionPerformed(ActionEvent e) {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    private Winner chooseWinner(Player player1, Player player2) {
        Hand p1Hand = player1.hand();
        Hand p2Hand = player2.hand();
        
        switch (p1Hand) {
            case Rock:
                switch (p2Hand) {
                    case Paper:
                        return Winner.Player2;
                    case Scissors:
                        return Winner.Player1;
                }
                break;
            case Paper:
                switch (p2Hand) {
                    case Rock:
                        return Winner.Player1;
                    case Scissors:
                        return Winner.Player2;
                }
                break;
            case Scissors:
                switch (p2Hand) {
                    case Rock:
                        return Winner.Player2;
                    case Paper:
                        return Winner.Player1;
                }
                break;
        }
        
        return Winner.None;
    }
    
    private void initComponents() {
        // "Game" Panel
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setLayout(new GridLayout(2, 2));
        button1 = new JButton();
        button1.setIcon(new ImageIcon("images/rock.png"));
        button1.addActionListener((ActionEvent e) -> {
            button1_OnActionPerformed(e);
        });
        panel1.add(button1);
        button2 = new JButton();
        button2.setIcon(new ImageIcon("images/paper.png"));
        button2.addActionListener((ActionEvent e) -> {
            button2_OnActionPerformed(e);
        });
        panel1.add(button2);
        button3 = new JButton();
        button3.setIcon(new ImageIcon("images/scissors.png"));
        button3.addActionListener((ActionEvent e) -> {
            button3_OnActionPerformed(e);
        });
        panel1.add(button3);
        button4 = new JButton("Quit");
        button4.addActionListener((ActionEvent e) -> {
            button4_OnActionPerformed(e);
        });
        panel1.add(button4);
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        
        // "Stats" Panel
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 2));
        label1 = new JLabel("Player Wins: ");
        panel2.add(label1);
        textField1 = new JTextField("0");
        textField1.setEditable(false);
        panel2.add(textField1);
        label2 = new JLabel("Computer Wins: ");
        panel2.add(label2);
        textField2 = new JTextField("0");
        textField2.setEditable(false);
        panel2.add(textField2);
        label3 = new JLabel("Ties: ");
        panel2.add(label3);
        textField3 = new JTextField("0");
        textField3.setEditable(false);
        panel2.add(textField3);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        
        // "Results" Panel
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        textArea1 = new JTextArea(6, 50);
        textArea1.setEditable(false);
        scrollPane1 = new JScrollPane(textArea1);
        panel3.add(scrollPane1);
        this.getContentPane().add(panel3, BorderLayout.SOUTH);
    }
    
    private void onActionPerformed(ActionEvent e) {
        ai.setOpponent(me);
        // The strategy chosen may result in no hand
        // (e.g. Least/Most Used Strategy when Rock == Paper, etc.)
        Strategy strategy;
        Hand hand;
        do {
            strategy = ai.chooseStrategy();
            hand = strategy.chooseHand();
        } while (hand == Hand.None);
        ai.setHand(hand);
        updateStats(me, ai);
        updateResults(me, ai);
    }
    
    public void updateResults(Player player1, Player player2) {
        String str = player1.hand().toString();
        
        switch (chooseWinner(player1, player2)) {
            case None:
                str += " ties with " + player2.hand().toString();
                break;
            case Player1:
                str += " wins against " + player2.hand().toString();
                break;
            case Player2:
                str += " loses to " + player2.hand().toString();
                break;
        }
        
        str += " - " + player2.strategy().toString() + System.lineSeparator();
        
        textArea1.append(str);
    }
    
    public void updateStats(Player player1, Player player2) {
        Stats p1Stats = player1.stats();
        Stats p2Stats = player2.stats();
        
        switch (player1.hand()) {
            case Rock:
                p1Stats.setRock(p1Stats.getRock() + 1);
                break;
            case Paper:
                p1Stats.setPaper(p1Stats.getPaper() + 1);
                break;
            case Scissors:
                p1Stats.setScissors(p1Stats.getScissors() + 1);
                break;
        }
        
        switch (player2.hand()) {
            case Rock:
                p2Stats.setRock(p2Stats.getRock() + 1);
                break;
            case Paper:
                p2Stats.setPaper(p2Stats.getPaper() + 1);
                break;
            case Scissors:
                p2Stats.setScissors(p2Stats.getScissors() + 1);
                break;
        }
        
        switch (chooseWinner(player1, player2)) {
            case None:
                p1Stats.setTies(p1Stats.getTies() + 1);
                p2Stats.setTies(p2Stats.getTies() + 1);
                break;
            case Player1:
                p1Stats.setWins(p1Stats.getWins() + 1);
                p2Stats.setLosses(p2Stats.getLosses() + 1);
                break;
            case Player2:
                p1Stats.setLosses(p1Stats.getLosses() + 1);
                p2Stats.setWins(p2Stats.getWins() + 1);
                break;
        }
        
        textField1.setText(String.valueOf(p1Stats.getWins()));
        textField2.setText(String.valueOf(p2Stats.getWins()));
        textField3.setText(String.valueOf(p1Stats.getTies()));
    }
    
}
