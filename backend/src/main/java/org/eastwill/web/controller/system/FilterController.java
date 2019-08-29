package org.eastwill.web.controller.system;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
public class FilterController {
	
	@GetMapping("/testc")
	public String test() {
		log.info("testc===================");
		return "testc";
	}
}
