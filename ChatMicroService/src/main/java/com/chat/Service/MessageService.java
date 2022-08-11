package com.chat.Service;

import java.util.List;

import javax.validation.Valid;

import com.chat.dto.MessageDto;

public interface MessageService {
	

	public MessageDto sendMessage(@Valid MessageDto messageDto);

	public List<MessageDto> getMessage();


}
