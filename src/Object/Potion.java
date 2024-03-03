package Object;

import Gamestates.Playing;
import Main.Game;

import static utilz.Constant.ObjectConstants.BLUE_POTION_VALUE;
import static utilz.Constant.ObjectConstants.HEART_VALUE;

public class Potion extends GameObject{
    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        createHitbox();
    }

    private void createHitbox() {
        initHitbox(7,14);
        xDrawOffset= (int) (3* Game.SCALE);
        yDrawOffset = (int) (2*Game.SCALE);
        hitbox.y += yDrawOffset + (int) (Game.SCALE*2);
    }

    public void update(){
        updateAnimationTick();
    }

    public void applyEffectToPlayer(Playing playing) {
        playing.getPlayer().changePower(BLUE_POTION_VALUE);
    }
}
