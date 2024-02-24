package Gamestates;

import Main.Game;
import ui.SoundButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.PauseButtons.SOUND_SIZE;

public class Pausing implements Gamestates{
    private BufferedImage background;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton, sfxButton;
    public Pausing (){
        loadBackground();
        createSoundButtons();
    }

    private void createSoundButtons() {
        int soundX = (int)(450*Game.SCALE);
        int musicY = (int)(140*Game.SCALE);
        int sfxY = (int)(186*Game.SCALE);
        musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
        sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
    }

    private void loadBackground() {
        background = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
        bgW = (int) (background.getWidth()* Game.SCALE);
        bgH = (int) (background.getHeight()* Game.SCALE);
        bgX = Game.GAME_WIDTH/2-bgW/2;
        bgY = (int)(25*Game.SCALE);
    }

    @Override
    public void resetDirBoolean() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage (background, bgX, bgY,bgW, bgH, null);
        musicButton.draw(g);
        sfxButton.draw(g);
    }

    @Override
    public void Mouseclick(MouseEvent e) {

    }

    @Override
    public void MouseRealease(MouseEvent e) {

    }

    @Override
    public void MouseMove(MouseEvent e) {

    }

    @Override
    public void KeyPress(KeyEvent e) {

    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }
}
