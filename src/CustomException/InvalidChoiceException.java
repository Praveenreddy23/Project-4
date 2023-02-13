package CustomException;

public class InvalidChoiceException extends RuntimeException{
    private final String message;
    public InvalidChoiceException(String message){
        this.message = message;
    }
    public String getMessage(){

        return message;
    }
}
