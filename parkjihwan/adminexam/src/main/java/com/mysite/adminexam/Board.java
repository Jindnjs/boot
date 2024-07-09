package com.mysite.adminexam;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data // Outline에서 getter, setter 생성되었는지 확인 (lombok이 있어야 함)
@Entity // DB에 연결해서 테이블 생성 (이미 존재한다면 생성하지 않음)
public class Board {

	@Id // key를 붙여주는 개념
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가되는 번호
	private Integer id;

	// @Column(length=200)
	private String title;

	// @Column(columnDefinition="TEXT")
	private String content;

	private LocalDateTime date;

	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE) // 앞자리(One)가 '나'="board" , REMOVE = board가 삭제되면 연결된
																	// reply도 삭제해라
	private List<Reply> replyList; // 가져오려는 곳
}
