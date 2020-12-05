package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {
    private int numberOfArrow;

    public Archer(Point position,  Random random) {
        super(position, 100, random);
        this.numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    public int getActualSecondaryDamage() {
        return super.getRandom().nextInt(4)+1;
    }

    private void shootingAnArrow(Character enemy){
        decreaseTheNumberOfArrow();
        super.hit(enemy,getActualSecondaryDamage());
    }

    public void decreaseTheNumberOfArrow() {
        this.numberOfArrow-=1;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }
}
//    szükséges attribútumok
//        numberOfArrow, hány nyíl van még (int típusú).
//    hozz létre egy konstruktort, amely megkapja a nyílas pozícióját és erre állítja be a position örökölt attribútumot.
//      Állítsa be a numberOfArrow attribútum értékét 100-ra.
//    generálj gettert a numberOfArrow attribútumra.
//    hozz létre egy privát getActualSecondaryDamage metódust, ami visszaad egy 1 és 5 közötti egész véletlen értéket.
//    definiálj egy shootingAnArrow privát metódust, amely megkapja az ellenséges karakter referenciáját (enemy).
//       Csökkenti a nyílak számát numberOfArrow, és
//       meghívja a hit örökölt metódusát
//          a kapott ellenséges karakter referenciával, és
//          a getActualSecondaryDamage metódus visszatérési értékével.
//    implementáld az örökölt secondaryAttack metódust

//      úgy, hogy meghívod az előzőleg definiált privát shootingAnArrow metódust, átadva a kapott enemy paramétert.
