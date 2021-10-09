package pjh.test.util.ConvertUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.ConvertUtil;

class UrlConvertTest {
	
	@Test
	void getEmptyQueryStrFromUrlTest() {
		String url = "http://localhost:8080/pjh/sample.jsp";
		String queryStr = ConvertUtil.getQueryStrFromUrl(url);
		
		assertEquals(queryStr, "");				
	}
	
	@Test
	void UrlConvertTest() {
		String data = "A + B";
		String encData = ConvertUtil.urlEncode(data);
		String decData = ConvertUtil.urlDecode(encData);
		
		assertEquals(data, decData);				
	}
	
	@Test
	void UrlConvertStrangeCaseTest() {
		String data = "A + B";
		String decData = ConvertUtil.urlDecode(data);
		String encData = ConvertUtil.urlEncode(decData);
		String spaceToPlus = "A+++B";
		
		assertEquals(encData, spaceToPlus);				
	}
}
