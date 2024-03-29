package utilz;

import Main.Game;
import entities.BoxPig;
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
    public static final String SOUND_BUTTON = "UI/sound_button.png";
    public static final String URM_BUTTON = "UI/urm_buttons.png";
    public static final String VOLUME_BUTTON = "UI/volume_buttons.png";
    public static final String B_PIG_IDLE = "Enemy/Idle (26x30).png";
    public static final String B_PIG_PICKING_BOX = "Enemy/Picking Box (26x30).png";
    public static final String B_PIG_RUN = "Enemy/Run (26x30).png";
    public static final String B_PIG_THROWING_BOX = "Enemy/Throwing Box (26x30).png";
    public static final String BIG_HEART_HIT = "UI/Big Heart Hit (18x14).png";
    public static final String BIG_HEART_IDLE = "UI/Big Heart Idle (18x14).png";
    public static final String LIVE_BAR = "UI/Live Bar.png";
    public static final String HEALTH_POWER_BAR = "UI/health_power_bar.png";
    public static final String SMALL_HEART_HIT = "UI/Small Heart Hit (18x14).png";
    public static final String SMALL_HEART_IDLE = "UI/Small Heart Idle (18x14).png";
    public static final String BIG_DIAMOND_HIT = "UI/Big Diamond Hit (18x14).png";
    public static final String BIG_DIAMOND_IDLE = "UI/Big Diamond Idle (18x14).png";
    public static final String NUMBERS = "UI/Numbers (6x8).png";
    public static final String SMALL_DIAMOND = "UI/Small Diamond (18x14).png";
    public static final String COMPLETE = "UI/completed_sprite.png";
    public static final String DEATH_SCREEN = "UI/death_screen.png";
    public static final String DOOR_IDLE = "Idle.png";
    public static final String DOOR_OPENING ="UI/Opening (46x56).png";
    public static final String DOOR_CLOSING = "UI/Closiong (46x56).png";
    public static final String BOX= "UI/objects_sprites.png";
    public static final String CANNON_IDLE = "Level/Idle.png";
    public static final String CANNON_SHOOT = "Level/Shoot (44x28).png";
    public static final String CANNON_BALL = "UI/Cannon Ball.png";
    public static final String POTION = "UI/potions_sprites.png";


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
