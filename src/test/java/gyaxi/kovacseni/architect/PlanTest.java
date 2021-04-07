package gyaxi.kovacseni.architect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlanTest {

    @Test
    public void testCreateResidentialBuildingPlan() {
        ResidentialBuildingPlan plan = new ResidentialBuildingPlan("Baracska, Rákóczi u. 77.", House.FAMILY_HOUSE, 2, 80);

        Assertions.assertEquals("Baracska, Rákóczi u. 77.", plan.getProjectName());
        Assertions.assertEquals(House.FAMILY_HOUSE, plan.getHouse());
        Assertions.assertEquals(2, plan.getStock());
        Assertions.assertEquals(80, plan.getArea());
        Assertions.assertEquals(160, plan.calculateSquareMeter());
        Assertions.assertEquals(PlanType.RESIDENTIAL, plan.getType());
    }

    @Test
    public void testCreatePublicBuildingPlan() {
        PublicBuildingPlan plan = new PublicBuildingPlan("Óvoda, Vál", 1, 350);

        Assertions.assertEquals("Óvoda, Vál", plan.getProjectName());
        Assertions.assertEquals(1, plan.getStock());
        Assertions.assertEquals(350, plan.getArea());
        Assertions.assertEquals(350, plan.calculateSquareMeter());
        Assertions.assertEquals(PlanType.PUBLIC, plan.getType());
    }

    @Test
    public void testCreateIndustrialBuildingPlan() {
        IndustrialBuildingPlan plan = new IndustrialBuildingPlan("Műkőgyártó üzem, Kajászó", 250, 2, 600);

        Assertions.assertEquals("Műkőgyártó üzem, Kajászó", plan.getProjectName());
        Assertions.assertEquals(250, plan.getAreaOfOfficeBlock());
        Assertions.assertEquals(2, plan.getStock());
        Assertions.assertEquals(600, plan.getAreaOfManufacturingHall());
        Assertions.assertEquals(1100, plan.calculateSquareMeter());
        Assertions.assertEquals(PlanType.INDUSTRIAL, plan.getType());
    }
}
