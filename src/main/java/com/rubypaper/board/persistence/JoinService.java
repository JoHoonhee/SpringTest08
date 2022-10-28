package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.JoinVO;

public interface JoinService {
	List<JoinVO> getJoinList(JoinVO vo);
	List<JoinVO> getJoinId(JoinVO vo);
	JoinVO getJoinSeq(JoinVO vo);
}
