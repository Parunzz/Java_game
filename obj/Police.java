package obj;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Other.Resource;
import java.awt.Rectangle;

public class Police extends Enemy {
    private int posX;
    private int posY;
    private int width = 100;
    private int height = 120;
    private BufferedImage image,image2;
    private Rectangle rect;
    CharacterMain characterMain;
    boolean isScoreGot = false;
    boolean isHitGot = false;

    public Police(CharacterMain characterMain) {
        this.characterMain = characterMain;
        image = Resource.getResourceImage("img/Police.png");
        image2 = Resource.getResourceImage("img/wave1.png");
        posX=800;
        posY=300;
        rect = new Rectangle();
    }

    public void update(){
        posX-=2;
        rect.x = posX;
        rect.y = posY;
        rect.width = width;
        rect.height = height;
    }
    @Override
    public Rectangle getBound(){
        return rect;
    }
    @Override
    public void draw(Graphics g){
        g.drawRect(posX, posY,width,height);
        g.drawImage(image, posX, posY,width,height, null);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }
    public BufferedImage getImage2() {
        return image2;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void setImage2(BufferedImage image) {
        this.image2 = image;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public boolean isOutOfScreen() {
        return (posX + width < 0);
        
    }

    @Override
    public boolean isOver() {
        return (characterMain.getX() > getPosX());
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
