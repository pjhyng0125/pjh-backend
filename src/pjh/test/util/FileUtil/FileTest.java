package pjh.test.util.FileUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

/**
 * 파일 관련 테스트
 */
class FileTest {
	final String FILE_NAME = "myName";
	final String writeStr = "This is sample txt file.";

	@Test
	void writeFileTest() {
		String filePath = FileUtil.getFullFilepath(FILE_NAME, CmnConsts.FILE_DIV.TXT);
		FileUtil.writeStrToFile(writeStr, filePath);
		
		assertTrue(FileUtil.isPathExists(filePath));
	}
	
	@Test
	void readFileTest() {
		writeFileTest();
		
		String filePath = FileUtil.getFullFilepath(FILE_NAME, CmnConsts.FILE_DIV.TXT);
		
		assertEquals(FileUtil.readFileToStr(filePath), writeStr);
	}
	
	@Test
	void renameFileTest() {
		writeFileTest();
		
		String oldStr = FILE_NAME;
		String newStr = "newFile";
		String oldPath = FileUtil.getFullFilepath(oldStr, CmnConsts.FILE_DIV.TXT);
		String newPath = FileUtil.renameFilepath(oldPath, oldStr, newStr);
		
		// Dir도 테스트 가능
		assertTrue(FileUtil.isPathExists(newPath));		
	}
}
