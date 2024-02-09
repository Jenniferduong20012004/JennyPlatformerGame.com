package utilz;

import Main.Game;

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
                        default:
                            return 0;

                    }
            }
            return 0;
        }
    }
    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
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
