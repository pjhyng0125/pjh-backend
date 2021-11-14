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
class RrnoDvCTest {
	String rrnoDvC = "";

	@Test
	void rrnoDvC1Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "1", "1");
		System.out.println("rrnoDvC/1/(1900년대생/내국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, "1");
	}
	
	@Test
	void rrnoDvC2Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "1", "2");
		System.out.println("rrnoDvC/2/(1900년대생/내국인/여) : " + rrnoDvC);
		assertEquals(rrnoDvC, "2");
	}
	
	@Test
	void rrnoDvC3Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("20040101", "1", "1");
		System.out.println("rrnoDvC/3/(2000년대생/내국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, "3");
	}
	
	@Test
	void rrnoDvC4Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("20040101", "1", "2");
		System.out.println("rrnoDvC/4/(2000년대생/내국인/여) : " + rrnoDvC);
		assertEquals(rrnoDvC, "4");
	}
	
	@Test
	void rrnoDvC5Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "2", "1");
		System.out.println("rrnoDvC/5/(1900년대생/외국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, "5");
	}
	
	@Test
	void rrnoDvC6Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "2", "2");
		System.out.println("rrnoDvC/6/(1900년대생/외국인/여) : " + rrnoDvC);
		assertEquals(rrnoDvC, "6");
	}
	
	@Test
	void rrnoDvC7Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("20040101", "2", "1");
		System.out.println("rrnoDvC/7/(2000년대생/외국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, "7");
	}
	
	@Test
	void rrnoDvC8Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("20040101", "2", "2");
		System.out.println("rrnoDvC/8/(2000년대생/외국인/여) : " + rrnoDvC);
		assertEquals(rrnoDvC, "8");
	}
	
	@Test
	void rrnoDvC9Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("18940101", "1", "1");
		System.out.println("rrnoDvC/9/(1800년대생/내국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, "9");
	}
	
	@Test
	void rrnoDvC0Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("18940101", "1", "2");
		System.out.println("rrnoDvC/0/(1800년대생/내국인/여) : " + rrnoDvC);
		assertEquals(rrnoDvC, "0");
	}
	
	@Test
	void rrnoDvCExceptYY1700Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("17940101", "1", "1");
		System.out.println("Exception/YY1700/(1700년대생/내국인/남) : " + rrnoDvC);
		assertEquals(rrnoDvC, CmnConsts.EMPTY);
	}
	
	@Test
	void rrnoDvCExceptFrnrC3Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "3", "1");
		System.out.println("Exception/FrnrC3/(1900년대생/내국인/3) : " + rrnoDvC);
		assertEquals(rrnoDvC, CmnConsts.EMPTY);
	}
	
	@Test
	void rrnoDvCExceptGenderC3Test() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo("19940101", "1", "3");
		System.out.println("Exception/GenderC3/(1900년대생/내국인/3) : " + rrnoDvC);
		assertEquals(rrnoDvC, CmnConsts.EMPTY);
	}
	
	@Test
	void rrnoDvCNullTest() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo(null, null, null);
		System.out.println("Exception/null/(null/null/null) : " + rrnoDvC);
		assertEquals(rrnoDvC, CmnConsts.EMPTY);
	}
	
	@Test
	void rrnoDvCEmptyTest() {
		rrnoDvC = "";
		rrnoDvC = RrnoUtil.getRrnoDvCFromPsnlInfo(CmnConsts.EMPTY, CmnConsts.EMPTY, CmnConsts.EMPTY);
		System.out.println("Exception/EMPTY/(EMPTY/EMPTY/EMPTY) : " + rrnoDvC);
		assertEquals(rrnoDvC, CmnConsts.EMPTY);
	}
}
