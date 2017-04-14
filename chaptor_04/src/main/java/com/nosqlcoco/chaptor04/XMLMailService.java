package com.nosqlcoco.chaptor04;

/**
 * 一个普通的类，由xml文件配置bean，需要在此类生成xmlMailConfig的setter/getter方法，否则会提示注入失败
 * @author nosqlcoco
 *
 */
public class XMLMailService {
	private XMLMailConfig xmlMailConfig;
	
	public String sendMail() {
		System.out.println("Create beans by xml file ");
		return xmlMailConfig.getUsername();
	}

	/**
	 * @return the xmlMailConfig
	 */
	public XMLMailConfig getXmlMailConfig() {
		return xmlMailConfig;
	}

	/**
	 * @param xmlMailConfig the xmlMailConfig to set
	 */
	public void setXmlMailConfig(XMLMailConfig xmlMailConfig) {
		this.xmlMailConfig = xmlMailConfig;
	}
}
