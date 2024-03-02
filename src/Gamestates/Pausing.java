package Gamestates;

import Main.Game;
import ui.SoundButton;
import ui.UrmButton;
import ui.VolumeButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.PauseButtons.SOUND_SIZE;
import static utilz.Constant.UI.UmrButtons.UMR_SIZE;
import static utilz.Constant.UI.VolumeButtons.*;

public class Pausing extends States implements Gamestates{
    private BufferedImage background;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton, sfxButton;
    private UrmButton menuB, replayB, unpauseB;
    private Playing playing;
    private VolumeButton volumeB;
    public Pausing (Game game, Playing playing){
        super(game);
        this.playing = playing;
        loadBackground();
        createSoundButtons();
        createUmrButtons();
        createVolumeButtons();
    }

    private void createVolumeButtons() {
        int vX = (int)(309*Game.SCALE);
        int vY = (int)(278*Game.SCALE);
        volumeB = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_HEIGHT);

    }

    private void createUmrButtons() {
        int menuX = (int)(313*Game.SCALE);
        int replayX = (int)(387*Game.SCALE);
        int unpauseX = (int)(462*Game.SCALE);
        int bY = (int)(325*Game.SCALE);
        menuB = new UrmButton(menuX,bY, UMR_SIZE, UMR_SIZE, 2);
        replayB= new UrmButton(replayX,bY, UMR_SIZE, UMR_SIZE, 1 );
        unpauseB= new UrmButton(unpauseX,bY, UMR_SIZE, UMR_SIZE, 0);
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
        menuB.update();
        replayB.update();
        unpauseB.update();
        volumeB.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage (background, bgX, bgY,bgW, bgH, null);
        musicButton.draw(g);
        sfxButton.draw(g);
        menuB.draw(g);
        replayB.draw(g);
        unpauseB.draw(g);
        volumeB.draw(g);
    }

    @Override
    public void Mouseclick(MouseEvent e) {
        if (isIn(e, musicButton)){
            musicButton.setMousePress(true);
        }
        else if (isIn (e, sfxButton)) {
            sfxButton.setMousePress(true);
        }
        else if (isIn (e, menuB)) {
            menuB.setMousePress(true);
        }
        else if (isIn (e, replayB)) {
            replayB.setMousePress(true);
        }
        else if (isIn (e, unpauseB)) {
            unpauseB.setMousePress(true);
        }
        else if (isIn (e, volumeB)) {
            volumeB.setMousePress(true);
        }
    }

    @Override
    public void MouseRelease(MouseEvent e) {
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
        else if (isIn (e, menuB)) {
            if (menuB.isMousePress()) {
                game.setState(new Menu(game));
            }
        }
        else if (isIn (e, replayB)) {
            if (replayB.isMousePress()) {
                playing.resetAll();
                playing.unPauseGame();
            }
        }
        else if (isIn (e, replayB)) {
            if (replayB.isMousePress()) {

            }
        }
        else if (isIn (e, unpauseB)) {
            if (unpauseB.isMousePress()) {
                playing.unPauseGame();
            }
        }
        musicButton.resetBools();
        sfxButton.resetBools();
        menuB.resetBools();
        replayB.resetBools();
        unpauseB.resetBools();
        volumeB.resetBools();
    }

    @Override
    public void MouseMove(MouseEvent e) {
        musicButton.setMouseOver(false);
        sfxButton.setMouseOver(false);
        menuB.setMousePress(false);
        replayB.setMouseOver(false);
        unpauseB.setMouseOver(false);
        volumeB.setMouseOver(false);
        if (isIn(e, musicButton)){
            musicButton.setMouseOver(true);
        }
        else if (isIn(e,sfxButton)){
            sfxButton.setMouseOver(true);
        }
        else if (isIn(e,menuB)){
            menuB.setMouseOver(true);
        }
        else if (isIn(e,replayB)){
            replayB.setMouseOver(true);
        }
        else if (isIn(e,unpauseB)){
            unpauseB.setMouseOver(true);
        }
        else if (isIn(e,volumeB)){
            volumeB.setMouseOver(true);
        }
    }
    public void mouseDrag (MouseEvent e){
        if (volumeB.isMousePress()){
            volumeB.changeX(e.getX());
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {

    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }


}
