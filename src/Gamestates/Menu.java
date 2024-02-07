package Gamestates;

import Main.Game;
import ui.MenuButton;
import ui.OptionsButtons;
import ui.PlayingButton;
import ui.QuitButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu extends States implements Gamestates {
    private MenuButton [] buttons = new MenuButton[3];
    public Menu(Game game) {
        super(game);
        loadButtons();
    }

    private void loadButtons() {
        buttons [0] = new PlayingButton(Game.GAME_WIDTH/2, (int)(150*Game.SCALE), 0);
        buttons [1] = new OptionsButtons(Game.GAME_WIDTH/2, (int)(220*Game.SCALE), 1);
        buttons [2] = new QuitButton(Game.GAME_WIDTH/2, (int)(290*Game.SCALE), 2);
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
    public void MouseRealease(MouseEvent e) {
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
}
