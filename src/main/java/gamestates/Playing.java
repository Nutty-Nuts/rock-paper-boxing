package gamestates;

import java.awt.*;
import java.awt.event.*;

import entities.PlayableCharacter;
import logic.Logic;
import main.Game;

import ui.*;
import ui.Image;

import utils.Constants.*;
import utils.Loader.*;
import utils.Helpers;

public class Playing extends State implements StateMethods {
    private PlayableCharacter player1, player2;
    private MoveOverlay overlay1, overlay2;
    private Rectangle playerRect1, playerRect2, healthP1, healthP2;
    private ImageButton[] moveButtons;
    private ImageButton goButton;
    private Logic logic;
    private WinOverlay winOverlay;

    private Image playerImage1, playerImage2;
    private String[] characterSources, characterNames;
    private int[][] characterPixels;

    private boolean hasP1Moved, hasP2Moved, choosing, choosingP1, choosingP2, winP1, winP2;

    public Playing(Game game) {
        super(game);

        this.hasP1Moved = false;
        this.hasP2Moved = false;
        this.choosing = false;
        this.choosingP1 = false;
        this.choosingP2 = false;
        this.winP1 = false;
        this.winP2 = false;

        this.characterSources = new String[] { SOURCE.CATHYLUS, SOURCE.LOREI, SOURCE.GERARDE, SOURCE.DEB };
        this.characterPixels = new int[][] { PIXELS.CATHYLUS, PIXELS.LOREI, PIXELS.GERARDE, PIXELS.DEB };
    }

    public void initPlayers(int p1, int p2) {
        player1 = new PlayableCharacter(CHARACTER.CHARACTER_NAME[p1], CHARACTER.CHARACTERS[p1][0],
                CHARACTER.CHARACTERS[p1][1], CHARACTER.CHARACTERS[p1][2], CHARACTER.CHARACTERS[p1][3]);

        player2 = new PlayableCharacter(CHARACTER.CHARACTER_NAME[p2], CHARACTER.CHARACTERS[p2][0],
                CHARACTER.CHARACTERS[p2][1], CHARACTER.CHARACTERS[p2][2], CHARACTER.CHARACTERS[p2][3]);

        playerImage1 = new Image(characterSources[p1], 208, 372, characterPixels[p2], 0.1f, true, true);
        playerImage2 = new Image(characterSources[p2], 1044, 372, characterPixels[p2], 0.1f, true, true);

        initClasses();

        System.out.println(player2.getHealth());
        System.out.println(CHARACTER.CHARACTERS[p2][3]);
    }

    public void initClasses() {
        // WINDOW.SCALE), 164, 236);
        playerRect1 = new Rectangle(128, 160, 164, 236);
        playerRect2 = new Rectangle(965, 160, 164, 236);

        healthP1 = new Rectangle(120, 380, 164, 236);
        healthP2 = new Rectangle(960, 380, 164, 236);

        overlay1 = new MoveOverlay(this, player1);
        overlay2 = new MoveOverlay(this, player2);

        moveButtons = new ImageButton[2];

        moveButtons[0] = new ImageButton(SOURCE.MOVE_BUTTON, 64 * 3 + 10, 540, PIXELS.GO_BUTTON, 2, "MOVEP1", true);
        moveButtons[1] = new ImageButton(SOURCE.MOVE_BUTTON, WINDOW.SCALE_WIDTH - 64 * 4 + 20, 540, PIXELS.GO_BUTTON, 2,
                "MOVEP2", true);

        logic = new Logic(player1, player2, this);

        goButton = new ImageButton(SOURCE.GO_BUTTON, WINDOW.SCALE_X_CENTER, WINDOW.SCALE_HEIGHT - 128,
                PIXELS.GO_BUTTON, 3, "START", true);

        winOverlay = new WinOverlay(this);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        winOverlay.update();
        goButton.update();

        for (ImageButton button : moveButtons) {
            button.update();
        }

        if (choosing) {
            if (choosingP1) {
                overlay1.update();
            }
            if (choosingP2) {
                overlay2.update();
            }
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        playerImage1.draw(graphics);
        playerImage2.draw(graphics);
        Helpers.drawCenteredString(graphics, player1.getName(), playerRect1, FONTS.BIG,
                0);
        Helpers.drawCenteredString(graphics, player2.getName(), playerRect2, FONTS.BIG,
                0);
        Helpers.drawCenteredString(graphics, "HP " + Integer.toString(player1.getHealth()),
                healthP1,
                FONTS.NORMAL,
                0);
        Helpers.drawCenteredString(graphics, "HP " + Integer.toString(player2.getHealth()), healthP2,
                FONTS.NORMAL,
                0);

        for (ImageButton buttons : moveButtons) {
            buttons.draw(graphics);
        }

        goButton.draw(graphics);

        if (choosing) {
            if (choosingP1) {
                overlay1.draw(graphics);
            }
            if (choosingP2) {
                overlay2.draw(graphics);
            }
        }

        if (winP1 || winP2) {
            winOverlay.draw(graphics);
        }
    }

    public void resetChoosing() {
        choosing = false;
        choosingP1 = false;
        choosingP2 = false;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (winP1 || winP2) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_ESCAPE -> {
                    System.out.println("key pressed");
                    resetAll();
                    GameStates.gameState = GameStates.MENU;
                }
            }
        }
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
        if (isIn(event, goButton))
            if (hasP1Moved && hasP2Moved) {
                goButton.setMousePressed(true);
            }
        for (ImageButton button : moveButtons)
            if (isIn(event, button)) {
                button.setMousePressed(true);
                System.out.println("move button pressed");
            }

        if (choosing) {
            if (choosingP1) {
                overlay1.mousePressed(event);
            }
            if (choosingP2) {
                overlay2.mousePressed(event);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if ((isIn(event, goButton))) {
            if ((goButton.isMousePressed())) {
                logic.evaluate();
                resetRound();
            }
        }
        for (ImageButton button : moveButtons) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            System.out.println("move button released");
            switch (button.getTag()) {
                case "MOVEP1" -> {
                    choosing = true;
                    choosingP1 = true;
                    hasP1Moved = true;
                }
                case "MOVEP2" -> {
                    choosing = true;
                    choosingP2 = true;
                    hasP2Moved = true;
                }
            }
            break;
        }
        resetButtons();

        if (choosing) {
            if (choosingP1) {
                overlay1.mouseReleased(event);
            }
            if (choosingP2) {
                overlay2.mouseReleased(event);
            }
        }
    }

    private void resetButtons() {
        for (ImageButton button : moveButtons) {
            button.reset();
        }
        goButton.reset();
    }

    private void resetRound() {
        resetChoosing();
        hasP1Moved = false;
        hasP2Moved = false;
    }

    private void resetAll() {
        resetRound();
        winP1 = false;
        winP2 = false;
    }

    public void setWinP1(boolean winP1) {
        this.winP1 = winP1;
    }

    public void setWinP2(boolean winP2) {
        this.winP2 = winP2;
    }

    public boolean isWinP1() {
        return winP1;
    }

    public boolean isWinP2() {
        return winP2;
    }

}
