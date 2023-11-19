package utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Loader {

    public static class SOURCE {
        public static final String DAVE = "dave.jpg";
        public static final String TITLE = "title.png";
        public static final String PLAY_BUTTON = "playbutton.png";
        public static final String INFO_BUTTON = "infobutton.png";
        public static final String QUIT_BUTTON = "quitbutton.png";
        public static final String LEFT_ARROW_BUTTON = "leftarrowbutton.png";
        public static final String RIGHT_ARROW_BUTTON = "rightarrowbutton.png";
        public static final String START_BUTTON = "startbutton.png";
        public static final String GO_BUTTON = "gobutton.png";
        public static final String MOVE_BUTTON = "movebutton.png";
        public static final String CATHYLUS = "cathylus.png";
        public static final String LOREI = "lorei.png";
        public static final String DEB = "deb.png";
        public static final String GERARDE = "gerarde.png";
        public static final String CHOOSE = "choose.png";
        public static final String P1_WINS = "p1wins.png";
        public static final String P2_WINS = "p2wins.png";
        public static final String ROCK = "rock.png";
        public static final String PAPER = "paper.png";
        public static final String SCISSORS = "scissors.png";
    }

    public static class PIXELS {
        public static final int[] TITLE = { 89, 32 };
        public static final int[] PLAY_BUTTON = { 70, 30 };
        public static final int[] INFO_BUTTON = { 70, 30 };
        public static final int[] QUIT_BUTTON = { 70, 30 };
        public static final int[] LEFT_ARROW_BUTTON = { 13, 32 };
        public static final int[] RIGHT_ARROW_BUTTON = { 13, 32 };
        public static final int[] START_BUTTON = { 70, 30 };
        public static final int[] GO_BUTTON = { 70, 30 };
        public static final int[] MOVE_BUTTON = { 70, 30 };
        public static final int[] CATHYLUS = { 1640, 2360 };
        public static final int[] LOREI = { 1640, 2360 };
        public static final int[] DEB = { 1640, 2360 };
        public static final int[] GERARDE = { 1640, 2360 };
        public static final int[] CHOOSE = { 90, 32 };
        public static final int[] P1_WINS = { 90, 32 };
        public static final int[] P2_WINS = { 90, 32 };
        public static final int[] ROCK = { 32, 32 };
        public static final int[] PAPER = { 32, 32 };
        public static final int[] SCISSORS = { 32, 32 };
    }

    public static BufferedImage GetSpriteAtlas(String filename) {
        BufferedImage image = null;
        InputStream inputStream = Loader.class.getResourceAsStream("/" + filename);

        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return image;
    }
}
