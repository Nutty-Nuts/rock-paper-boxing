package gamestates;

import java.awt.*;
import java.awt.event.*;

import main.Game;
import ui.*;
import ui.Image;
import utils.Helpers;
import utils.Constants.*;
import utils.Loader.*;

public class Selection extends State implements StateMethods {
    private ImageButton[] selectButtons;
    private ImageButton startButton;
    private Rectangle characterName1, characterName2, characterStats1, characterStats2;

    private String[] characterSources;

    private int[][] characterPixels;
    private int[][] characters;
    private boolean choiceChanged1, choiceChanged2;

    private Image charImage1, charImage2, choose;

    private Playing playing;

    private int choice1, choice2;

    public Selection(Game game, Playing playing) {
        super(game);

        this.choice1 = 0;
        this.choice2 = 0;

        this.choiceChanged1 = false;
        this.choiceChanged2 = false;

        this.playing = playing;

        this.characterSources = new String[] { SOURCE.CATHYLUS, SOURCE.LOREI, SOURCE.GERARDE, SOURCE.DEB };
        this.characterPixels = new int[][] { PIXELS.CATHYLUS, PIXELS.LOREI, PIXELS.GERARDE, PIXELS.DEB };
        this.characters = new int[][] { CHARACTER.CATHYLUS, CHARACTER.LOREI, CHARACTER.GERARDE, CHARACTER.DEB };

        initButtons();
        initClasses();
    }

    public void initButtons() {
        this.selectButtons = new ImageButton[4];

        selectButtons[0] = new ImageButton(SOURCE.LEFT_ARROW_BUTTON, 64, 356, PIXELS.LEFT_ARROW_BUTTON, 3, "P1.PREV");
        selectButtons[1] = new ImageButton(SOURCE.RIGHT_ARROW_BUTTON, 64 * 5, 356, PIXELS.LEFT_ARROW_BUTTON, 3,
                "P1.NEXT");
        selectButtons[2] = new ImageButton(SOURCE.LEFT_ARROW_BUTTON, WINDOW.SCALE_WIDTH - (64 * 6), 356,
                PIXELS.LEFT_ARROW_BUTTON, 3, "P2.PREV");
        selectButtons[3] = new ImageButton(SOURCE.RIGHT_ARROW_BUTTON, WINDOW.SCALE_WIDTH - (64 * 2), 356,
                PIXELS.LEFT_ARROW_BUTTON, 3, "P2.NEXT");

        startButton = new ImageButton(SOURCE.START_BUTTON, WINDOW.SCALE_X_CENTER, WINDOW.SCALE_HEIGHT - 128,
                PIXELS.START_BUTTON, 3, "START", true);
    }

    public void initClasses() {
        charImage1 = new Image(characterSources[choice1], 208, 372, characterPixels[choice1], 0.1f, true, true);
        charImage2 = new Image(characterSources[choice2], 1044, 372, characterPixels[choice2], 0.1f, true, true);

        characterName1 = new Rectangle(128, 160, 164, 236);
        characterName2 = new Rectangle(960, 160, 164, 236);

        characterStats1 = new Rectangle(128, 380, 164, 236);
        characterStats2 = new Rectangle(960, 380, 164, 236);

        choose = new Image(SOURCE.CHOOSE, WINDOW.SCALE_X_CENTER, 12, PIXELS.TITLE, 6, true);
    }

    @Override
    public void update() {
        for (ImageButton button : selectButtons) {
            button.update();
        }
        startButton.update();

        if (choiceChanged1) {
            charImage1.setImage(characterSources[choice1], characterPixels[choice1]);
            choiceChanged1 = false;
        }

        if (choiceChanged2) {
            charImage2.setImage(characterSources[choice2], characterPixels[choice2]);
            choiceChanged2 = false;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (ImageButton button : selectButtons) {
            button.draw(graphics);
        }
        startButton.draw(graphics);

        charImage1.draw(graphics);
        charImage2.draw(graphics);
        choose.draw(graphics);

        graphics.setColor(Color.black);

        Helpers.drawCenteredString(graphics, CHARACTER.CHARACTER_NAME[choice1], characterName1, FONTS.BIG, 0);
        Helpers.drawCenteredString(graphics, CHARACTER.CHARACTER_NAME[choice2], characterName2, FONTS.BIG, 0);

        String stats1 = "R " + Integer.toString(characters[choice1][0]) + "    P "
                + Integer.toString(characters[choice1][1])
                + "    S " + Integer.toString(characters[choice1][2]) + "    HP "
                + Integer.toString(characters[choice1][3]);
        String stats2 = "R " + Integer.toString(characters[choice2][0]) + "    P "
                + Integer.toString(characters[choice2][1])
                + "    S " + Integer.toString(characters[choice2][2]) + "    HP "
                + Integer.toString(characters[choice2][3]);
        Helpers.drawCenteredString(graphics, stats1, characterStats1, FONTS.NORMAL, 0);
        Helpers.drawCenteredString(graphics, stats2, characterStats2, FONTS.NORMAL, 0);
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
        for (ImageButton button : selectButtons) {
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
                resetButtons();
                GameStates.gameState = GameStates.PLAYING;
            }
        }
        for (ImageButton button : selectButtons) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            System.out.println("released");

            switch (button.getTag()) {
                case "P1.PREV" -> {
                    choice1--;
                    choiceChanged1 = true;
                }
                case "P1.NEXT" -> {
                    choice1++;
                    choiceChanged1 = true;
                }
                case "P2.PREV" -> {
                    choice2--;
                    choiceChanged2 = true;
                }
                case "P2.NEXT" -> {
                    choice2++;
                    choiceChanged2 = true;
                }
            }
            choice1 = wrapChoice(choice1, 0, CHARACTER.CHARACTERS.length - 1);
            choice2 = wrapChoice(choice2, 0, CHARACTER.CHARACTERS.length - 1);

            break;
        }
        resetButtons();
    }

    public void resetButtons() {
        for (ImageButton button : selectButtons) {
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
