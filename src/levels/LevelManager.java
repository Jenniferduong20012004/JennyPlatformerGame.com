package levels;

import Main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    public LevelManager (Game game){
        this.game = game;
        importOutsiderSprites();
    }

    private void importOutsiderSprites() {
        levelSprite = new BufferedImage[48];
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.OUTSIDER_ATLAS);
        for (int i =0; i<4; i++){
            for (int j =0; j <12; j++){
                int index = 12*i +j;
                levelSprite[index] = img.getSubimage(j*32, i*32,32,32);
            }
        }
    }
    public void render (Graphics g){
        g.drawImage(levelSprite[10],200,200,32,32,null);
    }
    public void update(){

    }
}
