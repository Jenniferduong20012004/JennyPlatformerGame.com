package Object;

import Main.Game;

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
}
