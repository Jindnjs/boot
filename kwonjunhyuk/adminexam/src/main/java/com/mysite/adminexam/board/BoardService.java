package com.mysite.adminexam.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public void create(Board board) {
		/*
		 * Board board = new Board(); board.setTitle(title); board.setContent(content);
		 */

		board.setDate(LocalDateTime.now());
		boardRepository.save(board);
	}

	public List<Board> readlist() {
		return boardRepository.findAll();
	}

	public Board readdetail(Integer id) {

		Optional<Board> o = boardRepository.findById(id);

		return o.get();
	}

	public void delete(Integer id) {

		boardRepository.deleteById(id);

	}

	public void update(Board board) {

		boardRepository.save(board);
		
		
		//create랑 똑같은 코드라서 새롭게 만들거임 -> 주의사항 어떤 때에 적용이 되는지 -> 새로 계시물을 생성할 때도 save메서드를 사용했음에도 update에서도 동일한 상황임
		//중요한 점은 board객체에 id값을 함께 가져오면 update가 된다. 

	}
}
