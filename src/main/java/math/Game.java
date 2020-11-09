package math;

public class Game {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Dávid" , new Point(10,3));
        System.out.println( warrior1.toString() );
        Warrior warrior2 = new Warrior("Góliát" , new Point(0,7));
        System.out.println( warrior2.toString() );
        int round = 1;
        do{
            if ( warrior1.distance(warrior2) != 0 ){
                warrior1.move(warrior2);
            }else{
                warrior1.attack(warrior2);
            }
            if ( !warrior2.isAlive() ) {
                break;
            }
            if ( warrior2.distance(warrior1) != 0 ){
                warrior2.move(warrior1);
            }else{
                warrior2.attack(warrior1);
            }
            System.out.println(round + ". round");
            System.out.println( warrior1.toString() );
            System.out.println( warrior2.toString() );
            ++round;
        } while ( warrior1.isAlive() && warrior2.isAlive() );
        System.out.println("Winner: " + ( warrior1.isAlive() ? warrior1.toString() : warrior2.toString() ));
    }
}
