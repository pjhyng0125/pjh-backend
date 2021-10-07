package pjh.test.util.FileUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

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
