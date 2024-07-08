package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepostiory;

	/*@Test
	void testJpa() {
		 Question q1 = new Question();
	     q1.setSubject("sbb가 무엇인가요?");
	     q1.setContent("sbb에 대해서 알고 싶습니다.");
	     q1.setCreateDate(LocalDateTime.now());
	     this.questionRepository.save(q1);  // 첫번째 질문 저장

	     Question q2 = new Question();
	     q2.setSubject("스프링부트 모델 질문입니다.");
	     q2.setContent("id는 자동으로 생성되나요?");
	     q2.setCreateDate(LocalDateTime.now());
	     this.questionRepository.save(q2);  // 두번째 질문 저장
	}
	
	@Test
	void testJpa() {
		List<Question> all=this.questionRepository.findAll();
		assertEquals(2,all.size());
		
		Question q=all.get(0);
		assertEquals("sbb가 무엇인가요?",q.getSubject());
	}

	@Test
	void testJpa() {
		Optional<Question> oq=this.questionRepository.findById(1);
		
		if(oq.isPresent()) {
			Question q=oq.get();
			assertEquals("sbb가 무엇인가요?",q.getSubject());
		}
	}
	
	@Test
	void testJpa() {
		Question q=this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1,q.getId());
	}
	
	@Test
	void testJpa() {
		Question q=this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
		assertEquals(1,q.getId());
	}
	
	@Test
	void testJpa() {
		assertEquals(2,this.questionRepository.count());
		Optional<Question> oq=this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q=oq.get();
		this.questionRepository.delete(q);
		assertEquals(1,this.questionRepository.count());
	}
	
	@Test
	void testJpa() {
		Optional<Question> oq=this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q=oq.get();
		
		Answer a=new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);	//어떤 질문의 답변인지 알기위해 Question 객체 필요
		a.setCreateDate(LocalDateTime.now());
		this.answerRepostiory.save(a);
	}
	
	@Test
	void testJpa() {
		Optional<Answer> oa=this.answerRepostiory.findById(1);
		assertTrue(oa.isPresent());
		Answer a=oa.get();
		assertEquals(2,a.getQuestion().getId());
	}*/
	
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq=this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q=oq.get();
		
		List<Answer> answerList=q.getAnswerList();
		
		assertEquals(1,answerList.size());
		assertEquals("네 자동으로 생성됩니다.",answerList.get(0).getContent());
	}
}
