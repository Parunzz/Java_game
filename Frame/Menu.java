package Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

import Other.Resource;
import obj.CharacterMain;

public class Menu extends JPanel implements Runnable{
    Thread thread ;
    private BufferedImage imgBg = Resource.getResourceImage("img/KmutnbBG.png");
    private BufferedImage Police1 = Resource.getResourceImage("img/M1.png");
    private BufferedImage Police2 = Resource.getResourceImage("img/M2.png");
    JButton Bplay = new JButton("play");
    JButton Bexit = new JButton("Exit");
    CharacterMain petch ;
    Menu(){
        thread = new Thread(this);
        petch = new CharacterMain();
        thread.start();
        setLayout(null);
        this.setSize(1000,500);
        Bplay.setBounds(200, 350, 100, 50);
        Bexit.setBounds(600, 350, 100, 50);
        add(Bplay);
        add(Bexit);
        System.out.println("Open Menu");
    }
    int walk = 0;
    int X = 0, Speed = 3;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBg, 0, 0, 1000,500,this);
        if(walk < 10){
            g.drawImage(Police1, X-250, 140, 200,200,this);
            walk++;
        }
        else if(walk < 20){
            g.drawImage(Police2, X-250, 140, 200,200,this);
            walk++;
        }
        else{
            g.drawImage(Police2, X-250, 140, 200,200,this);
            walk = 0;
        }
        petch.setX(X);
        if(X < 1200){
            petch.setX(X+=Speed);  
            X+=Speed;
        }
        else{
            X = -200;
            petch.setX(X);
        }

        petch.setY(125);
        petch.setHeight(220);
        petch.setWidth(200);
        petch.drawMenu(g);
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                
                
                
                petch.Update();
                repaint();
                thread.sleep(10);
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // System.out.print("Repaint");
        }
        
    }

}
