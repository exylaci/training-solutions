package gyaxi.kovacseni.architect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ArchitectStudioTest {

    private ArchitectStudio studio;

    @BeforeEach
    public void setUp() {
        ResidentialBuildingPlan residential1 = new ResidentialBuildingPlan("Budapest, Lejtő u. 20.", House.FAMILY_HOUSE, 1, 70);
        ResidentialBuildingPlan residential2 = new ResidentialBuildingPlan("Budapest, Zólyomi u. 12.", House.APARTMENT_BUILDING, 4, 100);
        ResidentialBuildingPlan residential3 = new ResidentialBuildingPlan("Érd, Vereckei u. 79.", House.FAMILY_HOUSE, 1, 60);
        PublicBuildingPlan public1 = new PublicBuildingPlan("Bölcsőde, Biatorbágy", 1, 350);
        PublicBuildingPlan public2 = new PublicBuildingPlan("Sportpálya öltözője, Baracska", 1, 100);
        PublicBuildingPlan public3 = new PublicBuildingPlan("Kollégium, Győr", 5, 600);
        IndustrialBuildingPlan industrial1 = new IndustrialBuildingPlan("Tűzoltóság, Déli Pályaudvar", 250, 1, 300);
        IndustrialBuildingPlan industrial2 = new IndustrialBuildingPlan("Lovarda, Pannonhalma", 50, 2, 500);
        IndustrialBuildingPlan industrial3 = new IndustrialBuildingPlan("Autószerelő műhely, Vál", 60, 1, 300);

        studio = new ArchitectStudio();
        studio.addPlan("Lajos", residential1);
        studio.addPlan("Biabölcsi", public1);
        studio.addPlan("tűzoltóság", industrial1);
        studio.addPlan("Zólyomi", residential2);
        studio.addPlan("sportöltöző", public2);
        studio.addPlan("lovarda", industrial2);
        studio.addPlan("Szalay", residential3);
        studio.addPlan("koli", public3);
        studio.addPlan("NaVál", industrial3);
    }

    @Test
    public void testAddPlanWithEmptyWorkingTitle() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.addPlan(null, new PublicBuildingPlan("Üzlethelyiség, Kukutyin", 1, 60)));
        Assertions.assertEquals("Working title and plan must not be empty!", ex.getMessage());
    }

    @Test
    public void testAddPlanWithEmptyPlan() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.addPlan("kiskastély", null));
        Assertions.assertEquals("Working title and plan must not be empty!", ex.getMessage());
    }

    @Test
    public void testGetPlanWithMaxSquareMeter() {
        Assertions.assertEquals("Kollégium, Győr", studio.getPlanWithMaxSquareMeter().getProjectName());
        Assertions.assertEquals(3000, studio.getPlanWithMaxSquareMeter().calculateSquareMeter());
    }

    @Test
    public void testGetPlanByWorkingTitle() {
        Assertions.assertEquals("Bölcsőde, Biatorbágy", studio.getPlanByWorkingTitle("Biabölcsi").getProjectName());
    }

    @Test
    public void testGetPlanByEmptyWorkingTitle() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.getPlanByWorkingTitle(""));
        Assertions.assertEquals("Working title must not be empty!", ex.getMessage());
    }

    @Test
    public void testGetPlanByUnknownWorkingTitle() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.getPlanByWorkingTitle("kiskastély"));
        Assertions.assertEquals("No such project.", ex.getMessage());
    }

    @Test
    public void testGetPlanByProjectName() {
        Assertions.assertEquals(550, studio.getPlanByProjectName("Tűzoltóság, Déli Pályaudvar").calculateSquareMeter());
        Assertions.assertEquals(PlanType.INDUSTRIAL, studio.getPlanByProjectName("Tűzoltóság, Déli Pályaudvar").getType());
    }

    @Test
    public void testGetPlanByEmptyProjectName() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.getPlanByProjectName("\n"));
        Assertions.assertEquals("Project name must not be empty!", ex.getMessage());
    }

    @Test
    public void testGetPlanByUnknownProjectName() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.getPlanByProjectName("Varroda, Kukutyin"));
        Assertions.assertEquals("No such project.", ex.getMessage());
    }

    @Test
    public void testGetSmallerPlans() {
        List<Plan> smaller = studio.getSmallerPlans(101);

        Assertions.assertEquals(3, smaller.size());
    }

    @Test
    public void testGetListOfPlansByPlanType() {
        List<Plan> industrials = studio.getListOfPlansByPlanType(PlanType.INDUSTRIAL);

        Assertions.assertEquals(3, industrials.size());
    }

    @Test
    public void testGetListOfPlansByEmptyPlanType() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> studio.getListOfPlansByPlanType(null));
        Assertions.assertEquals("Parameter must not be null!", ex.getMessage());
    }
}
