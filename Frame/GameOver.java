package Frame;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

import Other.Resource;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameOver extends JPanel implements ActionListener {
    private BufferedImage imgBg = Resource.getResourceImage("img/GameOver.png");
    JButton Bplay = new JButton("Play Again");
    JButton Bexit = new JButton("Exit");
    public BufferedImage getImage(){
        return imgBg;
    }
    GameOver(){
        setLayout(null);
        this.setSize(1000,500);
        Bplay.setBounds(600, 350, 100, 50);
        Bexit.setBounds(800, 350, 100, 50);
        add(Bplay);
        add(Bexit);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imgBg, 0, 0, this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
