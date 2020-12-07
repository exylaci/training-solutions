package bank2;

public class InvalidBankOperationException extends RuntimeException{

    InvalidBankOperationException(String message){
        super(message);
    }

}
