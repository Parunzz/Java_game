package Frame;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

import Other.CheckHit;
import obj.*;

import java.awt.Graphics;

public class Game extends JPanel implements Runnable,KeyListener,ActionListener{
    Thread thread;
    public static final float GRAVITY = 0.08f;
    public static final float GROUNDY = 400;
    public static int Score;
    private CharacterMain mainchar;
    private Balloon ballManU;
    private Road road;
    private EnemyManager enemyManager;
    GameOver gameOver;
    
    public Game(){
        thread = new Thread(this);
        
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
        g.drawString(""+Score, 800, 20);
        if(mainchar.getHP() < 0){
            thread.stop();
            this.remove(this);
            this.setSize(1000, 500);
            gameOver = new GameOver();
            gameOver.Bplay.addActionListener(this);
            gameOver.Bexit.addActionListener(this);
            g.drawString(""+Score, 600, 300);
            this.add(gameOver);
            gameOver.requestFocusInWindow();
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==gameOver.Bplay){
            this.remove(this);
            // this.add(this);
            System.out.println("Again");
        }
        else if(e.getSource()==gameOver.Bexit){
            System.out.println("Exit");
            System.exit(0);
        }
        
    }
}
