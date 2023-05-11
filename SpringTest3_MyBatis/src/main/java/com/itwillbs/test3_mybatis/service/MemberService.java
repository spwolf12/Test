package com.itwillbs.test3_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.test3_mybatis.mapper.MyBatisMapper;
import com.itwillbs.test3_mybatis.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	public MyBatisMapper mapper;

	public MemberVO checkUser(String id, String passwd) {
//		System.out.println("checkUser()");
		
		
		return mapper.selectUser(id, passwd);
	}

	public int registMember(MemberVO member) {
//		System.out.println("registMember");
		
		return mapper.insertMember(member);
	}
	
	
	
	
}
