package week08.d02;

public class Country {
    private String name;
    private int population;
    private int colors;
    private int neighbours;


    public Country(Country country) {
        name = country.getName();
        population = country.getPopulation();
        colors = country.getColors();
        neighbours = country.getNeighbours();
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return String.format("%s population=%d colorsInFlag=%d numberOfNeighbours=%d",name,population,colors,neighbours);
    }
}
