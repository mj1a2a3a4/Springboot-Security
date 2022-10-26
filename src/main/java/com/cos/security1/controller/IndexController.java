package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //<- 사용시 view를 리턴.
public class IndexController {
	
	@GetMapping({"","/"})
	public String index() {
		//머스테치 기본 폴더 src/main/resources/
		//뷰 리졸버 설정 : templates(prefix), .mustache(suffix) (생략가능!)
		
		return "index";
	}
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "manager";
	}
	//스프링 시큐리티가 해당주소를 낚아챔 
	//SecurityConfig 파일 생성 후 작동을 안함. 낚아 채지 못함.
	@GetMapping("/login")
	public @ResponseBody String login() {
		return "login";
	}
	@GetMapping("/join")
	public @ResponseBody String join() {
		return "join";
	}
	@GetMapping("/joinProc")
	public @ResponseBody String joinProc() {
		return "회원가입 완료됨!";
	}
}
