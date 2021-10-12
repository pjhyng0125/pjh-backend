package pjh.cmn.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import pjh.cmn.consts.CmnConsts;
import pjh.vo.XmlContentVO;
import pjh.vo.XmlElementVO;
import pjh.vo.XmlVO;

public class XmlUtil {
	/**
	 * 인스턴스화 방지
	 */
	private XmlUtil() throws InstantiationException {
		throw new InstantiationException();
	}

	/**
	 * xml 파일 생성
	 * 
	 * @param XmlVO
	 * @return String
	 * 
	 */
	public static String createXml(XmlVO xVo) {
		String xmlFilePath = "";
		if (TypeUtil.isNotNull(xVo) && TypeUtil.isNotNull(xVo.getRootName())) {
			xmlFilePath = FileUtil.getFullFilepath(xVo.getXmlName(), CmnConsts.FILE_DIV.XML);
			Element root = new Element(xVo.getRootName());
			Document document = new Document(root);
			ArrayList<XmlElementVO> eList = xVo.getXmlElementVOList();

			for (int i = 0; i < eList.size(); i++) {
				Element e = new Element(xVo.getElementName());
				e.setAttribute(new Attribute(xVo.getElementAttrName(), Integer.toString(i + 1)));
				ArrayList<XmlContentVO> cList = eList.get(i).getXmlContentVOList();
				for (XmlContentVO content : cList) {
					e.addContent(new Element(content.getTag()).setText(content.getContent()));
				}
				document.getRootElement().addContent(e);
			}

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			try {
				xmlOutput.output(document, new FileWriter(xmlFilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return xmlFilePath;
	}

	public static XmlContentVO setXmlContent(String tag, String content) {
		XmlContentVO xCVO = new XmlContentVO();
		xCVO.setTag(StringUtil.nvl(tag));
		xCVO.setContent(StringUtil.nvl(content));
		return xCVO;
	}

	public static XmlElementVO setXmlElement(ArrayList<XmlContentVO> cList) { // TODO: null 예외처리
		XmlElementVO xEVO = new XmlElementVO();
		xEVO.setXmlContentVOList(cList);
		return xEVO;
	}

	public static List<String> readXml(XmlVO xVo) {
		List<String> readXmlList = new ArrayList<>();
		if (TypeUtil.isNotNull(xVo)) {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(FileUtil.getFullFilepath(xVo.getXmlName(), CmnConsts.FILE_DIV.XML));
			Document document;
			try {
				document = (Document) builder.build(xmlFile);
				Element rootNode = document.getRootElement();
				List<Element> eList = rootNode.getChildren(xVo.getElementName());
				String rName = xVo.getSearchElementName();
				for (Element element : eList) {
					for (int i = 0; i < element.getChildren().size(); i++) {
						String eName = element.getChildren().get(i).getName();
						String eText = element.getChildText(eName);
						if (StringUtil.isEmptyTrim(rName)) {
							readXmlList.add(eName.concat(",".concat(eText)));
						} else if (rName.equals(eName)) {
							readXmlList.add(eText);
						}
					}
				}
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return readXmlList;
	}
}