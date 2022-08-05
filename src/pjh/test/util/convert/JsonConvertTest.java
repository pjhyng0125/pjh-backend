package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
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
	
	@Test
	@DisplayName("org JSON 형 변환 테스트")
	void orgJsonConvertTest() {
		JSONObject jObj = new JSONObject();
		jObj.put("input", "String");
		
		String inputStr = (String) jObj.get("input");
		assertEquals(inputStr, "String");
	}
	
	@Test
	@DisplayName("simple JSON 형 변환 테스트")
	@SuppressWarnings("unchecked")
	void simpleJsonConvertTest() {
		org.json.simple.JSONObject jObj = new org.json.simple.JSONObject();
		jObj.put("input", "String");
		
		String inputStr = (String) jObj.get("input");
		assertEquals(inputStr, "String");
	}
	
	@Test
	@DisplayName("ObjectMapper 반환 결과 simple JSON 형 변환 테스트")
	void OmRsSimpleJsonConvertTest() throws JsonMappingException, JsonProcessingException {
		String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		org.json.simple.JSONObject jObj = new org.json.simple.JSONObject();
	    ObjectMapper mapper = new ObjectMapper();
	    
	    jObj = mapper.readValue(jsonString, org.json.simple.JSONObject.class);
		
		String inputStr = (String) jObj.get("k1");
		assertEquals(inputStr, "v1");
	}
	
	@Test
	public void givenTheJsonNode_whenRetrievingDataFromId_thenCorrect() 
	  throws JsonParseException, IOException {
	    String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode actualObj = mapper.readTree(jsonString);

	    // When
	    JsonNode jsonNode1 = actualObj.get("k1");
	    assertEquals(jsonNode1.textValue(), "v1");
	}
	
	@Test
	public void givenTheJsonNode_whenRetrievingDataFromId_thenCorrect2() 
	  throws JsonParseException, IOException {
	    org.json.simple.JSONObject dataBody = new org.json.simple.JSONObject();
	    org.json.simple.JSONObject sample = new org.json.simple.JSONObject();
	    dataBody.put("result_cd", "0000");
	    dataBody.put("result_msg", "성공");
	    sample.put("dataBody", dataBody);
	    
	    System.out.println(sample);
	    
	    org.json.simple.JSONObject rst = om.convertValue(sample.get("dataBody"), org.json.simple.JSONObject.class);
	    
	    System.out.println("rst : " + rst.toString());
	    System.out.println("rst json : " + rst);
	}
}
