package Object;

import Gamestates.Playing;
import Main.Game;
import levels.Level;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constant.ObjectConstants.*;

public class ObjectManager {
    private Playing playing;
    private BufferedImage[] potionImgs,heartImgs;
    private BufferedImage[][] containerImgs, diamondImgs;
    private ArrayList<Heart> hearts = new ArrayList<>();
    private ArrayList<Potion> potions = new ArrayList<>();
    private ArrayList<GameContainer> containers = new ArrayList<>();
    public ObjectManager(Playing playing){
        this.playing=playing;
        loadImgs();}
    public void checkObjectTouch(Rectangle2D.Float hitbox){
        for (Heart h: hearts){
            if (h.isActive()){
                if (hitbox.intersects(h.getHitbox())){
                    h.setActive(false);
                    h.applyEffectToPlayer(playing);
                }
            }
        }
        for (Potion p: potions){
            if (p.isActive())
                 if (hitbox.intersects(p.getHitbox())){
                     p.setActive(false);
                     p.applyEffectToPlayer(playing);
                 }
        }

    }
    public void checkObjectHit(Rectangle2D.Float hitbox){
        for (GameContainer gc: containers){
            if (gc.isActive()){
                if (gc.getHitbox().intersects(hitbox)){
                    gc.setAnimation(true);
                    if(gc.getObjType()==BOX){
                        potions.add(new Potion ((int)(gc.getHitbox().x+gc.getHitbox().width/2),(int)(gc.getHitbox().y-gc.getHitbox().height), BLUE_POTION));
                        return;
                    }
                    else if (gc.getObjType()== BARREL){
                        hearts.add(new Heart ((int)(gc.getHitbox().x+gc.getHitbox().width/2),(int)(gc.getHitbox().y), HEART));
                        return;
                    }
                }
            }
        }
    }
    private void loadImgs() {
        BufferedImage potionSprite = LoadSave.GetSpriteAtlas(LoadSave.POTION);
        potionImgs = new BufferedImage[7];
        for (int j =0; j < potionImgs.length; j++){
            potionImgs [j]= potionSprite.getSubimage(12*j, 0,12,16);
        }
        BufferedImage containerSprite = LoadSave.GetSpriteAtlas(LoadSave.BOX);
        containerImgs = new BufferedImage[2][7];
        for (int j =0; j <containerImgs.length; j++){
            for (int i =0; i<containerImgs[j].length; i++){
                containerImgs[j][i]= containerSprite.getSubimage(40*i, 30*j, 40,30);
            }
        }
        BufferedImage heartSprite = LoadSave.GetSpriteAtlas(LoadSave.BIG_HEART_IDLE);
        heartImgs= new BufferedImage[10];
        for (int i =0; i < 8; i++){
            heartImgs[i] = heartSprite.getSubimage(18*i,0,18,14);
        }
        BufferedImage heartHit = LoadSave.GetSpriteAtlas(LoadSave.BIG_HEART_HIT);
        heartImgs[8]= heartHit.getSubimage(18*0,0,18,14);
        heartImgs[9]= heartHit.getSubimage(18*1,0,18,14);
    }
    public void update(){
        for (Potion p: potions) {
            if (p.isActive()) {
                p.update();
            }
        }
        for (GameContainer gc : containers){
            if (gc.isActive())
                gc.update();
        }
        for (Heart h: hearts){
            if (h.isActive()){
                h.update();
            }
        }
    }
    public void renderHeart (Graphics g, int xLvlOffset){
        for (Heart gc:hearts){
            if (gc.isActive()){
                g.drawImage(heartImgs[gc.getAniIndex()], (int)(gc.getHitbox().x-gc.getxDrawOffset()-xLvlOffset),(int)(gc.getHitbox().y-gc.getyDrawOffset()), HEART_WIDTH, HEART_HEIGHT, null);
            }
        }
    }
    public void render (Graphics g, int xLvlOffset){
        renderPotion (g, xLvlOffset);
        renderContainer(g, xLvlOffset);
        renderHeart(g,xLvlOffset);
    }

    private void renderContainer(Graphics g, int xLvlOffset) {
        for (GameContainer gc:containers){
            if (gc.isActive()){
                int type =0;
                if (gc.getObjType()==BARREL){
                    type =1;
                }
                g.drawImage(containerImgs[type][gc.getAniIndex()], (int)(gc.getHitbox().x-gc.getxDrawOffset()-xLvlOffset),(int)(gc.getHitbox().y-gc.getyDrawOffset()), CONTAINER_WIDTH, CONTAINER_HEIGHT, null);
            }
        }
    }

    private void renderPotion(Graphics g, int xLvlOffset) {
        for (Potion p: potions){
            if (p.isActive()) {
                g.drawImage(potionImgs[p.getAniIndex()], (int) (p.getHitbox().x - p.getxDrawOffset() - xLvlOffset), (int) (p.getHitbox().y - p.getyDrawOffset()), POTION_WIDTH, POTION_HEIGHT, null);
            }
        }
    }

    public void loadObject(Level newLevel) {
        potions= newLevel.getPotion();
        containers = newLevel.getGameContainers();
        hearts = newLevel.getHeart();
    }

    public void resetAll() {
        for (Heart h: hearts){
            h.reset();
        }
        for (Potion p: potions){
            p.reset();
        }
        for (GameContainer gc:containers){
            gc.reset();
        }
    }
}
