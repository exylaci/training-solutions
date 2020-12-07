package exceptions.faults;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> input) {
        if (input == null) throw new IllegalArgumentException("Input is a must!");

        List<String> result = new ArrayList<>();
        for (String one : input) {
            String oneMessage = processing(one);
            if (oneMessage != null) {
                result.add(oneMessage);
            }
        }
        return result;
    }

    private String processing(String oneLine) {
        String[] splitted = oneLine.split(",");
        if (splitted.length != 3) return splitted[0] + "," + ProcessingResult.WORD_COUNT_ERROR.getCode();

        if (isMessage(splitted[0])) return null;

        boolean number = isNumber(splitted[1]);
        boolean date = isDate(splitted[2]);
        if (!number && !date) return splitted[0] + "," + ProcessingResult.VALUE_AND_DATE_ERROR.getCode();
        if (!number) return splitted[0] + "," + ProcessingResult.VALUE_ERROR.getCode();
        if (!date) return splitted[0] + "," + ProcessingResult.DATE_ERROR.getCode();

        return null;
    }

    private boolean isMessage(String isMessage) {
        try {
            Integer.parseInt(isMessage);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean isNumber(String isNumber) {
        if (isNumber.isBlank()) {
            return false;
        }
        try {
            Double.parseDouble(isNumber.replace(',', '.'));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isDate(String isDate) {
        String[] split = isDate.split("\\.");
        if (split.length < 3) return false;
        try {
            LocalDate.of(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]));
        } catch (NumberFormatException | DateTimeException nfe) {
            return false;
        }
        return true;
    }
}
