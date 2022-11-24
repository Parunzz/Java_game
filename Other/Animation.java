package Other;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
    private ArrayList<BufferedImage> frames;
    private int frameIndex = 0;
    private int deltatime;
    private long previousTime;
    public Animation(int deltatime){
        this.deltatime = deltatime;
        frames = new ArrayList<BufferedImage>();
    }

    public void update(){
        if(System.currentTimeMillis() - previousTime > deltatime){
            frameIndex++;
            if(frameIndex >= frames.size()){
                frameIndex = 0;
            }
            previousTime = System.currentTimeMillis();
        }
    }

    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }

    public BufferedImage getFrame(){
        if(frames.size() > 0){
            return frames.get(frameIndex);
        }
        return null;
    }
}
