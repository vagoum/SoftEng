package gr.ece.ntua.bitsTeam.controllers;

public class GenericResponse {
	
    private String message;
    private String error;
  
    public GenericResponse(String message) {
        super();
        this.setMessage(message);
    }
  
    public GenericResponse(String message, String error) {
        super();
        this.setMessage(message);
        this.setError(error);
    }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
