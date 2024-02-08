package ui;

import Gamestates.Playing;
import Gamestates.Quitting;
import Main.Game;
import utilz.LoadSave;

import java.awt.image.BufferedImage;

import static utilz.Constant.UI.Buttons.B_HEIGHT_DEFAULT;
import static utilz.Constant.UI.Buttons.B_WIDTH_DEFAULT;

public class QuitButton extends MenuButton {
    public QuitButton(int xPos, int yPos, int rowIndex) {
        super(xPos, yPos, rowIndex);
    }

    @Override
    public void loadImgs() {
        super.loadImgs();
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BUTTONS_ATLAS);
        for (int i =0; i< imgs.length; i++)
            imgs[i]= temp.getSubimage(i* B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }

    @Override
    public void applyGameState(Game game) {
        game.setState(new Quitting(game));
    }
}
