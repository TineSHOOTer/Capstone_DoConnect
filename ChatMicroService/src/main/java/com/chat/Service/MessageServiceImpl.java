package com.chat.Service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.Repo.MessageRepo;
import com.chat.dto.MessageDto;
import com.chat.entity.Message;

@Service
public class MessageServiceImpl implements MessageService{
	
	
	@Autowired
	private MessageRepo messageRepo;

	@Override
	public MessageDto sendMessage(@Valid MessageDto messageDto) {
		Message message = new Message();
		message.setMessage(messageDto.getMessage());
		message.setFromUser(messageDto.getFromUser());
		message = messageRepo.save(message);

		messageDto.setFromUser(message.getFromUser());
		messageDto.setMessage(message.getMessage());

		return messageDto;
	}

	@Override
	public List<MessageDto> getMessage() {
		List<MessageDto> data = new ArrayList<MessageDto>();

		List<Message> messages = messageRepo.findAll();
		for (Message message : messages) {

			MessageDto messageDTO = new MessageDto();
			messageDTO.setFromUser(message.getFromUser());
			messageDTO.setMessage(message.getMessage());
			data.add(messageDTO);

		}

		return data;
	}


}
