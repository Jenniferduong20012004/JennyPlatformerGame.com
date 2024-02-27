package entities;

import Main.Game;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import static utilz.Constant.EnemyConstants.*;
public class Pig extends Enemy{
    private BufferedImage[][] pigArr;
    public Pig(float x, float y) {
        super(x, y, PIG_WIDTH, PIG_HEIGHT, PIG,  Constant.EnemyConstants.IDLE);
        initHitbox(x, y, (int)(20* Game.SCALE),(int)(15*Game.SCALE));
        initAttackBox();
    }
    @Override
    public void initAttackBox(){
        attackbox = new Rectangle2D.Float(x+flipX(),y,(int)(52*Game.SCALE*flipW()), (int)(19*Game.SCALE));
        attackBoxOffsetX = (int)(Game.SCALE*30); //30 trái, 22 giữa
    }

    @Override
    public void resetEnemy() {
        hitbox.x = x;
        hitbox.y = y;
        firstUpdate = true;
        currentHealth = maxHealth;
        newState(IDLE);
        fallSpeed =0;
    }

    public void updateMove(int [][] lvlData, Player player){
        if (firstUpdate){
            firstUpdateCheck(lvlData);
            }
        if (inAir) {
            updateInAir(lvlData);
        }
        else{
            switch (enemyState){
                case IDLE:
                    newState(RUN);
                    break;
                case RUN:
                    if (canSeePlayer(lvlData, player)){
                        turnTowardPlayer(player);
                        if (isPlayerCloseForAttack(player)){
                            newState(ATTACK);
                        }
                    }
                    move(lvlData);
                    break;
                case ATTACK:
                    if (aniIndex==0){
                        attackCheck = false;
                    }
                    if (aniIndex == 2&&!attackCheck){
                        checkEnemyAttack(attackbox,player);
                    }
                    break;
            }
        }

    }
    public void update(int [][] lvlData, Player player){
        updateMove(lvlData, player);
        updateAnimationTick();
        updateAttackBox();
    }

    @Override
    protected void checkState() {
        switch (enemyState){
            case ATTACK, HIT:
                enemyState = IDLE;
                break;
            case DEAD:
                active = false;
                break;
        }
    }

}
