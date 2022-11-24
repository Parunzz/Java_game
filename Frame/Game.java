package Frame;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import Other.CheckHit;
import Other.Resource;
import obj.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Game extends JPanel implements Runnable,KeyListener,ActionListener{
    Thread thread;
    Thread t1;
    public static final float GRAVITY = 0.08f;
    public static final float GROUNDY = 400;
    public static int time = 0;
    private BufferedImage imgBg = Resource.getResourceImage("img/GameOver.png");
    JButton Bexit = new JButton("Exit");
    public static int Score;
    private CharacterMain mainchar;
    private Balloon ballManU;
    private Road road;
    private EnemyManager enemyManager;
    GameOver gameOver;
    // Font f = new Font();
    
    public Game(){
        thread = new Thread(this);
        t1 = new Thread(new Runnable(){
            public void run() {
                while (true) {
                    try {
                        time++;
                        t1.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
            }
        });
        t1.start();
        mainchar = new CharacterMain();
        road = new Road(this);
        ballManU = new Balloon(mainchar);
        enemyManager = new EnemyManager(mainchar);
        thread.start();
        System.out.println("Start");

    }



    @Override
    public void run() {
        while(true){
            try {
                mainchar.Update();
                road.update();
                ballManU.update();
                enemyManager.update();
                CheckHit.checkhit(mainchar, ballManU);
                repaint();
                thread.sleep(8);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int a = e.getKeyCode();
            if(a == KeyEvent.VK_W || a == KeyEvent.VK_UP || a == KeyEvent.VK_SPACE){
                if(mainchar.getY() > 10)
                    mainchar.jump();
                
            }
            if(a == KeyEvent.VK_D || a == KeyEvent.VK_RIGHT){
                float mx = mainchar.getX()+10;
                mainchar.setX(mx);
                if(mainchar.getX() > 1000){
                    mainchar.setX(-50);
                }
                
            }
            if(a == KeyEvent.VK_A || a == KeyEvent.VK_LEFT){
                if(mainchar.getX() > 0){
                    float mx = mainchar.getX()-10;
                    mainchar.setX(mx);
                }
            }

        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    //-------------Paint-----------------------
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);
        road.draw(g);
        ballManU.draw(g);
        mainchar.draw(g);
        enemyManager.draw(g);
        g.setColor(Color.white);
        g.drawString("Score : "+Score, 600, 50);
        // Game over ---------------------
        if(mainchar.getHP() <= 0){
            mainchar.setHP(0);
            mainchar.draw(g);
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
            thread.stop();
            t1.stop();
            g.drawImage(imgBg, 0, 0, 1000, 500, this);
            Bexit.setBounds(500, 400, 100, 50);
            Bexit.addActionListener(this);
            add(Bexit);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.setColor(Color.orange);
            g.drawString(""+Score, 800, 230);
            g.drawString("Time : "+time+" sec", 520, 340);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Bexit){
            // System.out.println("Exit");
            System.exit(0);
        }
        
        
    }
}
