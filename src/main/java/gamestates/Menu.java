package gamestates;

import main.Game;
import ui.*;
import ui.Image;

import java.awt.*;
import java.awt.event.*;

import gamestates.GameStates;
import utils.Constants.*;
import utils.Loader.*;

public class Menu extends State implements StateMethods {
    private ImageButton[] menuButtons;
    private Image title;

    public Menu(Game game) {
        super(game);

        initClasses();
        initButtons();
    }

    public void initClasses() {
        title = new Image(SOURCE.TITLE, WINDOW.SCALE_X_CENTER, 24, PIXELS.TITLE, 6, true);
    }

    public void initButtons() {
        String[] tags = { "PLAY", "INFO", "QUIT" };
        String[] source = { SOURCE.PLAY_BUTTON, SOURCE.INFO_BUTTON, SOURCE.QUIT_BUTTON };
        int[][] pixels = { PIXELS.PLAY_BUTTON, PIXELS.INFO_BUTTON, PIXELS.QUIT_BUTTON };

        menuButtons = new ImageButton[3];

        for (int i = 0; i < tags.length; i++) {
            int y = 280 + (pixels[i][1] * 3 * i);
            y = y + (40 * i);

            menuButtons[i] = new ImageButton(source[i], WINDOW.SCALE_X_CENTER, y, pixels[i], 3, tags[i], true);
        }
    }

    @Override
    public void update() {
        for (ImageButton button : menuButtons)
            button.update();
    }

    @Override
    public void draw(Graphics graphics) {
        title.draw(graphics);

        for (ImageButton button : menuButtons)
            button.draw(graphics);
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
        for (ImageButton button : menuButtons)
            if (isIn(event, button))
                button.setMousePressed(true);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        for (ImageButton button : menuButtons) {
            if (!isIn(event, button))
                continue;
            if (!button.isMousePressed())
                continue;

            switch (button.getTag()) {
                case "PLAY" -> GameStates.gameState = GameStates.SELECTION;
                case "INFO" -> GameStates.gameState = GameStates.INFO;
                case "QUIT" -> GameStates.gameState = GameStates.QUIT;
            }
            break;
        }
        resetButtons();
    }

    public void resetButtons() {
        for (ImageButton button : menuButtons)
            button.reset();
    }
}
