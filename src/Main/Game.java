package Main;
import Gamestates.Gamestates;
import Gamestates.Playing;
import Gamestates.Menu;
import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class Game implements Runnable{
    private static Game gameInstance = null;
    private GameWindow gamewindow;
    private GamePanel gamePanel;
    private Gamestates state;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET =200;
    public final static int TILES_DEFAULT_SIZE =32;
    public final static float SCALE = 1.25f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE *SCALE);
    public final static int GAME_WIDTH = TILES_SIZE*TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE*TILES_IN_HEIGHT;
    private Game(){
        initClasses();
        gamePanel = new GamePanel(this);
        gamewindow = new GameWindow(gamePanel);
        gamePanel.setFocusable (true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {
        state = new Menu (this);
    }

    public static Game getGame(){
        if (gameInstance ==null){
            gameInstance = new Game();
        }
        return gameInstance;
    }

    private void startGameLoop(){
        gameThread = new Thread (this);
        gameThread.start();
    }
    public void update(){state.update();}
    public void render (Graphics g){state.render(g);}
    @Override
    public void run() {
        long previousTime = System.nanoTime();
        double timePerFrame = 1000000000.0/FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastCheck = System.currentTimeMillis();
        double deltaU =0;
        double deltaF =0;
        while (true){
            long currentTime = System.nanoTime();
            deltaU+= (currentTime -previousTime)/timePerUpdate;
            deltaF+= (currentTime -previousTime)/timePerFrame;
            previousTime= currentTime;
            if (deltaU>=1){
                update();
                deltaU--;

            }
            if (deltaF >=1){
                gamePanel.repaint();
                deltaF--;
            }
            if (System.currentTimeMillis()-lastCheck>=1000){
                lastCheck = System.currentTimeMillis();
            }
        }
    }

    public void windowFocusLost() {
        state.resetDirBoolean();
    }
    public Gamestates getState(){return state;}
    public void setState(Gamestates state){this.state = state;}
}
