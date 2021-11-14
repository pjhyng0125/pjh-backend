package pjh.test.util.rrno;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.RrnoUtil;

/**
 * 주민등록번호 Util 테스트
 */
class RrnoTest {
	Map<String, String> rstMap = new HashMap<>();

	@Test
	void rrnoNormalTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9401011234567");
		System.out.println("rstMap (normal) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoShortTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9401011");
		System.out.println("rstMap (short) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoDashTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("940101-1234567");
		System.out.println("rstMap (dash) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoEmptyTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo(CmnConsts.EMPTY);
		System.out.println("rstMap (empty) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoNullTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo(null);
		System.out.println("rstMap (null) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoFmleTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9401012345678");
		System.out.println("rstMap (Fmle) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoYY2000Test() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("0201014345678");
		System.out.println("rstMap (YY2000) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoFrnrManTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9401015345678");
		System.out.println("rstMap (FrnrMan) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoFrnrFmleTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9401016345678");
		System.out.println("rstMap (FrnrFmle) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoYY2000FrnrTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("0501018345678");
		System.out.println("rstMap (YY2000Frnr) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoYY1800Test() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoPsnlInfo("9001010345678");
		System.out.println("rstMap (YY1800) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
}
