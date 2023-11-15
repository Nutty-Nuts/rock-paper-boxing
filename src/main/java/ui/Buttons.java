package ui;

import java.awt.*;

import gamestates.GameStates;
import utils.Helpers;

public class Buttons {
    private int x, y;

    private boolean mouseOver, mousePressed;

    private GameStates state;
    private Rectangle bounds;

    public Buttons(int x, int y, GameStates state) {
        this.x = x;
        this.y = y;
        this.state = state;

        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rectangle(x, y, 196, 64);
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(x, y, 196, 64);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, "PRESS ME", bounds, new Font("Sanserif", Font.BOLD, 32), 0);
    }

    public void applyState() {
        GameStates.gameState = state;
    }

    public void reset() {
        mouseOver = false;
        mousePressed = false;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
}
