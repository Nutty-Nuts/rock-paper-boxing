package main;

import gamestates.GameStates;
import gamestates.Menu;
import gamestates.Playing;
import gamestates.Selection;
import java.awt.*;

import developer.BouncingSquare;
import developer.FrameRateCounter;
import developer.StateViewer;
import utils.Constants.GAME;

public class Game implements Runnable {
    private Panel panel;
    private Window window;

    private Menu menu;
    private Playing playing;
    private Selection selection;

    private BouncingSquare square;
    private FrameRateCounter counter;
    private StateViewer stateViewer;

    public Game() {
        this.panel = new Panel(this);
        this.window = new Window(panel);

        this.square = new BouncingSquare(0, 0, 4, 4);
        this.counter = new FrameRateCounter();
        this.stateViewer = new StateViewer();

        initClasses();
        start();
    }

    private void initClasses() {
        this.menu = new Menu(this);
        this.playing = new Playing(this);
        this.selection = new Selection(this, playing);
    }

    private void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void update() {
        square.update();
        counter.update();
        stateViewer.update();

        switch (GameStates.gameState) {
            case MENU:
                menu.update();
                break;
            case SELECTION:
                selection.update();
                break;
            case PLAYING:
                playing.update();
                break;
            default:
                break;
        }
    }

    public void render(Graphics graphics) {
        square.render(graphics);
        counter.draw(graphics);
        stateViewer.draw(graphics);

        switch (GameStates.gameState) {
            case MENU:
                menu.draw(graphics);
                break;
            case SELECTION:
                selection.draw(graphics);
                break;
            case PLAYING:
                playing.draw(graphics);
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        float frameDelta = 0, tickDelta = 0;
        int frames = 0, ticks = 0;

        long previous = System.nanoTime();
        long last = System.nanoTime();

        while (true) {
            long current = System.nanoTime();

            frameDelta += delta(current, previous, GAME.FRAMERATE);
            tickDelta += delta(current, previous, GAME.TICKRATE);
            previous = current;

            if (frameDelta >= 1) {
                panel.repaint();
                panel.getToolkit().sync();

                frames++;
                frameDelta--;
            }

            if (tickDelta >= 1) {
                update();
                stateViewer.setStateName(GameStates.gameState);

                ticks++;
                tickDelta--;
            }

            if (System.nanoTime() - last >= GAME.SEC) {
                counter.setFps(frames);
                counter.setUps(ticks);

                System.out.printf("FPS %s, UPS %s\n", frames, ticks);
                last = System.nanoTime();
                frames = 0;
                ticks = 0;
            }
        }
    }

    private float delta(long current, long previous, float rate) {
        return (current - previous) / rate;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Selection getSelection() {
        return selection;
    }
}
