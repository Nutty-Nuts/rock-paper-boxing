package main;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window(Panel panel) {
        add(panel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
