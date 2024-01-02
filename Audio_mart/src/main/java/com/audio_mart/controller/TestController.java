package com.audio_mart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/message")
	@ResponseBody
	public String testByResponseBody() {
		String message = "테스트 중";
		return message;
	}
}
