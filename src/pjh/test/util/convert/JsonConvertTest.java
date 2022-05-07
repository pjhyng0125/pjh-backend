package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pjh.cmn.util.JsonUtil;
import pjh.cmn.util.VoUtil;
import pjh.vo.CamelCase;
import pjh.vo.SnakeCase;

/**
 * Json 변환 테스트: 순서 보장 X
 */
class JsonConvertTest {
	Map<String, Object> map = new LinkedHashMap<String, Object>();
	String jsonStr = "";
	String timeStamp = "";
	final String DATE_FORMAT = "yyyyMMddHHmmss";
	SnakeCase sc;
	ObjectMapper om;
	
	void initData() {
		map.put("zero", "kotlin");
		map.put("first", "java");
		map.put("second", "eclipse");
		map.put("third", "Junit");
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
		timeStamp = sdf.format(System.currentTimeMillis());
	}

	@BeforeEach
	void init() {
		initData();
		
		sc = new SnakeCase();
		sc.setTimeStamp(timeStamp);
		om = new ObjectMapper();
	}
	
	@Test
	void mapToJsonTest() {
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
		String xmlStr = JsonUtil.jsonToXml(JsonUtil.mapToJson(map));
		System.out.println("[jsonToXmlTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void jsonToXmlNullTest() {
		String xmlStr = JsonUtil.jsonToXml(null);
		System.out.println("[jsonToXmlNullTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void mapToXmlTest() {
		String xmlStr = JsonUtil.mapToXml(map);
		System.out.println("[mapToXmlTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void mapToXmlNullTest() {
		String xmlStr = JsonUtil.mapToXml(null);
		System.out.println("[mapToXmlNullTest] xmlStr: " + xmlStr);
		
		assertNotNull(xmlStr);
	}
	
	@Test
	void printSnakeCase() {
		System.out.println("[snake_caseTest] " + sc);
		VoUtil.printVo(sc);
	}
	
	@Test
	void printConvertedJsonStrTest() throws JsonProcessingException {
		String jsonStr = om.writeValueAsString(sc);
		System.out.println("converted JsonStr : " + jsonStr);
		assertTrue(jsonStr.contains("time_stamp"));
	}
	
	@Test
	void printConvertedMapKeySetTest() {
		boolean isJsonConvert = false;
		
		Map<String, Object> voMap = om.convertValue(sc, Map.class);
		
		System.out.println("[MapKeySet출력] Map : " + voMap);
		
		for (String key : voMap.keySet()) {
			isJsonConvert = key.equals("time_stamp");
			System.out.println("[keySet] key : " + key);
			System.out.println("[keySet] value : " + voMap.get(key));
		}
		assertTrue(isJsonConvert);
	}
	
	@Test
	void printConvertedMapEntrySetTest() {
		boolean isJsonConvert = false;
		
		Map<String, Object> voMap = om.convertValue(sc, Map.class);
		System.out.println("converted Map : " + voMap);
		
		for (Entry<String, Object> elem : voMap.entrySet()) {
			String key = elem.getKey();
			isJsonConvert = key.equals("time_stamp");
			System.out.println("key : " + key);
			System.out.println("value : " + elem.getValue());
		}
		assertTrue(isJsonConvert);
	}
	
	@Test
	void camelCaseTest() {
		CamelCase cc = new CamelCase();
		cc.setTimeStamp(timeStamp);
		System.out.println("[camelCaseTest] " + cc);
		
		VoUtil.printVo(cc);
	}
}
