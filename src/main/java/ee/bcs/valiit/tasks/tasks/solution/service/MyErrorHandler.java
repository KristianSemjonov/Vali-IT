package ee.bcs.valiit.tasks.tasks.solution.service;

import ee.bcs.valiit.tasks.tasks.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> handelMyException(Exception ex) {
        System.out.println("handle exception here");
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handelError(Exception ex) {
        System.out.println("handle exception here");
        ErrorResponse error = new ErrorResponse();
        error.setMessage("Internal server error");
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
