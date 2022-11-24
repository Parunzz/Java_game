package Frame;

import javax.swing.JPanel;

import obj.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements Runnable,KeyListener{
    Thread thread;
    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 400;
    private CharacterMain mainchar;
    private Balloon ballManU;
    private Road road;
    private EnemyManager enemyManager;
    
    public Game(){
        thread = new Thread(this);
        mainchar = new CharacterMain();
        road = new Road(this);
        ballManU = new Balloon();
        enemyManager = new EnemyManager();
        thread.start();
        System.out.println("Start");

    }
    public void startGame(){
        // thread.start();
    }



    @Override
    public void run() {
        
        while(true){
            try {
                mainchar.Update();
                road.update();
                ballManU.update();
                enemyManager.update();
                repaint();
                thread.sleep(10);
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
                float mx = mainchar.getX()+5;
                mainchar.setX(mx);
            }
            if(a == KeyEvent.VK_A || a == KeyEvent.VK_LEFT){
                float mx = mainchar.getX()-5;
                mainchar.setX(mx);
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

    }
}
