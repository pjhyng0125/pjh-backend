package pjh.test.util.date;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.DateUtil;

/**
 * 디렉토리 관련 테스트
 */
class DateTest {
	@Test
	void getDefaultTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.DEFAULT, Locale.getDefault()));
	}
	
	@Test
	void getNullTest() {
		assertNotNull(DateUtil.getCurrentTmss(null, null));
	}
	
	@Test
	void getEmptyTest() {
		assertNotNull(DateUtil.getCurrentTmss("", null));
	}
	
	@Test
	void getddMMyyTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.ddMMyy, Locale.getDefault()));
	}
	
	@Test
	void getEEEMMMdyyTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.getDefault()));
	}
	
	@Test
	void getEEEMMMdyyKOREATest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.KOREA));
	}
	
	@Test
	void getEEEMMMdyyENGLISHTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.ENGLISH));
	}
}
