package ManagementSystem.Task.Handler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ManagementSystem.Task.exception.TaskAlreadyExistException;
import ManagementSystem.Task.exception.TaskDoesnotExistException;
import ManagementSystem.Task.exception.UsernameNotFoundException;
import ManagementSystem.Task.response.ErrorResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionTaskHandler {

	@ExceptionHandler(value = TaskDoesnotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse TaskDoesnotExistException(TaskDoesnotExistException ex) {
        return new ErrorResponse( ex.getMessage());
    }
	
	@ExceptionHandler(value = TaskAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse TaskAlreadyExistException(TaskAlreadyExistException ex) {
        return new ErrorResponse( ex.getMessage());
    }
	
	@ExceptionHandler(value = UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse UsernameNotFoundException(UsernameNotFoundException ex) {
        return new ErrorResponse( ex.getMessage());
    }
	
	
	
}
