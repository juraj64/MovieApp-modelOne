package com.jurajlazovy.movies.domain;

import java.io.Serializable;

/**
 * Enum for Gender
 */
public enum Gender implements Serializable {
	M, F;

	/**
	 */
	private Gender() {
	}

	public String getName() {
		return name();
	}
}
