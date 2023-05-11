package com.itwillbs.test3_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.test3_mybatis.mapper.MyBatisMapper;
import com.itwillbs.test3_mybatis.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private MyBatisMapper mapper;
	
//	public int registBoard(BoardVO board) {
//		
////		System.out.println("BoardService - registBoard()");
//		
//		return mapper.insertBoard(board);
//	}
	
//	public int registBoard(BoardVO board) {
//		
//		int board_num = mapper.selectMaxBoardNum();
////		System.out.println(board_num);
//		
//		board.setBoard_num(board_num);
//		
//		return mapper.insertBoard(board);
//	}
	public int registBoard(BoardVO board) {
		
		return mapper.insertBoard2(board);
	}

	public List<BoardVO> getBoardList() {
//		System.out.println("getBoardList");
		
		
		return mapper.selectBoardList();
	}
	
}
