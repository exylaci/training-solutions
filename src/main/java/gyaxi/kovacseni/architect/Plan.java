package gyaxi.kovacseni.architect;

public interface Plan {
    String getProjectName();

    int calculateSquareMeter();

    PlanType getType();
}
