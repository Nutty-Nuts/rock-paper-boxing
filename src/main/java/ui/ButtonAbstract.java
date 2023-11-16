package ui;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class ButtonAbstract {
    protected int x, y, width, height;
    protected boolean mouseOver, mousePressed;
    protected String tag;
    protected Rectangle boundary;

    public ButtonAbstract(int x, int y, int width, int height, String tag) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tag = tag;
    }

    abstract public void update();

    abstract public void draw(Graphics graphics);

    abstract public String getTag();

    abstract public Rectangle getBoundary();

    abstract public boolean isMouseOver();

    abstract public boolean isMousePressed();

    abstract public void setMouseOver(boolean value);

    abstract public void setMousePressed(boolean value);

    abstract public void reset();
}
