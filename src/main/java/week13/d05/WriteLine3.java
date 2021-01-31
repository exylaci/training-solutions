package week13.d05;

import java.util.Optional;
import java.util.function.Function;

public class WriteLine3 implements Function {

    public static final String FORMAT = "%s %d * %d = %d";

    @Override
    public Optional<String> apply(Object o) {
        if (o == null || !(o instanceof BillItem)) {
            return Optional.empty();
        }
        BillItem bill = (BillItem) o;
        return Optional.of(String.format(FORMAT,
                bill.getName(), bill.getPieces(), bill.getUnitPrice(), bill.getPieces() * bill.getUnitPrice()));
    }
}