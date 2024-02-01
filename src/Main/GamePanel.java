package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private BufferedImage img;
    private MouseInputs mouseInputs;
    public GamePanel(){
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        importImg();
    }
    public void paintComponent (Graphics g){

    }

    private void importImg() {
        /*InputStream is = getClass().getResourceAsStream("Res/Main-char/Attack (78x58).png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }
}
