package pjh.test.util.convert;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URLEncoder;

import org.junit.jupiter.api.Test;

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
	
	@Test
	void urlConvertCharsetTest() {
		String data = "결제하기";
		String encUTF8Data = UrlUtil.urlEncode(data);
		@SuppressWarnings("deprecation")
		String encNonCharSetData = URLEncoder.encode(data);
		// [문제] charSet 생략 시, %3F (?) 출력 케이스 확인 => 디코딩 시 ???? 출력
		// Java에서 한글을 인코딩할 경우, 문자 인코딩 UTF-8 반드시 명시해 주자
		
		assertEquals(encUTF8Data, encNonCharSetData);				
	}
}
