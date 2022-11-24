package obj;
import java.awt.Graphics;
import static Frame.Game.GROUNDY;
import static Frame.Game.GRAVITY;
import static Frame.Game.time;
import static obj.Balloon.isScoreGot;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import Other.Animation;
import Other.Resource;

public class CharacterMain{
    private float x=0,y=0;//x , y of char
    private float speedY = 0;
    private float width = 100,height =120;
    private boolean Hit = false;
    



    private int HP = 100;


    private BufferedImage ImageJump,ImageJump2;
    private Animation charecterRun;
    private Rectangle rect;
    private Balloon b;
    public CharacterMain() {
        charecterRun = new Animation(200);//Charecter speed
        charecterRun.addFrame(Resource.getResourceImage("img/Petch1.png"));
        charecterRun.addFrame(Resource.getResourceImage("img/Petch2.png"));
        charecterRun.addFrame(Resource.getResourceImage("img/Petch3.png"));
        ImageJump = Resource.getResourceImage("img/PetchJump.png");
        ImageJump2 = Resource.getResourceImage("img/PetchJump2.png");
        rect = new Rectangle();
    }
    public void Update(){
        charecterRun.update();
        //for jump
        if(y >= GROUNDY - height){
            speedY+=0;//stop
            y = GROUNDY - height;//stand
        }else{
            speedY+=GRAVITY;
            y+=speedY;
        }
        rect.x = (int)x;
        rect.y = (int)y;
        rect.width = (int)width;
        rect.height =(int)height;
    }
    public void jump(){
        speedY = -6;
        y += speedY;
    }

    public boolean getHit(){
        return Hit;
    }
    public void setHit(boolean hit) {
        Hit = hit;
    }

    public Rectangle getBound(){
        return rect;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getSpeedY() {
        return speedY;
    }
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int hP) {
        HP = hP;
    }

    public void draw(Graphics g) {
        // super.paintComponent(g);
        g.drawRect((int)x, (int)y, (int)width, (int)height);
        if((int)y != 280){
            if(getHit()){
                g.drawImage(ImageJump2, (int)x, (int)y,(int)width, (int)height,null);
            }else{
                g.drawImage(ImageJump, (int)x, (int)y,(int)width, (int)height,null);
                
            }
        }else{
            g.drawImage(charecterRun.getFrame(), (int)x, (int)y,(int)width, (int)height,null);
            setHit(false);
            
            
        }
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        // g.drawString("HP : "+HP+" %", 20, 50);
        // g.drawRect(0, 0, HP, 100);
        g.setColor(Color.red);
        if(HP > 0)
            g.fillRect(0, 0, HP*5, 20);

    }
    public void drawMenu(Graphics g) {
        g.drawImage(charecterRun.getFrame(), (int)x, (int)y,(int)width, (int)height,null);
    }

    
}
