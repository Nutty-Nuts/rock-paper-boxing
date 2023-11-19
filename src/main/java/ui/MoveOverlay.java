package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

import ui.ImageButton;
import entities.PlayableCharacter;
import gamestates.Playing;
import utils.Constants.WINDOW;
import utils.Loader.PIXELS;
import utils.Loader.SOURCE;

/**
 * MoveOverlay
 */
public class MoveOverlay {
    private PlayableCharacter player;
    private Playing playing;
    private ImageButton[] moveOverlayButtons;

    public MoveOverlay(Playing playing, PlayableCharacter player) {
        this.playing = playing;
        this.player = player;

        initButtons();
    }

    public void initButtons() {
        this.moveOverlayButtons = new ImageButton[3];
        String[] sources = { SOURCE.ROCK, SOURCE.PAPER, SOURCE.SCISSORS };
        String[] tags = { "ROCK", "PAPER", "SCISSORS" };
        int[][] pixels = { PIXELS.ROCK, PIXELS.PAPER, PIXELS.SCISSORS };

        for (int i = 0; i < moveOverlayButtons.length; i++) {
            int x = 450 + (196 * i);
            moveOverlayButtons[i] = new ImageButton(sources[i], x, WINDOW.SCALE_Y_CENTER, pixels[i], 4, tags[i], true,
                    true);
        }
    }

    public void update() {
        for (ImageButton button : moveOverlayButtons) {
            button.update();
        }
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRect(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
        for (ImageButton button : moveOverlayButtons) {
            button.draw(graphics);
        }
    }

    public void mousePressed(MouseEvent event) {
        for (ImageButton button : moveOverlayButtons) {
            if (isIn(event, button)) {
                button.setMousePressed(true);
            }
        }
    }

    public void mouseReleased(MouseEvent event) {
        for (ImageButton button : moveOverlayButtons) {
            if (!(isIn(event, button))) {
                continue;
            }
            if (!(button.isMousePressed())) {
                continue;
            }
            switch (button.getTag()) {
                case "ROCK" -> player.setMove(0);
                case "PAPER" -> player.setMove(1);
                case "SCISSORS" -> player.setMove(2);
            }
            resetButtons();
            playing.resetChoosing();
        }
    }

    public boolean isIn(MouseEvent e, Button button) {
        return button.getBoundary().contains(e.getX(), e.getY());
    }

    public void resetButtons() {
        for (ImageButton button : moveOverlayButtons) {
            button.reset();
        }
    }
}