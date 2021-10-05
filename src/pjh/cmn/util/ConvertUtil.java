package pjh.cmn.util;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertUtil {
	/**
	 * 인스턴스화 방지
	 */
	private ConvertUtil() throws InstantiationException {
		throw new InstantiationException();
	}

	/**
	 * Map을 json String으로 변환하여 반환
	 * @param Map
	 * @return String json 문자열
	 */
	public static String mapToJson(Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper(); // jackson-databind, jackson-annotations
		String jsonStr = "";
		try {
			jsonStr = mapper.writeValueAsString(map); // jackson-core
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * json String을 Map으로 변환하여 반환
	 * @param String json 문자열
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper(); // jackson-databind
		Map<String, Object> map = null;
		try {
			map = mapper.readValue(jsonStr, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * Map String 에서 key에 매핑되는 value 반환 
	 * @param Map mapStr {k1=v1, k2=v2, k3=v3, ...}
	 * @param String key
	 * @return String val
	 */
	public static String getValFromMapStr(String mapStr, String key) {
		String val = null;
		if (mapStr != null && key != null) {
			mapStr = mapStr.replace("{", "").replace("}", "");
			String[] sptByComArr = mapStr.split(",");
			if (sptByComArr != null) {
				for (String sptByComStr : sptByComArr) {
					String[] sptByEqualArr = sptByComStr.split("=");
					if (sptByEqualArr.length > 1) {
						if (key.equals(sptByEqualArr[0].trim())) {
							val = sptByEqualArr[1];
						}
					}
				}
			}
		}
		return val;
	}
}
