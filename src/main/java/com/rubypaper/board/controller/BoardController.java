package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private JoinServiceImpl joinService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(JoinVO vo, Model model) {
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("title");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		model.addAttribute("li", joinService.getJoinList(vo));
		return "board/getBoardList.html";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(JoinVO vo, Model model) {
		model.addAttribute("vo", joinService.getJoinSeq(vo));
		return "board/getBoard.html";
	}
	
	@RequestMapping("/formBoard.do")
	public String formBoard() {
		return "board/formBoard.html";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
}
