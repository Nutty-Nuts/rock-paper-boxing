package ui;

import java.awt.*;
import java.awt.Rectangle;

import utils.Helpers;
import utils.Constants.WINDOW;

public class MoveOverlayButtons extends ButtonAbstract {
    private int move;
    private String title;
    private Rectangle boundary;

    public MoveOverlayButtons(int x, int y, String title, String tag, int move) {
        super(x, (y - 64 / 2), 64, 64, tag);
        this.title = title;
        this.move = move;
        this.boundary = new Rectangle(x, y - 64 / 2, 64, 64);
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

    public int getMove() {
        return move;
    }

    @Override
    public Rectangle getBoundary() {
        return boundary;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public boolean isMouseOver() {
        return mouseOver;
    }

    @Override
    public boolean isMousePressed() {
        return mousePressed;
    }

    @Override
    public void setMouseOver(boolean value) {
        mouseOver = value;
    }

    @Override
    public void setMousePressed(boolean value) {
        mousePressed = value;
    }

    @Override
    public void reset() {
        mouseOver = false;
        mousePressed = false;
    }
}
