package entities;
import Main.Game;
import utilz.Constant.EnemyConstants;
import utilz.helpMethods;

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
            }
        }
    }
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
            }
    }
    public int getAniIndex(){return aniIndex;}
    public int getEnemyState(){return enemyState;}
}