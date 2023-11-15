package gamestates;

import main.Game;
import ui.Buttons;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu extends State implements StateMethods {
    private Buttons buttons[] = new Buttons[1];

    public Menu(Game game) {
        super(game);
        loadButtons();
    }

    public void loadButtons() {
        buttons[0] = new Buttons(100, 100, GameStates.SELECTION);
    }

    @Override
    public void update() {
        for (Buttons button : buttons) {
            button.update();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Buttons button : buttons) {
            button.draw(graphics);
        }

    }

    @Override
    public void keyPressed(KeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent event) {
        for (Buttons button : buttons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        for (Buttons button : buttons) {
            if (isIn(event, button)) {
                if (button.isMousePressed()) {
                    System.out.println("Button pressed");
                    button.applyState();
                }
                break;
            }
        }
        resetButtons();
    }

    public void resetButtons() {
        for (Buttons button : buttons) {
            button.reset();
        }
    }

}
