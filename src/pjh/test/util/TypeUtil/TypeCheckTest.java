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
		assertEquals(TypeUtil.isString(STR), true);
	}
	
	@Test
	void typeStringCheckIntegerTest() {
		assertEquals(TypeUtil.isString(INT), false);
	}
	
	@Test
	void typeStringCheckBooleanTest() {
		assertEquals(TypeUtil.isString(BOOLEAN), false);
	}
	
	@Test
	void typeStringCheckEmptyTest() {
		assertEquals(TypeUtil.isString(EMPTY), true);
	}
	
	@Test
	void typeStringCheckNullTest() {
		assertEquals(TypeUtil.isString(null), false);
	}
	
	@Test
	void typeIntegerCheckTest() {
		assertEquals(TypeUtil.isInteger(INT), true);
	}
	
	@Test
	void typeIntegerCheckStringTest() {
		assertEquals(TypeUtil.isInteger(STR), false);
	}
	
	@Test
	void typeIntegerCheckBooleanTest() {
		assertEquals(TypeUtil.isInteger(BOOLEAN), false);
	}
	
	@Test
	void typeIntegerCheckEmptyTest() {
		assertEquals(TypeUtil.isInteger(EMPTY), false);
	}
	
	@Test
	void typeIntegerCheckNullTest() {
		assertEquals(TypeUtil.isInteger(null), false);
	}
	
	@Test
	void typeBooleanCheckTest() {
		assertEquals(TypeUtil.isBoolean(BOOLEAN), true);
	}
	
	@Test
	void typeBooleanCheckIntegerTest() {
		assertEquals(TypeUtil.isBoolean(INT), false);
	}
	
	@Test
	void typeBooleanCheckStringTest() {
		assertEquals(TypeUtil.isBoolean(STR), false);
	}
	
	@Test
	void typeBooleanCheckEmptyTest() {
		assertEquals(TypeUtil.isBoolean(EMPTY), false);
	}
	
	@Test
	void typeBooleanCheckNullTest() {
		assertEquals(TypeUtil.isBoolean(null), false);
	}
	
	@Test
	void typeNullCheckTest() {
		assertEquals(TypeUtil.isNull(null), true);
	}
	
	@Test
	void typeNullCheckStringTest() {
		assertEquals(TypeUtil.isNull(STR), false);
	}
	
	@Test
	void typeNullCheckIntegerTest() {
		assertEquals(TypeUtil.isNull(INT), false);
	}
	
	@Test
	void typeNullCheckBooleanTest() {
		assertEquals(TypeUtil.isNull(BOOLEAN), false);
	}
	
	@Test
	void typeNullCheckEmptyTest() {
		assertEquals(TypeUtil.isNull(EMPTY), false);
	}
}
