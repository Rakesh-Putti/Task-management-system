package exception;



public class UnauthorizedException extends RuntimeException {
    private String message = "You are not authorized to perform this action";

    public UnauthorizedException(String message) {
		
	}

	@Override
    public String getMessage() {
        return message;
    }
}

