package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.JoinVO;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinDao dao;
	
	@Override
	public List<JoinVO> getJoinList(JoinVO vo) {
		return dao.getJoinList(vo);
	}

	@Override
	public List<JoinVO> getJoinId(JoinVO vo) {
		return dao.getJoinId(vo);
	}

	@Override
	public JoinVO getJoinSeq(JoinVO vo) {
		return dao.getJoinSeq(vo);
	}

}
