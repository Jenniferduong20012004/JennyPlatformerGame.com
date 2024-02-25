package entities;

import Main.Game;
import utilz.Constant;
import java.awt.image.BufferedImage;
import static utilz.Constant.EnemyConstants.*;
public class Pig extends Enemy{
    private BufferedImage[][] pigArr;
    public Pig(float x, float y) {
        super(x, y, PIG_WIDTH, PIG_HEIGHT, PIG,  Constant.EnemyConstants.IDLE);
        initHitbox(x, y, (int)(20* Game.SCALE),(int)(15*Game.SCALE));
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
            }
        }

    }
    public void update(int [][] lvlData, Player player){
        updateMove(lvlData, player);
        updateAnimationTick();

    }

    @Override
    protected void afterAttack() {
        if (enemyState == ATTACK){
            enemyState = IDLE;
        }
    }
}
