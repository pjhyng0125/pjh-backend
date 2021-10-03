package pjh.test.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

class TestFileUtil {

	@Test
	void writeFileTest() {
		String fileName = "fileName";
		String path = CmnConsts.PJT_ROOT_PATH.concat(fileName);
		FileUtil.writeStrToFile("[Junit5] FileUtil write 테스트 중입니다!", path);
		assertTrue(FileUtil.isPathExists(path));
	}

}
