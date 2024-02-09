package entities;

import static utilz.Constant.EnemyConstants.*;

public class Pig extends Enemy{
    public Pig(float x, float y) {
        super(x, y, PIG_WIDTH, PIG_HEIGHT, PIG);
    }
}
