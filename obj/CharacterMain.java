package obj;
import java.awt.Graphics;
import static Frame.Game.GROUNDY;
import static Frame.Game.GRAVITY;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import Other.Animation;
import Other.Resource;

public class CharacterMain{
    private float x=0,y=0;//x , y of char
    private float speedY = 0;
    private float width = 100,height =120;
    private BufferedImage ImageJump;
    private Animation charecterRun;
    private Rectangle rect;
    public CharacterMain() {
        charecterRun = new Animation(200);//Charecter speed
        charecterRun.addFrame(Resource.getResourceImage("img/Petch1.png"));
        charecterRun.addFrame(Resource.getResourceImage("img/Petch2.png"));
        charecterRun.addFrame(Resource.getResourceImage("img/Petch3.png"));
        ImageJump = Resource.getResourceImage("img/PetchJump.png");
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
        speedY = -4;
        y += speedY;
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

    public void draw(Graphics g) {
        // super.paintComponent(g);
        g.drawRect((int)x, (int)y, (int)width, (int)height);
        if((int)y != 280){
            g.drawImage(ImageJump, (int)x, (int)y,(int)width, (int)height,null);
        }else{
            g.drawImage(charecterRun.getFrame(), (int)x, (int)y,(int)width, (int)height,null);
        }
    }

    
}
