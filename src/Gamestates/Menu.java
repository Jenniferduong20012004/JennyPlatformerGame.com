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
        buttons [0] = new PlayingButton(Game.GAME_WIDTH/2, (int)(150*Game.GAME_WIDTH), 0);
        buttons [1] = new OptionsButtons(Game.GAME_WIDTH/2, (int)(150*Game.GAME_WIDTH), 1);
        buttons [2] = new QuitButton(Game.GAME_WIDTH/2, (int)(150*Game.GAME_WIDTH), 2);
    }

    @Override
    public void resetDirBoolean() {
        return;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawRect (200,200,100,100);
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
        if (e.getKeyCode() == KeyEvent.VK_0){
            game.setState(new Playing(game));
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }
}
