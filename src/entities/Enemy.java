package entities;
import Main.Game;
import utilz.Constant.EnemyConstants;
import utilz.helpMethods;

import java.awt.geom.Rectangle2D;

import static utilz.Constant.EnemyConstants.*;
import static utilz.helpMethods.*;
import static utilz.Constant.Directions.*;

public abstract class Enemy extends Entity{
    protected int aniIndex, enemyState, enemyType;
    protected int aniTick, aniSpeed = 25;
    protected boolean firstUpdate = true;
    protected boolean inAir = false;
    protected float fallSpeed;
    protected float gravity = 0.04f * Game.SCALE;
    protected float walkSpeed =(float )(0.5*Game.SCALE);
    protected int walkDir = LEFT;
    protected int tileY;
    protected float attackDistance = Game.TILES_SIZE *1;

    public Enemy(float x, float y, int width, int height,int enemyType, int enemyState) {
        super(x, y, width, height);
        this.enemyState = enemyState;
        this.enemyType=enemyType;
        initHitbox (x,y,width, height);
    }
    protected void updateAnimationTick(){
        aniTick++;
        if(aniTick >=aniSpeed){
            aniTick =0;
            aniIndex++;
            if (aniIndex >=EnemyConstants.getSpriteAmount(enemyType,enemyState)){
                aniIndex =0;
                afterAttack();
            }
        }
    }
    protected abstract void afterAttack();
    protected void changeWalkDir() {
        if (walkDir == LEFT){
            walkDir = RIGHT;
        }
        else {
            walkDir = LEFT;
        }
    }
    protected void firstUpdateCheck(int[][] lvlData){
        if (!helpMethods.IsEntityOnFloor(hitbox,lvlData)){
            inAir = true;
        }
        firstUpdate = false;
    }
    protected void updateInAir (int[][] lvlData){
            if (CanMoveHere(hitbox.x, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
                hitbox.y += fallSpeed;
                fallSpeed += gravity;
            }
            else{
                inAir = false;
                hitbox.y = GetEntityYPosUnderOfAboveFloor(hitbox, fallSpeed);
                tileY = (int)(hitbox.y/Game.TILES_SIZE);
            }
    }
    public int getAniIndex(){return aniIndex;}
    public int getEnemyState(){return enemyState;}
    protected void move(int [][] lvlData){
        float xSpeed = 0;
        if (walkDir == LEFT ){
            xSpeed =- walkSpeed;
        }
        else{
            xSpeed = walkSpeed;
        }
        if (CanMoveHere(hitbox.x+xSpeed, hitbox.y, hitbox.width,hitbox.height, lvlData)){
            if (IsFloor(hitbox, xSpeed, lvlData)){
                hitbox.x += xSpeed;
                return;
            }
        }
        changeWalkDir();
    }
    protected void newState (int enemyState){
        this.enemyState=enemyState;
        aniTick =0;
        aniIndex=0;
    }
    protected boolean canSeePlayer(int[][] lvlData, Player player){
        //same tile
        int playerTileY = (int)(player.getHitbox().y/Game.TILES_SIZE);
        if (playerTileY==tileY){
            //in range
            if(isPlayerInRange(player)){
                //no obstacle
                if (IsSightClear(lvlData, hitbox, player.hitbox, tileY))
                    return true;
            }
        }
        return false;
    }


    private boolean isPlayerInRange(Player player) {
        int absValue =(int) Math.abs (player.hitbox.x-hitbox.x);
        return absValue <= attackDistance *5;
    }
    protected void turnTowardPlayer (Player player){
        if (player.hitbox.x>hitbox.x){
            walkDir = RIGHT;
        }
        else{
            walkDir = LEFT;
        }
    }
    protected boolean isPlayerCloseForAttack(Player player){
        int absValue =(int) Math.abs (player.hitbox.x-hitbox.x);
        return absValue <= attackDistance;
    }
}