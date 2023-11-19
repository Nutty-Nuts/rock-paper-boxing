package ui;

import java.awt.Graphics;

public class ImageButton extends Button {
    private Image image;

    private boolean resetPos;

    public ImageButton(String source, int x, int y, int[] pixels, int scale, String tag) {
        super(x, y, pixels[0] * scale, pixels[1] * scale, tag);
        image = new Image(source, x, y, scale, pixels);
    }

    public ImageButton(String source, int x, int y, int[] pixels, int scale, String tag, boolean centered) {
        super(x, y, pixels[0] * scale, pixels[1] * scale, tag, centered);
        image = new Image(source, x, y, pixels, scale, centered);
    }

    public ImageButton(String source, int x, int y, int[] pixels, int scale, String tag, boolean xCentered,
            boolean yCentered) {
        super(x, y, pixels[0] * scale, pixels[1] * scale, tag, xCentered, yCentered);
        image = new Image(source, x, y, pixels, scale, xCentered, yCentered);
    }

    @Override
    public void update() {
        if (mousePressed && !resetPos) {
            image.setY(image.getY() + 10);
            resetPos = true;
        }

        if (!mousePressed && resetPos) {
            image.setY(image.getY() - 10);
            resetPos = false;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        image.draw(graphics);
    }
}
