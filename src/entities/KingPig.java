package entities;
import Main.Game;
import utilz.Constant;
import utilz.Constant.EnemyConstants;
import utilz.LoadSave;
import utilz.helpMethods;

import java.awt.*;

import static utilz.Constant.EnemyConstants.*;
import static utilz.helpMethods.CanMoveHere;
import static utilz.helpMethods.GetEntityYPosUnderOfAboveFloor;


public class KingPig extends Enemy{
    public KingPig(float x, float y) {
        super(x, y, EnemyConstants.K_PIG_WIDTH, EnemyConstants.K_PIG_HEIGHT, EnemyConstants.KING_PIG, Constant.EnemyConstants.K_IDLE);
        initHitbox(x,y,(int)(20* Game.SCALE), (int)(19*Game.SCALE));
    }
    public void updateMove(int [][] lvlData){
        if (firstUpdate){
            firstUpdateCheck(lvlData);
        }
        if (inAir) {
            updateInAir(lvlData);
            }
            else{
                inAir = false;
                hitbox.y = GetEntityYPosUnderOfAboveFloor(hitbox, fallSpeed);
            }
        }
    public void update(int [][] lvlData){
        updateAnimationTick();
        updateMove(lvlData);

    }

    @Override
    protected void afterAttack() {
        if (enemyState == K_ATTACK){
            enemyState = K_IDLE;
        }
    }
}
