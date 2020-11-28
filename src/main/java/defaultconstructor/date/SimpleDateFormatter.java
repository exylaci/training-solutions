package defaultconstructor.date;

public class SimpleDateFormatter {
    public static final String ERROR_MESSAGE = "Cannot be null!";

    private static CountryCode defaultCountryCode = CountryCode.HU;

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate date) {
        if (countryCode == null || date == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return countryCode.getDateFormat()
                .replaceFirst("y", String.valueOf(date.getYear()))
                .replaceFirst("m", String.valueOf(date.getMonth()))
                .replaceFirst("d", String.valueOf(date.getDay()));
    }

    public String formatDateString(SimpleDate date) {
        return formatDateStringByCountryCode(defaultCountryCode, date);
    }

    public static void setDefaultCountryCode(CountryCode defaultCountryCode) {
        if (defaultCountryCode == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        SimpleDateFormatter.defaultCountryCode = defaultCountryCode;
    }
}
