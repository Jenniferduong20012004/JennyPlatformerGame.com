package Gamestates;

import Main.Game;
import entities.EnemyManager;
import entities.Player;
import levels.LevelManager;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilz.LevelOne.Enemy_levelOne;
import static utilz.LevelOne.LEVEL_ONE;

public class Playing extends States implements Gamestates{
    private LevelManager levelManager;
    private Player player;
    private EnemyManager enemyManager;
    private boolean paused=false;
    private Pausing pause;
    private int xLvlOffset;
    private int leftBorder = (int)(0.2*Game.GAME_WIDTH);
    private int rightBorder = (int)(0.8*Game.GAME_WIDTH);
    private int lvlTileWide = LoadSave.GetLevelData(LEVEL_ONE)[0].length;
    private int maxTileOffset = lvlTileWide- Game.TILES_IN_WIDTH;
    private int maxLvlOffsetX = maxTileOffset *Game.TILES_SIZE;

    public Playing(Game game) {
        super(game);
        initClasses();
    }
    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(200,200,(int) (78 * Game.SCALE), (int) (58 * Game.SCALE));
        enemyManager = new EnemyManager(this);
        pause = new Pausing(game, this);
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
        if (!paused) {
            levelManager.update();
            player.update();
            checkCloseToBorder();
            enemyManager.update(LEVEL_ONE, player);
        }
        else {
            pause.update();
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
            g.setColor (new Color (0,0,0,150));
            g.fillRect (0,0,Game.GAME_WIDTH, Game.GAME_HEIGHT);
            pause.render(g);
        }
    }

    @Override
    public void Mouseclick(MouseEvent e) {
        if (paused){
            pause. Mouseclick(e);
        }
    }

    @Override
    public void MouseRelease(MouseEvent e) {
        if (paused){
            pause. MouseRelease(e);
        }
    }

    @Override
    public void MouseMove(MouseEvent e) {
        if (paused){
            pause. MouseMove(e);
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {
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

    @Override
    public void KeyRealease(KeyEvent e) {
        switch (e.getKeyCode()){
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

    @Override
    public void mouseDrag(MouseEvent e) {
        if (paused){
            pause.mouseDrag(e);
        }
    }

    public void unPauseGame(){
        paused = false;
    }
}
