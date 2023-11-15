package developer;

import java.awt.Graphics;

import utils.Constants.WINDOW;

public class BouncingSquare {
    private int x, y, xSpeed, ySpeed;

    public BouncingSquare(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = (int) (xSpeed * WINDOW.SCALE);
        this.ySpeed = (int) (ySpeed * WINDOW.SCALE);
    }

    public void update() {
        if (x < 0 || x > WINDOW.SCALE_WIDTH - (int) (32 * WINDOW.SCALE)) {
            xSpeed *= -1;
        }
        if (y < 0 || y > WINDOW.SCALE_HEIGHT - (int) (32 * WINDOW.SCALE)) {
            ySpeed *= -1;
        }
        x += xSpeed;
        y += ySpeed;
    }

    public void render(Graphics graphics) {
        graphics.fillRect(x, y, (int) (32 * WINDOW.SCALE), (int) (32 * WINDOW.SCALE));
    }
}
