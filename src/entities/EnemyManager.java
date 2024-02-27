package entities;

import Gamestates.Playing;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constant.EnemyConstants.*;
import static utilz.LoadSave.*;
import static utilz.LevelOne.*;

public class EnemyManager {
    private Playing playing;
    private ArrayList<Pig> pigs = new ArrayList<>();
    private ArrayList<KingPig> kingpigs = new ArrayList<>();
    private BufferedImage[][] pigArr, kingPigArr, boxPigArr;
    private ArrayList<BoxPig> boxpigs = new ArrayList<>();
    public EnemyManager(Playing playing){
        this.playing = playing;
        loadEnemyImg();
        addEnemies();
    }
    private void addEnemies() {
        pigs = LoadSave.GetPigs(Enemy_levelOne);
        kingpigs = LoadSave.GetKingPig (Enemy_levelOne);
        boxpigs = LoadSave.GetBoxPig (Enemy_levelOne);
    }

    private void loadEnemyImg() {
        pigArr = new BufferedImage[8][11];
        BufferedImage idle = LoadSave.GetSpriteAtlas(PIG_IDLE);
        for (int i = 0; i < Constant.EnemyConstants.getSpriteAmount(PIG,IDLE); i++){pigArr[IDLE][i] = idle.getSubimage(i*34,0,34,28);}
        BufferedImage attack = LoadSave.GetSpriteAtlas(LoadSave.PIG_ATTACK);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,ATTACK); i++){pigArr[ATTACK][i] = attack.getSubimage(i*34,0,34,28);}
        BufferedImage dead = LoadSave.GetSpriteAtlas(LoadSave.PIG_DEAD);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,DEAD); i++){pigArr[DEAD][i] =dead.getSubimage(i*34,0,34,28);}
        BufferedImage fall = LoadSave.GetSpriteAtlas(LoadSave.PIG_FALL);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,FALLING); i++){pigArr[FALLING][i] =fall.getSubimage(i*34,0,34,28);}
        BufferedImage ground = LoadSave.GetSpriteAtlas(LoadSave.PIG_GROUND);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,GROUND); i++){pigArr[GROUND][i] =ground.getSubimage(i*34,0,34,28);}
        BufferedImage hit= LoadSave.GetSpriteAtlas(LoadSave.PIG_HIT);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,HIT); i++){pigArr[HIT][i] =hit.getSubimage(i*34,0,34,28);}
        BufferedImage jump = LoadSave.GetSpriteAtlas(LoadSave.PIG_JUMP);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,JUMP); i++){pigArr[JUMP][i] =jump.getSubimage(i*34,0,34,28);}
        BufferedImage run = LoadSave.GetSpriteAtlas(LoadSave.PIG_RUN);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(PIG,RUN); i++){pigArr[RUN][i] =run.getSubimage(i*34,0,34,28);}
        kingPigArr = new BufferedImage[8][12];
        BufferedImage k_idle = LoadSave.GetSpriteAtlas(K_PIG_IDLE);
        for (int i = 0; i < Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_IDLE); i++){kingPigArr[K_IDLE][i] = k_idle.getSubimage(i*38,0,38,28);}
        BufferedImage k_attack = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_ATTACK);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_ATTACK); i++){kingPigArr[K_ATTACK][i] = k_attack.getSubimage(i*38,0,38,28);}
        BufferedImage k_dead = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_DEAD);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_DEAD); i++){kingPigArr[K_DEAD][i] =k_dead.getSubimage(i*38,0,38,28);}
        BufferedImage k_fall = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_FALL);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_FALLING); i++){kingPigArr[K_FALLING][i] =k_fall.getSubimage(i*38,0,38,28);}
        BufferedImage k_ground = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_GROUND);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_GROUND); i++){kingPigArr[K_GROUND][i] =k_ground.getSubimage(i*38,0,38,28);}
        BufferedImage k_hit= LoadSave.GetSpriteAtlas(LoadSave.K_PIG_HIT);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_HIT); i++){kingPigArr[K_HIT][i] =k_hit.getSubimage(i*38,0,38,28);}
        BufferedImage k_jump = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_JUMP);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_JUMP); i++){kingPigArr[K_JUMP][i] =k_jump.getSubimage(i*38,0,38,28);}
        BufferedImage k_run = LoadSave.GetSpriteAtlas(LoadSave.K_PIG_RUN);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(KING_PIG,K_RUN); i++){kingPigArr[K_RUN][i] =k_run.getSubimage(i*38,0,38,28);}
        boxPigArr = new BufferedImage[4][9];
        BufferedImage b_idle = LoadSave.GetSpriteAtlas(B_PIG_IDLE);
        for (int i = 0; i < Constant.EnemyConstants.getSpriteAmount(B_PIG,B_IDLE); i++){boxPigArr[B_IDLE][i] = b_idle.getSubimage(i*26,0,26,30);}
        BufferedImage b_pick = LoadSave.GetSpriteAtlas(B_PIG_PICKING_BOX);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(B_PIG,B_PICKING_BOX); i++){boxPigArr[B_PICKING_BOX][i] = b_pick.getSubimage(i*26,0,26,30);}
        BufferedImage b_run = LoadSave.GetSpriteAtlas(LoadSave.B_PIG_RUN);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(B_PIG,B_RUN); i++){boxPigArr[B_RUN][i] =b_run.getSubimage(i*26,0,26,30);}
        BufferedImage b_throw = LoadSave.GetSpriteAtlas(B_PIG_THROWING_BOX);
        for (int i =0; i <Constant.EnemyConstants.getSpriteAmount(B_PIG,B_THROWING_BOX); i++){boxPigArr[B_THROWING_BOX][i] =b_throw.getSubimage(i*26,0,26,30);}

    }
    public void update(int [][] lvlData, Player player){
        for (Pig pig: pigs)
            if (pig.isActive())
                pig.update(lvlData, player);
        for (KingPig kings: kingpigs)
            if (kings.isActive())
                kings.update(lvlData, player);
        for (BoxPig box: boxpigs)
            if (box.isActive())
                box.update(lvlData);
    }
    public void render(Graphics g, int lvlOffset){
        renderPigs(g,lvlOffset);
        renderKingPigs(g,lvlOffset);
        renderBoxPigs(g,lvlOffset);
    }

    private void renderBoxPigs(Graphics g, int lvlOffset) {
        for (BoxPig pig : boxpigs) {
            if (pig.isActive())
                g.drawImage(boxPigArr[pig.getEnemyState()][pig.getAniIndex()], (int)( pig.getHitbox().x-B_PIG_DRAWOFFSET_X-lvlOffset+pig.flipX()), (int) (pig.getHitbox().y-B_PIG_DRAWOFFSET_Y+12), B_PIG_WIDTH*pig.flipW(), B_PIG_HEIGHT, null);
        }
    }
    private void renderKingPigs(Graphics g, int lvlOffset) {
        for (KingPig pig : kingpigs) {
            if (pig.isActive())
                g.drawImage(kingPigArr[pig.getEnemyState()][pig.getAniIndex()], (int)( pig.getHitbox().x-K_PIG_DRAWOFFSET_X-lvlOffset+pig.flipX()), (int) (pig.getHitbox().y-K_PIG_DRAWOFFSET_Y), K_PIG_WIDTH*pig.flipW(), K_PIG_HEIGHT, null);
        }
    }
    public void checkEnemyIsHit(Rectangle2D.Float attackbox){
        for (Pig pig:pigs){
            if (attackbox.intersects(pig.getHitbox())){
                pig.hurt(10, Constant.EnemyConstants.DEAD,Constant.EnemyConstants.HIT);
                return;
            }
        }
        for ( KingPig pig: kingpigs){
            if (attackbox.intersects(pig.getHitbox())){
                pig.hurt(10, Constant.EnemyConstants.K_DEAD,Constant.EnemyConstants.K_HIT);
                return;
            }
        }
        for ( BoxPig pig: boxpigs){
            if (attackbox.intersects(pig.getHitbox())){
                pig.hurt(10, B_THROWING_BOX,B_THROWING_BOX);
                return;
            }
        }
        }


    private void renderPigs(Graphics g, int lvlOffset) {
        for (Pig pig: pigs){
            if (pig.isActive())
                g.drawImage(pigArr[pig.getEnemyState()][pig.getAniIndex()], (int)(pig.getHitbox().x-PIG_DRAWOFFSET_X-lvlOffset+pig.flipX()), (int)(pig.getHitbox().y-PIG_DRAWOFFSET_Y-5),PIG_WIDTH*pig.flipW(),PIG_HEIGHT,null);
        }
    }

    public void resetAllEnemy() {
        for (Pig pig: pigs){
            pig.resetEnemy();
        }
        for (KingPig pig: kingpigs){
            pig.resetEnemy();
        }
        for (BoxPig pig: boxpigs){
            pig.resetEnemy();
        }
    }
}