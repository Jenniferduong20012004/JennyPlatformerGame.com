package entities;
import utilz.Constant.EnemyConstants;

public abstract class Enemy extends Entity{
    protected int aniIndex, enemyState, enemyType;
    protected int aniTick, aniSpeed = 25;


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
    public void update(){
        updateAnimationTick();
    }
    public int getAniIndex(){return aniIndex;}
    public int getEnemyState(){return enemyState;}
}