package entities;

import Gamestates.Playing;
import Main.Game;
import utilz.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static utilz.Constant.PlayerConstants.*;

public class Player extends Entity{
    private int aniTick, aniIndex;
    private int aniSpeed = 30;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attack =false;
    private boolean jump = false;
    private boolean left, right;
    private BufferedImage [][] playerAnimation;
    private float playerSpeed =1*Game.SCALE;
    private int [][] lvlData;
    private float xDrawOffset = 20* Game.SCALE;
    private float yDrawOffset = 16*Game.SCALE;
    private float airSpeed =0f;
    private float gravity = 0.04f *Game.SCALE;
    private float jumpSpeed = -2.25f*Game.SCALE;
    private float fallSpeedAfterCollision = 0.5f *Game.SCALE;
    private boolean inAir = false;
    private boolean ground = false;
    //Health UI
    private BufferedImage healthBarImg;
    private int statusBarWidth = (int) (192 * Game.SCALE);
    private int statusBarHeight = (int) (58 * Game.SCALE);
    private int statusBarX = (int) (10 * Game.SCALE);
    private int statusBarY = (int) (10 * Game.SCALE);
    private int healthBarWidth = (int)(150*Game.SCALE);
    private int healthBarHeight = (int)(4*Game.SCALE);
    private int healthBarX = (int) (34*Game.SCALE);
    private int healthBarY = (int) (14*Game.SCALE);
    private BufferedImage[] diamondImg;
    private BufferedImage[] numberOfDiamondImg;
    private int diamondTick =0, diamondtime =0;
    private int diamondBarWidth = (int)(18*Game.SCALE);
    private int diamondBarHeight = (int)(14*Game.SCALE);
    private int diamondBarX = (int) (44*Game.SCALE);
    private int diamondBarY = (int) (74*Game.SCALE);
    private int numberWidth = (int)(6*Game.SCALE);
    private int numberHeight = (int)(8*Game.SCALE);
    private int numberX = (int) (64*Game.SCALE);
    private int numberY = (int) (76*Game.SCALE);
    private int maxHealth = 100;
    private int healthBarXStart = (int)(34*Game.SCALE);
    private int healthBarYStart = (int)(14*Game.SCALE);
    private int currentHealth = maxHealth;
    private int healthWidth = healthBarWidth;
    private Rectangle2D.Float attackbox;
    private int flipX =0;
    private int flipW =1;
    private  boolean attackCheck;
    private Playing playing;

    public Player(float x, float y, int width, int height, Playing playing) {
        super(x, y, width, height);
        this.playing =playing;
        loadAnimation();
        initHitbox(x,y,(int) (18*Game.SCALE), (int)(28*Game.SCALE));
        intAttackBox();
    }

    private void intAttackBox() {
        attackbox = new Rectangle2D.Float(x,y,(int)(20*Game.SCALE), (int)(20*Game.SCALE));
    }

    public void update (){
        updateHealthBar();
        if (currentHealth <=0&&aniIndex == getSpriteAmount(DEAD)-1){
            playing.setGameOver(true);
            return;
        }
        updateAttackBox();
        //observer
        loadlvlData(LevelOne.LEVEL_ONE);
        updatePos();
        if (attack){
            checkAttack();
        }
        updateAnimationTick();
        updateDiamondTick();
        setAnimation();
    }

    private void checkAttack() {
        if (attackCheck || aniIndex!=1 ){
            return;
        }
        attackCheck = true;
        playing.checkEnemyIsHit(attackbox);
    }

    private void updateAttackBox() {
        if (right){
            attackbox.x = hitbox.x+ hitbox.width+(int)(Game.SCALE*10);
        }
        else if (left){
            attackbox.x = hitbox.x- hitbox.width/2-(int)(Game.SCALE*10);
        }
        attackbox.y = hitbox.y+(Game.SCALE*10);
    }

    private void updateHealthBar() {
        healthWidth = (int)((currentHealth/(float)maxHealth)*healthBarWidth);
    }

    public void render(Graphics g, int lvlOffset){
        drawAttackBox(g,lvlOffset);
        g.drawImage(playerAnimation[playerAction][aniIndex],(int)(hitbox.x-xDrawOffset)-lvlOffset+flipX,(int)(hitbox.y-yDrawOffset),width*flipW,height,null);
        drawUI(g);
    }

