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
    public static final String BUTTONS_ATLAS = "UI/button_atlas.png";
    public static final String MENU_BACKGROUND = "UI/menu_background.png";
    public static final String NAME_ATLAS = "UI/Kings and Pigs.png";
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
    }

