package exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import util.ResponseStructure;



@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ResponseStructure<String>> handleUserNotFound(UserNotFound ex) {
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeamNotFound.class)
    public ResponseEntity<ResponseStructure<String>> handleTeamNotFound(TeamNotFound ex) {
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ResponseStructure<String>> handleTaskNotFound(TaskNotFound ex) {
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseStructure<String>> handleUnauthorized(UnauthorizedException ex) {
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        response.setMessage(ex.getMessage());
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}
