package pjh.cmn.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import pjh.cmn.consts.CmnConsts;
import pjh.vo.PdfVO;

/**
 * itextpdf-5.2.1.jar
 */
public class PdfUtil {
	private static Font largeFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font mediumFont = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
	private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font diffFont = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

	/**
	 * 인스턴스화 방지
	 */
	private PdfUtil() throws InstantiationException {
		throw new InstantiationException();
	}

	/**
	 * PDF 생성 (이미 존재하면 덮어쓰기)
	 * @param PdfVO PDF 생성 정보
	 * @return void
	 * 
	 */
	@SuppressWarnings("hiding")
	public static void createPdf(PdfVO pVo) {
		String pdfFileName = pVo.getPdfName();
		String pdfFilePath = FileUtil.getFullFilepath(pdfFileName, CmnConsts.FILE_DIV.PDF);
		Document document = new Document();
		Paragraph paragraph = new Paragraph();
		ArrayList<String> tableHeaderList = pVo.getTableHeaderList();
		PdfPTable table = new PdfPTable(tableHeaderList.size());
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
			document.open();
			addMetaData(document, pVo);
			addTitle(paragraph, pVo.getTitle());
			addMessage(paragraph, pVo.getMsg());
			addImg(paragraph, pVo.getImgName(), pVo.getImgType());
			addTableHeader(table, tableHeaderList);
			addTableRows(table, pVo.getTableRowsList());
			paragraph.add(table);
			document.add(paragraph);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("다른 프로세스가 [" + pdfFileName + "] 파일을 사용 중이기 때문에 프로세스가 액세스 할 수 없습니다");
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * PDF 메타 데이터 추가
	 * @param Document
	 * @param PdfVO PDF 생성 정보
	 * @return void
	 * 
	 */
	private static void addMetaData(Document document, PdfVO pVo) {
		document.addTitle(pVo.getPdfName());
		document.addSubject(pVo.getSubject());
		document.addKeywords(pVo.getKeywords());
		document.addAuthor(pVo.getCreator());
		document.addCreator(pVo.getCreator());
	}

	/**
	 * PDF 제목 추가
	 * @param Paragraph
	 * @param String 제목
	 * @return void
	 * 
	 */
	private static void addTitle(Paragraph paragraph, String title) {
		addEmptyLine(paragraph, 1);
		paragraph.add(new Paragraph(new Chunk(title, diffFont)));
		addEmptyLine(paragraph, 1);
		paragraph.add(new Paragraph(title, largeFont));
	}

	/**
	 * PDF 출력 텍스트 추가
	 * @param Paragraph
	 * @param String 출력 텍스트
	 * @return void
	 * 
	 */
	private static void addMessage(Paragraph paragraph, String msg) {
		addEmptyLine(paragraph, 2);
		paragraph.add(new Paragraph(msg, mediumFont));
		addEmptyLine(paragraph, 2);
		paragraph.add(new Paragraph(msg, smallFont));
		addEmptyLine(paragraph, 2);
		paragraph.add(new Paragraph(msg, redFont));
	}

	/**
	 * PDF 이미지 추가
	 * 
	 * @param Paragraph paragraph
	 * @param String 이미지 파일명
	 * @param String 이미지 파일 확장자
	 * @return void
	 * 
	 */
	private static void addImg(Paragraph paragraph, String imgName, String imgType) {
		addEmptyLine(paragraph, 3);
		String imgPath = FileUtil.getFullFilepath(imgName, imgType); // TODO: IMG 타입 예외처리
		Image img;
		try {
			img = Image.getInstance(imgPath);
			img.scalePercent(30);
			paragraph.add(img);
			addEmptyLine(paragraph, 4);
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * PDF 테이블 헤더 추가
	 * @param PdfPTable
	 * @param ArrayList<String> 테이블 헤더 리스트
	 * @return void
	 * 
	 */
	private static void addTableHeader(PdfPTable table, ArrayList<String> tableHeaderList) {
		tableHeaderList.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			// .setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(header);
		});
	}

	/**
	 * PDF 테이블 열 추가
	 * @param PdfPTable
	 * @param ArrayList<ArrayList<String>> 테이블 열 리스트
	 * @return void
	 * 
	 */
	private static void addTableRows(PdfPTable table, ArrayList<ArrayList<String>> tableRowList) {
		tableRowList.forEach(rowList -> {
			for (int colCnt = 0; colCnt < rowList.size(); colCnt++) {
				table.addCell(rowList.get(colCnt));				
			}
		});
	}
	
	/**
	 * PDF 공백 줄 추가
	 * @param Paragraph
	 * @param int 공백 줄 개수
	 * @return void
	 * 
	 */
	private static void addEmptyLine(Paragraph paragraph, int lineCnt) {
		for (int i = 0; i < lineCnt; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	/**
	 * PDF 파일 비밀번호 설정 (파일명: PDF원본파일명_비밀번호
	 * @param String PDF원본파일명
	 * @param String 비밀번호
	 * @return void
	 * 
	 */
	public static String setPasswordPdf(String oldPdfFileName, String password) {
		PdfStamper stamper = null;
		PdfReader reader = null;
		String pdfFilePath = FileUtil.getFullFilepath(oldPdfFileName, CmnConsts.FILE_DIV.PDF);
		String newPdfFilePath = "";
		if (FileUtil.isPathExists(pdfFilePath)) {
			String newPdfFileName = oldPdfFileName.concat("_").concat(password);
			newPdfFilePath =  FileUtil.getFullFilepath(newPdfFileName, CmnConsts.FILE_DIV.PDF);
			try {
				reader = new PdfReader(pdfFilePath);
				stamper = new PdfStamper(reader, new FileOutputStream(newPdfFilePath));
				stamper.setEncryption(password.getBytes(), null, 0, PdfWriter.ENCRYPTION_AES_256);
				stamper.close();
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		return newPdfFilePath;
	}
}