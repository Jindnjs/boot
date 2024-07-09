package com.mysite.adminexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	/*
	 * BoardController로 이동
	 * 
	 * @GetMapping("/readlist") 
	 * public String readlist() {
	 * 	 return "readlist";
	 * }
	 */
}
