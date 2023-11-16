package entities;

public class PlayableCharacter extends Entities {

    public PlayableCharacter(String name, int rockDmg, int paperDmg, int scissorsDmg, int health) {
        super(name, rockDmg, paperDmg, scissorsDmg, health);
    }

    @Override
    public int dealDamage(int move) {
        switch (move) {
            case 0 -> {
                return rockDmg;
            }
            case 1 -> {
                return paperDmg;
            }
            case 2 -> {
                return scissorsDmg;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public void receiveDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    @Override
    public int getMove() {
        return move;
    }

    @Override
    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }
}
