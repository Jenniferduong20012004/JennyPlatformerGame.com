package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.Game.*;
import static utilz.Constant.Directions.*;
import static utilz.Constant.PlayerConstants.*;

public class GamePanel extends JPanel {
    private BufferedImage img;
    private MouseInputs mouseInputs;
    private Player player;
    private Game game;
    public GamePanel(Game game){
        mouseInputs = new MouseInputs(this);
        this.game = game;
        player = new Player(0,0);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }



    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
