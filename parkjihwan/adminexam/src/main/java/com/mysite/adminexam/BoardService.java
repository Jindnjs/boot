package com.mysite.adminexam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository; // 보드 리포지터리에 던져주기 위해 리포지터리 객체 생성

	public void create(Board board) { // board 객체로 받음

		board.setDate(LocalDateTime.now());

		boardRepository.save(board); // board 객체에 저장된 정보를 저장
	}

	// 작성 위치 주의!! : BoardController - BoardService - BoardRepository
	public List<Board> readlist() { // 여러개를 가져가는 경우 List를 사용
		// Board에 있는 모든 정보를 가져간다
		return boardRepository.findAll();
	}
	
	public Board readdetail(Integer id) {
		// 하나 가지고 나갈 경우 반드시 Optional 사용해 예외처리
		Optional<Board> o = boardRepository.findById(id);
		
		return o.get();
	}
	
	public void delete(Integer id) {
		// 예외처리 할 필요 없이 그냥 삭제 -> 없는 것을 삭제해도 상관없음
		boardRepository.deleteById(id);
	}
	
	
	public void update(Board board) {// 수정할 것을 id가 아닌 객체로 가져온다
		
		boardRepository.save(board);	// create도 객체 가져와서 save, update도 객체 가져와서 save
		// !!주의!!	새로 게시물을 생성하는 경우에도 save메서드를 사용하고 update도 save메서드를 사용
		// 중요한 점은 그 객체(여기서는 board객체)에 id값이 있는지로 구분한다.
		// 새로 생성할 경우 title, content
		// update할 경우 id, title, content
	}
	

	/*
	 * ****BoardController에서 @ModelAttribute로 객체를 생성함****
	 * 
	 * public void create(String title, String content) { // title, content 던져주기 -> id값을 입력하지 않았으니까 create
	 * 
	 * Board board = new Board(); // board 객체 생성
	 * 
	 * board.setTitle(title); board.setContent(content);
	 * board.setDate(LocalDateTime.now()); boardRepository.save(board); // board 객체에
	 * 저장된 title, content, date를 저장 }
	 *
	 */
}
