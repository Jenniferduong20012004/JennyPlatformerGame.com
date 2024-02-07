package Gamestates;

import Main.Game;
import ui.MenuButton;

import java.awt.event.MouseEvent;

public class States {
    protected Game game;
    public States(Game game){
        this.game = game;
    }
    public Game getGame(){return game;}
    public boolean isIn (MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(), e.getY());
    }
}
