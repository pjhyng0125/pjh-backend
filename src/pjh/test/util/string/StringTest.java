package pjh.test.util.string;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.StringUtil;

/**
 * 문자열 Null 확인 테스트
 */
class StringTest {
	final String iStr = "한글입력했음";
	final int mLen = 12; 
	
	@Test
	void rpadByLengthTest() {
		String oStr = "한글입력했음  ";
		assertEquals(StringUtil.rpad(iStr, 8, ' '), oStr);
	}
	
	@Test
	void rpadByByteForEUCKRTest() throws UnsupportedEncodingException {
		String iStr = "한글입력";
		String oStr = StringUtil.rpad(iStr, mLen, ' ', CmnConsts.EUC_KR_CHARSET);
		assertEquals(StringUtil.getByteLength(oStr, CmnConsts.EUC_KR_CHARSET), mLen);
	}
	
	@Test
	void getByteLegnthUTF8Test() throws UnsupportedEncodingException {
		String iStr = "한글입력";
		assertEquals(StringUtil.getByteLength(iStr, CmnConsts.DEFAULT_CHARSET), 12);
	}
	@Test
	void getByteLegnthEUCKRTest() throws UnsupportedEncodingException {
		String iStr = "한글입력";
		assertEquals(StringUtil.getByteLength(iStr, CmnConsts.EUC_KR_CHARSET), 8);
	}
}
