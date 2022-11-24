package Other;

import obj.Balloon;
import obj.CharacterMain;
import obj.Police;

public class CheckHit {
    public static void checkhit(CharacterMain character,Balloon ballManU){
        if (ballManU.getBound().intersects(character.getBound()) && !ballManU.isHitGot() && ballManU.isOver()){
            character.jump();
            character.setHP(character.getHP()-10);
            ballManU.setHitGot(true);
            character.setHit(true);
        }
    }
    public static void checkhit2(CharacterMain character,Police police){
        if (police.getBound().intersects(character.getBound())){
            character.jump();
            character.setHP(character.getHP()-1);
        }
    }
}
