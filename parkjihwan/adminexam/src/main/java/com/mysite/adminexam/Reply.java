package com.mysite.adminexam;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가되는 번호
	private Integer id;

	private String content;

	private LocalDateTime date;

	@ManyToOne
	private Board board;

}
