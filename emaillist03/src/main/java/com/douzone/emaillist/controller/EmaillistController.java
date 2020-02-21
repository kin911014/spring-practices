package com.douzone.emaillist.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		// spring-servlet.xml에서 지원을 해주어서 /WEB-INF/views/와 .jsp는 생략하면 저절로 채워준다.
		// 원래는 return "/WEB-INF/views/index.jsp"로 되있어야 하지만 설정으로 아래와 같이 가능
		return "index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
