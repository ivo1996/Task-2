package util;

public class customErrorType {
	
    private String Message;

    public customErrorType(String message){
        this.Message = message;
    }

    public String getErrorMessage() {
        return Message;
    }
}
