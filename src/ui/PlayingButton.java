package ui;

import Gamestates.Gamestates;
import utilz.LoadSave;

import java.awt.image.BufferedImage;

import static utilz.Constant.UI.Buttons.B_HEIGHT_DEFAULT;
import static utilz.Constant.UI.Buttons.B_WIDTH_DEFAULT;

public class PlayingButton extends MenuButton{

    public PlayingButton(int xPos, int yPos, int rowIndex) {
        super(xPos, yPos, rowIndex);
    }
    @Override
    public void loadImgs() {
        super.loadImgs();
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BUTTONS_ATLAS);
        for (int i =0; i< imgs.length; i++)
        imgs[i]= temp.getSubimage(i* B_WIDTH_DEFAULT, 0* B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }

}
