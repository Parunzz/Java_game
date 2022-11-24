    package obj;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import Other.Resource;

import java.awt.Graphics;

public class EnemyManager {
        private List<Enemy> enemies;
        private Random random;
        private BufferedImage imagePolice1,imgWave;
        public EnemyManager(){
            enemies = new ArrayList<Enemy>(); 
            imagePolice1 = Resource.getResourceImage("img/Police.png");
            imgWave = Resource.getResourceImage("img/wave1.png");
            random = new Random();
            Police police = new Police();
            enemies.add(getRandom());
            
        }

        public void update(){
            for(Enemy e : enemies){
                e.update();
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
            Police police = new Police();
            police.setPosX(random.nextInt(1000,1500));
            if(random.nextBoolean()){
                police.setImage(imagePolice1);
            }
            else{
                police.setImage(imgWave);
            }
            return police;
        }

    
    }
    