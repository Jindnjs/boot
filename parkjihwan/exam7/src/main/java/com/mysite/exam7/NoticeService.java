package com.mysite.exam7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	public void create(Notice notice) {
		noticeRepository.save(notice);	// 넣는다
	}
	
	public List<Notice> readlist() {	// 조회해서 가지고 나감
		return noticeRepository.findAll();	// 전체를 찾는다
	}
}
