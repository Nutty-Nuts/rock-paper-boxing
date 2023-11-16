package ui;

import gamestates.Playing;
import java.awt.*;
import utils.Constants.WINDOW;
import utils.Helpers;

public class WinOverlay {
    private Playing playing;
    private String winner;
    private Rectangle boundary;

    public WinOverlay(Playing playing) {
        this.playing = playing;
        this.boundary = new Rectangle(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
    }

    public void update() {
        if (playing.isWinP1()) {
            winner = "Player 1 Wins";
        }
        if (playing.isWinP2()) {
            winner = "Player 2 Wins";
        }
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRect(0, 0, WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
        graphics.setColor(Color.WHITE);
        Helpers.drawCenteredString(graphics, winner, boundary, new Font("Sanserif", Font.BOLD, 32), 0);
    }
}
