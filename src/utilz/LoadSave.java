package utilz;

import javax.imageio.ImageIO;
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
}
