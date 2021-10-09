package pjh.test.util.StringUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.StringUtil;

/**
 * 금액 단위 (Amount Unit) 테스트
 */
class AmUnitTest {

	@Test
	void cutUnitCase1Test() {
		assertEquals(StringUtil.cutUnit("520000", CmnConsts.AM_CUT_UNIT.TEN_THOUSAND), "52"); // 520000원 -> 52만원
	}
	
	@Test
	void cutUnitCase2Test() {
		assertEquals(StringUtil.cutUnit("520000", -1), "520000"); // 520000원 -> 520000원
	}
	
	@Test
	void cutUnitCase3Test() {
		assertEquals(StringUtil.cutUnit("52", CmnConsts.AM_CUT_UNIT.HUNDRED_THOUSAND), "0");
	}
	
	@Test
	void cutEmptyNullTest() {
		assertEquals(StringUtil.cutUnit("", CmnConsts.AM_CUT_UNIT.TEN_THOUSAND), "0");
	}
	
	@Test
	void cutUnitNullTest() {
		assertEquals(StringUtil.cutUnit(null, CmnConsts.AM_CUT_UNIT.TEN_THOUSAND), "0");
	}
}
