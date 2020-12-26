package week08.d02;

public class Country {
    private final String name;
    private final int population;
    private final int colors;
    private final int neighbours;

    public Country(String name, int population, int colors, int neighbours) {
        this.name = name;
        this.population = population;
        this.colors = colors;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getColors() {
        return colors;
    }

    public int getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return String.format("%s population=%d colorsInFlag=%d numberOfNeighbours=%d",
                name, population, colors, neighbours);
    }
}