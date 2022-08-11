package com.chat.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

	@NotBlank(message = "provide the user Details")
	private String fromUser;
	@NotBlank(message = "provide message")
	private String message;
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageDto(@NotBlank(message = "provide the user Details") String fromUser,
			@NotBlank(message = "provide message") String message) {
		super();
		this.fromUser = fromUser;
		this.message = message;
	}
	public MessageDto() {
		
	}
}