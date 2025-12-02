package com.alex.graphics.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilsTest {

	@Test
	void base() {
		assertEquals("Alex", Utils.firstCharToUpper("alex") ) ;
	}

	@Test
	void onlyFirstChar() {
		assertEquals("ALeX", Utils.firstCharToUpper("aLeX") ) ;
	}

	@Test
	void singleChar() {
		assertEquals("A", Utils.firstCharToUpper("a") ) ;
	}

	@Test
	void blankAsFirstChar() {
		assertEquals(" a ", Utils.firstCharToUpper(" a ") ) ;
	}

}
