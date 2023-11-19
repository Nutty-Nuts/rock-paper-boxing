package inputs;

import gamestates.GameStates;
import main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private Panel panel;

    public KeyHandler(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (GameStates.gameState) {
            case MENU:
                panel.getGame().getMenu().keyPressed(event);
                break;
            case PLAYING:
                panel.getGame().getPlaying().keyPressed(event);
                break;
            case SELECTION:
                panel.getGame().getSelection().keyPressed(event);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent event) {
        switch (GameStates.gameState) {
            case MENU:
                panel.getGame().getMenu().keyReleased(event);
                break;
            case PLAYING:
                panel.getGame().getPlaying().keyReleased(event);
                break;
            case SELECTION:
                panel.getGame().getSelection().keyReleased(event);
                break;
            case INFO:
                panel.getGame().getInfo().keyReleased(event);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // TODO Auto-generated method stub

    }

}
