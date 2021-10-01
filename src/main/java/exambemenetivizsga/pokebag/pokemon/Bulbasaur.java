package exambemenetivizsga.pokebag.pokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        this("Bulbasaur");
    }

    public Bulbasaur(String name) {
        super(6, name);
    }

    @Override
    public String speak() {
        return "Bulba-saur";
    }
}