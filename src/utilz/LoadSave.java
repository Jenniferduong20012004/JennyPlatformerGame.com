package utilz;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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
    public static final String OUTSIDER_ATLAS = "Level/outside_sprites.png";
    public static final String LEVEL_ONE = "Level/level_one_data_long.png";
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
    public static int [][] GetLevelData(){
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
        int [][] lvl = {
                {40,40,40,40,26,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,27},
                {40,40,40,40,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {40,40,40,40,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {26,59,59,59,60,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {41,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,39},
                {41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39},
                {45,21,21,21,21,22,1,1,1,1,1,1,1,1,1,1,1,1,1,1,24,1,1,1,1,39},
                {40,40,40,40,40,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,105,21,21,21,21,46},
                {40,40,40,40,40,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39,40,40,40,40,40},
                {40,40,40,40,40,41,1,1,1,1,1,1,1,1,1,1,1,1,1,1,39,40,40,40,40,40},
                {40,40,40,40,40,45,21,21,21,21,21,21,21,21,21,21,21,21,21,21,46,40,40,40,40,40}

        };
        return lvl;
    }
}
