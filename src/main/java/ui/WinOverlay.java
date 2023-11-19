package ui;

import java.awt.*;

import gamestates.Playing;
import utils.Constants.WINDOW;
import utils.Loader.PIXELS;
import utils.Loader.SOURCE;
import utils.Helpers;

public class WinOverlay {
    private Playing playing;
    private String winner;
    private Rectangle boundary;

    private Image p1Wins, p2Wins;

    public WinOverlay(Playing playing) {
        this.playing = playing;
        this.boundary = new Rectangle(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);

        this.p1Wins = new Image(SOURCE.P1_WINS, WINDOW.SCALE_X_CENTER, WINDOW.SCALE_Y_CENTER, PIXELS.P1_WINS, 7.5f,
                true,
                true);
        this.p2Wins = new Image(SOURCE.P2_WINS, WINDOW.SCALE_X_CENTER, WINDOW.SCALE_Y_CENTER, PIXELS.P2_WINS, 7.5f,
                true,
                true);
    }

    public void update() {
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRect(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
        if (playing.isWinP1()) {
            p1Wins.draw(graphics);
        }
        if (playing.isWinP2()) {
            p2Wins.draw(graphics);
        }
    }
}
