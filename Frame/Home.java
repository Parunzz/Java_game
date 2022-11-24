package Frame;

import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.event.*;

class Home extends JFrame implements ActionListener {
    Menu menu;
    Game game;

    Home() {
        menu = new Menu();
        add(menu);
        menu.Bplay.addActionListener(this);
        menu.Bexit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menu.Bplay) {
            this.setLocationRelativeTo(null);
            this.remove(menu);
            this.setSize(1000, 500);
            game = new Game();
            this.add(game);
            game.addKeyListener(game);
            game.requestFocusInWindow();

        } else if (e.getSource() == menu.Bexit) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }

    public static void main(String[] args) {
        Home frame = new Home();
        frame.setSize(1000, 500);
        frame.setTitle("CSB RUN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}