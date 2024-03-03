package utilz;

import Main.Game;
import entities.BoxPig;
import entities.KingPig;
import entities.Pig;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import Object.Potion;
import Object.GameContainer;
import Object.Heart;

import static utilz.Constant.ObjectConstants.*;

public class helpMethods {
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        if (!isSolid(x, y, lvlData)) {
            if (!isSolid(x + width, y + height, lvlData))
                if (!isSolid(x + width, y, lvlData))
                    if (!isSolid(x, y + height, lvlData))
                        return true;
        }
        return false;
    }

    private static boolean isSolid(float x, float y, int[][] lvlData) {
        int maxWidth = lvlData[0].length * Game.GAME_WIDTH;
        if (x < 0 || x >= maxWidth) {
            return true;
        }
        if (y < 0 || y >= Game.GAME_HEIGHT) {
            return true;
        }
        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;
        return IsTileSolid((int) xIndex, (int) yIndex, lvlData);
    }

    public static boolean IsTileSolid(int xTile, int yTile, int[][] lvlData) {
        int value = lvlData[(int) yTile][(int) xTile];
        if (value < 134) {
            return true;
        }
        return false;
    }

    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
        if (xSpeed > 0) {//Right
            int tileXPos = currentTile * Game.TILES_SIZE;
            int xOffSet = (int) (Game.TILES_SIZE - hitbox.width);
            return tileXPos + xOffSet - 1;
        } else {//left
            return currentTile * Game.TILES_SIZE;

        }
    }

    public static float GetEntityYPosUnderOfAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        int currentTile = (int) (hitbox.y / Game.TILES_SIZE);
        if (airSpeed > 0) {
            //falling
            int tileYPos = currentTile * Game.TILES_SIZE;
            int yOffSet = (int) (Game.TILES_SIZE - hitbox.height);
            return tileYPos + yOffSet - 1;
        } else {
            //jumping
            return currentTile * Game.TILES_SIZE;
        }
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        //check the pixel below bottom left and bottomright
        if (!isSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData)) {
            if (!isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData)) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsFloor(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {
        if (xSpeed > 0) {
            return isSolid(hitbox.x + hitbox.width + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
        } else {
            return isSolid(hitbox.x + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
        }
    }

    public static boolean IsAllTileWalkable(int xStart, int xEnd, int y, int[][] lvlData) {
        for (int i = 0; i < xEnd - xStart; i++) {
            if (IsTileSolid(xStart + i, y, lvlData))
                return false;
            if (!IsTileSolid(xStart + i, y + 1, lvlData)) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsSightClear(int[][] lvlData, Rectangle2D.Float enemyHitbox, Rectangle2D.Float playerHitbox, int yTile) {
        int enemyXTile = (int) enemyHitbox.x / Game.TILES_SIZE;
        int playerXTile = (int) playerHitbox.x / Game.TILES_SIZE;
        if (enemyXTile > playerXTile) {
            return IsAllTileWalkable(playerXTile, enemyXTile, yTile, lvlData);
        } else {
            return IsAllTileWalkable(enemyXTile, playerXTile, yTile, lvlData);

        }
    }

    public static ArrayList<Pig> GetPigs(int[][][] lvlChoose) {
        ArrayList<Pig> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 1) {
                    list.add(new Pig(j * Game.TILES_SIZE, i * Game.TILES_SIZE));
                }
            }
        }
        return list;
    }

    public static ArrayList<KingPig> GetKingPig(int[][][] lvlChoose) {
        ArrayList<KingPig> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 2) {
                    list.add(new KingPig(j * Game.TILES_SIZE, i * Game.TILES_SIZE));
                }
            }
        }
        return list;
    }

    public static ArrayList<BoxPig> GetBoxPig(int[][][] lvlChoose) {
        ArrayList<BoxPig> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 3) {
                    list.add(new BoxPig(j * Game.TILES_SIZE, i * Game.TILES_SIZE));
                }
            }
        }
        return list;
    }

    public static int[][] GetLevelData(int[][][] lvlData) {
        int[][] result = new int[lvlData[0].length][lvlData[0][0].length];
        for (int j = 0; j < lvlData[0].length; j++) {
            for (int i = 0; i < lvlData[0][0].length; i++) {
                result[j][i] = lvlData[0][j][i];
            }
        }
        return result;
    }

    public static Point GetPlayerSpawn(int[][][] lvlChoose) {
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 100) {
                    return new Point(j * Game.TILES_SIZE, i * Game.TILES_SIZE);
                }
            }
        }
        return new Point(1 * Game.TILES_SIZE, 1 * Game.TILES_SIZE);
    }

    public static ArrayList<Potion> GetPotion(int[][][] lvlChoose) {
        ArrayList<Potion> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 10) {
                    list.add(new Potion(j * Game.TILES_SIZE, i * Game.TILES_SIZE, BLUE_POTION));
                }
            }
        }
        return list;
    }

    public static ArrayList<GameContainer> GetContainer(int[][][] lvlChoose) {
        ArrayList<GameContainer> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 11) {
                    list.add(new GameContainer(j * Game.TILES_SIZE, i * Game.TILES_SIZE, BOX));
                } else if (lvlChoose[1][i][j] == 12) {
                    list.add(new GameContainer(j * Game.TILES_SIZE, i * Game.TILES_SIZE, BARREL));
                }
            }
        }
        return list;
    }

    public static ArrayList<Heart> GetHeart(int[][][] lvlChoose) {
        ArrayList<Heart> list = new ArrayList<>();
        for (int i = 0; i < lvlChoose[1].length; i++) {
            for (int j = 0; j < lvlChoose[1][i].length; j++) {
                if (lvlChoose[1][i][j] == 13) {
                    list.add(new Heart(j * Game.TILES_SIZE, i * Game.TILES_SIZE, HEART));
                }
            }
        }
        return list;
    }
}
