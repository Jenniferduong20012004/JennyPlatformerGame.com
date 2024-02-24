package ui;

import jdk.jshell.execution.LoaderDelegate;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import utilz.Constant.UI.PauseButtons.*;

public class SoundButton extends PauseButton{
    private BufferedImage[][] soundImg;
    public SoundButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadImgs();
    }
    @Override
    public void loadImgs(){
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SOUND_BUTTON);
        soundImg = new BufferedImage[2][3];
        for (int i =0; i< soundImg.length; i++){
            for (int j =0; j < soundImg[i].length; j++){
                soundImg [i][j] = temp.getSubimage(j*Constant.UI.PauseButtons.SOUND_SIZE_DEFAULT, i*Constant.UI.PauseButtons.SOUND_SIZE_DEFAULT, Constant.UI.PauseButtons.SOUND_SIZE_DEFAULT, Constant.UI.PauseButtons.SOUND_SIZE_DEFAULT);
            }
        }
    }
    @Override
    public void update(){

    }
    @Override
    public void draw (Graphics g){
        g.drawImage (soundImg[0][0],x,y,width, height, null);
    }

}
