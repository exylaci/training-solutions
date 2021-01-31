package week13.d05;

import java.util.Optional;
import java.util.function.Function;

public class WriteLine2 implements Function {

    public static final String FORMAT_HEADER = "%-20s %13s %5s %6s";
    public static final String FORMAT_LINES = "%-20s %13d %5d %6d";

    @Override
    public Optional<String> apply(Object o) {
        if (o == null) {
            return Optional.of(String.format(FORMAT_HEADER, "Megnevezés", "Egységár (Ft)", "Darab", "Összeg"));
        }
        if (o instanceof BillItem) {
            BillItem bill = (BillItem) o;
            return Optional.of(String.format(FORMAT_LINES,
                    bill.getName(), bill.getUnitPrice(), bill.getPieces(), bill.getUnitPrice() * bill.getPieces()));
        }
        return Optional.empty();
    }
}