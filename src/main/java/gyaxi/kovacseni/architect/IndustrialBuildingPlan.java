package gyaxi.kovacseni.architect;

public class IndustrialBuildingPlan implements Plan {
    private final String projectName;
    private final int areaOfOfficeBlock;
    private final int stock;
    private final int areaOfManufacturingHall;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
    }

    public int calculateSquareMeter() {
        return stock * areaOfOfficeBlock + areaOfManufacturingHall;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public PlanType getType() {
        return PlanType.INDUSTRIAL;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }
}
