package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {
    public AxeWarrior(Point position,  Random random) {
        super(position, 100, random);
    }
    private int  getActualSecondaryDamage(Character enemy){
        return super.getRandom().nextInt(20)+1;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (enemy.getPosition().distance(super.getPosition())<2){
            hit(enemy,getActualSecondaryDamage(enemy));
        }
    }
}
