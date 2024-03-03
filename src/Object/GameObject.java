package Object;

import utilz.Constant;

import java.awt.geom.Rectangle2D;

import static utilz.Constant.ObjectConstants.*;

public class GameObject {
    protected int x,y, objType;
    protected Rectangle2D.Float hitbox;
    protected boolean doAnimation, active= true;
    protected int aniTick, aniIndex, aniSpeed = 25;
    protected int xDrawOffset, yDrawOffset;
    public GameObject(int x, int y, int objType){
        this. x =x;
        this. y=y;
        this.objType = objType;
    }
    protected void initHitbox(int width, int height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }
    protected void updateAnimationTick(){
        aniTick++;
        if(aniTick >=aniSpeed){
            aniTick =0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(objType)){
                aniIndex =0;
                if (objType ==BARREL|| objType == BOX){
                    doAnimation =false;
                    active = false;
                }
            }
        }
    }
    public void reset(){
        aniIndex=0;
        aniTick =0;
        active = true;
        if (objType == BARREL ||objType == BOX) {
            doAnimation = false;
        }
        else {
            doAnimation = true;
        }
    }

    public int getxDrawOffset() {
        return xDrawOffset;
    }
        public int getyDrawOffset() {
        return yDrawOffset;
    }
    public int getObjType() {
        return objType;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public int getAniIndex() {
        return aniIndex;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
