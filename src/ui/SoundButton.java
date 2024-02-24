package ui;

import jdk.jshell.execution.LoaderDelegate;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SoundButton extends PauseButton{
    private BufferedImage[][] soundImg;
    private boolean mouseOver, mousePress;
    private boolean muted;
    private int rowIndex, column;
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
        if (muted){
            rowIndex =1;
        }
        else{
            rowIndex = 0;
        }
        column =0;
        if(mouseOver){
            column =1;
        }
        if (mousePress){
            column = 2;
        }

    }
    @Override
    public void draw (Graphics g){
        g.drawImage (soundImg[rowIndex][column],x,y,width, height, null);
    }
    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePress() {
        return mousePress;
    }

    public void setMousePress(boolean mousePress) {
        this.mousePress = mousePress;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }
    public void resetBools(){
        mouseOver = false;
        mousePress = false;
    }

}
