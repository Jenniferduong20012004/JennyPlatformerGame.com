package Main;
import entities.Player;

import java.awt.*;

public class Game implements Runnable{
    private static Game gameInstance = null;
    private GameWindow gamewindow;
    private GamePanel gamePanel;
    private Player player;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET =200;
    private Game(){
        initClasses();
        gamePanel = new GamePanel(this);
        gamewindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {
        player = new Player(200,200);
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
    public void update(){
        player.update();
    }
    public void render (Graphics g){
        player.render(g);
    }

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
    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }
}
