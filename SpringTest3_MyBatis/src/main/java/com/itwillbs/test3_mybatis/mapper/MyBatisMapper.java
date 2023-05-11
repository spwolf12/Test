package com.itwillbs.test3_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.test3_mybatis.vo.BoardVO;
import com.itwillbs.test3_mybatis.vo.MemberVO;

public interface MyBatisMapper {
	
	// 1.
	int insertBoard(BoardVO board);

	
	// 2.
	int selectMaxBoardNum();
	// ---------------------------------
	int insertBoard2(BoardVO board);
	
	// 3.
	MemberVO selectUser(@Param("id") String id, @Param("passwd") String passwd);
	
	// 4.
	int insertMember(MemberVO member);

	// 5.
	List<BoardVO> selectBoardList();
	
}
