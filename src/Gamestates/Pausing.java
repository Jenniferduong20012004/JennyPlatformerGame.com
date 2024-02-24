package Gamestates;

import Main.Game;
import ui.SoundButton;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.PauseButtons.SOUND_SIZE;

public class Pausing extends States implements Gamestates{
    private BufferedImage background;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton, sfxButton;
    private Constant.UI.UmrButtons menuB, replayB, unpauseB;
    public Pausing (Game game){
        super(game);
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
        musicButton.update();
        sfxButton.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage (background, bgX, bgY,bgW, bgH, null);
        musicButton.draw(g);
        sfxButton.draw(g);
    }

    @Override
    public void Mouseclick(MouseEvent e) {
        if (isIn(e, musicButton)){
            musicButton.setMousePress(true);
        }
        else if (isIn (e, sfxButton)) {
            sfxButton.setMousePress(true);
        }
    }

    @Override
    public void MouseRealease(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePress()) {
                musicButton.setMuted(!musicButton.isMuted());
            }
        }
        else if (isIn (e, sfxButton)) {
            if (sfxButton.isMousePress()) {
                sfxButton.setMuted(!sfxButton.isMuted());
            }
        }
        musicButton.resetBools();
        sfxButton.resetBools();
    }

    @Override
    public void MouseMove(MouseEvent e) {
        musicButton.setMouseOver(false);
        sfxButton.setMouseOver(false);
        if (isIn(e, musicButton)){
            musicButton.setMouseOver(true);
        }
        else if (isIn(e,sfxButton)){
            sfxButton.setMouseOver(true);
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {

    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }


}
