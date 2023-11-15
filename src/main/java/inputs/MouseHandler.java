package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.GameStates;
import main.Panel;

public class MouseHandler implements MouseListener, MouseMotionListener {
    private Panel panel;

    public MouseHandler(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO Auto-generated method stub
        switch (GameStates.gameState) {
            case MENU:
                panel.getGame().getMenu().mousePressed(event);
                break;
            case PLAYING:
                panel.getGame().getPlaying().mousePressed(event);
                break;
            case SELECTION:
                panel.getGame().getSelection().mousePressed(event);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub
        switch (GameStates.gameState) {
            case MENU:
                panel.getGame().getMenu().mouseReleased(event);
                break;
            case PLAYING:
                panel.getGame().getPlaying().mouseReleased(event);
                break;
            case SELECTION:
                panel.getGame().getSelection().mouseReleased(event);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        // TODO Auto-generated method stub

    }

}
