package com.rubypaper.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rubypaper.board.domain.JoinVO;

@Mapper
public interface JoinDao {
	List<JoinVO> getJoinList(JoinVO vo);
	List<JoinVO> getJoinId(JoinVO vo);
	JoinVO getJoinSeq(JoinVO vo);
}
