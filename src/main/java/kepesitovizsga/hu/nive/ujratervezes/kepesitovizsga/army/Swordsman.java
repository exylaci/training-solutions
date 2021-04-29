package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean shield = true;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (shield) {
            shield = false;
            return;
        }
        super.sufferDamage(damage);
    }
}