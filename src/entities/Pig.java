package entities;

import Main.Game;

import static utilz.Constant.EnemyConstants.*;

public class Pig extends Enemy{
    public Pig(float x, float y) {
        super(x, y, PIG_WIDTH, PIG_HEIGHT, PIG);
        initHitbox(x, y, (int)(20* Game.SCALE),(int)(15*Game.SCALE));
    }
}
