package com.chat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.Service.MessageService;
import com.chat.dto.MessageDto;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping("/sendMessage")
	public MessageDto sendMessage(@Valid @RequestBody MessageDto messageDto) {
		return messageService.sendMessage(messageDto);
	}

	@GetMapping("/getMessage")
	public List<MessageDto> getMessage() {
		return messageService.getMessage();
	}
}