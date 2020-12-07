package bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException {
    public InvalidAccountNumberBankOperationException(String message) {
        super(message);
    }
}
