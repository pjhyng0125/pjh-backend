package pjh.test.util.TypeUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.TypeUtil;
/**
 * 객체 타입 확인 테스트
 */
class TypeCheckTest {
	final String STR = "문자열";
	final int INT = 3;
	final boolean BOOLEAN = false;
	final String EMPTY = "";

	@Test
	void typeStringCheckTest() {
		assertTrue(TypeUtil.isString(STR));
	}
	
	@Test
	void typeStringCheckIntegerTest() {
		assertFalse(TypeUtil.isString(INT));
	}
	
	@Test
	void typeStringCheckBooleanTest() {
		assertFalse(TypeUtil.isString(BOOLEAN));
	}
	
	@Test
	void typeStringCheckEmptyTest() {
		assertTrue(TypeUtil.isString(EMPTY));
	}
	
	@Test
	void typeStringCheckNullTest() {
		assertFalse(TypeUtil.isString(null));
	}
	
	@Test
	void typeIntegerCheckTest() {
		assertTrue(TypeUtil.isInteger(INT));
	}
	
	@Test
	void typeIntegerCheckStringTest() {
		assertFalse(TypeUtil.isInteger(STR));
	}
	
	@Test
	void typeIntegerCheckBooleanTest() {
		assertFalse(TypeUtil.isInteger(BOOLEAN));
	}
	
	@Test
	void typeIntegerCheckEmptyTest() {
		assertFalse(TypeUtil.isInteger(EMPTY));
	}
	
	@Test
	void typeIntegerCheckNullTest() {
		assertFalse(TypeUtil.isInteger(null));
	}
	
	@Test
	void typeBooleanCheckTest() {
		assertTrue(TypeUtil.isBoolean(BOOLEAN));
	}
	
	@Test
	void typeBooleanCheckIntegerTest() {
		assertFalse(TypeUtil.isBoolean(INT));
	}
	
	@Test
	void typeBooleanCheckStringTest() {
		assertFalse(TypeUtil.isBoolean(STR));
	}
	
	@Test
	void typeBooleanCheckEmptyTest() {
		assertFalse(TypeUtil.isBoolean(EMPTY));
	}
	
	@Test
	void typeBooleanCheckNullTest() {
		assertFalse(TypeUtil.isBoolean(null));
	}
	
	@Test
	void typeNullCheckTest() {
		assertTrue(TypeUtil.isNull(null));
	}
	
	@Test
	void typeNullCheckStringTest() {
		assertFalse(TypeUtil.isNull(STR));
	}
	
	@Test
	void typeNullCheckIntegerTest() {
		assertFalse(TypeUtil.isNull(INT));
	}
	
	@Test
	void typeNullCheckBooleanTest() {
		assertFalse(TypeUtil.isNull(BOOLEAN));
	}
	
	@Test
	void typeNullCheckEmptyTest() {
		assertFalse(TypeUtil.isNull(EMPTY));
	}
}
