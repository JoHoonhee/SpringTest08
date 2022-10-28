package com.rubypaper.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class JoinVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	private String id;
	private String password;
	private String name;
	private Role role;
	private String enabled;
	
	private String searchCondition;
	private String searchKeyword;
}
