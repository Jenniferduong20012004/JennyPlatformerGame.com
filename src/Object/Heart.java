package Object;

import Main.Game;

public class Heart extends GameObject{
    public Heart(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        initHitbox(18,14);
        xDrawOffset= (int) (4* Game.SCALE);
        yDrawOffset = (int) (2*Game.SCALE);
    }
    public void update(){
        updateAnimationTick();
    }
}
