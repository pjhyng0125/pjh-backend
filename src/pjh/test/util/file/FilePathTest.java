package pjh.test.util.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

/**
 * 파일절대경로 반환 테스트
 */
class FilePathTest {
	final String TXT = CmnConsts.FILE_DIV.TXT;
	final String JSON = CmnConsts.FILE_DIV.JSON;
	final String PDF = CmnConsts.FILE_DIV.PDF;
	final String PNG = CmnConsts.FILE_DIV.PNG;
	final String JPG = CmnConsts.FILE_DIV.JPG;

	@Test
	void getTxtFullFilePath() {
		String txtFullFilepath = FileUtil.getFullFilepath("myName", TXT);
		System.out.println("txtFullFilepath: " + txtFullFilepath);
		
		assertTrue(FileUtil.isPathExists(txtFullFilepath));
	}
	
	@Test
	void getPdfFullFilePath() {
		String pdfFullFilepath = FileUtil.getFullFilepath("sample", PDF);
		System.out.println("pdfFullFilepath: " + pdfFullFilepath);
		
		assertTrue(FileUtil.isPathExists(pdfFullFilepath));
	}
	
	@Test
	void getJpgFullFilePath() {
		String jpgFullFilepath = FileUtil.getFullFilepath("sample", JPG);
		System.out.println("jpgFullFilepath: " + jpgFullFilepath);
		
		assertTrue(FileUtil.isPathExists(jpgFullFilepath));
	}
	
	@Test
	void getEmptyFullFilePath() {
		String emptyFullFilepath = FileUtil.getFullFilepath("", "");
		System.out.println("emptyFullFilepath: " + emptyFullFilepath);
		
		assertFalse(FileUtil.isPathExists(emptyFullFilepath));
	}
	
	@Test
	void getNullFullFilePath() {
		String nullFullFilepath = FileUtil.getFullFilepath(null, null);
		System.out.println("nullFullFilepath: " + nullFullFilepath);
		
		assertFalse(FileUtil.isPathExists(nullFullFilepath));
	}
}
