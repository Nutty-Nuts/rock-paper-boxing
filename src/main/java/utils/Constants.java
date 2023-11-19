package utils;

public class Constants {
    public static class WINDOW {
        public static int WIDTH = 1280;
        public static int HEIGHT = 720;
        public static float SCALE = 1f;

        public static int X_CENTER = WIDTH / 2;
        public static int Y_CENTER = HEIGHT / 2;

        public static int SCALE_WIDTH = (int) (WIDTH * SCALE);
        public static int SCALE_HEIGHT = (int) (HEIGHT * SCALE);

        public static int SCALE_X_CENTER = (int) (X_CENTER * SCALE);
        public static int SCALE_Y_CENTER = (int) (Y_CENTER * SCALE);
    }

    public static class GAME {
        public static int FPS = 60;
        public static int UPS = 120;
        public static int SEC = 1000000000;

        public static float FRAMERATE = SEC / FPS;
        public static float TICKRATE = SEC / UPS;
    }

    public static class CHARACTER {
        public static int[] CATHYLUS = { 1, 1, 3, 15 };
        public static int[] LOREI = { 1, 3, 1, 15 };
        public static int[] GERARDE = { 3, 1, 1, 15 };
        public static int[] DEB = { 2, 2, 2, 12 };
        public static int[][] CHARACTERS = { CATHYLUS, LOREI, GERARDE, DEB };
        public static String[] CHARACTER_NAME = { "Cathylus", "Lorei", "Gerarde", "Deb" };
    }
}
