package gyaxi.kovacseni.architect;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArchitectStudio {

    private Map<String, Plan> plans = new HashMap<>();

    public void addPlan(String workingTitle, Plan plan) {
        if (workingTitle == null || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        plans.put(workingTitle, plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        return plans
                .values()
                .stream()
                .max(Comparator.comparing(Plan::calculateSquareMeter))
                .orElseThrow(() -> new IllegalStateException("There is no plan"));
    }

    public Plan getPlanByWorkingTitle(String workingTitle) {
        if (workingTitle == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        if (plans.containsKey(workingTitle)) {

            return plans.get(workingTitle);
        }
        throw new IllegalArgumentException("No such project.");
    }

    public Plan getPlanByProjectName(String projectName) {
        if (projectName == null || projectName.isBlank()) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        return plans
                .values()
                .stream()
                .filter(plan -> plan.getProjectName().equals(projectName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such project."));
    }

    public List<Plan> getSmallerPlans(int squareMeter) {
        return plans
                .values()
                .stream()
                .filter(plan -> plan.calculateSquareMeter() < squareMeter)
                .collect(Collectors.toList());
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }

        return plans
                .values()
                .stream()
                .filter(plan -> plan.getType() == type)
                .collect(Collectors.toList());
    }
}
