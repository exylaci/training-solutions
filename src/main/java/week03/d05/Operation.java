package week03.d05;

public class Operation {
    private int leftOperand;
    private int rightOperand;

    public Operation(String s) {
        if (s == null || !s.contains("+")) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        String[] parts = s.split("\\+");
        leftOperand = Integer.parseInt(parts[0]);
        rightOperand = Integer.parseInt(parts[1]);
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }

    public static void main(String[] args) {
        Operation operation = new Operation("3+4");
        System.out.println(operation.getResult());
    }
}
//Írj egy Operation osztályt, mely konstruktorban kap egy összeadást,
// pl. 68+12!
//
// A getResult() metódus visszaadja a művelet eredményét.
// Egy belső leftOperand és rightOperand attribútumba dolgozz!