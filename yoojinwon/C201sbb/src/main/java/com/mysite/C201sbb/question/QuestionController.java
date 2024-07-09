package com.mysite.C201sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService qs;

    @GetMapping("/list")
    //Model은 컨트롤러에서 뷰(htm)로 데이터를 전송하기위한 방법
    public String list(Model model) {
        List<Question> questionList = this.qs.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    	Question question = this.qs.getQuestion(id);
        model.addAttribute("question", question);
    	return "question_detail";
    }
//	
    @GetMapping("/create")
    public String create() {
    	return "question_create";
    }
    
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
    	this.qs.create(subject, content);
    	
    	return "redirect:/question/list";
    }
    @GetMapping("/delete")
    public String deleteQuestion(@PathVariable("id") Integer id) {
    	qs.delete(id);
    	return "redirect:/question/list";
    }
//	@GetMapping("/question/list")
//    public String list() {
//        return "question_list";
//    }
}
