package com.mx.Client_Rick_Martin_API.DTO;

public class ResponseError {
	
	private int status;
	private String message;

	public ResponseError() {
	}

	public ResponseError(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
