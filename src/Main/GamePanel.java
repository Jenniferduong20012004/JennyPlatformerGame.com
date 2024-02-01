package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private BufferedImage img;
    public GamePanel() throws IOException {
        importImg();
    }
    public void paintComponent (Graphics g){

    }

    private void importImg() throws IOException {
        InputStream is = getClass().getResourceAsStream("Res/Main-char/Attack (78x58).png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
