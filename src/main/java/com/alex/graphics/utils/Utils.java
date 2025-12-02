package com.alex.graphics.utils;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Utils {

	private Utils() {
		//only static functions
	}

	public static String firstCharToUpper(String input) {
		if (input == null) {
			return null;
		} else if (input.isEmpty()) {
			return input;
		}
		//A single char works OK and second string is just blank
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
}
