package Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
    JButton Bplay = new JButton("play");
    JButton Bexit = new JButton("Exit");
    Menu(){
        setLayout(null);
        this.setSize(1000,500);
        Bplay.setBounds(200, 350, 100, 50);
        Bexit.setBounds(600, 350, 100, 50);
        add(Bplay);
        add(Bexit);
        System.out.println("Open Menu");
    }

}
