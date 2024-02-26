package entities;

import utilz.Constant;

import static utilz.Constant.EnemyConstants.*;
import static utilz.helpMethods.GetEntityYPosUnderOfAboveFloor;

public class BoxPig extends Enemy{
    public BoxPig(float x, float y) {
        super(x, y, Constant.EnemyConstants.B_PIG_WIDTH, Constant.EnemyConstants.B_PIG_HEIGHT, Constant.EnemyConstants.B_PIG, Constant.EnemyConstants.B_IDLE);
    }
    public void update(int [][] lvlData){
        updateAnimationTick();
        updateMove(lvlData);
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
                //case
            }
        }
    }

    @Override
    protected void afterAttack() {
        if (enemyState == B_THROWING_BOX){
            enemyState = B_IDLE;
        }
    }

    @Override
    public void initAttackBox() {

    }
}
