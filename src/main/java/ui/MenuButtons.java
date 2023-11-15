package ui;

import java.awt.*;
import java.awt.Rectangle;

import gamestates.GameStates;
import utils.Helpers;

public class MenuButtons extends Button {
    private GameStates state;
    private String title;

    public MenuButtons(int x, int y, String title, String tag, GameStates state) {
        this.state = state;
        this.title = title;

        super.x = x;
        super.y = y;
        super.tag = tag;
        super.width = 196;
        super.height = 64;

        initBoundary();
    }

    private void initBoundary() {
        x = x - (width / 2);
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

    public void applyState() {
        GameStates.gameState = state;
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
    public void reset() {
        mouseOver = false;
        mousePressed = false;
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
