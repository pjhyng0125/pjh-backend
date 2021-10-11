package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.MapUtil;
import pjh.cmn.util.UrlUtil;

/**
 * Url 변환 테스트
 */
class UrlConvertTest {
	
	@Test
	void getQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=v3";
		String queryStr = UrlUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "{\"k1\":\"v1\",\"k2\":\"v2\",\"k3\":\"v3\"}");				
	}
	
	@Test
	void getExceptQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp?k1=v1&k2=v2&k3=";
		String queryStr = UrlUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "{\"k1\":\"v1\",\"k2\":\"v2\"}");				
	}
	
	@Test
	void getEmptyQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp";
		String queryStr = UrlUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "");				
	}
	
	@Test
	void urlConvertTest() {
		String data = "A + B";
		String encData = UrlUtil.urlEncode(data);
		String decData = UrlUtil.urlDecode(encData);
		
		assertEquals(data, decData);				
	}
	
	@Test
	void urlConvertStrangeCaseTest() {
		String data = "A + B";
		String decData = UrlUtil.urlDecode(data);
		String encData = UrlUtil.urlEncode(decData);
		String spaceToPlus = "A+++B";
		
		assertEquals(encData, spaceToPlus);				
	}
}