    private void drawUI(Graphics g) {
        g.drawImage (healthBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
        g.setColor(Color.RED);
        g.fillRect(healthBarXStart+statusBarX, healthBarYStart+statusBarY,healthWidth ,healthBarHeight);
        g.drawImage(diamondImg[diamondTick], diamondBarX,diamondBarY,diamondBarWidth*2,diamondBarHeight*2,null);
        g.drawImage(numberOfDiamondImg[9], numberX+20,numberY+3,numberWidth*2,numberHeight*2,null);
    }
    private void updateDiamondTick(){
        diamondtime++;
        if (diamondtime >=30){
            diamondTick ++;
            if(diamondTick>=8){
                diamondTick =0;
            }
        }
    }
    public void changeHealth(int value){
        currentHealth +=value;
        if (currentHealth <=0){
            currentHealth =0;
        }
        else if (currentHealth>=maxHealth){
            currentHealth =maxHealth;
        }
    }
    private void loadAnimation() {
        playerAnimation = new BufferedImage[10][11];
        BufferedImage idle = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_IDLE);
        for (int i =0; i < Constant.PlayerConstants.getSpriteAmount(IDLE); i++){playerAnimation[IDLE][i] = idle.getSubimage(i*78,0,78,58);}
        BufferedImage attack = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATTACK);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(ATTACK); i++){playerAnimation[ATTACK][i] = attack.getSubimage(i*78,0,78,58);}
        BufferedImage dead = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DEAD);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(DEAD); i++){playerAnimation[DEAD][i] =dead.getSubimage(i*78,0,78,58);}
        BufferedImage door_in = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_IN);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(DOOR_IN); i++){playerAnimation[DOOR_IN][i] =door_in.getSubimage(i*78,0,78,58);}
        BufferedImage door_out = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_OUT);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(DOOR_OUT); i++){playerAnimation[DOOR_OUT][i] =door_out.getSubimage(i*78,0,78,58);}
        BufferedImage fall = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_FALLING);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(FALLING); i++){playerAnimation[FALLING][i] =fall.getSubimage(i*78,0,78,58);}
        BufferedImage ground = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_GROUND);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(GROUND); i++){playerAnimation[GROUND][i] =ground.getSubimage(i*78,0,78,58);}
        BufferedImage hit= LoadSave.GetSpriteAtlas(LoadSave.PLAYER_HIT);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(HIT); i++){playerAnimation[HIT][i] =hit.getSubimage(i*78,0,78,58);}
        BufferedImage jump = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_JUMP);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(JUMP); i++){playerAnimation[JUMP][i] =jump.getSubimage(i*78,0,78,58);}
        BufferedImage run = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN);
        for (int i =0; i <Constant.PlayerConstants.getSpriteAmount(RUNNING); i++){playerAnimation[RUNNING][i] =run.getSubimage(i*78,0,78,58);}
        healthBarImg= LoadSave.GetSpriteAtlas(LoadSave.HEALTH_POWER_BAR);
        BufferedImage dia = LoadSave.GetSpriteAtlas(LoadSave.SMALL_DIAMOND);
        diamondImg = new BufferedImage[9];
        for (int i =0; i < 8; i++){diamondImg[i]= dia.getSubimage(i*18,0,18,14);}
        BufferedImage num = LoadSave.GetSpriteAtlas(LoadSave.NUMBERS);
        numberOfDiamondImg = new BufferedImage[10];
        for (int i =0; i < 10; i++){numberOfDiamondImg[i]= num.getSubimage(i*6,0,6,8);}
    }
    public void loadlvlData(int[][] lvlData){
        this.lvlData = lvlData;
        if (!helpMethods.IsEntityOnFloor(hitbox,lvlData)){
            inAir = true;
        }
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
                attackCheck = false;
            }
        }
    }
    private void setAnimation() {
        int startAni = playerAction;
        if (moving){
            playerAction = RUNNING;
        }
        else{
            playerAction = IDLE;
        }if (inAir){
            if (airSpeed<0){
                playerAction= JUMP;
            }
            else{
                playerAction = FALLING;
            }
        }
        if (ground){
            playerAction = GROUND;
            ground = false;
        }
        if (attack){
            playerAction = ATTACK;
            if (startAni!= ATTACK){
                aniIndex =1;
                aniTick =0;
            }
        }
        if (currentHealth <=0){
            playerAction = DEAD;
        }
        if (startAni != playerAction){
            resetAniTick();
        }

    }

    private void resetAniTick() {
        aniTick =0;
        aniIndex=0;
    }

    private void updatePos() {
        moving = false;
        if (jump){
            jump();
        }
        if(!inAir)
            if ((!left &&!right) || (left&&right) )
                return;
        float xSpeed =0;
        if (left &&!right){
            xSpeed =- playerSpeed;
            flipX = width;
            flipW = -1;
        }
        else if (!left && right){
            xSpeed = playerSpeed;
            flipX =0;
            flipW =1;
        }
        if (!inAir){
            if (!helpMethods.IsEntityOnFloor(hitbox,lvlData)){
                inAir = true;
            }
        }
        if (inAir){
            if (helpMethods.CanMoveHere(hitbox.x,hitbox.y+airSpeed,hitbox.width,hitbox.height, lvlData)){
                hitbox.y += airSpeed;
                airSpeed += gravity;
                updateXPos(xSpeed);
            }
            else{
                hitbox.y = helpMethods.GetEntityYPosUnderOfAboveFloor(hitbox, airSpeed);
                ground = true;
                if (airSpeed >0){
                    resetInAir();
                }
                else{
                airSpeed = fallSpeedAfterCollision;
                }
                updateXPos(xSpeed);
            }
        }
        else {
            updateXPos(xSpeed);
        }
        moving = true;
    }

    private void jump() {
        if (inAir){
            return;
        }
        inAir = true;
        airSpeed = jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed =0;

    }

    private void updateXPos(float xSpeed) {
        if(helpMethods.CanMoveHere(hitbox.x+xSpeed,hitbox.y, hitbox.width, hitbox.height, lvlData)){
            hitbox.x +=xSpeed;
            moving = true;
        }else{
            hitbox.x = helpMethods.GetEntityXPosNextToWall(hitbox,xSpeed);
        }
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
        right = false;
        left = false;
    }
    private void drawAttackBox(Graphics g, int lvlOffsetX) {
        g.setColor(Color.red);
        g.drawRect((int) attackbox.x - lvlOffsetX, (int) attackbox.y, (int) attackbox.width, (int) attackbox.height);

    }

    public void resetAll() {
        resetDirBoolean();
        inAir = false;
        attack = false;
        moving = false;
        playerAction = IDLE;
        currentHealth = maxHealth;
        hitbox.x = x;
        hitbox.y = y;
        if (!helpMethods.IsEntityOnFloor(hitbox, lvlData)) {
            inAir = true;
        }
    }
}
