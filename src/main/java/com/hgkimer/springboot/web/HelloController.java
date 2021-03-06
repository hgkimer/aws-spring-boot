package com.hgkimer.springboot.web;

import com.hgkimer.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto getHelloResponse(@RequestParam String name, @RequestParam int amount) {
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		return dto;

	}
}
