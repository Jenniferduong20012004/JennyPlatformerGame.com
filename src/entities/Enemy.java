package entities;
import Main.Game;
import utilz.Constant.EnemyConstants;
import utilz.helpMethods;

import static utilz.Constant.EnemyConstants.*;
import static utilz.helpMethods.*;
import static utilz.Constant.Directions.*;

public abstract class Enemy extends Entity{
    protected int aniIndex, enemyState=5, enemyType;
    protected int aniTick, aniSpeed = 25;
    protected boolean firstUpdate = true;
    protected boolean inAir = false;
    protected float fallSpeed;
    protected float gravity = 0.04f * Game.SCALE;
    protected float walkSpeed = 1*Game.SCALE;
    protected int walkDir = LEFT;

    public Enemy(float x, float y, int width, int height,int enemyType) {
        super(x, y, width, height);
        this.enemyType=enemyType;
        initHitbox (x,y,width, height);
    }
    public void updateAnimationTick(){
        aniTick++;
        if(aniTick >=aniSpeed){
            aniTick =0;
            aniIndex++;
            if (aniIndex >=EnemyConstants.getSpriteAmount(enemyType,enemyState)){
                aniIndex =0;
            }
        }
    }
    public void update(int [][] lvlData){
        updateMove(lvlData);
        updateAnimationTick();
    }
    public void updateMove(int [][] lvlData){
        if (firstUpdate){
            if (!helpMethods.IsEntityOnFloor(hitbox,lvlData)){
                inAir = true;
            }
            firstUpdate = false;
        }
        if (inAir) {
            if (CanMoveHere(hitbox.x, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
                hitbox.y += fallSpeed;
                fallSpeed += gravity;
            }
            else{
                inAir = false;
                hitbox.y = GetEntityYPosUnderOfAboveFloor(hitbox, fallSpeed);
            }
        }
        else{
            switch (enemyState){
                case IDLE:
                    enemyState = RUN;
                    break;
                case RUN:
                    float xSpeed = 0;
                    if (walkDir == LEFT ){
                        xSpeed += walkSpeed;
                    }
                    else{
                        xSpeed -= walkSpeed;
                    }
                    if (CanMoveHere(hitbox.x+xSpeed, hitbox.y, hitbox.width,hitbox.height, lvlData)){
                        if (IsFloor(hitbox, xSpeed, lvlData)){
                            hitbox.x += xSpeed;
                            return;
                        }
                        changeWalkDir();
                    }
                    break;
            }
        }

    }

    private void changeWalkDir() {
        if (walkDir == LEFT){
            walkDir = RIGHT;
        }
        else {
            walkDir = LEFT;
        }
    }

    public int getAniIndex(){return aniIndex;}
    public int getEnemyState(){return enemyState;}
}