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
	String rrnoNormal = "9401011234567";
	String rrnoShort = "9401011";
	String rrnoDash = "940101-1234567";
	String rrnoEmpty = CmnConsts.EMPTY;
	Map<String, String> rstMap = new HashMap<>();

	@Test
	void rrnoNormalTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoDvInfo(rrnoNormal);
		System.out.println("rstMap (normal) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoShortTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoDvInfo(rrnoShort);
		System.out.println("rstMap (short) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoDashTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoDvInfo(rrnoDash);
		System.out.println("rstMap (dash) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoEmptyTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoDvInfo(rrnoEmpty);
		System.out.println("rstMap (empty) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
	
	@Test
	void rrnoNullTest() {
		rstMap = null;
		rstMap = RrnoUtil.getRrnoDvInfo(null);
		System.out.println("rstMap (null) : " + rstMap.toString());
		assertNotNull(rstMap);
	}
}
