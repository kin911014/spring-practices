package com.douzone.reguestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.reguestbook.repository.GuestbookRepository;
import com.douzone.reguestbook.vo.GuestbookVo;

@Controller
public class ReGuestbookController {
	
	// Repository에서 어노테이션을 안해줄 경우 injection에러가 난다.
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String index(GuestbookVo vo) {
		System.out.println(vo);
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, 
			@RequestParam(value="password", required=true, defaultValue="")  String password) {
		guestbookRepository.delete(no, password);
		return "redirect:/";
	}
	
}
	