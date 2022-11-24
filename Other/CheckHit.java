package Other;

import java.util.List;

import obj.Balloon;
import obj.CharacterMain;

public class CheckHit {
    public static boolean checkhit(CharacterMain character,Balloon ballManU){
        return ballManU.getBound().intersects(character.getBound());
    }
    public static void checkhit2(CharacterMain character,Balloon ballManU){
        if(character.getX()+character.getWidth() > ballManU.getX() && character.getX() < ballManU.getX()){
            if(character.getY() + character.getHeight() >= ballManU.getY() - ballManU.getHeight())
            {
                character.jump();
                character.setHP(character.getHP()-1);
            }
            
        }
    }
}
