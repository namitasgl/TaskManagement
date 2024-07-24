package ManagementSystem.Task.exception;

public class UsernameNotFoundException extends RuntimeException{
	private String message;

	public UsernameNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UsernameNotFoundException() {
		super();
	}

}
