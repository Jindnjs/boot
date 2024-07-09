package com.mysite.exam7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {

	@Autowired // Service로 던져주기 위해 객체 생성
	private NoticeService noticeService;

	@GetMapping("/") // "/"로 들어오면 내부에서 진행되는 과정을 거쳐서 return을 통해 readlist.html을 띄워준다(가져온 정보를 포함시켜서)
	public String index(Model model) {
		model.addAttribute("notices", noticeService.readlist()); // 조회한 readlist를 notices에 가지고 간다
		return "readlist";
	}

	@GetMapping("/create") // view에 던져주기 위해 mapping 필요
	public String create() { // DB에 던져주려면 입력을 받아야 함 -> 입력받는 화면을 띄워줌
		return "create"; // 생성하면 create으로 돌아간다
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Notice notice) {
		noticeService.create(notice);
		return "redirect:/";
	} // create과 update는 @GetMapping과 @PostMapping 쌍으로 작성한다.

	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
}

// DB에서 가져와서 클라이언트의 화면에 띄워주는 역할 -> @GetMapping
// 클라이언트가 DB에 보내주는 역할 -> @PostMapping