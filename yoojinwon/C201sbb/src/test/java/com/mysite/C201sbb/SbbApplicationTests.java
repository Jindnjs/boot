package com.mysite.C201sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.C201sbb.answer.Answer;
import com.mysite.C201sbb.answer.AnswerRepositoty;
import com.mysite.C201sbb.question.Question;
import com.mysite.C201sbb.question.QuestionRepository;

@SpringBootTest
public class SbbApplicationTests {

	@Autowired
	private QuestionRepository qr;
	@Autowired
	private AnswerRepositoty ar;
	
    @Transactional

	@Test
	void testJpa() {
		
		//디비에서 검색하는 코드
		//Optional을 쓰는 이유
		//1개를 꺼내올때 사용한다.
		//만약 꺼내오는 값이 없어서 null이 리턴된다면 (this.qr.findById(1);에서),
		//오류가 발생하기 때문에 optional객체로 우선 받아온다.
		
//		Optional<Question> oq = this.qr.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
		
		//제목으로 검색하는 코드
//		Question q2 = this.qr.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q2.getId());
		
		//삭제하는 코드
		//삭제전 총 갯수 확인
//		assertEquals(2,this.qr.count());
//		//get single Question where id = 1
//		Optional<Question> oq = this.qr.findById(1);
//		//check oq is valid
//		assertTrue(oq.isPresent());
//		//delete q where id = 1
//		Question q = oq.get();
//		this.qr.delete(q);
//		assertEquals(1, this.qr.count());
		
		//답변생성
//		Optional<Question> oq = this.qr.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.ar.save(a);
		
//		//답변 검색
//		Optional<Answer> oa = this.ar.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());
		
		//질문을 통한 답변 검색
		Optional<Question> oq = this.qr.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
        
        
		
	}
}
