package exceptions.faults;

public enum ProcessingResult {

    WORD_COUNT_ERROR("Nem bontható 3 részre."),
    VALUE_ERROR("A 2. tag nem szám."),
    DATE_ERROR("A harmadik tag nem yyyy.mm.dd. alakú."),
    VALUE_AND_DATE_ERROR("A 2. tag nem szám és a harmadik tag nem yyyy.mm.dd. alakú.");
    private final String code;

    ProcessingResult(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
