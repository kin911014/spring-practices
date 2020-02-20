package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * @RequestMapping
 * Class 단독 맵핑
 * */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "/GuestbookController:list";
	}
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "/GuestbookController:delete";
	}
}
