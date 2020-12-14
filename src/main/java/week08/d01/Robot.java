package week08.d01;

public class Robot {
    private Position position;

    public Robot() {
        this.position = new Position();
    }

    public Position move(String directions){
        for ( int i=0;i<directions.length();++i){
            oneStep(directions.charAt(i));
        }
        return position;
    }

    private void oneStep(char direction) {
        switch (direction){
            case 'J':position.increaseX();return;
            case 'B':position.decreaseX();return;
            case 'F':position.increaseY();return;
            case 'L':position.decreaseY();return;
            default: throw new IllegalArgumentException("Invalid direction!");
        }
    }
}
