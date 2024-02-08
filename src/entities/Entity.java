package entities;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float x, y;
    protected Rectangle2D.Float hitbox;
    protected int width, height;
    public Entity (float x, float y, int width, int height){
        this.x = x;
        this.y =y;
        this.width =width;
        this.height = height;
    }

    protected void initHitbox(float x, float y, int width, int height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }
    protected void updateHitbox(){
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }
    public Rectangle2D.Float getHitbox(){
        return hitbox;
    }
}
