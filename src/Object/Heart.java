package Object;

import Main.Game;

public class Heart extends GameObject{
    public Heart(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        createHitbox();
        xDrawOffset= (int) (4* Game.SCALE);
        yDrawOffset = (int) (2*Game.SCALE);
    }

    private void createHitbox() {
        initHitbox(18,14);
        xDrawOffset = (int)(7* Game.SCALE);
        yDrawOffset = (int) (12*Game.SCALE);
        hitbox.y += yDrawOffset + (int) (Game.SCALE*2);
        hitbox.x += xDrawOffset/2;
    }

    public void update(){
        updateAnimationTick();
    }
}
