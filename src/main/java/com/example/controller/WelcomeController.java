package com.example.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static final Logger logger =
		LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {

		logger.info("Spring logback logger.");

		logger.trace("Trace msg for logback");

		logger.debug("welcome () is executed, value {}", LocalDateTime.now().toString());

//		logger.error("This is Error message", new Exception("Testing"));

		model.addAttribute("msg", "Hello Spring MVC + Logback");
		return "welcome";

	}

}
