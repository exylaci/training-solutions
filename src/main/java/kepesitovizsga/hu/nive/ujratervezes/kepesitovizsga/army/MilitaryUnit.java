package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    private int lifePower;
    private int damageCapability;
    private boolean armor;

    MilitaryUnit(int lifePower, int damageCapability, boolean armor) {
        this.lifePower = lifePower;
        this.damageCapability = damageCapability;
        this.armor = armor;
    }

    public int doDamage() {
        return damageCapability;
    }

    public void sufferDamage(int damage) {
        lifePower -= damage / (armor ? 2 : 1);
    }

    public int getHitPoints() {
        return lifePower;
    }
}