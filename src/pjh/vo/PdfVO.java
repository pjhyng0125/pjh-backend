package pjh.vo;

import java.util.ArrayList;

/**
 * PDF 생성 정보
 */
public class PdfVO {
	/* 파일명 */
	private String pdfName;
	/* 제목 */
	private String title;
	/* 메타데이터 - 주제 */
	private String subject;
	/* 메타데이터 - 키워드 */
	private String keywords;
	/* 메타데이터 - 생성자 */
	private String creator;
	/* 이미지 파일명 */
	private String imgName;
	/* 이미지 파일 확장자 */
	private String imgType;
	/* 출력 텍스트 */
	private String msg;
	/* 테이블 헤더 리스트 */
	private ArrayList<String> tableHeaderList;
	/* 테이블 열 리스트 */
	private ArrayList<ArrayList<String>> tableRowsList;
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ArrayList<String> getTableHeaderList() {
		return tableHeaderList;
	}
	public void setTableHeaderList(ArrayList<String> tableHeaderList) {
		this.tableHeaderList = tableHeaderList;
	}
	public ArrayList<ArrayList<String>> getTableRowsList() {
		return tableRowsList;
	}
	public void setTableRowsList(ArrayList<ArrayList<String>> tableRowsList) {
		this.tableRowsList = tableRowsList;
	}
	
}
