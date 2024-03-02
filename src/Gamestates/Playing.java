package Gamestates;

import Main.Game;
import entities.EnemyManager;
import entities.Player;
import levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Playing extends States implements Gamestates{
    private LevelManager levelManager;
    private Player player;
    private EnemyManager enemyManager;
    private boolean paused=false;
    private Pausing pause;
    private int xLvlOffset;
    private int leftBorder = (int)(0.2*Game.GAME_WIDTH);
    private int rightBorder = (int)(0.8*Game.GAME_WIDTH);
    private int maxLvlOffsetX;
    private boolean gameOver;
    private GameOver over;
    private LevelComplete levelComplete;
    private boolean lvlComplete = false;
    //private int level = 1;

    public Playing(Game game) {
        super(game);
        initClasses();
        calculateLvlOffset();
        loadStartLevel();
    }
    public void loadNextLevel(){
        resetAll();
        levelManager.loadNextLevel();
        player.setPawn(levelManager.getCurrentLevel().getPlayerSpawn());
    }
    public void setLevelComplete (boolean levelComplete){this.lvlComplete = levelComplete;}

    private void loadStartLevel() {
        enemyManager.loadEnemies(levelManager.getCurrentLevel());
    }

    private void calculateLvlOffset() {
        maxLvlOffsetX = levelManager.getCurrentLevel().getLvlOffset();
    }
    public void setMaxLvlOffSet (int lvl){
        this.maxLvlOffsetX = lvl;
    }

    private void initClasses() {
        levelManager = new LevelManager(game, this);
        enemyManager = new EnemyManager(this, levelManager);
        player = new Player(200,200,(int) (78 * Game.SCALE), (int) (58 * Game.SCALE),this);
        player.loadlvlData(levelManager.getCurrentLevel().getLevelData());
        pause = new Pausing(game, this);
        over = new GameOver(game, this);
        levelComplete = new LevelComplete(game, this);
    }
    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }

    @Override
    public void resetDirBoolean() {
        player.resetDirBoolean();
    }

    @Override
    public void update() {
        if (paused){
            pause.update();
        }
        else if (lvlComplete){
            levelComplete.update();
        } else if (!gameOver) {
            levelManager.update();
            player.update();
            enemyManager.update(player);//levelManager.getCurrentLevel().getLevelData(), player);
            checkCloseToBorder();
        }
    }

    private void checkCloseToBorder() {
        int playerX = (int) player.getHitbox().x;
        int diff = playerX -xLvlOffset;
        if (diff>rightBorder){
            xLvlOffset += diff - rightBorder;
        }
        else if (diff <leftBorder){
            xLvlOffset += diff-leftBorder;
        }
        if (xLvlOffset>maxLvlOffsetX){
            xLvlOffset = maxLvlOffsetX;
        }
        else if (xLvlOffset < 0){
            xLvlOffset =0;
        }
    }
    @Override
    public void render(Graphics g) {
        levelManager.render(g, xLvlOffset);
        player.render(g,xLvlOffset);
        enemyManager.render(g,xLvlOffset);
        if (paused) {
            g.setColor (new Color (0,0,0, 50));
            g.fillRect (0,0,Game.GAME_WIDTH, Game.GAME_HEIGHT);
            pause.render(g);
        }
        else if (gameOver){
            over.render(g);
        } else if (lvlComplete) {
            levelComplete.render(g);
        }
    }

    @Override
    public void Mouseclick(MouseEvent e) {
        if (!gameOver) {
            if (paused) {
                pause.Mouseclick(e);
            }
            else if (lvlComplete){
                levelComplete.Mouseclick(e);
            }
        }
    }

    @Override
    public void MouseRelease(MouseEvent e) {
        if (!gameOver) {
            if (paused) {
                pause.MouseRelease(e);
            } else if (lvlComplete) {
                levelComplete.MouseRelease(e);
            }
        }
    }

    @Override
    public void MouseMove(MouseEvent e) {
        if (!gameOver) {
            if (paused) {
                pause.MouseMove(e);
            } else if (lvlComplete) {
                levelComplete.MouseMove(e);
            }
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {
        if (gameOver) {
            over.KeyPress(e);
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.setJump(true);
                    break;
                case KeyEvent.VK_LEFT:
                    player.setLeft(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setRight(true);
                    break;
                case KeyEvent.VK_SPACE:
                    player.setAttack(true);
                    break;
                case KeyEvent.VK_ESCAPE:
                    paused = !paused;
                    break;
            }
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {
        if (!gameOver) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    player.setJump(false);
                    break;
                case KeyEvent.VK_LEFT:
                    player.setLeft(false);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setRight(false);
                    break;
                case KeyEvent.VK_SPACE:
                    player.setAttack(false);
                    break;
            }
        }
    }

    @Override
    public void mouseDrag(MouseEvent e) {
        if (!gameOver) {
            if (paused) {
                pause.mouseDrag(e);
            }
        }
    }

    public void unPauseGame(){
        paused = false;
    }
    public void resetAll(){
        gameOver = false;
        paused = false;
        lvlComplete=false;
        player.resetAll();
        enemyManager.resetAllEnemy();
    }
    public EnemyManager getEnemyManager(){
        return enemyManager;
    }

    public void checkEnemyIsHit(Rectangle2D.Float attackbox) {
        enemyManager.checkEnemyIsHit(attackbox);
    }

    public void setGameOver(boolean b) {
        this.gameOver=b;
    }
}

