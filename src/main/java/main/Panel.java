package main;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

import inputs.MouseHandler;
import utils.Constants.WINDOW;

public class Panel extends JPanel {
    private Game game;
    private MouseHandler mouseHandler;

    public Panel(Game game) {
        this.game = game;
        this.mouseHandler = new MouseHandler(this);

        setPanelSize(WINDOW.SCALE_WIDTH, WINDOW.SCALE_HEIGHT);
        setDoubleBuffered(true);

        addMouseListener(mouseHandler);
    }

    private void setPanelSize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
    }

    public void update() {

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        game.render(graphics);
    }

    public Game getGame() {
        return game;
    }
}
