package obj;
import java.awt.Rectangle;
import java.awt.Graphics;
public abstract class Enemy {
    public Enemy() {
    }

    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isOutOfScreen();
}
