package exambemenetivizsga.pokebag;

import exambemenetivizsga.pokebag.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Pokebag {
    private List<Pokemon> pokemons = new ArrayList<>();

    public void add(Pokemon pokemon) {
        if (pokemon == null) {
            throw new IllegalArgumentException();
        }
        pokemons.add(pokemon);
    }

    public int getNumberOfPokemons() {
        return pokemons.size();
    }

    public Pokemon getByIndex(int index) {
        if (index >= pokemons.size()) {
            throw new IllegalArgumentException();
        }
        return pokemons.get(index);
    }

    public Pokemon getStrongest() {
        return pokemons
                .stream()
                .max(Comparator.comparingLong(Pokemon::getStrength))
                .orElseThrow(() -> new NoSuchElementException());
    }

    public Pokemon fight(int indexA, int indexB) {
        if (indexA == indexB) {
            throw new IllegalArgumentException();
        }
        Pokemon pokemonA = pokemons.get(indexA);
        Pokemon pokemonB = pokemons.get(indexB);

        if (pokemonA.getStrength() > pokemonB.getStrength()) {
            pokemonB.decreaseHealth();
            System.out.println(pokemonA.speak());
            return pokemonA;
        }
        pokemonA.decreaseHealth();
        System.out.println(pokemonB.speak());
        return pokemonB;
    }
}