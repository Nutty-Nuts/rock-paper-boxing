package utils;

import java.awt.*;

public class Helpers {
    public static void drawCenteredString(Graphics graphics, String text, Rectangle rect, Font font, int yOffset) {
        FontMetrics metrics = graphics.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent() + yOffset;

        graphics.setFont(font);
        graphics.drawString(text, x, y);
    }
}
