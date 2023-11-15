package developer;

import java.awt.*;
import utils.Helpers;

public class FrameRateCounter {
    private int fps;
    private int ups;
    private Rectangle bounds;

    public FrameRateCounter() {
        this.fps = 0;
        this.ups = 0;
        this.bounds = new Rectangle(0, 0, 96, 12);
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.fillRect(0, 0, 96, 12);
        graphics.setColor(Color.white);
        String counter = "FPS " + Integer.toString(fps) + " " + "UPS " + Integer.toString(ups);
        Helpers.drawCenteredString(graphics, counter, bounds,
                new Font("Sanserif", Font.BOLD, 10), 0);
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }
}
