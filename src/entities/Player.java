package entities;

import Main.Game;
import utilz.LevelBuild;
import utilz.LoadSave;
import utilz.helpMethods;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.PlayerConstants.*;

public class Player extends Entity{
    private int aniTick, aniIndex;
    private int aniSpeed = 30;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attack =false;
    private boolean jump = false;
    private boolean up, down, left, right;
    private BufferedImage [][] playerAnimation;
    private int playerSpeed =3;
    private int [][] lvlData;
    private float xDrawOffset = 42* Game.SCALE;
    private float yDrawOffset = 40*Game.SCALE;


    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimation();
        initHitbox(x,y,20*Game.SCALE, 28*Game.SCALE);
    }
    public void update (){
        //observer
        updatePos();
        updateAnimationTick();
        setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(playerAnimation[playerAction][aniIndex],(int)(hitbox.x-xDrawOffset),(int)(hitbox.y-yDrawOffset),156,116,null);
    }
    private void loadAnimation() {
        playerAnimation = new BufferedImage[10][11];
        BufferedImage idle = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_IDLE);
        for (int i =0; i <getSpriteAmount(IDLE); i++){playerAnimation[IDLE][i] = idle.getSubimage(i*78,0,78,58);}
        BufferedImage attack = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATTACK);
        for (int i =0; i <getSpriteAmount(ATTACK); i++){playerAnimation[ATTACK][i] = attack.getSubimage(i*78,0,78,58);}
        BufferedImage dead = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DEAD);
        for (int i =0; i <getSpriteAmount(DEAD); i++){playerAnimation[DEAD][i] =dead.getSubimage(i*78,0,78,58);}
        BufferedImage door_in = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_IN);
        for (int i =0; i <getSpriteAmount(DOOR_IN); i++){playerAnimation[DOOR_IN][i] =door_in.getSubimage(i*78,0,78,58);}
        BufferedImage door_out = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_OUT);
        for (int i =0; i <getSpriteAmount(DOOR_OUT); i++){playerAnimation[DOOR_OUT][i] =door_out.getSubimage(i*78,0,78,58);}
        BufferedImage fall = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_FALLING);
        for (int i =0; i <getSpriteAmount(FALLING); i++){playerAnimation[FALLING][i] =fall.getSubimage(i*78,0,78,58);}
        BufferedImage ground = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_GROUND);
        for (int i =0; i <getSpriteAmount(GROUND); i++){playerAnimation[GROUND][i] =ground.getSubimage(i*78,0,78,58);}
        BufferedImage hit= LoadSave.GetSpriteAtlas(LoadSave.PLAYER_HIT);
        for (int i =0; i <getSpriteAmount(HIT); i++){playerAnimation[HIT][i] =hit.getSubimage(i*78,0,78,58);}
        BufferedImage jump = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_JUMP);
        for (int i =0; i <getSpriteAmount(JUMP); i++){playerAnimation[JUMP][i] =jump.getSubimage(i*78,0,78,58);}
        BufferedImage run = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN);
        for (int i =0; i <getSpriteAmount(RUNNING); i++){playerAnimation[RUNNING][i] =run.getSubimage(i*78,0,78,58);}
    }
    public void loadlvlData(int[][] lvlData){
        this.lvlData = lvlData;
    }
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick =0;
            aniIndex ++;
            if (aniIndex >= getSpriteAmount (playerAction)){
                aniIndex =0;
                attack = false;
                jump = false;
            }
        }
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    private void setAnimation() {
        if (moving){
            playerAction = RUNNING;
        }
        else{
            playerAction = IDLE;
        }
        if (attack){
            playerAction = ATTACK;
        }
        if (jump){
            playerAction = JUMP;
        }
    }
    private void updatePos() {
        moving = false;
        if(!left &&!right &&!up&&!down)
            return;
        float xSpeed =0, ySpeed=0;
        if (left &&!right){
            xSpeed =- playerSpeed;
        }
        else if (!left && right){
            xSpeed = playerSpeed;
        }
        if (up && !down){
            ySpeed = -playerSpeed;
        }
        else if (!up&& down){
            ySpeed = playerSpeed;
        }
        /*if(helpMethods.CanMoveHere(x+xSpeed,y+ySpeed, width, height, LevelBuild.LEVEL_ONE)){
            this.x +=xSpeed;
            this.y += ySpeed;
            moving = true;
        }*/
        if(helpMethods.CanMoveHere(hitbox.x+xSpeed,hitbox.y+ySpeed, hitbox.width, hitbox.height, LevelBuild.LEVEL_ONE)){
            hitbox.x +=xSpeed;
            hitbox.y += ySpeed;
            moving = true;
        }
    }
    public void setUp(boolean up){
        this.up =up;
    }
    public void setDown(boolean down){
        this.down =down;
    }
    public void setLeft(boolean left){
        this.left =left;
    }
    public void setRight(boolean right){
        this.right =right;
    }
    public void setAttack(boolean attack) {this.attack = attack;}
    public void setJump(boolean jump){this.jump = jump;}

    public void resetDirBoolean() {
        up = false;
        down = false;
        right = false;
        left = false;
    }
}
