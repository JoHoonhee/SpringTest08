package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.MemberVO;

public interface MemberService {
	void insertMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	void updateMember(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
}
