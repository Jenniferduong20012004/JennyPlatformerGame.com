package ui;

import utilz.LoadSave;

import java.awt.image.BufferedImage;

import static utilz.Constant.UI.Buttons.B_HEIGHT_DEFAULT;
import static utilz.Constant.UI.Buttons.B_WIDTH_DEFAULT;

public class OptionsButtons extends MenuButton{
    public OptionsButtons(int xPos, int yPos, int rowIndex) {
        super(xPos, yPos, rowIndex);
    }
    @Override
    public void loadImgs() {
        super.loadImgs();
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BUTTONS_ATLAS);
        for (int i =0; i< imgs.length; i++)
            imgs[i]= temp.getSubimage(i* B_WIDTH_DEFAULT, 1* B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }
}
