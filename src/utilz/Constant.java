package utilz;

import Main.Game;

import java.util.Collection;

public class Constant {
    public static class EnemyConstants {
        public static final int PIG = 0;
        public static final int ATTACK = 0;
        public static final int DEAD = 1;
        public static final int FALLING = 2;
        public static final int GROUND = 3;
        public static final int HIT = 4;
        public static final int IDLE = 5;
        public static final int JUMP = 6;
        public static final int RUN = 7;
        public static final int PIG_WIDTH_DEFAULT = 34;
        public static final int PIG_HEIGHT_DEFAULT = 28;
        public static final int PIG_WIDTH = (int) (PIG_WIDTH_DEFAULT * Game.SCALE);
        public static final int PIG_HEIGHT = (int) (PIG_HEIGHT_DEFAULT * Game.SCALE);
        public static int PIG_DRAWOFFSET_X = (int) (10*Game.SCALE);
        public static int PIG_DRAWOFFSET_Y = (int) (10*Game.SCALE);
        public static final int KING_PIG = 1;
        public static final int K_ATTACK = 0;
        public static final int K_DEAD = 1;
        public static final int K_FALLING = 2;
        public static final int K_GROUND = 3;
        public static final int K_HIT = 4;
        public static final int K_IDLE = 5;
        public static final int K_JUMP = 6;
        public static final int K_RUN = 7;
        public static final int K_PIG_WIDTH_DEFAULT = 38;
        public static final int K_PIG_HEIGHT_DEFAULT = 28;
        public static final int K_PIG_WIDTH = (int) (K_PIG_WIDTH_DEFAULT * Game.SCALE);
        public static final int K_PIG_HEIGHT = (int) (K_PIG_HEIGHT_DEFAULT * Game.SCALE);
        public static int K_PIG_DRAWOFFSET_X = (int) (10*Game.SCALE);
        public static int K_PIG_DRAWOFFSET_Y = (int) (10*Game.SCALE);
        public static final int B_PIG = 2;
        public static final int B_IDLE = 0;
        public static final int B_PICKING_BOX = 1;
        public static final int B_RUN = 2;
        public static final int B_THROWING_BOX = 3;
        public static final int B_PIG_WIDTH_DEFAULT = 21;
        public static final int B_PIG_HEIGHT_DEFAULT = 27;
        public static final int B_PIG_WIDTH = (int) (B_PIG_WIDTH_DEFAULT * Game.SCALE);
        public static final int B_PIG_HEIGHT = (int) (B_PIG_HEIGHT_DEFAULT * Game.SCALE);
        public static int B_PIG_DRAWOFFSET_X = (int) (10*Game.SCALE);
        public static int B_PIG_DRAWOFFSET_Y = (int) (10*Game.SCALE);

        public static int getSpriteAmount(int enemyType, int enemyState) {
            switch (enemyType) {
                case PIG:
                    switch (enemyState) {
                        case ATTACK:
                            return 5;
                        case IDLE:
                            return 11;
                        case JUMP:
                            return 1;
                        case FALLING:
                            return 1;
                        case GROUND:
                            return 1;
                        case HIT:
                            return 2;
                        case DEAD:
                            return 4;
                        case RUN:
                            return 6;
                        default:
                            return 0;

                    }
                case KING_PIG:
                    switch(enemyState){
                        case K_ATTACK:
                            return 5;
                        case K_IDLE:
                            return 12;
                        case K_JUMP:
                            return 1;
                        case K_FALLING:
                            return 1;
                        case K_GROUND:
                            return 1;
                        case K_HIT:
                            return 2;
                        case K_DEAD:
                            return 4;
                        case K_RUN:
                            return 6;
                        default:
                            return 0;
                    }
                case B_PIG:
                    switch (enemyState){
                        case B_IDLE:
                            return 9;
                        case B_PICKING_BOX:
                            return 5;
                        case B_RUN:
                            return 6;
                        case B_THROWING_BOX:
                            return 5;
                    }
            }
            return 0;
        }
        public static int GetMaxHealth(int enemyType){
            switch ( enemyType){
                case PIG, B_PIG:
                    return 20;
                case KING_PIG:
                    return 40;
                default:
                    return 1;
            }
        }
        public static int GeEnemyDamage(int enemyType){
            switch (enemyType){
                case PIG:
                    return 15;
                case KING_PIG:
                    return 35;
                case B_PIG:
                    return 0;
                default:
                    return 0;
            }
        }
    }
    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;

            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);

        }
        public static class PauseButtons{
            public static final int SOUND_SIZE_DEFAULT=42;
            public static final int SOUND_SIZE = (int)(Game.SCALE*SOUND_SIZE_DEFAULT);
        }
        public static class UmrButtons{
            public static final int UMR_SIZE_DEFAULT=56;
            public static final int UMR_SIZE = (int)(Game.SCALE*UMR_SIZE_DEFAULT);
        }
        public static class VolumeButtons{
            public static final int VOLUME_DEFAULT_WIDTH=28;
            public static final int VOLUME_DEFAULT_HEIGHT=44;
            public static final int SLIDER_DEFAULT_WIDTH=215;
            public static final int VOLUME_WIDTH = (int)(Game.SCALE*VOLUME_DEFAULT_WIDTH);
            public static final int VOLUME_HEIGHT = (int)(Game.SCALE*VOLUME_DEFAULT_HEIGHT);
            public static final int SLIDER_WIDTH = (int)(Game.SCALE*SLIDER_DEFAULT_WIDTH);

        }
    }
    public static class Directions{
        public static final int LEFT =0;
        public static final int UP =1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants{
        public static final int RUNNING =0;
        public static final int IDLE =1;
        public static final int JUMP =2;
        public static final int FALLING = 3;
        public static final int HIT =4;
        public static final int ATTACK = 5;
        public static final int DOOR_OUT =6;
        public static final int DOOR_IN =7;
        public static final int DEAD = 8;
        public static final int GROUND = 9;
        public static int getSpriteAmount(int player_action){
            switch (player_action){
                case RUNNING:
                    return 8;
                case IDLE:
                    return 11;
                case JUMP:
                    return 1;
                case FALLING:
                    return 1;
                case GROUND:
                    return 1;
                case HIT:
                    return 2;
                case ATTACK:
                    return 3;
                case DOOR_OUT:
                    return 8;
                case DOOR_IN:
                    return 8;
                case DEAD:
                    return 4;
                default:
                    return 1;

            }
        }
    }

}
