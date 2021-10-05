package pjh.test.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.ConvertUtil;

class ConvertUtilTest {
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
		
		String rtnStr = ConvertUtil.mapToJson(map);
//		System.out.println("[mapToJsonTest] rtnStr: " + rtnStr); // {"first":"java","second":"eclipse","third":"Junit"}
		
		assertEquals(rtnStr, jsonStr);
	}
	
	@Test
	void jsonToMapTest() {
		initData();
		
		Map<String, Object> rtnMap = ConvertUtil.jsonToMap(jsonStr);
//		System.out.println("[jsonToMapTest] rtnMap: " + rtnMap); // {first=java, second=eclipse, third=Junit}
		
		assertEquals(rtnMap, map);				
	}
	
	@Test
	void getValFromMapStrTest() {
		initData();
		String key = "first";
		String val = "java";
		
//		System.out.println("[getValFromMapStrTest] map: " + map); // {first=java, second=eclipse, third=Junit}
		String rtnVal = ConvertUtil.getValFromMapStr(map.toString(), key);
		
		assertEquals(rtnVal, val);				
	}

}
