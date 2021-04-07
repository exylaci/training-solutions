package gyaxi.kovacseni.rabbitsandeggs;

public class Rabbit {
    public static final String SEPARATOR = ";";

    private final String name;
    private final int Eggs;

    private Rabbit(String name, int eggs) {
        this.name = name;
        Eggs = eggs;
    }

    public static Rabbit of(String all){
        String[] parts = all.split(SEPARATOR);
        if(parts.length!=2 || !parts[1].matches("[0-9]{1,10}")){
            throw new IllegalStateException("Invalid line in the datafile!");
        }
        return new Rabbit(parts[0],Integer.parseInt(parts[1]));
    }

    public String getName() {
        return name;
    }

    public int getEggs() {
        return Eggs;
    }
}