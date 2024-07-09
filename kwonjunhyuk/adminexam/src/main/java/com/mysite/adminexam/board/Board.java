package com.mysite.adminexam.board;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.adminexam.reply.Reply;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	
	private String content;
	
	private LocalDateTime date;
	
	
	@OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
	private List<Reply> replyList;
	//이렇게 id, date는 필수적으로 들어가야된다고 함
}
