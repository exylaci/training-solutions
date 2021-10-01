package exambemenetivizsga.pokebag.pokemon;

public class Pokemon {
    private int health = 10;
    private int strength;
    private String name;

    protected Pokemon(int strength, String name) {
        this.strength = strength;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void decreaseHealth() {
        --health;
    }

    public String speak() {
        return null;
    }
}