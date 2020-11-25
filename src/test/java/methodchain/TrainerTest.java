package methodchain;

import org.junit.jupiter.api.Test;

public class TrainerTest {

    @Test
    public void testCreate(){
        Trainer trainer = new Trainer();
        trainer.setName("Gábor Áron");
        trainer.setAge(36);

        Trainer trainer1 = new Trainer().setName("Valaki Más").setAge(21);

    }
}
