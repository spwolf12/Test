package com.itwillbs.test3_mybatis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.test3_mybatis.service.BoardService;
import com.itwillbs.test3_mybatis.service.MemberService;
import com.itwillbs.test3_mybatis.vo.BoardVO;
import com.itwillbs.test3_mybatis.vo.MemberVO;

@Controller
public class MyBatisController {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/main")
	public String main() {
		
		return "main";
	}
	@GetMapping(value = "/Newfile")
	public String Newfile() {
		
		return "Newfile";
	}
	
//	@RequestMapping(value = "/login.me", method = {RequestMethod.GET, RequestMethod.POST})
//	public String loginForm() {
//		return "login_form";
//	}
	
	@GetMapping(value = "/login.me")
	public String loginForm() {
		return "login_form";
	}
	
	@PostMapping(value = "/loginPro.me")
	public String loginPro(@RequestParam String id, @RequestParam String passwd, HttpSession session, Model model) {
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		
		MemberVO member = memberService.checkUser(id, passwd);
		System.out.println(member);
		
		if(member == null) {
			System.out.println("로그인 실패!");
			
			model.addAttribute("msg", "로그인 실패!");
			
			return "fail_back";
		} else {
			System.out.println("로그인 성공!");
			
			session.setAttribute("sId", id);
			
			return "redirect:/main";
		}
		
	}
	
//	@RequestMapping(value = "/write.bo", method = {RequestMethod.GET, RequestMethod.POST})
//	public String writeForm() {
//		return "write_form";
//	}
	@GetMapping(value = "/write.bo")
	public String writeForm() {
		return "write_form";
	}
	
	@PostMapping(value = "/writePro.bo")
	public String writePro(BoardVO board) {
//		System.out.println(board);
		
//		BoardService service = new BoardService();
		
		
		int insertCount = boardService.registBoard(board);
		
		return "redirect:/list.bo";
	}
	
//	@RequestMapping(value = "/list.bo", method = {RequestMethod.GET, RequestMethod.POST})
//	public String list() {
//		return "board_list";
//	}
	@GetMapping(value = "/list.bo")
	public String list(Model model) {
		List<BoardVO> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		return "board_list";
	}
	
	@GetMapping(value = "/join.me")
	public String joinForm() {
		return "join_form";
	}

	@PostMapping(value = "/joinPro.me")
	public String joinPro(MemberVO member, @RequestParam String email1, @RequestParam String email2, Model model) {
//		System.out.println(member);
//		System.out.println(email1);
//		System.out.println(email2);
		
		member.setEmail(email1 + "@" + email2);
		
		int insertCount = memberService.registMember(member);
		
		if(insertCount > 0) {
			return "redirect:/main";
		} else {
			model.addAttribute("msg", "회원 가입 실패!");
			return "fail_back";
			
		}
		
	}
	
	@GetMapping(value = "logout.me")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
}
