package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import pjh.cmn.util.JsonUtil;

/**
 * Json 변환 테스트: 순서 보장 X
 */
class JsonConvertTest {
	Map<String, Object> map = new LinkedHashMap<String, Object>();
	String jsonStr = "";
	
	void initData() {
		map.put("zero", "kotlin");
		map.put("first", "java");
		map.put("second", "eclipse");
		map.put("third", "Junit");
	}
	
	@Test
	void mapToJsonTest() {
		initData();
		
		JSONObject jsonObject = JsonUtil.mapToJson(map);
		System.out.println("[mapToJsonTest] jsonObject: " + jsonObject);
		
		assertNotNull(jsonObject);
	}
	
	@Test
	void mapToJsonNullTest() {
		JSONObject jsonObject = JsonUtil.mapToJson(null);
		System.out.println("[mapToJsonNullTest] jsonObject: " + jsonObject);
		
		assertNotNull(jsonObject);
	}
	
	@Test
	void jsonToXmlTest() {
		initData();
		
		String xmlStr = JsonUtil.jsonToXml(JsonUtil.mapToJson(map));
		System.out.println("[jsonToXmlTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void jsonToXmlNullTest() {String xmlStr = JsonUtil.jsonToXml(null);
		System.out.println("[jsonToXmlNullTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void mapToXmlTest() {
		initData();
		
		String xmlStr = JsonUtil.mapToXml(map);
		System.out.println("[mapToXmlTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void mapToXmlNullTest() {String xmlStr = JsonUtil.mapToXml(null);
		System.out.println("[mapToXmlNullTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
}
