package ui;

import java.awt.*;
import utils.Loader;

import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage image;
    private int x, y, width, height;
    private boolean xCentered, yCentered;
    private float scale;

    public Image(String image, int x, int y, float scale, int[] pixels) {
        this.image = Loader.GetSpriteAtlas(image);
        this.x = x;
        this.y = y;

        this.width = (int) (pixels[0] * scale);
        this.height = (int) (pixels[1] * scale);

        this.xCentered = false;
        this.yCentered = false;

        this.scale = scale;
    }

    public Image(String image, int x, int y, int[] pixels, float scale, boolean centered) {
        this.width = (int) (pixels[0] * scale);
        this.height = (int) (pixels[1] * scale);

        if (centered) {
            x = x - width / 2;
        }

        this.image = Loader.GetSpriteAtlas(image);
        this.x = x;
        this.y = y;

        this.xCentered = centered;
        this.yCentered = false;

        this.scale = scale;
    }

    public Image(String image, int x, int y, int[] pixels, float scale, boolean xCentered, boolean yCentered) {
        this.width = (int) (pixels[0] * scale);
        this.height = (int) (pixels[1] * scale);

        if (xCentered) {
            x = x - width / 2;
        }

        if (yCentered) {
            y = y - height / 2;
        }

        this.image = Loader.GetSpriteAtlas(image);
        this.x = x;
        this.y = y;

        this.xCentered = xCentered;
        this.yCentered = yCentered;

        this.scale = scale;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, width, height, null);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(String image, int[] pixels) {
        this.image = Loader.GetSpriteAtlas(image);
        System.out.println(image + " " + this.image.getSource());

        this.width = (int) (pixels[0] * scale);
        this.height = (int) (pixels[1] * scale);

        System.out.println(pixels[0] + " " + pixels[1] + " " + width + " " + height);
    }
}
