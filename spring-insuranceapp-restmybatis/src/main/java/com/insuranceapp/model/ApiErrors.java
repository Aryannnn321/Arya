package com.insuranceapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	private String message;
	private LocalDateTime timestap;
	private int statusCode;
	private String error;
	private HttpStatus status;
	public ApiErrors() {
		super();
	}
	public ApiErrors(LocalDateTime timestap, int statusCode, String error, HttpStatus status) {
		super();
		this.message = message;
		this.timestap = timestap;
		this.statusCode = statusCode;
		this.error = error;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestap() {
		return timestap;
	}
	public void setTimestap(LocalDateTime timestap) {
		this.timestap = timestap;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", timestap=" + timestap + ", statusCode=" + statusCode + ", error="
				+ error + ", status=" + status + "]";
	}
	
}
