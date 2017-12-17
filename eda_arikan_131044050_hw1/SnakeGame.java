/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eda
 */
public class SnakeGame extends JFrame {

    public SnakeGame(Snake snake) {
        add(new Board(snake));
        setResizable(false);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        int flag = 0;

        do {
            String enteredString = JOptionPane.showInputDialog("Select a snake\n1 - Python\n2 - Anaconda");

            if (enteredString == null) {
                break;
            }
            
            if (enteredString.equals("1")) {
                Snake snake = new Python();
                flag = 1;
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame ex = new SnakeGame(snake);
                        ex.setVisible(true);
                    }
                });
            } else if (enteredString.equals("2")) {
                Snake snake = new Anaconda();
                flag = 1;
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame ex = new SnakeGame(snake);
                        ex.setVisible(true);
                    }
                });
            }
        } while (flag == 0);
    }

}
