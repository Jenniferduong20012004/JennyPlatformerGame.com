package entities;
import utilz.Constant.EnemyConstants;

public class KingPig extends Enemy{
    public KingPig(float x, float y) {
        super(x, y, EnemyConstants.K_PIG_WIDTH, EnemyConstants.K_PIG_HEIGHT, EnemyConstants.KING_PIG);
    }
}
