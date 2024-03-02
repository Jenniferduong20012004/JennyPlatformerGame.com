package levels;

import Gamestates.Playing;
import Main.Game;

import utilz.Levels;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Levels.LEVEL_ONE;
import static utilz.Levels.LEVEL_TWO;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    private ArrayList<Level> levels;
    private int lvlIndex =0;
    private Playing playing;
    public LevelManager (Game game, Playing playing){
        this.game = game;
        this.playing = playing;
        importOutsiderSprites();
        levels = new ArrayList<>();
        buildAllLevel();
    }
    public Level getCurrentLevel(){return levels.get(lvlIndex);}
    public int getAmountOfLevels(){
        return levels.size();
    }
    private void buildAllLevel() {
        levels.add (new Level(LEVEL_ONE));
        levels.add (new Level(LEVEL_TWO));
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
    public void render (Graphics g, int xlvloffset){
        for (int i=0; i< Game.TILES_IN_HEIGHT; i++){
            for (int j =0; j<levels.get(lvlIndex).getLevelData()[0].length; j++){
                int index = levels.get(lvlIndex).getSpriteIndex (j,i);
                g.drawImage(levelSprite[index],Game.TILES_SIZE*j-xlvloffset,Game.TILES_SIZE*i,Game.TILES_SIZE,Game.TILES_SIZE,null);
            }
        }
    }
    public void update(){

    }

    public void loadNextLevel() {
        lvlIndex+=1;
        if (lvlIndex >= levels.size()){
            lvlIndex =0;
            game.setState(new Gamestates.Menu(game));
        }
        Level newLevel = levels.get(lvlIndex);
        playing.getEnemyManager().loadEnemies(newLevel);
        playing.getPlayer().loadlvlData(newLevel.getLevelData());
        playing.setMaxLvlOffSet(newLevel.getLvlOffset());
    }
}
