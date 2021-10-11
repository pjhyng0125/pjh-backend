package pjh.test.util.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

/**
 * 디렉토리 관련 테스트
 */
class DirTest {
	final String txtDirPath = CmnConsts.SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.TXT);
	
	@Test
	void getFileListFromDirTest() {
		assertNotNull(FileUtil.getFileNameListFromDir(txtDirPath));
	}
	
	@Test
	void getEmptyFileListFromDirTest() {
		assertNotNull(FileUtil.getFileNameListFromDir(""));
	}
	
	@Test
	void getNullFileListFromDirTest() {
		assertNotNull(FileUtil.getFileNameListFromDir(null));
	}
}
