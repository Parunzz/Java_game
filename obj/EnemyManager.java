    package obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import  static Frame.Game.Score;


import java.awt.Graphics;

public class EnemyManager {
        private List<Enemy> enemies;
        private Random random;
        CharacterMain characterMain;
         
        public EnemyManager(CharacterMain characterMain){
            this.characterMain = characterMain;
            enemies = new ArrayList<Enemy>(); 
            random = new Random();
            // Police police = new Police();

            enemies.add(getRandom());
            enemies.add(getRandom());
            enemies.add(getRandom());
            // enemies.add(getRandom());
            
        }

        public void update(){
            for(Enemy e : enemies){
                e.update();
                if(enemies.get(0).isOver() && !e.isScoreGot()){
                    if(!characterMain.getHit())
                        Score++;
                    e.setScoreGot(true);
                }
                if(e.getBound().intersects(characterMain.getBound()) && !e.isHitGot() && enemies.get(0).isOver()){
                    characterMain.jump();
                    characterMain.setHP(characterMain.getHP()-20);
                    e.setHitGot(true);
                    characterMain.setHit(true);
                }
            }

            Enemy firstEnemy = enemies.get(0);
            if(enemies.get(0).isOutOfScreen()){
                enemies.remove(firstEnemy);
                enemies.add(getRandom());
            }
        }


        public void draw(Graphics g){
            for(Enemy e : enemies){
                e.draw(g);
            }
        }

        private Police getRandom(){
            Police police = new Police(characterMain);
            police.setPosX(random.nextInt(1000,1500));
            if(random.nextBoolean()){
                police.setImage(police.getImage());
            }
            else{
                police.setImage(police.getImage2());
            }
            return police;
        }

        public void reset(){
            enemies.clear();
            enemies.add(getRandom());
        }

   

    
    }
    