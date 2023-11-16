package ui;

import java.awt.*;
import java.awt.Rectangle;
import utils.Helpers;

public class MoveButtons extends ButtonAbstract {
    private String title;

    public MoveButtons(int x, int y, String title, String tag) {
        super(x, y, 196, 64, tag);
        this.title = title;
        boundary = new Rectangle(x, y, width, height);
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

    @Override
    public Rectangle getBoundary() {
        // TODO Auto-generated method stub
        return boundary;
    }

    @Override
    public String getTag() {
        // TODO Auto-generated method stub
        return tag;
    }

    @Override
    public boolean isMouseOver() {
        // TODO Auto-generated method stub
        return mouseOver;
    }

    @Override
    public boolean isMousePressed() {
        // TODO Auto-generated method stub
        return mousePressed;
    }

    @Override
    public void reset() {
        mouseOver = false;
        mouseOver = false;
    }

    @Override
    public void setMouseOver(boolean value) {
        mouseOver = value;
    }

    @Override
    public void setMousePressed(boolean value) {
        mousePressed = value;
    }
}
