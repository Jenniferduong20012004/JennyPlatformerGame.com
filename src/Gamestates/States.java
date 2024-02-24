package Gamestates;

import Main.Game;
import ui.MenuButton;
import utilz.Constant;

import java.awt.event.MouseEvent;

public class States {
    protected Game game;
    public States(Game game){
        this.game = game;
    }
    public Game getGame(){return game;}
    public boolean isIn (MouseEvent e, ui.Buttons mb){
        return mb.getBounds().contains(e.getX(), e.getY());
    }
}
