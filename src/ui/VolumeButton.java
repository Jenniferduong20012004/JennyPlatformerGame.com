package ui;

import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.VolumeButtons.*;

public class VolumeButton extends ui.PauseButton{
    private BufferedImage[] volumeImg;
    private BufferedImage slideImg;
    private int index =0;
    private boolean mouseOver,mousePress;
    private int buttonX;
    public VolumeButton(int x, int y, int width, int height) {
        super(x=width/2, y, VOLUME_WIDTH, height);
        buttonX = x+width/2;
        loadImgs();
    }
    @Override
    public void loadImgs(){
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.VOLUME_BUTTON);
        volumeImg = new BufferedImage[3];
        for (int i=0; i< volumeImg.length; i++){
            volumeImg[i] = temp.getSubimage(i*VOLUME_DEFAULT_WIDTH,0, VOLUME_DEFAULT_WIDTH, VOLUME_DEFAULT_HEIGHT);
        }
        slideImg = temp.getSubimage(3*VOLUME_DEFAULT_WIDTH,0, SLIDER_DEFAULT_WIDTH, VOLUME_DEFAULT_HEIGHT );
    }
    @Override
    public void update(){
        if (mouseOver){
            index =1;
        }
        if (mousePress){
            index =2;
        }
    }
    @Override
    public void draw(Graphics g){
        g.drawImage (slideImg, x,y,width, height, null);
        g.drawImage(volumeImg[index], buttonX,y,VOLUME_WIDTH, height, null);
    }
}
