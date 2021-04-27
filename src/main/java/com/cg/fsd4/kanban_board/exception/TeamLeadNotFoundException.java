package com.cg.fsd4.kanban_board.exception;

public class TeamLeadNotFoundException extends RuntimeException {
	
	String message;

	public TeamLeadNotFoundException()
	{
		
	}
	
	@Override
	public String toString() {
		return "TeamLeadNotFoundException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TeamLeadNotFoundException(String message) {
		super();
		this.message = message;
	}
	public TeamLeadNotFoundException(String message , Exception e) {
		super();
		this.message = message;
	}
}
