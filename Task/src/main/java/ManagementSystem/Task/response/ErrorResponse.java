package ManagementSystem.Task.response;

public class ErrorResponse extends AppResponse{
	 
	    

	    public ErrorResponse() {
			super();
		}

		public ErrorResponse(String message)
	    {
	        super(false);
	        addFullMessage(message);
	    }
		
		

		

}
