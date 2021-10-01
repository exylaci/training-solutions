package exambemenetivizsga.pokebag.pokemon;

public class Charmander extends Pokemon {
    public Charmander() {
        this("Charmander");
    }

    public Charmander(String name) {
        super(8, name);
    }

    @Override
    public String speak() {
        return "Char-char";
    }
}