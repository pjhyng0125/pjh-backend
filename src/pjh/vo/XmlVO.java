package pjh.vo;

import java.util.ArrayList;

/**
 * XML 생성 정보
 */
public class XmlVO {
	/* 파일명 */
	private String xmlName;
	/* 루트명 */
	private String rootName;
	/* 요소명 */
	private String elementName;
	/* 요소속성명 */
	private String elementAttrName;
	/* 탐색요소명 */
	private String searchElementName;
	/* 요소속성명 */
	private ArrayList<XmlElementVO> xmlElementVOList;

	public String getXmlName() {
		return xmlName;
	}

	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementAttrName() {
		return elementAttrName;
	}

	public void setElementAttrName(String elementAttrName) {
		this.elementAttrName = elementAttrName;
	}

	public ArrayList<XmlElementVO> getXmlElementVOList() {
		return xmlElementVOList;
	}

	public void setXmlElementVOList(ArrayList<XmlElementVO> xmlElementVOList) {
		this.xmlElementVOList = xmlElementVOList;
	}

	public String getSearchElementName() {
		return searchElementName;
	}

	public void setSearchElementName(String searchElementName) {
		this.searchElementName = searchElementName;
	}
	
}
