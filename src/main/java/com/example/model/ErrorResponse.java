package com.example.model;

import java.time.LocalDateTime;

public class ErrorResponse<T> {
	
	private String status;
	private LocalDateTime time;
	private T data;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResponse(LocalDateTime time, String status,T data) {
		super();
		this.time = time;
		this.data = data;
		this.status = status;
	}
	
	public ErrorResponse(LocalDateTime time, String status) {
		super();
		this.time = time;
		this.status = status;

	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}