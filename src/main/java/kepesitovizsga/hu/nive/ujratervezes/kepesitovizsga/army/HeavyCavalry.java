package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    private boolean fistAttack = true;

    HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        int capability = super.doDamage();
        if (fistAttack) {
            capability *= 3;
            fistAttack = false;
        }
        return capability;
    }
}