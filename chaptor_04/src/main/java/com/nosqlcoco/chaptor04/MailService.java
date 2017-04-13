package com.nosqlcoco.chaptor04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nosqlcoco
 *
 */
@Component
public class MailService {
	@Autowired
	private MailConfig mailConfig;
	
	public String sendMail() {
		System.out.println("Create beans by annotation ");
		return mailConfig.getUsername();
	}
}
