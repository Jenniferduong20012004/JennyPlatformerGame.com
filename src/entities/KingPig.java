package entities;
import Main.Game;
import utilz.Constant;
import utilz.Constant.EnemyConstants;
import utilz.LoadSave;
import utilz.helpMethods;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utilz.Constant.EnemyConstants.*;
import static utilz.helpMethods.CanMoveHere;
import static utilz.helpMethods.GetEntityYPosUnderOfAboveFloor;


public class KingPig extends Enemy{
    public KingPig(float x, float y) {
        super(x, y, EnemyConstants.K_PIG_WIDTH, EnemyConstants.K_PIG_HEIGHT, EnemyConstants.KING_PIG, Constant.EnemyConstants.K_IDLE);
        initHitbox(x,y,(int)(20* Game.SCALE), (int)(19*Game.SCALE));
        initAttackBox();
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
                case K_IDLE :
                    if (canSeePlayer(lvlData,player)){
                        turnTowardPlayer(player);
                        move(lvlData);
                        if (isPlayerCloseForAttack(player)){
                            newState(K_ATTACK);
                        }
                    }
                    break;
                case ATTACK:
                    if (aniIndex==0){
                        attackCheck = false;
                    }
                    if (aniIndex ==2&&!attackCheck){
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
        switch (enemyState) {
            case K_ATTACK, K_HIT:
                enemyState = K_IDLE;
                break;
            case K_DEAD:
                active = false;
                break;
        }
    }


    @Override
    public void initAttackBox() {
        attackbox = new Rectangle2D.Float(x+flipX(),y,(int)(52*Game.SCALE*flipW()), (int)(19*Game.SCALE));
        attackBoxOffsetX = (int)(Game.SCALE*30);
    }

    @Override
    public void resetEnemy() {
        hitbox.x = x;
        hitbox.y = y;
        firstUpdate = true;
        currentHealth = maxHealth;
        newState(K_IDLE);
        fallSpeed =0;
    }
}
