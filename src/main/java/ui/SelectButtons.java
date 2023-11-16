package ui;

import java.awt.*;

import utils.Helpers;

/**
 * SelectButtons
 */
public class SelectButtons extends ButtonAbstract {
    private String title;

    public SelectButtons(int x, int y, String title, String tag) {
        super(x, y, 64, 32, tag);
        this.title = title;

        initBoundary();
    }

    private void initBoundary() {
        boundary = new Rectangle(x, y, width, height);
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, title, boundary, new Font("Sanserif", Font.BOLD, 16), 0);
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean value) {
        mouseOver = value;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean value) {
        mousePressed = value;
    }

    public void reset() {
        mouseOver = false;
        mousePressed = false;
    }
}