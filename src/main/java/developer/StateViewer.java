package developer;

import java.awt.*;
import java.awt.Rectangle;

import gamestates.GameStates;
import utils.Constants.WINDOW;
import utils.Helpers;

public class StateViewer {
    private String stateName;
    private Rectangle boundary;

    public StateViewer() {
        this.boundary = new Rectangle(WINDOW.SCALE_WIDTH - 96, 0, 96, 12);
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(WINDOW.SCALE_WIDTH - 96, 0, 96, 12);
        graphics.setColor(Color.white);
        Helpers.drawCenteredString(graphics, stateName, boundary,
                new Font("Sanserif", Font.BOLD, 10), 0);

    }

    public void setStateName(GameStates state) {
        switch (state) {
            case MENU -> stateName = "MENU";
            case PLAYING -> stateName = "PLAYING";
            case SELECTION -> stateName = "SELECTION";
        }
    }
}
