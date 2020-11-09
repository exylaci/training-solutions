package math;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    private Point position;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        stamina = new Random().nextInt(100);
        skill = new Random().nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior warrior){
        if ( position.getX()<warrior.position.getX() ){
            position = new Point(position.getX()+1 , position.getY());
        }else if ( position.getX()>warrior.position.getX() ) {
            position = new Point(position.getX()-1 , position.getY());
        }
        if ( position.getY()<warrior.position.getY() ){
            position = new Point(position.getX() , position.getY()+1 );
        }else if ( position.getY()>warrior.position.getY() ) {
            position = new Point(position.getX() , position.getY()-1 );
        }
    }

    public void attack(Warrior warrior){
        if ( this.skill > new Random().nextDouble() ) {
            warrior.stamina-= new Random().nextInt(2)+1;
        }
    }

    public double distance(Warrior warrior){
        return position.distance(warrior.getPosition());
    }

    public boolean isAlive(){
        return stamina>0;
    }

    public String toString(){
        return name + ": (" + position.getX() + " x " + position.getY() + ") " + stamina;

    }
}
