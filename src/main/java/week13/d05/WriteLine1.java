package week13.d05;

import java.util.Optional;
import java.util.function.Function;

public class WriteLine1 implements Function {

    public static final String FORMAT = "%d %s, darabja %d Ft.";

    @Override
    public Optional<String> apply(Object o) {

        if (o == null || !(o instanceof BillItem)) {
            return Optional.empty();
        }
        BillItem billItem = (BillItem) o;
        return Optional.of(
                String.format(FORMAT, billItem.getPieces(), billItem.getName(), billItem.getUnitPrice()));
    }
}