package pjh.cmn.util;

import java.io.UnsupportedEncodingException;

import pjh.cmn.consts.CmnConsts;

public class StringUtil {
	/**
	 * 인스턴스화 방지
	 */
	private StringUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 공백제거한 String 값이 Empty 인지 확인
	 * @param String
	 * @return boolean
	 */
	public static boolean isEmptyTrim(String val) {
		return TypeUtil.isNull(val) ? true : val.trim().isEmpty();
	}
	
	/**
	 * null 체크하여 "" 반환
	 * @param String
	 * @return String
	 */
	public static String nvl(String val) {
		return isEmptyTrim(val) ? "" : val;
	}
	
	/**
	 * 금액 단위 버림
	 * @param String am 금액
	 * @param String cutStart 단위 버림 시작점 (뒤에서부터 count)
	 * @return String
	 */
	public static String cutUnit(String am, int cutStart) {
		String cutAm = "0";
		if (cutStart < 0) {
			cutAm = am;
		} else if (TypeUtil.isNotNull(am)) {
			int len = am.length();
			int printLen = len - cutStart;
			if (printLen > 0) {
				cutAm = am.substring(0, printLen);
			}
		}
		return cutAm;
	}
	
	/**
	 * byte length 구하기
	 * @param String iStr input String
	 * @param String encodeFlag 인코딩 속성 (UTF-8, EUC-KR)
	 * @return int
	 */
	public static int getByteLength(String iStr, String encodeFlag) throws UnsupportedEncodingException {
		return iStr.getBytes(encodeFlag).length;
	}
	
	/**
	 * 오른쪽 특정 문자열 채우기 (right padding) 
	 * @param String iStr input String
	 * @param int length
	 * @param char pChar padding char
	 * @return String
	 */
	public static String rpad(String iStr, int length, char pChar) {
		if (iStr == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        if (length <= iStr.length()) {
            return iStr;
        }

        StringBuilder padded = new StringBuilder(iStr);

        while (padded.length() < length) {
            padded.append(pChar);
        }

        return padded.toString();
	}
	
	/**
	 * 오른쪽 특정 문자열 채우기 (right padding) 
	 * @param String iStr input String
	 * @param int length
	 * @param char pChar padding char
	 * @param String encodeFlag 인코딩 속성 (UTF-8, EUC-KR)
	 * @return String
	 * @throws UnsupportedEncodingException 
	 */
	public static String rpad(String iStr, int length, char pChar, String encodeFlag) throws UnsupportedEncodingException {
		if (iStr == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        if (length <= iStr.length()) {
            return iStr;
        }
        
        byte[] encodeByteArr = iStr.getBytes(encodeFlag);
        
        StringBuilder psb = new StringBuilder(iStr);

        for (int i = 0; i < length - encodeByteArr.length; i ++) {
        	psb.append(pChar);
        }

        return psb.toString();
	}
}