package Main;

public class Game implements Runnable{
    private static Game gameInstance = null;
    private GameWindow gamewindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET =200;
    private Game(){
        gamePanel = new GamePanel();
        gamewindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
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
}
