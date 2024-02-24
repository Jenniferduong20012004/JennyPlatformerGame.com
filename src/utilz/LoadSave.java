package utilz;

import Main.Game;
import entities.KingPig;
import entities.Pig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LoadSave {
    public static final String PLAYER_ATTACK = "Player/Attack (78x58).png";
    public static final String PLAYER_DEAD = "Player/Dead (78x58).png";
    public static final String PLAYER_DOOR_IN ="Player/Door In (78x58).png";
    public static final String PLAYER_DOOR_OUT = "Player/Door Out (78x58).png";
    public static final String PLAYER_FALLING = "Player/Fall (78x58).png";
    public static final String PLAYER_GROUND = "Player/Ground (78x58).png";
    public static final String PLAYER_HIT = "Player/Hit (78x58).png";
    public static final String PLAYER_IDLE = "Player/Idle (78x58).png";
    public static final String PLAYER_JUMP = "Player/Jump (78x58).png";
    public static final String PLAYER_RUN = "Player/Run (78x58).png";
    public static final String TERRAIN_ATLAS = "Level/Terrain (32x32).png";
    public static final String DECORATION_ATLAS= "Level/Decorations (32x32).png";
    public static final String BUTTONS_ATLAS = "UI/button_atlas.png";
    public static final String MENU_BACKGROUND = "UI/menu_background.png";
    public static final String NAME_ATLAS = "UI/Kings and Pigs.png";
    public static final String PINK_ATLAS = "UI/background_menu.png";
    public static final String PIG_ATTACK = "Enemy/Attack (34x28).png";
    public static final String PIG_DEAD = "Enemy/Dead (34x28).png";
    public static final String PIG_FALL = "Enemy/Fall (34x28).png";
    public static final String PIG_GROUND = "Enemy/Ground (34x28).png";
    public static final String PIG_HIT = "Enemy/Hit (34x28).png";
    public static final String PIG_IDLE = "Enemy/Idle (34x28).png";
    public static final String PIG_JUMP = "Enemy/Jump (34x28).png";
    public static final String PIG_RUN = "Enemy/Run (34x28).png";
    public static final String K_PIG_ATTACK = "Enemy/Attack (38x28).png";
    public static final String K_PIG_DEAD = "Enemy/Dead (38x28).png";
    public static final String K_PIG_FALL = "Enemy/Fall (38x28).png";
    public static final String K_PIG_GROUND = "Enemy/Ground (38x28).png";
    public static final String K_PIG_HIT = "Enemy/Hit (38x28).png";
    public static final String K_PIG_IDLE = "Enemy/Idle (38x28).png";
    public static final String K_PIG_JUMP = "Enemy/Jump (38x28).png";
    public static final String K_PIG_RUN = "Enemy/Run (38x28).png";
    public static final String PAUSE_BACKGROUND ="UI/pause_menu.png";

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img=null;
        InputStream is = LoadSave.class.getResourceAsStream("/"+fileName);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
    public static int [][] GetLevelData(int [][] lvlChoose){
        /*int [][] lvlData = new int [100][100];
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ONE);
        for (int i =0;i< img.getHeight(); i++){
            for (int j =0; j< img.getWidth(); j++){
                Color color = new Color(img.getRGB(j,i));
                int value = color.getRed();
                if(value >=48){
                    value = 0;
                }
                lvlData[i][j]=value;
            }
        }
        return lvlData;*/
        int [][] lvl = lvlChoose;
        return lvl;
        }
        public static ArrayList<Pig> GetPigs(int [][] lvlChoose){
            ArrayList<Pig> list = new ArrayList<>();
            for (int i =0; i< lvlChoose.length;i++){
                for (int j =0; j<lvlChoose[i].length;j++){
                    if (lvlChoose [i][j]==1){
                        list.add (new Pig(j*Game.TILES_SIZE,i*Game.TILES_SIZE));
                    }
                }
            }
            return list;
        }

    public static ArrayList<KingPig> GetKingPig(int[][] lvlChoose) {
        ArrayList<KingPig> list = new ArrayList<>();
        for (int i =0; i< lvlChoose.length;i++){
            for (int j =0; j<lvlChoose[i].length;j++){
                if (lvlChoose [i][j]==2){
                    list.add (new KingPig(j*Game.TILES_SIZE,i*Game.TILES_SIZE));
                }
            }
        }
        return list;
    }
}

