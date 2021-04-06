package erettsegik.majus2019.cegesautok;

public enum Direction {
    IN("1","be"), OUT("0","ki");

    String value;
    String direction;

    Direction(String value,String direction) {
        this.value = value;
        this.direction=direction;
    }

    public static Direction of(String value){
        for (Direction direction : Direction.values()){
            if (direction.value.equals(value)){
                return direction;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen irány!");
    }

    public String getDirection() {
        return direction;
    }
}
