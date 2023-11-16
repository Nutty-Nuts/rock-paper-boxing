package gamestates;

import java.awt.*;
import java.awt.event.*;

import main.Game;
import ui.ButtonAbstract;

public class State {
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public boolean isIn(MouseEvent e, ButtonAbstract button) {
        return button.getBoundary().contains(e.getX(), e.getY());
    }

    public Game getGame() {
        return game;
    }

    public void setGameState(GameStates state) {
        GameStates.gameState = state;
    }
}
