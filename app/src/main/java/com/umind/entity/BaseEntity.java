package com.umind.entity;

import java.io.Serializable;

/**
 * Hai Nguyen - 8/27/15.
 */
public class BaseEntity implements Serializable {

	private String error;
	private String result;

	public String getError() {
		return error;
	}

	public String getResult() {
		return result;
	}
}
