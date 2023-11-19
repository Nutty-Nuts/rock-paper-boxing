package ui;

import java.awt.*;

public abstract class Button {
    protected int x, y, width, height;
    protected boolean mouseOver, mousePressed;
    protected String title, tag;
    protected Rectangle boundary;

    public Button(int x, int y, int width, int height, String tag) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tag = tag;

        this.boundary = new Rectangle(x, y, width, height);
    }

    public Button(int x, int y, int width, int height, String tag, boolean centered) {
        if (centered) {
            x = x - width / 2;
        }

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tag = tag;

        this.boundary = new Rectangle(x, y, width, height);
    }

    public Button(int x, int y, int width, int height, String tag, boolean xCentered, boolean yCentered) {
        if (xCentered) {
            x = x - width / 2;
        }
        if (yCentered) {
            y = y - height / 2;
        }

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tag = tag;

        this.boundary = new Rectangle(x, y, width, height);
    }

    abstract public void update();

    abstract public void draw(Graphics graphics);

    public String getTag() {
        return tag;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void reset() {
        mouseOver = false;
        mousePressed = false;
    }
}
