package com.mysite.C201sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionRepository qr;

    @GetMapping("/question/list")
    //Model은 컨트롤러에서 뷰(htm)로 데이터를 전송하기위한 방법
    public String list(Model model) {
        List<Question> questionList = this.qr.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
//	
//	@GetMapping("/question/list")
//    public String list() {
//        return "question_list";
//    }
}
