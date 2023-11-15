package ui;

import java.awt.*;
import java.awt.Rectangle;

import gamestates.GameStates;
import utils.Helpers;

public class StartButton extends Button {
    private GameStates state;
    private String title;

    public StartButton(int x, int y, String title, String tag, GameStates state) {
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
        super.x = super.x - super.width / 2;
        boundary = new Rectangle(super.x, super.y, super.width, super.height);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(super.x, super.y, super.width, super.height);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, title, super.boundary, new Font("Sanserif", Font.BOLD, 32), 0);
    }

    public void applyState() {
        GameStates.gameState = state;
    }

    @Override
    public Rectangle getBoundary() {
        return super.boundary;
    }

    @Override
    public String getTag() {
        return super.tag;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isMouseOver() {
        return super.mouseOver;
    }

    @Override
    public boolean isMousePressed() {
        return super.mousePressed;
    }

    @Override
    public void reset() {
        super.mouseOver = false;
        super.mousePressed = false;
    }

    @Override
    public void setMouseOver(boolean value) {
        super.mouseOver = value;
    }

    @Override
    public void setMousePressed(boolean value) {
        super.mousePressed = value;
    }
}
