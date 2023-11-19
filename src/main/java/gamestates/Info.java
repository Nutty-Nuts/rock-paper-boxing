package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import ui.Image;
import utils.Helpers;
import utils.Constants.*;
import utils.Loader.*;

public class Info extends State implements StateMethods {
    private String[] stats, characterSources;
    private Rectangle[] statsRect, nameRect;
    private Image[] characterImages;
    private int[][] characters, characterPixels;

    public Info(Game game) {
        super(game);

        this.characters = new int[][] { CHARACTER.CATHYLUS, CHARACTER.LOREI, CHARACTER.GERARDE, CHARACTER.DEB };
        this.characterSources = new String[] { SOURCE.CATHYLUS, SOURCE.LOREI, SOURCE.GERARDE, SOURCE.DEB };
        this.characterPixels = new int[][] { PIXELS.CATHYLUS, PIXELS.LOREI, PIXELS.GERARDE, PIXELS.DEB };

        initClasses();
    }

    private void initClasses() {
        stats = new String[4];
        characterImages = new Image[4];
        statsRect = new Rectangle[4];
        nameRect = new Rectangle[4];

        for (int i = 0; i < stats.length; i++) {
            stats[i] = "R " + Integer.toString(characters[i][0]) + "    P "
                    + Integer.toString(characters[i][1])
                    + "    S " + Integer.toString(characters[i][2]) + "    HP "
                    + Integer.toString(characters[i][3]);
        }

        for (int i = 0; i < characterImages.length; i++) {
            int x = 150 + (256 * i);
            int y = 100;

            characterImages[i] = new Image(characterSources[i], x, y, characterPixels[i], 0.1f, true, true);
        }

        for (int i = 0; i < statsRect.length; i++) {
            int x = 60 + (258 * i);
            int y = 150;

            statsRect[i] = new Rectangle(x, y, 164, 236);
        }

        for (int i = 0; i < nameRect.length; i++) {
            int x = 60 + (258 * i);
            int y = 100;

            nameRect[i] = new Rectangle(x, y, 164, 236);
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(Graphics graphics) {
        // TODO Auto-generated method stub
        for (Image image : characterImages) {
            image.draw(graphics);
        }

        for (int i = 0; i < statsRect.length; i++) {
            graphics.setColor(Color.BLACK);
            Helpers.drawCenteredString(graphics, stats[i], statsRect[i], FONTS.NORMAL, 0);
        }

        for (int i = 0; i < nameRect.length; i++) {
            graphics.setColor(Color.BLACK);
            Helpers.drawCenteredString(graphics, CHARACTER.CHARACTER_NAME[i], nameRect[i], FONTS.BIG, 0);
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_ESCAPE -> GameStates.gameState = GameStates.MENU;
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub

    }
}
