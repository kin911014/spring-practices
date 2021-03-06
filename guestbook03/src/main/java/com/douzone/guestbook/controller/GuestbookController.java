package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.service.GuestbookService;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String index(GuestbookVo vo) {
		guestbookService.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String deleteform(@PathVariable("no") Long no,Model model) {
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	// @PathVariable는 url파라미터값 @RequestParam는 일반 파라미터값을 갖고온다.
	public String delete(@PathVariable("no") Long no,@RequestParam("password") String password) {
		guestbookService.delete(no,password);
		return "redirect:/";
	}
	
}
