package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping
	@ResponseBody
	public String index() {
		return "welcome to sbb";
	}
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
