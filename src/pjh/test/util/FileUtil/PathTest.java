package pjh.test.util.FileUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.FileUtil;

class PathTest {
	
	@Test
	void isPathEmptyTest() {		
		assertEquals(FileUtil.isPathExists(""), false);	
	}
	
	@Test
	void isPathNullTest() {
		assertEquals(FileUtil.isPathExists(null), false);
	}	
}
