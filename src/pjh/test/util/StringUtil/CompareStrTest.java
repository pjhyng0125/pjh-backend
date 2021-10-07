package pjh.test.util.StringUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompareStrTest {
	String str = "My backend is java";
	String comStr = "";
	
	/**
	 * matches(): 비교 문자열이 정확히 일치해야만 true 반환. 특정 문자열 비교보다는 정규식 표현 이용
	 * contains(): 비교 문자열이 포함되면 true 반환.
	 */

	@Test
	void matchesTest1() {
		comStr = "backend";
		assertEquals(str.matches(comStr), false);
	}
	
	@Test
	void matchesTest2() {
		comStr = "My backend is java";
		assertEquals(str.matches(comStr), true);
	}
	
	@Test
	void matchesTest3() {
		comStr = ".*backend.*";
		assertEquals(str.matches(comStr), true);
	}
	
	@Test
	void matchesTest4() {
		comStr = "(.*)java";
		assertEquals(str.matches(comStr), true);
	}
	
	@Test
	void containsTest1() {
		comStr = "backend";
		assertEquals(str.contains(comStr), true);
	}
}
