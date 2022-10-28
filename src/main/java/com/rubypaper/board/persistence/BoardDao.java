package com.rubypaper.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rubypaper.board.domain.BoardVO;

@Mapper
public interface BoardDao {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	
	void countCnt(BoardVO vo);
}
