package Main;

public class Game implements Runnable{
    private static Game gameInstance = null;
    private GameWindow gamewindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private Game(){
        gamePanel = new GamePanel();
        gamewindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
    public static Game getGame(){
        if (gameInstance ==null){
            gameInstance = new Game();
        }
        return gameInstance;
    }

    private void startGameLoop(){

    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while (true){
            now = System.nanoTime();
            if(System.nanoTime()- lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;            }
        }
    }
}
