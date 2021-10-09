package pjh.test.util.TypeUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.TypeUtil;

/**
 * 객체 자료형명 확인 테스트
 */
class TypeNameTest {

	@Test
	void typeNameIntegerTest() {
		int num = 3;
		assertEquals(TypeUtil.getTypeName(num), "Integer");
	}
	
	@Test
	void typeNameIntegerArrayTest() {
		int[] num = {1, 2, 3, 4};
		assertEquals(TypeUtil.getTypeName(num), "int[]");
	}
	
	@Test
	void typeNameStringTest() {
		String str = "문자열이다.";
		assertEquals(TypeUtil.getTypeName(str), "String");
	}
	
	@Test
	void typeNameStringArrayTest() {
		String[] strArr = {"문자열이다.", "또한 배열이다."};
		assertEquals(TypeUtil.getTypeName(strArr), "String[]");
	}
	
	@Test
	void typeNameBooleanTest() {
		boolean flag = true;
		assertEquals(TypeUtil.getTypeName(flag), "Boolean");
	}
	
	@Test
	void typeNameArrayListTest() {
		List<String> list = new ArrayList<>();
		assertEquals(TypeUtil.getTypeName(list), "ArrayList");
	}
	
	@Test
	void typeNameLinkedListTest() {
		List<String> list = new LinkedList<>();
		assertEquals(TypeUtil.getTypeName(list), "LinkedList");
	}
	
	@Test
	void typeNameLinkedHashMapArrayTest() {
		Map<Object, String> map = new LinkedHashMap<>();
		assertEquals(TypeUtil.getTypeName(map), "LinkedHashMap");
	}
	
	@Test
	void typeNameHashMapTest() {
		Map<Object, String> map = new HashMap<>();
		assertEquals(TypeUtil.getTypeName(map), "HashMap");
	}
	
	@Test
	void typeNameEmptyTest() {
		assertEquals(TypeUtil.getTypeName(""), "String");
	}
	
	@Test
	void typeNameNullTest() {
		assertEquals(TypeUtil.getTypeName(null), "null");
	}
}
