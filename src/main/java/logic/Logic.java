package logic;

import entities.PlayableCharacter;
import gamestates.Playing;

public class Logic {
    private PlayableCharacter p1, p2;
    private Playing playing;

    public Logic(PlayableCharacter p1, PlayableCharacter p2, Playing playing) {
        this.p1 = p1;
        this.p2 = p2;
        this.playing = playing;
    }

    public void evaluate() {
        int moveP1 = p1.getMove();
        int moveP2 = p2.getMove();

        if (moveP1 == moveP2) {
            // no damage
        } else if (moveP1 == 0 && moveP2 == 2 ||
                moveP1 == 1 && moveP2 == 0 ||
                moveP1 == 2 && moveP2 == 1) {
            // p1 wins rounds
            p2.receiveDamage(p1.dealDamage(moveP1));
        } else {
            // p2 wins rounds
            p1.receiveDamage(p2.dealDamage(moveP2));
        }

        if (p1.getHealth() == 0) {
            playing.setWinP2(true);
            playing.setWinP1(false);
        }
        if (p2.getHealth() == 0) {
            playing.setWinP1(true);
            playing.setWinP2(false);
        }
    }
}
