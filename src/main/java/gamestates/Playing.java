package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.PlayableCharacter;
import logic.Logic;
import main.Game;
import ui.GoButton;
import ui.MoveButtons;
import ui.MoveOverlay;
import ui.SelectButtons;
import ui.WinOverlay;
import utils.Constants.WINDOW;
import utils.Constants.CHARACTER;
import utils.Helpers;

public class Playing extends State implements StateMethods {
    private PlayableCharacter player1, player2;
    private MoveOverlay overlay1, overlay2;
    private Rectangle playerRect1, playerRect2, healthP1, healthP2;
    private MoveButtons[] moveButtons;
    private GoButton[] goButton;
    private Logic logic;
    private WinOverlay winOverlay;

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

    }

    public void initPlayers(int p1, int p2) {
        player1 = new PlayableCharacter(CHARACTER.CHARACTER_NAME[p1], CHARACTER.CHARACTERS[p1][0],
                CHARACTER.CHARACTERS[p1][1], CHARACTER.CHARACTERS[p1][2], CHARACTER.CHARACTERS[p1][3]);

        player2 = new PlayableCharacter(CHARACTER.CHARACTER_NAME[p2], CHARACTER.CHARACTERS[p2][0],
                CHARACTER.CHARACTERS[p2][1], CHARACTER.CHARACTERS[p2][2], CHARACTER.CHARACTERS[p2][3]);

        initClasses();

        System.out.println(player2.getHealth());
        System.out.println(CHARACTER.CHARACTERS[p2][3]);
    }

    public void initClasses() {
        playerRect1 = new Rectangle((int) (64 * 1.5 * WINDOW.SCALE), (int) (256 * WINDOW.SCALE), 256, 32);
        playerRect2 = new Rectangle(WINDOW.SCALE_WIDTH - (int) (64 * 5.5 * WINDOW.SCALE),
                (int) (256 * WINDOW.SCALE), 256, 32);

        healthP1 = new Rectangle((int) (64 * 1.5 * WINDOW.SCALE), (int) (320 * WINDOW.SCALE), 256, 32);
        healthP2 = new Rectangle(WINDOW.SCALE_WIDTH - (int) (64 * 5.5 * WINDOW.SCALE),
                (int) (320 * WINDOW.SCALE), 256, 32);

        overlay1 = new MoveOverlay(this, player1);
        overlay2 = new MoveOverlay(this, player2);

        moveButtons = new MoveButtons[2];

        moveButtons[0] = new MoveButtons((int) (64 * 2 * WINDOW.SCALE), (int) (384 * WINDOW.SCALE), "MOVE", "MOVEP1");
        moveButtons[1] = new MoveButtons(WINDOW.SCALE_WIDTH - (int) (64 * 5 * WINDOW.SCALE),
                (int) (384 * WINDOW.SCALE), "MOVE", "MOVEP2");

        logic = new Logic(player2, player1, this);

        goButton = new GoButton[1];

        goButton[0] = new GoButton((WINDOW.WIDTH / 2), WINDOW.HEIGHT - 128, "GO", "GO");

        winOverlay = new WinOverlay(this);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        winOverlay.update();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        Helpers.drawCenteredString(graphics, player1.getName(), playerRect1, new Font("Sanserif", Font.BOLD, 16),
                0);
        Helpers.drawCenteredString(graphics, player2.getName(), playerRect2, new Font("Sanserif", Font.BOLD, 16),
                0);
        Helpers.drawCenteredString(graphics, Integer.toString(player1.getHealth()),
                healthP1,
                new Font("Sanserif", Font.BOLD, 16),
                0);
        Helpers.drawCenteredString(graphics, Integer.toString(player2.getHealth()), healthP2,
                new Font("Sanserif", Font.BOLD, 16),
                0);

        for (MoveButtons buttons : moveButtons) {
            buttons.draw(graphics);
        }

        goButton[0].draw(graphics);

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
        for (GoButton button : goButton) {
            if (!isIn(event, button)) {
                continue;
            }
            if (hasP1Moved && hasP2Moved) {
                button.setMousePressed(true);
                System.out.println("go button pressed");
            }
        }
        for (MoveButtons button : moveButtons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
                System.out.println("move button pressed");
            }
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

        for (GoButton button : goButton) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            System.out.println("go button released");
            logic.evaluate();
            resetRound();
            System.out.println(hasP1Moved);
        }
        for (MoveButtons button : moveButtons) {
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

    public void resetButtons() {
        for (MoveButtons button : moveButtons) {
            button.reset();
        }
        goButton[0].reset();
        System.out.println(goButton[0].isMousePressed());
    }

    public void resetRound() {
        resetChoosing();
        hasP1Moved = false;
        hasP2Moved = false;
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
