package Object;

import Gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constant.ObjectConstants.*;

public class ObjectManager {
    private Playing playing;
    private BufferedImage[] potionImgs;
    private BufferedImage[][] containerImgs, heartImgs, diamondImgs;
    private ArrayList<Potion> potions = new ArrayList<>();
    private ArrayList<GameContainer> containers = new ArrayList<>();
    public ObjectManager(Playing playing){
        this.playing=playing;
        loadImgs();
        potions.add (new Potion (300,300,2));
        containers.add (new GameContainer(500,300, BARREL));
        containers.add (new GameContainer(600,300, BOX));
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
    }
    public void render (Graphics g, int xLvlOffset){
        renderPotion (g, xLvlOffset);
        renderContainer(g, xLvlOffset);
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
            g.drawImage(potionImgs[p.getAniIndex()], (int)(p.getHitbox().x-p.getxDrawOffset()-xLvlOffset),(int)(p.getHitbox().y-p.getyDrawOffset()), POTION_WIDTH, POTION_HEIGHT, null);
        }
    }
}
