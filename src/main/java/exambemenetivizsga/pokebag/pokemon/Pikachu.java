package exambemenetivizsga.pokebag.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu() {
        this("Pikachu");
    }

    public Pikachu(String name) {
        super(10, name);
    }

    @Override
    public String speak() {
        return "Pika-pika";
    }
}