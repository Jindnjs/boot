package com.mysite.C201sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	//주제 이름으로 검색하기 위해 만든 메서드
	//
	Question findBySubject(String subject);
}
