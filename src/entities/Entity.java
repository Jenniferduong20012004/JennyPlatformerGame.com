package entities;

import java.awt.*;

public abstract class Entity {
    protected float x, y;
    protected Rectangle hitbox;
    protected int width, height;
    public Entity (float x, float y, int width, int height){
        this.x = x;
        this.y =y;
        this.width =width;
        this.height = height;
        initHitbox();
    }

    private void initHitbox() {
        hitbox = new Rectangle((int)x, (int) y, width, height);
    }
    protected void updateHitbox(){
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
}
