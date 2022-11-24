package obj;
import java.awt.Graphics;

import Other.Resource;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

public class Balloon extends Enemy {
    private BufferedImage imgball;
    private List<Ball> balls;
    private Random random;
    private Rectangle rect;
    private int width=100,height=100;
    CharacterMain characterMain;
    private boolean isHitGot;
    private boolean isScoreGot;
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public Balloon(CharacterMain characterMain) {
        this.characterMain = characterMain;
        random = new Random();
        imgball = Resource.getResourceImage("img/BallManU.png");
        balls = new ArrayList<Ball>();
        Ball ball1 = new Ball();
        rect = new Rectangle();
        RandomBall();
    }
    public void RandomBall(){
        Ball ball1 = new Ball();
        ball1.posX = random.nextFloat(1000,2000);
        ball1.posY = random.nextFloat(300);
        balls.add(ball1);
    }

    public Rectangle getBound(){
        return rect;
    }
    public float getX(){
        return balls.get(0).posX;
    }
    public float getY(){
        return balls.get(0).posY;
    }

    public void update(){
        for(Ball ball: balls){
            ball.posX -=5;
            rect.x = (int)ball.posX;
            rect.y = (int)ball.posY;
            rect.width = width;
            rect.height = height;
        }
        Ball fBall = balls.get(0);
        if(fBall.posX + imgball.getWidth() < 0){
            // fBall.posX = balls.get(balls.size() - 1).posX + 100;
            fBall.posX = 1000;
            balls.remove(fBall);
            // balls.add(fBall);
            RandomBall();
        }
    }

    public void draw(Graphics g){
        for(Ball ball: balls){
            g.drawRect((int) ball.posX, (int)ball.posY,width,height);
            g.drawImage(imgball,(int) ball.posX, (int)ball.posY,width,height ,null);

        }
    }
    @Override
    public boolean isOutOfScreen() {
        return (balls.get(0).posX + width < 0);
    }
    
    private class Ball{
        float posX;
        float posY;
    }

    @Override
    public boolean isOver() {
        return characterMain.getX() > getX();
    }

    @Override
    public boolean isScoreGot() {
        return isScoreGot;
    }

    @Override
    public void setScoreGot(boolean isScoreGot) {
        this.isScoreGot = isScoreGot;
    }
    
    @Override
    public boolean isHitGot() {
        return isHitGot;
    }

    @Override
    public void setHitGot(boolean isHitGot) {
        this.isHitGot = isHitGot;
    }

}
