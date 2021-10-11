package pjh.test.util.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.StringUtil;

/**
 * 문자열 Null 확인 테스트
 */
class StringNullTest {
	final String STR = "문자열";
	
	@Test
	void stringNullFalseTest() {
		assertFalse(StringUtil.isEmptyTrim(STR));
	}

	@Test
	void stringEmptyTrueTest() {
		assertTrue(StringUtil.isEmptyTrim(""));
	}
	
	@Test
	void stringNullTrueTest() {
		assertTrue(StringUtil.isEmptyTrim(null));
	}
}
