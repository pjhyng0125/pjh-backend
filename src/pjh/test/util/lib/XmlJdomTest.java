package pjh.test.util.lib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.FileUtil;
import pjh.cmn.util.JsonUtil;
import pjh.cmn.util.XmlUtil;
import pjh.vo.XmlContentVO;
import pjh.vo.XmlElementVO;
import pjh.vo.XmlVO;

/**
 * xml jdom 테스트
 */
class XmlJdomTest {
	XmlVO xVo = new XmlVO();
	void initSampleXmlData() {
		xVo.setXmlName("xmlSample");
		xVo.setRootName("root");
		xVo.setElementName("person");
		xVo.setElementAttrName("no");

		ArrayList<XmlContentVO> contentList = new ArrayList<>();
		contentList.add(XmlUtil.setXmlContent("name", "pjh"));
		contentList.add(XmlUtil.setXmlContent("gender", "man"));
		contentList.add(XmlUtil.setXmlContent("adress", "seoul"));
		contentList.add(XmlUtil.setXmlContent("height", "200"));
		XmlElementVO xEVO = XmlUtil.setXmlElement(contentList);
		
		ArrayList<XmlContentVO> contentList2 = new ArrayList<>();
		contentList2.add(XmlUtil.setXmlContent("name", "kms"));
		contentList2.add(XmlUtil.setXmlContent("gender", "man"));
		contentList2.add(XmlUtil.setXmlContent("adress", "jeju"));
		XmlElementVO xEVO2 = XmlUtil.setXmlElement(contentList2);
		
		ArrayList<XmlContentVO> contentList3 = new ArrayList<>();
		contentList3.add(XmlUtil.setXmlContent("name", "ysh"));
		contentList3.add(XmlUtil.setXmlContent("gender", "man"));
		XmlElementVO xEVO3 = XmlUtil.setXmlElement(contentList3);
		
		ArrayList<XmlElementVO> elementList = new ArrayList<>();
		elementList.add(xEVO);
		elementList.add(xEVO2);
		elementList.add(xEVO3);
		
		xVo.setXmlElementVOList(elementList);
	}

	@Test
	void createXmlTest() {
		initSampleXmlData();
		assertNotNull(FileUtil.isPathExists(XmlUtil.createXml(xVo)));
	}
	
	@Test
	void createElementNullTest() {
		XmlVO xVo = new XmlVO();
		XmlElementVO xEVO = XmlUtil.setXmlElement(null);
		ArrayList<XmlElementVO> elementList = new ArrayList<>();
		elementList.add(xEVO);
		xVo.setXmlElementVOList(elementList);
		assertNotNull(FileUtil.isPathExists(XmlUtil.createXml(xVo)));
	}
	
	@Test
	void createXmlNullTest() {
		assertEquals(XmlUtil.createXml(null), "");
	}
	
	@Test
	void readXmlTest() {
		XmlVO readXVo = new XmlVO();
		readXVo.setXmlName("xmlSample");
		readXVo.setElementName("person");
		List<String> list = XmlUtil.readXml(readXVo);
		assertEquals(list.size(), 9);
	}
	
	@Test
	void readXmlSearchElementTest() {
		XmlVO readXVo = new XmlVO();
		readXVo.setXmlName("xmlSample");
		readXVo.setElementName("person");
		readXVo.setSearchElementName("name");
		List<String> list = XmlUtil.readXml(readXVo);
		assertEquals(list.size(), 3);
	}
	
	@Test
	void readXmlNullTest() {
		assertNotNull(XmlUtil.readXml(null));
	}
	
	
	
}
