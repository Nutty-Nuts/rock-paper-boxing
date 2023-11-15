package ui;

import java.awt.*;

import utils.Helpers;

/**
 * SelectButtons
 */
public class SelectButtons extends Button {
    private String title;

    public SelectButtons(int x, int y, String title, String tag) {
        this.title = title;

        super.x = x;
        super.y = y;
        super.tag = tag;

        super.width = 64;
        super.height = 32;

        initBoundary();
    }

    private void initBoundary() {
        boundary = new Rectangle(super.x, super.y, super.width, super.height);
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(super.x, super.y, super.width, super.height);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, title, super.boundary, new Font("Sanserif", Font.BOLD, 16), 0);
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return super.tag;
    }

    public Rectangle getBoundary() {
        return super.boundary;
    }

    public boolean isMouseOver() {
        return super.mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        super.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return super.mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        super.mousePressed = mousePressed;
    }

    public void reset() {
        super.mouseOver = false;
        super.mousePressed = false;
    }
}