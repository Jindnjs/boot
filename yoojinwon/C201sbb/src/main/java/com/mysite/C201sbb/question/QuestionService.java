package com.mysite.C201sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.C201sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository qr;
	
	public List<Question> getList(){
		return this.qr.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> q = this.qr.findById(id);
		if (q.isPresent()) {
            return q.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
	}
}
