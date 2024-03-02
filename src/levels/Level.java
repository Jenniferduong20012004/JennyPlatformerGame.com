package levels;

import Gamestates.Playing;
import Main.Game;
import entities.BoxPig;
import entities.KingPig;
import entities.Pig;
import utilz.Levels;
import utilz.LoadSave;
import utilz.helpMethods;

import java.awt.*;
import java.util.ArrayList;
import static utilz.helpMethods.GetBoxPig;
import static utilz.helpMethods.GetKingPig;

public class Level {
    private int [][] lvlData;
    private int [][][] currentLevel;
    private Playing playing;
    private int lvlTilesWide;
    private int maxTilesOffset;
    private int maxLvlOffsetX;
    private Point playerSpawn;
    private ArrayList<BoxPig> boxpigs;
    private ArrayList<KingPig> kingpigs;
    private ArrayList<Pig> pigs;

    public Level(int [][][] lvlData){
        this.currentLevel = lvlData;
        createLevelData();
        createEnemies();
        calculateLvlOffset();
        calculatePlayerSpawn();
    }

    private void calculatePlayerSpawn() {
    }

    private void calculateLvlOffset() {
        lvlTilesWide = lvlData[0].length;
        maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
        maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffset;
    }

    private void createEnemies() {
        pigs= helpMethods.GetPigs(currentLevel);
        kingpigs =GetKingPig(currentLevel);
        boxpigs = GetBoxPig(currentLevel);
    }
    public int getLvlOffset() {
        return maxLvlOffsetX;
    }
    public ArrayList<Pig> getPigs(){return pigs;}
    public ArrayList<KingPig> getKingPigs(){return kingpigs;}
    public ArrayList<BoxPig> getBoxPigs(){return boxpigs;}

    private void createLevelData() {
        lvlData = helpMethods.GetLevelData(currentLevel);
    }

    public int getSpriteIndex (int x, int y){
        return lvlData [y][x];
    }
    public int [][] getLevelData(){
        return lvlData;
    }
    public Point getPlayerSpawn() {
        return playerSpawn;
    }
}
