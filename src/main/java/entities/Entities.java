package entities;

public abstract class Entities {
    protected String name;
    protected int health;
    protected int rockDmg;
    protected int paperDmg;
    protected int scissorsDmg;
    protected int move;

    public Entities(String name, int rockDmg, int paperDmg, int scissorsDmg, int health) {
        this.name = name;
        this.rockDmg = rockDmg;
        this.paperDmg = paperDmg;
        this.scissorsDmg = scissorsDmg;
        this.health = health;
    }

    abstract public void receiveDamage(int damage);

    abstract public int dealDamage(int move);

    abstract public int getMove();

    abstract public void setMove(int move);

    abstract public int getHealth();

    abstract public String getName();
}
