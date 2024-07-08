package com.mysite.C201sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SbbApplicationTests {

	@Autowired
	private QuestionRepository qr;
	
	@Test
	void testJpa() {
		
		//q1 객체 생성 및 설정
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에대해 알고싶습니");
		q1.setCreateDate(LocalDateTime.now());
		
		//q1을 db에 저장
		this.qr.save(q1);
		
		//q2 객체 생성 및 설정
		Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
		
        //q2을 db에 저장
      	this.qr.save(q2);
	}
}
