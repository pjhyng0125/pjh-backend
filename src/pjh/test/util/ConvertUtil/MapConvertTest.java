package pjh.test.util.ConvertUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.ConvertUtil;

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
		
		String rtnStr = ConvertUtil.mapToJson(map);
		
		assertEquals(rtnStr, jsonStr);
	}
	
	@Test
	void jsonToMapTest() {
		initData();
		
		Map<String, Object> rtnMap = ConvertUtil.jsonToMap(jsonStr);
		
		assertEquals(rtnMap, map);				
	}
	
	@Test
	void getValFromMapStrTest() {
		initData();
		String key = "first";
		
		String rtnVal = ConvertUtil.getValFromMapStr(map.toString(), key);
		
		assertEquals(rtnVal, "java");				
	}
	
	@Test
	void getQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=v3";
		String queryStr = ConvertUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "{\"k1\":\"v1\",\"k2\":\"v2\",\"k3\":\"v3\"}");				
	}
	
	@Test
	void getExceptQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=";
		String queryStr = ConvertUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "{\"k1\":\"v1\",\"k2\":\"v2\"}");				
	}
}
