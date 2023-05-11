package com.itwillbs.test3_mybatis.vo;

import java.sql.Timestamp;

/*
 mvc_board3.board 테이블 생성
 ------------------------------------
 글번호(board_num) : 정수, PK
 작성자(board_name) : 문자 20글자, NN
 패스워드(board_pass) : 문자 16글자, NN
 제목(board_subject) : 문자 50글자, NN
 내용(board_content) : 문자 2000글자, NN
 파일명(board_file) : 문자 50글자, NN
 참조글번호(board_re_ref) : 정수, NN
 들여쓰기레벨(board_re_lev) : 정수, NN
 순서번호(board_re_seq) : 정수, NN
 조회수(board_readcount) : 정수, NN
 작성일(board_date) : 날짜 및 시각(DATETIME), NN
 --------------------------------------
 CREATE TABLE board (
	board_num INT PRIMARY KEY,
	board_name VARCHAR(20) NOT NULL,
	board_pass VARCHAR(16) NOT NULL,
	board_subject VARCHAR(50) NOT NULL,
	board_content VARCHAR(2000) NOT NULL,
	board_file VARCHAR(200) NOT NULL,
	board_re_ref INT NOT NULL,
	board_re_lev INT NOT NULL,
	board_re_seq INT NOT NULL,
	board_readcount INT NOT NULL,
	board_date DATETIME
 );
 */
public class BoardVO {
	// board 테이블의 각 컬럼에 대응하는 멤버변수 선언 및 Getter/Setter 정의
	private int board_num;
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int board_readcount;
	private Timestamp board_date; // java.sql.TimeStamp(날짜 및 시각 관리)
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int board_num, String board_name, String board_pass, String board_subject, String board_content,
			String board_file, int board_re_ref, int board_re_lev, int board_re_seq, int board_readcount,
			Timestamp board_date) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_file = board_file;
		this.board_re_ref = board_re_ref;
		this.board_re_lev = board_re_lev;
		this.board_re_seq = board_re_seq;
		this.board_readcount = board_readcount;
		this.board_date = board_date;
	}




	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_pass() {
		return board_pass;
	}
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getBoard_re_ref() {
		return board_re_ref;
	}
	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	public int getBoard_re_lev() {
		return board_re_lev;
	}
	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	public int getBoard_re_seq() {
		return board_re_seq;
	}
	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	@Override
	public String toString() {
		return "BoardBean [board_num=" + board_num + ", board_name=" + board_name + ", board_pass=" + board_pass
				+ ", board_subject=" + board_subject + ", board_content=" + board_content + ", board_file=" + board_file
				+ ", board_re_ref=" + board_re_ref + ", board_re_lev=" + board_re_lev + ", board_re_seq=" + board_re_seq
				+ ", board_readcount=" + board_readcount + ", board_date=" + board_date + "]";
	}
	
}









