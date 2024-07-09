package com.mysite.adminexam;

import org.springframework.data.jpa.repository.JpaRepository;

// interface는 @Repository를 작성하지 않는다
public interface BoardRepository extends JpaRepository<Board, Integer> {

}

// CRUD를 위해 리포지터리 생성
// Jpa 리포지터리 상속