package Object;

import Gamestates.Playing;
import Main.Game;

import static utilz.Constant.ObjectConstants.BLUE_POTION_VALUE;

public class Potion extends GameObject{
    private float hoverOffset;
    private int maxHoverOffset, hoverDir= 1;
    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        createHitbox();
        maxHoverOffset = (int)(10*Game.SCALE);
    }

    private void createHitbox() {
        initHitbox(7,14);
        xDrawOffset= (int) (3* Game.SCALE);
        yDrawOffset = (int) (2*Game.SCALE);
        hitbox.y += yDrawOffset + (int) (Game.SCALE*2);
    }

    public void update(){
        updateAnimationTick();
        updateHover();
    }

    private void updateHover() {
        hoverOffset += (0.075f *Game.SCALE*hoverDir);
        if (hoverOffset>= maxHoverOffset){
            hoverDir = -1;
        } else if (hoverOffset<0) {
            hoverDir =1;
        }
        hitbox.y = y+hoverOffset;
    }

    public void applyEffectToPlayer(Playing playing) {
        playing.getPlayer().changePower(BLUE_POTION_VALUE);
    }
}
