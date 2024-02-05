package levels;

import Main.Game;
import utilz.LevelBuild;
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
        levelOne = new Level(LoadSave.GetLevelData(LevelBuild.LEVEL_ONE));
    }

    private void importOutsiderSprites() {
        levelSprite = new BufferedImage[247];
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.TERRAIN_ATLAS);
        for (int i =0; i<13; i++){
            for (int j =0; j <19; j++){
                int index = 19*i +j;
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
