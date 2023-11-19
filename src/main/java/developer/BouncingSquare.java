package developer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;
import java.io.InputStream;

import utils.Loader;
import utils.Constants.WINDOW;

public class BouncingSquare {
    private int x, y, xSpeed, ySpeed;
    private BufferedImage image;

    public BouncingSquare(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = (int) (xSpeed * WINDOW.SCALE);
        this.ySpeed = (int) (ySpeed * WINDOW.SCALE);

        image = Loader.GetSpriteAtlas(Loader.SOURCE.DAVE);
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
        // graphics.fillRect(x, y, (int) (32 * WINDOW.SCALE), (int) (32 *
        // WINDOW.SCALE));
        graphics.drawImage(image, x, y, 168, 177, null);
    }
}
