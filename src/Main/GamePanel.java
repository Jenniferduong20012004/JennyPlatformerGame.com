package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constant.*;
import static utilz.Constant.PlayerConstants.*;

public class GamePanel extends JPanel {
    private BufferedImage img;
    private MouseInputs mouseInputs;
    private BufferedImage [] attackAni;
    private int aniTick, aniIndex;
    private int aniSpeed = 20;
    private int playerAction = ATTACK;
    private int playerDir = -1;
    private boolean moving = false;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        importImg();
        loadAnimation();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimation() {
        attackAni = new BufferedImage[3];
        for (int i =0; i <attackAni.length; i++){
            attackAni[i] = img.getSubimage(i*78,0,78,58);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(3120, 1450);
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        g.drawImage(attackAni[aniIndex],0,0,156,116,null);
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick =0;
            aniIndex ++;
            if (aniIndex >= getSpriteAmount (playerAction)){
                aniIndex =0;
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/Player/Attack (78x58).png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
