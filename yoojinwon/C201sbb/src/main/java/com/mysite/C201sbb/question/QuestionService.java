package com.mysite.C201sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.C201sbb.DataNotFoundException;
import com.mysite.C201sbb.answer.Answer;

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
	
	public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.qr.save(q);
    }
	public void delete(Integer id) {
    	Optional<Question> oq = qr.findById(id);
    	if(oq.isPresent()) {
    		Question a = oq.get();
    		qr.delete(a);
    	}
    }
}
