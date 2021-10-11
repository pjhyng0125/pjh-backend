package pjh.test.util.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.FileUtil;

/**
 * 경로 유효성 확인 테스트
 */
class PathValidationTest {
	
	@Test
	void isPathEmptyTest() {		
		assertEquals(FileUtil.isPathExists(""), false);	
	}
	
	@Test
	void isPathNullTest() {
		assertEquals(FileUtil.isPathExists(null), false);
	}	
}
