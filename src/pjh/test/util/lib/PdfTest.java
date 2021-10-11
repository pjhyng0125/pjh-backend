package pjh.test.util.lib;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;
import pjh.cmn.util.PdfUtil;
import pjh.vo.PdfVO;

/**
 * 디렉토리 관련 테스트
 */
class PdfTest {
	String FILE_NAME = "sample";
	
	PdfVO initPdfSampleData() {
		PdfVO pVo = new PdfVO();
		ArrayList<String> headerList = new ArrayList<>();
		headerList.add("header1");
		headerList.add("header2");
		headerList.add("header3");
		ArrayList<String> row1List = new ArrayList<>();
		row1List.add("row1 - col1");
		row1List.add("row1 - col2");
		row1List.add("row1 - col3");
		ArrayList<String> row2List = new ArrayList<>();
		row2List.add("row2 - col1");
		row2List.add("row2 - col3");
		row2List.add("row2 - col2");
		ArrayList<String> row3List = new ArrayList<>();
		row3List.add("row3 - col1");
		row3List.add("row3 - col2");
		row3List.add("row3 - col3");
		ArrayList<ArrayList<String>> rowsList = new ArrayList<>();
		rowsList.add(row1List);
		rowsList.add(row2List);
		rowsList.add(row3List);
		pVo.setPdfName(FILE_NAME);
		pVo.setTitle("title");
		pVo.setSubject("itextpdf");
		pVo.setKeywords("Java, PDF");
		pVo.setCreator("pjh");
		pVo.setImgName("sample");
		pVo.setImgType(CmnConsts.FILE_DIV.PNG);
		pVo.setMsg("This document is smaple pdf.");
		pVo.setTableHeaderList(headerList);
		pVo.setTableRowsList(rowsList);
		return pVo;
	}
	
	@Test
	void createPdfSampleTest() {
		PdfVO samplePdfVo = initPdfSampleData();
		PdfUtil.createPdf(samplePdfVo);
		assertTrue(FileUtil.isPathExists(FileUtil.getFullFilepath(samplePdfVo.getPdfName(), CmnConsts.FILE_DIV.PDF)));
	}
	
	@Test
	void setPasswordPdfTest() {
		String password = "123456";
		assertTrue(FileUtil.isPathExists(PdfUtil.setPasswordPdf(FILE_NAME, password)));		
	}
}
