package erettsegik.oktober2019.forditoiroda;

public class ReportData {
    private int pieces;
    private int amount;
    private int size;
    private String subject;
    private String sourceLanguage;
    private String targetLanguage;

    public ReportData(String subject, String sourceLanguage, String targetLanguage) {
        this.subject = subject;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
    }

    public ReportData(int size, String subject) {
        this.size = size;
        this.subject = subject;
    }

    public ReportData(int pieces, int amount) {
        this.pieces = pieces;
        this.amount = amount;
    }

    public int getPieces() {
        return pieces;
    }

    public int getAmount() {
        return amount;
    }

    public int getSize() {
        return size;
    }

    public String getSubject() {
        return subject;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }
}
