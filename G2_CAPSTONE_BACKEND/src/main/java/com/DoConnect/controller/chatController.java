package com.DoConnect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoConnect.dto.Message;
import com.DoConnect.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class chatController {
	@Autowired
	private UserService userService;
	@PostMapping("/sendMessage")
	public Message sendMessage(@Valid @RequestBody Message message) {
		return userService.sendMessage(message);
	}

}
