package Gamestates;

import Main.Game;
import ui.MenuButton;
import ui.OptionsButtons;
import ui.PlayingButton;
import ui.QuitButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends States implements Gamestates {
    private MenuButton [] buttons = new MenuButton[3];
    private BufferedImage background, name, pinkBack;
    private int nameX, nameY, nameWidth, nameHeight;
    private int menuX, menuY, menuWidth, menuHeight;
    private int pinkX, pinkY, pinkWidth, pinkHeight;
    public Menu(Game game) {
        super(game);
        loadPinkBack();
        loadName();
        loadBackground();
        loadButtons();
    }

    private void loadPinkBack() {
        pinkBack = LoadSave.GetSpriteAtlas(LoadSave.PINK_ATLAS);
        pinkWidth = (int) (pinkBack.getWidth()*Game.SCALE);
        pinkHeight = (int)(pinkBack.getHeight()*Game.SCALE);
        pinkX = 0;
        pinkY = 0;
    }

    private void loadName() {
        name = LoadSave.GetSpriteAtlas(LoadSave.NAME_ATLAS);
        nameWidth = (int) (name.getWidth()*Game.SCALE*2.5);
        nameHeight = (int)(name.getHeight()*Game.SCALE*2.5);
        nameX = Game.GAME_WIDTH/2-nameWidth/2;
        nameY = (int)(45*Game.SCALE-20);
    }

    private void loadBackground() {
        background = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
        menuWidth = (int)(background.getWidth()*Game.SCALE);
        menuHeight = (int) (background.getHeight()*Game.SCALE);
        menuX = Game.GAME_WIDTH/2-menuWidth/2;
        menuY = (int)(45*Game.SCALE+40);
    }

    private void loadButtons() {
        buttons [0] = new PlayingButton(Game.GAME_WIDTH/2, (int)(180*Game.SCALE), 0);
        buttons [1] = new OptionsButtons(Game.GAME_WIDTH/2, (int)(250*Game.SCALE), 1);
        buttons [2] = new QuitButton(Game.GAME_WIDTH/2, (int)(320*Game.SCALE), 2);
    }

    @Override
    public void resetDirBoolean() {
        return;
    }

    @Override
    public void update() {
        for (MenuButton mb: buttons){
            mb.update();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(pinkBack,pinkX,pinkY,pinkWidth,pinkHeight,null);
        g.drawImage(name,nameX,nameY,nameWidth,nameHeight,null);
        g.drawImage(background,menuX,menuY,menuWidth,menuHeight, null);
            for (MenuButton mb: buttons){
                mb.draw(g);
            }
    }

    @Override
    public void Mouseclick(MouseEvent e) {
            for (MenuButton mb: buttons){
                if (isIn(e,mb)){
                    mb.setMouseClick(true);
                    break;
                }
            }
    }

    @Override
    public void MouseRelease(MouseEvent e) {
        for (MenuButton mb: buttons){
            if (isIn(e,mb)){
                if (mb.getMouseClick()){
                    mb.applyGameState(game);
                }
                break;
            }
        }
        resetButtons();
    }

    private void resetButtons() {
        for (MenuButton mb: buttons){
            mb.resetBools();
        }
    }

    @Override
    public void MouseMove(MouseEvent e) {
        for (MenuButton mb: buttons){
            mb.setMouseOver(false);
        }
        for (MenuButton mb: buttons){
            if (isIn(e,mb)){
                mb.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void KeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0){
            game.setState(new Playing(game));
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }

    @Override
    public void mouseDrag(MouseEvent e) {

    }
}
