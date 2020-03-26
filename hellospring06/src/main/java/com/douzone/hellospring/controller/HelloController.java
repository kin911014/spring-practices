package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// route설정
	@RequestMapping("/hello")
	public String hello() {
		// jsp설정
		return "hello";
	}
	@RequestMapping("/hello2")
	public String hello2(String name) {
		// 파라미터 빼올 수 있다. ex http://127.0.0.1:8088/hellospring/hello2?name=1
		System.out.println("hello2의" + name);
		return "hello2";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		// 가져온 파라미터를  jsp에서 jstlel로 사용할 수 있도록 설정
		mav.addObject("name", name);
		mav.setViewName("hello3");
		return mav;
	}
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		// 위의 것보다 더욱 간편하게!
		model.addAttribute("name", name);
		return "hello4";
	}
}
