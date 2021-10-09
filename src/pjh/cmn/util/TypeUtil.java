package pjh.cmn.util;

import pjh.cmn.consts.CmnConsts;

public class TypeUtil {
	/**
	 * 인스턴스화 방지
	 */
	private TypeUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 객체 자료형 문자열 형태로 반환
	 * @param Object
	 * @return String
	 * 
	 */
//	private static String getTypeName(Object obj) {
	public static String getTypeName(Object obj) {
		return obj != null ? obj.getClass().getSimpleName() : "null" ;
	}
	
	/**
	 * 객체(값) 자료형이 String 인지 확인
	 * @param Object
	 * @return boolean
	 */
	public static boolean isString(Object val) {
		return val instanceof String || getTypeName(val).equals(CmnConsts.TYPE_DIV.STRING);
	}
	
	/**
	 * 객체(값) 자료형이 Integer 인지 확인
	 * @param Object
	 * @return boolean
	 */
	public static boolean isInteger(Object val) {
		return val instanceof Integer || getTypeName(val).equals(CmnConsts.TYPE_DIV.INTEGER);
	}
	
	/**
	 * 객체(값) 자료형이 Boolean 인지 확인
	 * @param Object
	 * @return boolean
	 */
	public static boolean isBoolean(Object val) {
		return val instanceof Boolean || getTypeName(val).equals(CmnConsts.TYPE_DIV.BOOLEAN);
	}
	
	/**
	 * 객체(값) 이 null 인지 확인
	 * @param Object
	 * @return boolean
	 */
	public static boolean isNull(Object val) {
		return val == null;
	}
	
	/**
	 * 객체(값) 이 null 아닌지 확인
	 * @param Object
	 * @return boolean
	 */
	public static boolean isNotNull(Object val) {
		return val != null;
	}
}