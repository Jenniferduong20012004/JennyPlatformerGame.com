package levels;

import Main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.Game.TILES_SIZE;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;
    public LevelManager (Game game){
        this.game = game;
        importOutsiderSprites();
        levelOne = new Level(LoadSave.GetLevelData());
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
        for (int i=0; i< Game.TILES_IN_HEIGHT; i++){
            for (int j =0; j<Game.TILES_IN_WIDTH; j++){
                int index = levelOne.getSpriteIndex (j,i);
                g.drawImage(levelSprite[index],Game.TILES_SIZE*j,Game.TILES_SIZE*i,Game.TILES_SIZE,Game.TILES_SIZE,null);
            }
        }
    }
    public void update(){

    }
}
