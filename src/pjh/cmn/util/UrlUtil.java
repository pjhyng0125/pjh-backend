package pjh.cmn.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pjh.cmn.consts.CmnConsts;

/**
 * jackson lib
 */
public class UrlUtil {
	/**
	 * 인스턴스화 방지
	 */
	private UrlUtil() throws InstantiationException {
		throw new InstantiationException();
	}/**
	 * URL 의 query String 을 Map 으로 반환 
	 * @param String url
	 * @example http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=v3
	 * @return Map<String, Object> queryMap
	 */
	public static Map<String, Object> getQueryMapFromUrl(String url) {
		Map<String, Object> queryMap = new HashMap<>();
		String[] sptByQ = url.split("\\?"); // Question TODO: escape 처리 공통 함수, 메타문자 상수, null 체크 필요
		if (sptByQ.length > 1) {
			String[] sptByA = sptByQ[1].split("&"); // Ampersand
			for (String pair : sptByA) {
				String[] sptByE = pair.split("="); // Equal
				if (sptByE.length > 1) {
					queryMap.put(sptByE[0], sptByE[1]); // TODO: decodeURI (part[1])
				}
			}
		}
		return queryMap;
	}
	
	/**
	 * URL 의 query String 을 json String 으로 반환 
	 * @param String url
	 * @example http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=v3
	 * @return String jsonStr
	 */
	public static String getQueryStrFromUrl(String url) {
		String jsonStr = "";
		Map<String, Object> queryMap = getQueryMapFromUrl(url);
		if (!queryMap.isEmpty()) {
			jsonStr = MapUtil.mapToJson(queryMap);
		}
		return jsonStr;
	}
	
	/**
	 * 문자열 encode
	 * @param String data
	 * @return String encData
	 */
	public static String urlEncode(String data){
		String encStr = "";
		try {
			encStr = URLEncoder.encode(data, CmnConsts.DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		return encStr;
	}
	
	/**
	 * 문자열 decode
	 * @param String data
	 * @return String decData
	 */
	public static String urlDecode(String data){
		String decStr = "";
		try {
			decStr = URLDecoder.decode(data, CmnConsts.DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		return decStr;
	}
}
