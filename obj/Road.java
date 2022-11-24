package obj;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Frame.Game;
import Other.Resource;

public class Road {
    private BufferedImage imgRoad1,imgRoad2,imgRoad3;
    private List<ImageRoad> listImage;

    public Road(Game game) {
        imgRoad1 = Resource.getResourceImage("img/Road1.png");
        imgRoad2 = Resource.getResourceImage("img/Road2.png");
        imgRoad3 = Resource.getResourceImage("img/Road3.png");
        listImage = new ArrayList<ImageRoad>();
        int numberOfTitle = 1000/imgRoad1.getWidth()+2;
        for(int i=0;i<numberOfTitle;i++){
            ImageRoad IRoad = new ImageRoad();
            IRoad.posX = (int)(i * imgRoad1.getWidth());
            IRoad.image = imgRoad1;
            if(i==0)
                IRoad.image = imgRoad1;
            else if(i==1)
                IRoad.image = imgRoad2;
            else
                IRoad.image = imgRoad3;

            listImage.add(IRoad);
        }
    }

    public void update(){
        for(ImageRoad imageRoad : listImage){
            imageRoad.posX -=2;
        }
        ImageRoad first = listImage.get(0);
        if(listImage.get(0).posX + imgRoad1.getWidth() < 0){
            first.posX = listImage.get(listImage.size() - 1).posX + imgRoad1.getWidth();
            listImage.add(listImage.get(0));
            listImage.remove(0);
        }
    }

    public void draw(Graphics g){
        for(ImageRoad imageRoad:listImage){
            g.drawImage(imageRoad.image, imageRoad.posX, 0, null);
        }
        // g.drawImage(imgRoad1, 0, 0, null);
        // g.drawImage(imgRoad2, 845, 0, null);
    }
    private class ImageRoad{
        int posX;
        BufferedImage image;
    }
}
