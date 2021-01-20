package methodvarargs.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) throws IllegalArgumentException  {
        checkParameters(results);
        double limit = calculateLimit(limitInPercent);
        int counter = 0;

        for ( double one : results ){
            if ( one>=limit ){
                ++counter;
            }
        }
        return counter;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results){
        checkParameters(results);
        double limit = calculateLimit(limitInPercent);

        for ( double one : results ){
            if ( one<limit ){
                return true;
            }
        }
        return false;
    }

    private void checkParameters(int... results){
        if ( results==null || results.length==0 ){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    }

    private double calculateLimit(int limitInPercent){
        return maxPoints / 100. * limitInPercent;
    }
}
