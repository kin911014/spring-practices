package com.douzone.reguestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.reguestbook.repository.GuestbookRepository;
import com.douzone.reguestbook.vo.GuestbookVo;

@Controller
public class ReGuestbookController {
	
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("/")
	public String index() {
		List<GuestbookVo> list = guestbookRepository.findAll();
		return "hello guestbook003";
	}
	
}
	