package ui;

import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UrmButton extends PauseButton{
    private BufferedImage[] umrImg;
    private int rowIndex, index ;
    private boolean mouseOver,mousePress;

    public UrmButton(int x, int y, int width, int height, int rowIndex) {
        super(x, y, width, height);
        this.rowIndex = rowIndex;
        loadImgs();
    }
    @Override
    public void loadImgs(){
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.URM_BUTTON);
        umrImg = new BufferedImage[3];
        for (int i =0; i< umrImg.length; i++){
                umrImg[i] = temp.getSubimage(i* Constant.UI.UmrButtons.UMR_SIZE_DEFAULT, rowIndex*Constant.UI.UmrButtons.UMR_SIZE_DEFAULT, Constant.UI.UmrButtons.UMR_SIZE_DEFAULT, Constant.UI.UmrButtons.UMR_SIZE_DEFAULT);
        }
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(umrImg[index], x, y, Constant.UI.UmrButtons.UMR_SIZE,Constant.UI.UmrButtons.UMR_SIZE, null );
    }
    @Override
    public void update(){
        index =0;
        if (mouseOver){
            index =1;
        }
        if (mousePress){
            index = 2;
        }
    }
}
