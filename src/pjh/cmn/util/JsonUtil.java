package pjh.cmn.util;

import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

/**
 * org.json lib
 */
public class JsonUtil {
	/**
	 * 인스턴스화 방지
	 */
	private JsonUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * Map을 JsonObject로 변환
	 * @param Map<String, Object>
	 * @return JSONObject
	 */
	public static JSONObject mapToJson(Map<String, Object> map)
    {
        JSONObject jsonObject = new JSONObject();
        if (TypeUtil.isNotNull(map)) {
        	for (Map.Entry<String, Object> entry : map.entrySet() ) { // TODO: map for 문 확인
        		String key = entry.getKey();
        		Object value = entry.getValue();
        		jsonObject.put(key, value);
        	}        	
        }
        return jsonObject;
    }

	/**
	 * JsonObject를 xml String으로 변환
	 * @param JSONObject
	 * @return String
	 */
	public static String jsonToXml(JSONObject input) {
		return TypeUtil.isNotNull(input) ? XML.toString(input) : "";
    }

	/**
	 * Map을 xml String으로 변환
	 * @param JSONObject
	 * @return String
	 */	
	public static String mapToXml(Map<String, Object> map) {
		JSONObject jsonData = mapToJson(map);
		return XML.toString(jsonData);
	}
}