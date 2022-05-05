package pjh.cmn.util;

import java.lang.reflect.Field;

/**
 * vo util
 */
public class VoUtil {
	/**
	 * 인스턴스화 방지
	 */
	private VoUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * print vo(dto) object with key-value
	 */
	public static void printVo(Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				System.out.println("[VoUtil] printVo getName : " + fields[i].getName());
				System.out.println("[VoUtil] printVo get(obj) : " + fields[i].get(obj));
				System.out.println("[VoUtil] printVo getAnnotatedType() : " + fields[i].getAnnotatedType());
				System.out.println("[VoUtil] printVo getModifiers() : " + fields[i].getModifiers());
			}
		} catch (Exception e) {
			System.out.println("[VoUtil] printVo catch exception error!");
		}
	}
}
