package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

import entities.PlayableCharacter;
import gamestates.Playing;
import utils.Constants.WINDOW;

/**
 * MoveOverlay
 */
public class MoveOverlay {
    private PlayableCharacter player;
    private Playing playing;
    private MoveOverlayButtons[] moveOverlayButtons;

    public MoveOverlay(Playing playing, PlayableCharacter player) {
        this.playing = playing;
        this.player = player;

        initButtons();
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRect(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
        for (MoveOverlayButtons button : moveOverlayButtons) {
            button.draw(graphics);
        }
    }

    public void initButtons() {
        this.moveOverlayButtons = new MoveOverlayButtons[3];

        this.moveOverlayButtons[0] = new MoveOverlayButtons(448, WINDOW.SCALE_HEIGHT / 2, "ROCK", "ROCK", 0);
        this.moveOverlayButtons[1] = new MoveOverlayButtons(576, WINDOW.SCALE_HEIGHT / 2, "PAPER", "PAPER", 1);
        this.moveOverlayButtons[2] = new MoveOverlayButtons(704, WINDOW.SCALE_HEIGHT / 2, "SCISSORS", "SCISSORS", 2);
    }

    public void mousePressed(MouseEvent event) {
        for (MoveOverlayButtons button : moveOverlayButtons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
            }
        }
    }

    public void mouseReleased(MouseEvent event) {
        for (MoveOverlayButtons button : moveOverlayButtons) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            player.setMove(button.getMove());
            playing.resetChoosing();
            System.out.println(player.getName() + " " + player.getMove());
        }
    }

    public boolean isIn(MouseEvent e, ButtonAbstract button) {
        return button.getBoundary().contains(e.getX(), e.getY());
    }
}