package com.packt.cardatabase.domain.car.web;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

	@RequestMapping("/env")
	public @ResponseBody Map<String, String> env() {
		return System.getenv();
	}
}
