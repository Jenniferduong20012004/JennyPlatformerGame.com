package entities;

import Main.Game;
import utilz.Constant;
import utilz.LoadSave;
import utilz.helpMethods;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.Directions.LEFT;
import static utilz.Constant.EnemyConstants.*;
import static utilz.LoadSave.PIG_IDLE;
import static utilz.helpMethods.*;

public class Pig extends Enemy{
    private BufferedImage[][] pigArr;
    public Pig(float x, float y) {
        super(x, y, PIG_WIDTH, PIG_HEIGHT, PIG,  Constant.EnemyConstants.IDLE);
        initHitbox(x, y, (int)(20* Game.SCALE),(int)(15*Game.SCALE));
    }
    public void updateMove(int [][] lvlData){
        if (firstUpdate){
            firstUpdateCheck(lvlData);
            }
        if (inAir) {
            updateInAir(lvlData);
        }
        else{
            switch (enemyState){
                case IDLE:
                    enemyState = RUN;
                    break;
                case RUN:
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
                    break;
            }
        }

    }
    public void update(int [][] lvlData){
        updateAnimationTick();
        updateMove(lvlData);

    }
    }
