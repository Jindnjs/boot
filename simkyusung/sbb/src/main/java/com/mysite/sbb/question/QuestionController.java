package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	@Autowired
	private final QuestionRepository questionRepository;

	@GetMapping("/question/list")
	public String list(Model model) {
		List<Question> questionList=this.questionRepository.findAll();
		model.addAttribute("questionList",questionList);
		return "question_list";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
