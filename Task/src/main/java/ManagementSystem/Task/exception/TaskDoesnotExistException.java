package ManagementSystem.Task.exception;

public class TaskDoesnotExistException extends RuntimeException{
	private String message;

    public TaskDoesnotExistException() {}

    public TaskDoesnotExistException(String msg) {
        super(msg);
        this.message = msg;
    }
}
