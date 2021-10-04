package pjh.test.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

class FileUtilTest {
	final String txtFilePath = CmnConsts.SHARE_ROOT_PATH.concat(CmnConsts.TXT_FILE_DIV).concat(File.separator);
	final String fileName = "myName";
	final String writeStr = "PJH";
	

	@Test
	void writeFileTest() {
		String filePath = FileUtil.getFileDivPath(txtFilePath.concat(fileName));
		FileUtil.writeStrToFile(writeStr, filePath);
		
		assertTrue(FileUtil.isPathExists(filePath));
	}
	
	@Test
	void readFileTest() {
		writeFileTest();
		
		String filePath = FileUtil.getFileDivPath(txtFilePath.concat(fileName), CmnConsts.TXT_FILE_DIV);
		
		assertEquals(FileUtil.readFileToStr(filePath), writeStr);
	}
	
	@Test
	void renameFileTest() {
		writeFileTest();
		
		String oldStr = fileName;
		String newStr = "newFile";
		String oldPath = FileUtil.getFileDivPath(txtFilePath.concat(oldStr));
		String newPath = FileUtil.renameFilePath(oldPath, oldStr, newStr);
		
		// Dir도 테스트 가능
		assertTrue(FileUtil.isPathExists(newPath));		
	}

}
