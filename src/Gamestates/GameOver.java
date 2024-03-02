package Gamestates;

import Main.Game;
import ui.UrmButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.UmrButtons.UMR_SIZE;

public class GameOver extends States implements Gamestates{
    private Playing playing;
    private BufferedImage img;
    private int bgX, bgY, bgW, bgH;
    private UrmButton menu, replay;
    public GameOver(Game game, Playing playing) {
        super(game);
        this.playing =playing;
        loadImgs();
        initButtons();
    }

    private void initButtons() {
        int menuX = (int)(330*Game.SCALE);
        int nextX = (int)(445*Game.SCALE);
        int y = (int)(195*Game.SCALE);
        replay = new UrmButton(nextX,y, UMR_SIZE, UMR_SIZE, 1);
        menu = new UrmButton(menuX,y, UMR_SIZE, UMR_SIZE, 2 );
    }

    public void loadImgs(){
        img = LoadSave.GetSpriteAtlas(LoadSave.DEATH_SCREEN);
        bgW = (int)(img.getWidth()*Game.SCALE);
        bgH = (int)(img.getHeight()*Game.SCALE);
        bgX = Game.GAME_WIDTH /2-bgW/2;
        bgY = (int) (75*Game.SCALE);
    }

    @Override
    public void resetDirBoolean() {

    }

    @Override
    public void update() {
        replay.update();
        menu.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, bgX, bgY, bgW, bgH, null);
        replay.draw(g);
        menu.draw(g);
    }

    @Override
    public void Mouseclick(MouseEvent e) {
        if (isIn(e,menu)){
            menu.setMousePress(true);
        }
        else if (isIn(e,replay)){
            replay.setMousePress(true);
        }
    }

    @Override
    public void MouseRelease(MouseEvent e) {
        if (isIn(e,menu)) {
            if (menu.isMousePress()) {
                game.setState(new Menu(game));
            }
        }
        else if (isIn(e,replay)){
            if (replay.isMousePress()){
                playing.loadNextLevel();
            }
        }
        menu.resetBools();
        replay.resetBools();
    }

    @Override
    public void MouseMove(MouseEvent e) {
        replay.setMouseOver(false);
        menu.setMouseOver(false);
        if (isIn(e,menu)){
            menu.setMouseOver(true);
        }
        else if (isIn(e,replay)){
            replay.setMouseOver(true);
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ESCAPE){
            playing.resetAll();
            game.setState(new Menu(game));
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }

    @Override
    public void mouseDrag(MouseEvent e) {

    }
}
