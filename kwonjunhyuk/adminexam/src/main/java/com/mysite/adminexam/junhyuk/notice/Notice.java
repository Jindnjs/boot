package com.mysite.adminexam.junhyuk.notice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.mysite.adminexam.junhyuk.comment.Comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	
	private String content;
	
	private LocalDateTime date;
	
	private String list;

	@OneToMany(mappedBy = "notice",cascade = CascadeType.REMOVE)
	private List<Comment> commentList;
	
}