package pjh.test.sample;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;

/**
 * 디렉토리 관련 테스트
 */
class SampleTest {
	@Test
	void printNestConsts() {
		System.out.println(CmnConsts.Parent.Child.TEST);
	}
}
