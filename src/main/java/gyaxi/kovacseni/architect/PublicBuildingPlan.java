package gyaxi.kovacseni.architect;

public class PublicBuildingPlan implements Plan {
    private final String projectName;
    private final int stock;
    private final int area;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
    }

    public int calculateSquareMeter() {
        return stock * area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public PlanType getType() {
        return PlanType.PUBLIC;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
