package com.mysite.adminexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; // 줄32) boardService.create(board)를 사용하기 위해 boardService 객체 생성

	@GetMapping("/readlist")
	public String readlist(Model model) {

		model.addAttribute("boards", boardService.readlist()); // 하나만 가져가면 board 여러개면 boards (여려개면 s붙이기)
		return "readlist";
	}

	@GetMapping("/create") // getmapping 띄워주고
	public String create() {
		return "create";
	}

	@PostMapping("/create") // postmapping 받아주고
	public String create(@ModelAttribute Board board) { // @ModelAttribute로 board 객체로 받아서
		boardService.create(board); // 객체로 던져줌
		// 목록으로 돌아가도록 redirect:목적지
		return "redirect:/board/readlist";
	}

	@GetMapping("/readdetail/{id}")
	public String readdetail(Model model, @PathVariable ("id") Integer id) {	// view로 가져가기 위해 Model model
		// 
		model.addAttribute("board", boardService.readdetail(id));
		return "readdetail";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable ("id") Integer id) {
		
		boardService.delete(id);
		
		return "redirect:/board/readlist";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable ("id") Integer id) {
		// create와는 다른 부분
		model.addAttribute("board", boardService.readdetail(id));
		
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.update(board); // 객체로 던져줌
		
		return "redirect:/board/readlist";
	}
}
