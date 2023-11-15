package gamestates;

import main.Game;
import ui.Buttons;
import ui.MenuButtons;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import utils.Constants.WINDOW;

public class Menu extends State implements StateMethods {
    private MenuButtons menuButtons[];

    public Menu(Game game) {
        super(game);

        initButtons();
    }

    public void initButtons() {
        this.menuButtons = new MenuButtons[3];

        menuButtons[0] = new MenuButtons(WINDOW.SCALE_WIDTH / 2, 100, "PLAY", "PLAY",
                GameStates.SELECTION);
        menuButtons[1] = new MenuButtons(WINDOW.SCALE_WIDTH / 2, 174, "INFO", "INFO",
                GameStates.INFO);
        menuButtons[2] = new MenuButtons(WINDOW.SCALE_WIDTH / 2, 248, "QUIT", "QUIT",
                GameStates.QUIT);
    }

    @Override
    public void update() {
        for (MenuButtons button : menuButtons) {
            button.update();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (MenuButtons button : menuButtons) {
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
        for (MenuButtons button : menuButtons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        for (MenuButtons button : menuButtons) {
            if (!isIn(event, button)) {
                continue;
            }
            if (!button.isMousePressed()) {
                continue;
            }

            switch (button.getTag()) {
                case "PLAY" -> button.applyState();
                case "INFO" -> button.applyState();
                case "QUIT" -> button.applyState();
            }
            break;
        }
        resetButtons();
    }

    public void resetButtons() {
        for (MenuButtons button : menuButtons) {
            button.reset();
        }
    }

}
