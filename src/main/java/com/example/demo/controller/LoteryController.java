package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotery")
public class LoteryController {

	
	@RequestMapping(method = RequestMethod.POST)
	void readBookmarks() {
		System.out.println("Rodou!!");
	}
}