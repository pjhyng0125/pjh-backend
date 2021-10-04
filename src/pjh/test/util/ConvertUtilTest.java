package pjh.test.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.ConvertUtil;

class ConvertUtilTest {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsonStr = "";
	
	void initMap() {
		map.put("first", "java");
		map.put("second", "eclipse");
		map.put("third", "Junit");
		jsonStr = "{\"third\":\"Junit\",\"first\":\"java\",\"second\":\"eclipse\"}";
	}

	@Test
	void mapToJsonTest() {
		initMap();
		
		String rtnStr = ConvertUtil.mapToJson(map);
//		System.out.println("[mapToJsonTest] rtnStr: " + rtnStr);
		
		assertEquals(rtnStr, jsonStr);
	}
	
	@Test
	void jsonToMapTest() {
		initMap();
		
		Map<String, Object> rtnMap = ConvertUtil.jsonToMap(jsonStr);
//		System.out.println("[jsonToMapTest] rtnMap: " + rtnMap);
		
		assertEquals(rtnMap, map);				
	}

}
