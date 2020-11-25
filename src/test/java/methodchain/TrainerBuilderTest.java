package methodchain;

import org.junit.jupiter.api.Test;

public class TrainerBuilderTest {
    @Test
    public void trainerBuilderTest(){
        Trainer trainer = new TrainerBuilder().withName("Gábor Áron").withAge(36).buil();
    }
}
