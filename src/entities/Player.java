package entities;

import utilz.LoadSave;

import java.awt.image.BufferedImage;

import static utilz.Constant.PlayerConstants.*;

public class Player extends Entity{
    private int aniTick, aniIndex;
    private int aniSpeed = 20;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;
    private BufferedImage [][] playerAnimation;


    public Player(float x, float y) {
        super(x, y);
    }
    public void update (){
        //observer

    }
    public void render(){

    }
    private void loadAnimation() {
        playerAnimation = new BufferedImage[10][11];
        BufferedImage idle = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_IDLE);
        for (int i =0; i <getSpriteAmount(IDLE); i++){playerAnimation[IDLE][i] = idle.getSubimage(i*78,0,78,58);}
        BufferedImage attack = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_ATTACK);
        for (int i =0; i <getSpriteAmount(ATTACK); i++){playerAnimation[ATTACK][i] = attack.getSubimage(i*78,0,78,58);}
        BufferedImage dead = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_DEAD);
        for (int i =0; i <getSpriteAmount(DEAD); i++){playerAnimation[DEAD][i] =dead.getSubimage(i*78,0,78,58);}
        BufferedImage door_in = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_DOOR_IN);
        for (int i =0; i <getSpriteAmount(DOOR_IN); i++){playerAnimation[DOOR_IN][i] =door_in.getSubimage(i*78,0,78,58);}
        BufferedImage door_out = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_DOOR_OUT);
        for (int i =0; i <getSpriteAmount(DOOR_OUT); i++){playerAnimation[DOOR_OUT][i] =door_out.getSubimage(i*78,0,78,58);}
        BufferedImage fall = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_FALLING);
        for (int i =0; i <getSpriteAmount(FALLING); i++){playerAnimation[FALLING][i] =fall.getSubimage(i*78,0,78,58);}
        BufferedImage ground = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_GROUND);
        for (int i =0; i <getSpriteAmount(GROUND); i++){playerAnimation[GROUND][i] =ground.getSubimage(i*78,0,78,58);}
        BufferedImage hit= LoadSave.GetPlayerAtlas(LoadSave.PLAYER_HIT);
        for (int i =0; i <getSpriteAmount(HIT); i++){playerAnimation[HIT][i] =hit.getSubimage(i*78,0,78,58);}
        BufferedImage jump = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_JUMP);
        for (int i =0; i <getSpriteAmount(JUMP); i++){playerAnimation[JUMP][i] =jump.getSubimage(i*78,0,78,58);}
        BufferedImage run = LoadSave.GetPlayerAtlas(LoadSave.PLAYER_RUN);
        for (int i =0; i <getSpriteAmount(RUNNING); i++){playerAnimation[RUNNING][i] =run.getSubimage(i*78,0,78,58);}
    }
}
