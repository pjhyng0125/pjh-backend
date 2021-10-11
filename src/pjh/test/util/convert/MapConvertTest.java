package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.MapUtil;

/**
 * Map 변환 테스트
 */
class MapConvertTest {
	Map<String, Object> map = new LinkedHashMap<String, Object>();
	String jsonStr = "";
	String mapStr = "";
	
	void initData() {
		map.put("first", "java");
		map.put("second", "eclipse");
		map.put("third", "Junit");
		jsonStr = "{\"first\":\"java\",\"second\":\"eclipse\",\"third\":\"Junit\"}";
	}

	@Test
	void mapToJsonTest() {
		initData();	
		String rtnStr = MapUtil.mapToJson(map);
		
		assertEquals(rtnStr, jsonStr);
	}
	
	@Test
	void jsonToMapTest() {
		initData();
		Map<String, Object> rtnMap = MapUtil.jsonToMap(jsonStr);
		
		assertEquals(rtnMap, map);				
	}
	
	@Test
	void getValFromMapStrTest() {
		initData();
		String key = "first";
		String rtnVal = MapUtil.getValFromMapStr(map.toString(), key);
		
		assertEquals(rtnVal, "java");				
	}
}
