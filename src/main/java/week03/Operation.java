package week03;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String s) {
        if (s==null) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        String[] parts = s.split("\\+");
        leftValue = Integer.parseInt(parts[0]);
        rightValue = Integer.parseInt(parts[1]);
    }

    public int getResoult(){
        return leftValue+rightValue;
    }

    public static void main(String[] args) {
        Operation operation = new Operation("3+4");
        System.out.println(operation.getResoult());
    }

}
