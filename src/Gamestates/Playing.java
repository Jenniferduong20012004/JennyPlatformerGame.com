package Gamestates;

import Main.Game;
import entities.EnemyManager;
import entities.Player;
import levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends States implements Gamestates{
    private LevelManager levelManager;
    private Player player;
    private EnemyManager enemyManager;

    public Playing(Game game) {
        super(game);
        initClasses();
    }
    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(200,200,(int) (78 * Game.SCALE), (int) (58 * Game.SCALE));
        enemyManager = new EnemyManager(this);
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
        levelManager.update();
        player.update();
        enemyManager.update();
    }

    @Override
    public void render(Graphics g) {
        levelManager.render(g);
        player.render(g);
        enemyManager.render(g);
    }

    @Override
    public void Mouseclick(MouseEvent e) {

    }

    @Override
    public void MouseRealease(MouseEvent e) {

    }

    @Override
    public void MouseMove(MouseEvent e) {

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
}
