package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import ui.SelectButtons;
import ui.StartButton;
import ui.ButtonAbstract;
import utils.Constants.WINDOW;
import utils.Constants.CHARACTER;
import utils.Helpers;

public class Selection extends State implements StateMethods {
    private SelectButtons[] selectButtons;
    private StartButton startButton;
    private String characterName1, characterName2;
    private Rectangle characterRect1, characterRect2;
    private Playing playing;

    private int choice1, choice2;

    public Selection(Game game, Playing playing) {
        super(game);

        this.choice1 = 0;
        this.choice2 = 0;
        this.playing = playing;

        initButtons();
        initClasses();
    }

    public void initButtons() {
        this.selectButtons = new SelectButtons[4];

        selectButtons[0] = new SelectButtons((int) (64 * WINDOW.SCALE), (int) (256 * WINDOW.SCALE), "PREV", "P1");
        selectButtons[1] = new SelectButtons((int) (64 * 5 * WINDOW.SCALE), (int) (256 * WINDOW.SCALE), "NEXT", "P1");

        selectButtons[2] = new SelectButtons(WINDOW.SCALE_WIDTH - (int) (64 * 6 *
                WINDOW.SCALE),
                (int) (256 * WINDOW.SCALE), "PREV", "P2");
        selectButtons[3] = new SelectButtons(WINDOW.SCALE_WIDTH - (int) (64 * 2 *
                WINDOW.SCALE),
                (int) (256 * WINDOW.SCALE), "NEXT", "P2");

        startButton = new StartButton((WINDOW.WIDTH / 2), WINDOW.HEIGHT - 128, "START", "START", GameStates.PLAYING);
    }

    public void initClasses() {
        this.characterRect1 = new Rectangle((int) (64 * 1.5 * WINDOW.SCALE), (int) (256 * WINDOW.SCALE), 256, 32);
        this.characterRect2 = new Rectangle(WINDOW.SCALE_WIDTH - (int) (64 * 5.5 * WINDOW.SCALE),
                (int) (256 * WINDOW.SCALE), 256, 32);
    }

    @Override
    public void update() {
        for (ButtonAbstract button : selectButtons) {
            button.update();
        }
        startButton.update();

        switch (choice1) {
            case 0:
                characterName1 = "Cathylus";
                break;
            case 1:
                characterName1 = "Lorei";
                break;
            case 2:
                characterName1 = "Gerarde";
                break;
            case 3:
                characterName1 = "Deb";
                break;
        }

        switch (choice2) {
            case 0:
                characterName2 = "Cathylus";
                break;
            case 1:
                characterName2 = "Lorei";
                break;
            case 2:
                characterName2 = "Gerarde";
                break;
            case 3:
                characterName2 = "Deb";
                break;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (ButtonAbstract button : selectButtons) {
            button.draw(graphics);
        }
        startButton.draw(graphics);

        graphics.setColor(Color.black);
        Helpers.drawCenteredString(graphics, characterName1, characterRect1, new Font("Sanserif", Font.BOLD, 16),
                0);
        Helpers.drawCenteredString(graphics, characterName2, characterRect2, new Font("Sanserif", Font.BOLD, 16),
                0);
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
        for (SelectButtons button : selectButtons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
                System.out.println("pressed.");
            }
        }
        if (isIn(event, startButton)) {
            startButton.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub
        if ((isIn(event, startButton))) {
            if ((startButton.isMousePressed())) {
                playing.initPlayers(choice1, choice2);
                startButton.applyState();
            }
        }
        for (SelectButtons button : selectButtons) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            System.out.println("released");

            if (button.getTag().equals("P1")) {
                switch (button.getTitle()) {
                    case "NEXT" -> choice1++;
                    case "PREV" -> choice1--;
                }
                choice1 = wrapChoice(choice1, 0, CHARACTER.CHARACTERS.length - 1);
            }
            if (button.getTag().equals("P2")) {
                switch (button.getTitle()) {
                    case "NEXT" -> choice2++;
                    case "PREV" -> choice2--;
                }
                choice2 = wrapChoice(choice2, 0, CHARACTER.CHARACTERS.length - 1);
            }
            break;
        }
        resetButtons();
    }

    public void resetButtons() {
        for (SelectButtons button : selectButtons) {
            button.reset();
        }
        startButton.reset();
    }

    private int wrapChoice(int choice, int min, int max) {
        if (choice < min) {
            choice = max;
        }
        if (choice > max) {
            choice = min;
        }
        return choice;
    }
}
