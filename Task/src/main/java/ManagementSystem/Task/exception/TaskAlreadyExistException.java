package ManagementSystem.Task.exception;

public class TaskAlreadyExistException extends RuntimeException{
	private String message;

    public TaskAlreadyExistException() {}

    public TaskAlreadyExistException(String msg) {
        super(msg);
        this.message = msg;
    }

}
