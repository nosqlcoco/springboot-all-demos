package com.nosqlcoco.chaptor04;

/**
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
