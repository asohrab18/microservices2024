package com.microservices.external.model;

public class Limits {

	private Integer minimum;
	private Integer maximum;
	private String message;

	public Limits() {
	}

	public Limits(Integer minimum, Integer maximum, String message) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
		this.message = message;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
