package ui;

import java.awt.*;
import utils.Helpers;

public class TextButton extends Button {
    private String title;

    public TextButton(int x, int y, int width, int height, String title, String tag) {
        super(x, y, width, height, tag);
        this.title = title;
    }

    public TextButton(int x, int y, int width, int height, String title, String tag, boolean centered) {
        super(x, y, width, height, tag, centered);
        this.title = title;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, title, boundary, new Font("Sanserif", Font.BOLD, 16), 0);
    }
}
