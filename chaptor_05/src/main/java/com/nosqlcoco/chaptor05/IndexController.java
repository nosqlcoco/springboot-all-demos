package com.nosqlcoco.chaptor05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		return "Hello World";
	}
}
