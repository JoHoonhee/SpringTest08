package com.rubypaper.board.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.MemberDao;

@Service
public class BoardUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = new MemberVO();
		member.setId(username);
		MemberVO user = dao.getMember(member);
		// 로그인 정보를 이용하기 위한 세션처리
		session.setAttribute("member", user);
		if(user == null) {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		} else {
			return new SecurityUser(user);
		}
	}

}
