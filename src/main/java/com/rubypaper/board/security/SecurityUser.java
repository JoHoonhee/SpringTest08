package com.rubypaper.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.board.domain.MemberVO;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;

	public SecurityUser(MemberVO member) {
		super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}

}
