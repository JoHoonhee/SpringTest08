package com.rubypaper.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@Controller
@RequestMapping("/board/")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private JoinServiceImpl joinService;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("/getMemberList.do")
	public String getMemberList(MemberVO vo, Model model) {
		model.addAttribute("li", memberService.getMemberList(vo));
		return "board/getMemberList.html";
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo) {
		BoardVO b = new BoardVO();
		JoinVO j = new JoinVO();
		j.setId(vo.getId());
		List<JoinVO> li = joinService.getJoinId(j);
		for (JoinVO v : li) {
			b.setSeq(v.getSeq());
			boardService.deleteBoard(b);
		}
		memberService.deleteMember(vo);
		return "redirect:getMemberList.do";
	}
	
}
