package utilz;

import Main.Game;

import java.awt.geom.Rectangle2D;

public class helpMethods {
    public static boolean CanMoveHere (float x, float y, float width, float height, int [][] lvlData){
        if (!isSolid(x,y, lvlData)){
            if (!isSolid(x+width, y+height, lvlData))
                if (!isSolid(x+width, y, lvlData))
                    if (!isSolid(x,y+height,lvlData))
                        return true;
        }
        return false;
    }
    private static boolean isSolid(float x, float y, int [][] lvlData){
        int maxWidth = lvlData[0].length*Game.GAME_WIDTH;
        if (x <0 || x >= maxWidth){
            return true;
        }
        if (y < 0|| y >= Game. GAME_HEIGHT){
            return true;
        }
        float xIndex = x/ Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;
        int value = lvlData[(int) yIndex][(int) xIndex];
        if (value < 134){
            return true;
        }
        return false;

    }
    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile = (int)(hitbox.x/Game.TILES_SIZE);
        if (xSpeed>0){//Right
            int tileXPos= currentTile *Game.TILES_SIZE;
            int xOffSet = (int)(Game.TILES_SIZE-hitbox.width);
            return tileXPos +xOffSet -1;
        }
        else {//left
            return currentTile *Game.TILES_SIZE;

        }
    }
    public static float GetEntityYPosUnderOfAboveFloor(Rectangle2D.Float hitbox,float airSpeed){
        int currentTile = (int)(hitbox.y/Game.TILES_SIZE);
        if (airSpeed>0){
            //falling
            int tileYPos = currentTile *Game.TILES_SIZE;
            int yOffSet = (int)(Game.TILES_SIZE-hitbox.height);
            return tileYPos +yOffSet -1;
        }
        else {
            //jumping
            return currentTile * Game.TILES_SIZE;
        }
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        //check the pixel below bottom left and bottomright
        if (!isSolid(hitbox.x,hitbox.y+hitbox.height+1,lvlData)){
            if (!isSolid(hitbox.x+hitbox.width,hitbox.y+hitbox.height+1,lvlData)){
                return false;
            }
        }
        return true;
    }
    public static boolean IsFloor (Rectangle2D.Float hitbox,float xSpeed, int [][] lvlData ){
        return isSolid (hitbox.x+xSpeed,hitbox.y +hitbox.height+1, lvlData);
    }
}
