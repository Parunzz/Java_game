package Other;

import obj.Balloon;
import static Frame.Game.Score;
import obj.CharacterMain;
import obj.Police;

public class CheckHit {
    public static void checkhit(CharacterMain character,Balloon ballManU){
        // System.out.println(ballManU.isYOver());
        if (ballManU.getBound().intersects(character.getBound()) && !ballManU.isHitGot() && !ballManU.isOver() && ballManU.isYOver()){
            character.jump();
            character.setHP(character.getHP()-10);
            ballManU.setHitGot(false);
            character.setHit(true);
            // System.out.println("hit ball");
        }
        if(ballManU.isOver() && !ballManU.isScoreGot()){
            if(!character.getHit())
                Score++;
                ballManU.setScoreGot(true);
        }
    }
}
